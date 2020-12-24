package com.kh.wsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.wsp.member.model.service.MemberService;
import com.kh.wsp.member.model.vo.Member;

// @WebServlet에 작성되는 요청 주소에서
// 제일 앞에 있는 '/'는 contextPath를 의미한다.
@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. POST 방식으로 전달된 데이터의 문자 인코딩 변경
		request.setCharacterEncoding("UTF-8");
		
		// 2. 파라미터를 꺼내서 변수에 저장
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String save = request.getParameter("save");
		// 체크시 on, 아니면 null
		
		// System.out.println(memberId + " / " + memberPwd + " / " + save);
		
		// JDBC 수행
		// 아이디와 비밀번호를 하나의 VO에 담아서 service로 전달
		// 3. 아이디와 비밀번호를 Member 객체에 세팅
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		
		// * try-catch를 이용하여 service, dao에서 발생한 예외를 처리
		// -> 응답 화면을 에러 페이지로 연결
		try {
			// 4. Member 객체를 Service로 전달하여 결과를 반환받기
			// (로그인 이란? id/pw가 일치하는 회원정보를 DB에서 조회해 오는것)
			Member loginMember = new MemberService().loginMember(member);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
