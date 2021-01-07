package com.kh.wsp.board.model.service;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.wsp.board.model.dao.BoardDAO;
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
		
		// 1. 게시글 번호 얻어오기
		
		// 2. 글 제목/내용 크로스 사이트 스크립팅 방지 처리
		
		// 3. 글 내용 개행문자 \r\n -> <br> 변경처리
		
		// 4. 게시글 부분(제목, 내용, 카테고리)만 BOARD 테이블에 삽이하는 DAO 호출
		
		return 0;
	}
}
