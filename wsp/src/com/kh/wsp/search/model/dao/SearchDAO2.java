package com.kh.wsp.search.model.dao;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.wsp.board.model.vo.Attachment;
import com.kh.wsp.board.model.vo.Board;
import com.kh.wsp.board.model.vo.PageInfo;

public class SearchDAO2 {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	/** 조건을 만족하는 게시글 수 조회 DAO
	 * @param session
	 * @param map
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(SqlSession session, Map<String, Object> map) throws Exception {
		return session.selectOne("searchMapper.getListCount", map);
	}

	/** 검색 게시글 목록 조회 DAO
	 * @param session
	 * @param pInfo
	 * @param map
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> searchBoardList(SqlSession session, PageInfo pInfo, Map<String, Object> map) throws Exception {
		
		int offset = (pInfo.getCurrentPage() - 1) * pInfo.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pInfo.getLimit());
		
		return session.selectList("searchMapper.searchBoardList", map, rowBounds);
	}

	/** 검색이 적용된 썸네일 목록 조회 DAO
	 * @param conn
	 * @param pInfo
	 * @param condition
	 * @return fList
	 * @throws Exception
	 */
	public List<Attachment> searchThumbnailList(Connection conn, PageInfo pInfo, String condition) throws Exception {
		
		List<Attachment> fList = null;
		
		String query =
				"SELECT FILE_NAME, PARENT_BOARD_NO FROM ATTACHMENT " + 
				"WHERE PARENT_BOARD_NO IN (" + 
				"    SELECT BOARD_NO FROM " + 
				"    (SELECT ROWNUM RNUM, V.* FROM " + 
				"            (SELECT BOARD_NO  FROM V_BOARD " + 
				"            WHERE BOARD_STATUS='Y' " + 
				"            AND " + condition + 
				"            ORDER BY BOARD_NO DESC ) V) " + 
				"    WHERE RNUM BETWEEN ? AND ?" + 
				") " + 
				"AND FILE_LEVEL = 0";
		
		try {
			int startRow = (pInfo.getCurrentPage() - 1) * pInfo.getLimit() + 1;
			int endRow = startRow + pInfo.getLimit() - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			fList = new ArrayList<Attachment>();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setFileName(rset.getString("FILE_NAME"));
				at.setParentBoardNo(rset.getInt("PARENT_BOARD_NO"));
				
				fList.add(at);
			}
			
		} finally {
			close(rset);
			close(pstmt);
		}

		return fList;
	}


}
