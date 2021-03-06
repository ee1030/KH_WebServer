package com.kh.wsp.search.model.service;

import static com.kh.wsp.common.MybatisTemplate.getSqlSession;
import static com.kh.wsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.wsp.board.model.vo.Attachment;
import com.kh.wsp.board.model.vo.Board;
import com.kh.wsp.board.model.vo.PageInfo;
import com.kh.wsp.search.model.dao.SearchDAO;
import com.kh.wsp.search.model.dao.SearchDAO2;

public class SearchService2 {

	private SearchDAO2 dao = new SearchDAO2();

	/** 검색 내용이 포함된 페이징 처리 정보 생성 Service
	 * @param map
	 * @return pInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo(Map<String, Object> map) throws Exception {
		SqlSession session = getSqlSession();
		
		// 얻어온 파라미터 cp가 null이면 1, 아니면 int형으로 파싱
		map.put("currentPage",
				(map.get("currentPage") == null) ? 1 
						: Integer.parseInt((String)map.get("currentPage")));		
		
		// DB에서 조건을 만족하는 게시글의 수를 조회하기
		int listCount = dao.getListCount(session, map);
		
		// SqlSession 반환
		session.close();
		
		// PageInfo 객체를 생성하여 반환
		return new PageInfo((int)map.get("currentPage"), listCount);
	}

	/** 검색 조건에 따라 SQL에 사용될 조건문을 조합하는 메소드
	 * @param map
	 * @return condition
	 */
	private String createCondition(Map<String, Object> map) {
		String condition = null;
		
		String searchKey = (String)map.get("searchKey");
		String searchValue = (String)map.get("searchValue");
		
		// 검색 조건(searchKey)에 따라 SQL 조합
		switch(searchKey) {
		case "title" :
			condition = " BOARD_TITLE LIKE '%' || '" + searchValue + "' || '%' "; 
			break;
		case "content" :
			condition = " BOARD_CONTENT LIKE '%' || '" + searchValue + "' || '%' "; 
			break;
		case "titcont" : 
			condition = " BOARD_TITLE LIKE '%' || '" + searchValue + "' || '%' " 
					+ "OR BOARD_CONTENT LIKE '%' || '" + searchValue + "' || '%' "; 
			break;
		case "writer" : 
			condition = " MEMBER_ID LIKE '%' || '" + searchValue + "' || '%' ";
			break;
		}
		
		return condition;
	}

	/** 검색 게시글 목록 리스트 조회 Service
	 * @param map
	 * @param pInfo 
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> searchBoardList(Map<String, Object> map, PageInfo pInfo) throws Exception {
		SqlSession session = getSqlSession();
		
		List<Board> bList = dao.searchBoardList(session, pInfo, map);
		
		session.close();
		
		return bList;
	}

	/** 검색이 적용된 썹네일 목록 조회 Service
	 * @param bList
	 * @param pInfo
	 * @return fList
	 * @throws Exception
	 */
	public List<Attachment> searchThumbnailList(List<Board> bList) throws Exception {
		SqlSession session = getSqlSession();
		
		List<Attachment> fList = dao.searchThumbnailList(session, bList);
		
		session.close();
		
		return fList;
	}

	/** 다중 조건이 포함된 전체 게시글 수 조회 Service
	 * @param map
	 * @return pInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo2(Map<String, Object> map) throws Exception {
		SqlSession session = getSqlSession();
		
		// 얻어온 파라미터 cp가 null이면 1, 아니면 int형으로 파싱
		map.put("currentPage",
				(map.get("currentPage") == null) ? 1 
						: Integer.parseInt((String)map.get("currentPage")));
		
		int listCount = dao.getListCount2(session, map);
		
		// SqlSession 반환
		session.close();
		
		// PageInfo 객체를 생성하여 반환
		return new PageInfo((int)map.get("currentPage"), listCount);
	}
	
	/** 다중 조건이 포함된 검색 게시글 목록 리스트 조회 Service
	 * @param map
	 * @param pInfo 
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> searchBoardList2(Map<String, Object> map, PageInfo pInfo) throws Exception {
		SqlSession session = getSqlSession();
		
		List<Board> bList = dao.searchBoardList2(session, pInfo, map);
		
		session.close();
		
		return bList;
	}

}
