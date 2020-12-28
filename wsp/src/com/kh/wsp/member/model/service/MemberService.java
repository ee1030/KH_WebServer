package com.kh.wsp.member.model.service;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.wsp.member.model.dao.MemberDAO;
import com.kh.wsp.member.model.vo.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/** 로그인 Service
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Member member) throws Exception {
		// 1) Connection 얻어오기
		Connection conn = getConnection();
		
		// 2) DAO 메소드를 실행하여 결과 반환 받기
		Member loginMember = dao.loginMember(conn, member);
		
		// 3) Connection 반환하기
		conn.close();
		
		// 4) DAO 수행 결과를 Controller로 반환
		return loginMember;
	}

	/** 회원가입 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception {
		// 1) Connection 얻어오기
		Connection conn = getConnection();
		
		// 2) DAO 메소드 호출 후 결과 반환
		int result = dao.signUp(conn, member);
		
		// 3) 트랜잭션 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		// Connection 반환
		conn.close();
		
		// 4) DAO 수행 결과를 Controller로 반환
		return result;
	}

}
