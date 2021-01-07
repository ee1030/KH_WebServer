package com.kh.wsp.board.model.service;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.wsp.board.model.dao.BoardDAO;
import com.kh.wsp.board.model.exception.FileInsertFailedException;
import com.kh.wsp.board.model.vo.Attachment;
import com.kh.wsp.board.model.vo.Board;
import com.kh.wsp.board.model.vo.PageInfo;

public class BoardService {

	private BoardDAO dao = new BoardDAO();

	/** 페이징 처리를 위한 값 계산 Service
	 * @param cp
	 * @return pInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo(String cp) throws Exception {
		Connection conn = getConnection();
		
		// cp가 null일 경우
		int currentPage = cp == null ? 1 : Integer.parseInt(cp);
		
		// DB에서 전체 게시글 수를 조회하여 반환 받기
		int listCount = dao.getListCount(conn);
		
		close(conn); 
		
		// 얻어온 현재 페이지와, DB에서 조회한 전체 게시글 수를 이용하여
		// PageInfo 객체를 생성함
		return new PageInfo(currentPage, listCount);
	}

	/** 게시글 목록 조회 Service
	 * @param pInfo
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(PageInfo pInfo) throws Exception {
		Connection conn = getConnection();
		
		List<Board> bList = dao.selectBoardList(conn, pInfo);
		
		close(conn);
		
		return bList;
	}

	/** 게시글 상세조회 Service
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int boardNo) throws Exception {
		Connection conn = getConnection();
		
		Board board = dao.selectBoard(conn, boardNo);
		
		if(board != null) { // DB에서 조회 성공 시
			
			// 조회수 증가
			int result = dao.increaseReadCount(conn, boardNo);
			
			if(result > 0) {
				commit(conn);
				
				// 반환되는 Board 데이터에는 조회수가 증가되어 있지 않기 때문에
				// 조회수를 1 증가 시켜줌
				board.setReadCount(board.getReadCount()+1);
			} else {
				rollback(conn);
			}
		}
		
		close(conn);
		
		return board;
	}

	/** 게시글 등록 Service (게시글 + 파일)
	 * @param map
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Map<String, Object> map) throws Exception {
		
		Connection conn = getConnection();
		
		int result = 0;
		
		// 1. 게시글 번호 얻어오기
		int boardNo = dao.selectNextNo(conn);
		
		if(boardNo > 0) {
			// 얻어온 게시글 번호를 map에 추가(게시글, 파일 정보 삽입 DAO에서 사용하기 위해)
			map.put("boardNo", boardNo);
			
			// 2. 글 제목/내용 크로스 사이트 스크립팅 방지 처리
			String boardTitle = (String)map.get("boardTitle");
			String boardContent = (String)map.get("boardContent");
			
			boardTitle = replaceParameter(boardTitle);
			boardContent = replaceParameter(boardContent);
			
			// 3. 글 내용 개행문자 \r\n -> <br> 변경처리
			boardContent = boardContent.replaceAll("\r\n", "<br>");
			
			// 처리된 내용을 다시 map에 추가
			map.put("boardTitle", boardTitle);
			map.put("boardContent", boardContent);
			
			try {
				// 4. 게시글 부분(제목, 내용, 카테고리)만 BOARD 테이블에 삽이하는 DAO 호출
				result = dao.insertBoard(conn, map);
				
				// 5. 파일 정보 부분만 ATTACHMENT 테이블에 삽입하는 DAO 호출
				List<Attachment> fList = (List<Attachment>)map.get("fList");
				
				// 게시글 부분 삽입 성공 && 파일 정보가 존재할 경우
				if(result > 0 && !fList.isEmpty()) {
					result = 0; // result 재활용을 위해 0으로 초기화
					
					// fList의 요소를 하나씩 반복 접근 하여
					// DAO 메소드를 반복 호출해 정보를 삽입함.
					for(Attachment at : fList) {
						
						// 파일 정보가 저장된 Attachment 객체에
						// 해당 파일이 작성된 게시글 번호를 추가 세팅
						at.setParentBoardNo(boardNo);
						
						result = dao.insertAttachment(conn, at);
						
						if(result == 0) { // 파일정보 삽입 실패
							//break; // 보류
							
							// 강제로 예외 발생
							throw new FileInsertFailedException("파일 정보 삽입 실패");
						}
					}	
				}
			} catch (Exception e) {
				// 4,5번에 대한 추가 작업
				// 게시글 또는 파일 정보 삽입 중 에러 발생 시
				// 서버에 저장된 파일을 삭제하는 작업이 필요.
				
				List<Attachment> fList = (List<Attachment>)map.get("fList");
				
				if(!fList.isEmpty()) {
					for(Attachment at : fList) {
						String filePath = at.getFilePath();
						String fileName = at.getFileName();
						
						File deleteFile = new File(filePath + fileName);
						
						if(deleteFile.exists()) {
							// 해당 경로에 해당 파일이 존재하면
							deleteFile.delete(); // 해당 파일 삭제
						}
					}	
				}
				
				// 에러페이지가 보여질 수 있도록 catch한 exception을 Controller로 던져줌
				throw e;
			} // end catch
			
			// 6. 트랜잭션 처리
			if(result > 0) {
				commit(conn);
				
				// 삽입 성공 시 상세 조회 화면으로 이동해야 되기 때문에
				// 글 번호를 반환 할 수 있도록 result에 boardNo를 대입
				result = boardNo;
			} else {
				rollback(conn);
			}
		}
			
		// 7. 커넥션 반환
		close(conn);
		
		// 8. 결과 반환
		return result;
	}
	
	// 크로스 사이트 스크립팅
	// 웹 애플리케이션에서 많이 나타나는 보안 취약점 중 하나로
	// 웹 사이트 관리자가 아닌 사용자가 웹 페이지에 악성 스크립트를 삽입할 수 있는 취약점
	
	// 크로스 사이트 스크립팅 방지 메소드
	private String replaceParameter(String param) {
		String result = param;
		
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		
		return result;
	}

	/** 게시글에 포함된 이미지 목록 조회 Service
	 * @param boardNo
	 * @return fList
	 * @throws Exception
	 */
	public List<Attachment> selectBoardFiles(int boardNo) throws Exception {
		Connection conn = getConnection();
		
		List<Attachment> fList = dao.selectBoardFiles(conn, boardNo);
		
		close(conn);
		
		return fList;
	}
}
