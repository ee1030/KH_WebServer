package com.kh.wsp.search.model.service;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.Map;

import com.kh.wsp.board.model.vo.PageInfo;
import com.kh.wsp.search.model.dao.SearchDAO;

public class SearchService {

	private SearchDAO dao = new SearchDAO();

	/** 검색 내용이 포함된 페이징 처리 정보 생성 Service
	 * @param map
	 * @return pInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();
		
		// 얻어온 파라미터 cp가 null이면 1, 아니면 int형으로 파싱
		map.put("currentPage",
				(map.get("currentPage") == null) ? 1 
						: Integer.parseInt((String)map.get("currentPage")));
		
		// 검색 조건에 따른 SQL 조건문을 조합하는 메소드 호출
		String condition = createCondition(map);
		
		return null;
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
}
