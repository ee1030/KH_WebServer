package com.kh.ajax.jquery.model.service;

import static com.kh.ajax.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.ajax.jquery.model.dao.MemberDAO;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	/** 아이디 중복 체크 Service
	 * @param inputId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String inputId) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.idDupCheck(conn, inputId);
		
		close(conn);
		
		return result;
	}

}
