package com.kh.wsp.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.wsp.member.model.service.MemberService;
import com.kh.wsp.member.model.vo.Member;

@WebServlet("/member/signUp.do")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식 전송 시 한글이 꺠지는 문제를 해결하기 위해 인코딩 변경
		request.setCharacterEncoding("UTF-8");
		
		// 전달받은 파라미터를 모두 변수에 저장.
		String memberId = request.getParameter("id");
		String memberPwd = request.getParameter("pwd1");
		String memberName = request.getParameter("name");
		String memberEmail = request.getParameter("email");
		
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		
		// 전화번호를 '-'를 구분자로 하여 하나로 합치기
		String memberPhone = phone1 + "-" + phone2 + "-" + phone3;
		
		String post = request.getParameter("post"); // 우편번호
		String address1 = request.getParameter("address1"); // 도로명 주소
		String address2 = request.getParameter("address2"); // 상세 주소
		
		String memberAddress = post + "," + address1 + "," + address2;
		
		String[] interest = request.getParameterValues("memberInterest");
		
		String memberInterest = null;
		
		if(interest != null) {
			memberInterest = String.join(",", interest);
		}
		
		// Member 객체를 생성하여 파라미터를 모두 저장
		Member member = new Member(memberId, memberPwd,
								memberName, memberPhone, memberEmail,
								memberAddress, memberInterest);
		
		// 비즈니스 로직 수행
		try {

			//비즈니스 로직 수행 후 결과를 반환 받아 저장
			int result = new MemberService().signUp(member);
			
			String swalIcon = null;
			String swalTitle = null;
			String swalText = null;
			
			if(result > 0) { // 성공
				swalIcon = "success";
				swalTitle = "회원가입 성공!";
				swalText = memberName + "님의 회원가입을 환영합니다.";
			} else { // 실패
				swalIcon = "error";
				swalTitle = "회원가입 실패!";
				swalText = "문제가 지속될 경우 고객센터로 문의 바랍니다.";
			}
			
			HttpSession session = request.getSession();
			
			session.setAttribute("swalIcon", swalIcon);
			session.setAttribute("swalTitle", swalTitle);
			session.setAttribute("swalText", swalText);
			
			// 회원가입 진행 후 메인페이지로 이동 (메인 화면 재요청)
			response.sendRedirect(request.getContextPath());
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("errorMsg", "회원가입 과정에서 오류가 발생했습니다.");
			
			String path = "/WEB-INF/views/common/errorPage.jsp";
			
			RequestDispatcher view = request.getRequestDispatcher(path);
			
			view.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
