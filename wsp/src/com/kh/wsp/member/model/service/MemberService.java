package com.kh.wsp.member.model.service;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.wsp.member.model.vo.Member;

public class MemberService {

	/** 로그인 Service
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Member member) throws Exception {
		// 1) Connection 얻어오기
		Connection conn = getConnection();
		
		// 2) DAO 메소드를 실행하여 결과 반환 받기
		
		// 3) Connection 반환하기
		
		// 4) DAO 수행 결과를 Controller로 반환
		return null;
	}

}
