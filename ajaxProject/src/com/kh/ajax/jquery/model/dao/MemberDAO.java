package com.kh.ajax.jquery.model.dao;

import static com.kh.ajax.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

	/** 아이디 중복 검사 DAO
	 * @param conn
	 * @param inputId
	 * @return
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String inputId) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_STATUS = 'Y'";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

}
