package com.kh.wsp.member.model.dao;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.kh.wsp.member.model.vo.Member;

public class MemberDAO {
	
	// DAO에서 자주 사용되는 JDBC 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;

	private Properties prop = null;
	
	public MemberDAO() {
		// 외부에 저장된 XML 파일로부터 SQL을 얻어옴 --> 유지보수성 향상
		try {
			String filePath 
				= MemberDAO.class.getResource("/com/kh/wsp/sql/member/member-query.xml").getPath();
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 로그인 DAO
	 * @param conn
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Connection conn, Member member) throws Exception {
		
		// 결과 저장용 변수 선언
		Member loginMember = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			// 1) PreparedStatement 객체를 얻어와 query 세팅
			pstmt = conn.prepareStatement(query);
			
			// 2) 위치홀더 (?)에 알맞은 값 세팅
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			
			// 3) SQL 수행 후 결과를 반환받아 저장
			rset = pstmt.executeQuery();
			
			// 4) 조회 결과가 있을 경우 Member 객체에 조회 내용을 저장
			if(rset.next()) {
				loginMember = new Member(rset.getInt("MEMBER_NO"),
										rset.getString("MEMBER_ID"),
										rset.getString("MEMBER_NM"),
										rset.getString("MEMBER_PHONE"),
										rset.getString("MEMBER_EMAIL"),
										rset.getString("MEMBER_ADDR"),
										rset.getString("MEMBER_INTEREST"),
										rset.getString("MEMBER_GRADE"));
			}
			
		} finally {
			// 사용한 DB 자원 반환
			close(rset);
			close(pstmt);
		}
	
		return loginMember;
	}

	/** 회원가입 DAO
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception {
		// 1) 결과를 저장할 변수 선언
		int result = 0;
		
		// 2) SQL 구문 준비
		String query = prop.getProperty("signUp");
		
		try {
			// 3) PreparedStatement 객체를 얻어와 sql구문을 세팅
			pstmt = conn.prepareStatement(query);
			
			// 4) 위치 홀더에 알맞은 값 세팅
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberAddress());
			pstmt.setString(7, member.getMemberInterest());
					
			// 5) sql구문 수행 후 반환값 저장
			result = pstmt.executeUpdate();
			
		} finally {
			// 6) 사용한 JDBC 자원 반환
			close(pstmt);
		}
		
		// 7) 결과 반환
		return result;
	}

	/** 아이디 중복 검사 DAO
	 * @param conn
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String id) throws Exception {
		int result = 0;
		
		String query = prop.getProperty("idDupCheck");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, id);
			
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
