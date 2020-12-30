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
		close(conn);
		
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
		close(conn);
		
		// 4) DAO 수행 결과를 Controller로 반환
		return result;
	}

	/** 아이디 중복 검사 Service
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String id) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.idDupCheck(conn, id);
		
		close(conn);
		
		return result;
	}

	/** 회원정보 수정 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member member) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, member);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 비밀번호 변경 Service
	 * @param loginMember
	 * @param newPwd
	 * @return result
	 * @throws Exception
	 */
	public int updatePwd(Member loginMember, String newPwd) throws Exception {
		Connection conn = getConnection();
		
		// 1) 현재 비밀번호가 일치하는 지 검사
		int result = dao.checkCurrentPwd(conn, loginMember);
		
		// 2) 현재 비밀번호 일치 시 새 비밀번호로 수정
		if(result > 0) { // 현재 비밀번호 일치하는 경우
			
			// loginMember의 비밀번호 필드에 newPwd를 세팅하여 재활용.
			loginMember.setMemberPwd(newPwd);
			
			result = dao.updatePwd(conn, loginMember);
			
			if(result > 0) commit(conn);
			else		   rollback(conn);
		} else { // 현재 비밀번호 불일치
			result = -1;
		}
		
		close(conn);
		
		return result; // -1, 0, 1
	}

	/** 회원 탈퇴 Service
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int updateStatus(Member loginMember) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.checkCurrentPwd(conn, loginMember);
		
		if(result > 0) {
			result = dao.updateStatus(conn, loginMember);
			
			if(result > 0) commit(conn);
			else rollback(conn);
		} else {
			result = -1;
		}
		
		return result;
	}


}
