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
import com.kh.wsp.member.model.service.MemberService2;
import com.kh.wsp.member.model.vo.Member;

@WebServlet("/member/updateStatus.do")
public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPwd = request.getParameter("currentPwd");
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		loginMember.setMemberPwd(currentPwd);
		
		try {
			int result = new MemberService2().updateStatus(loginMember);
			
			String swalIcon = null;
			String swalTitle = null;
			String url = null;
		
			if(result > 0) { // 회원탈퇴 성공
				swalIcon = "success";
				swalTitle = "회원탈퇴가 완료되었습니다.";
				
				// 로그아웃 == 세션 무효화
				session.invalidate();
				// 세션 무효화 시 현재 얻어온 세션을 사용할 수 없는 문제점이 있다.
				// -> 새로운 세션 얻어오기
				session = request.getSession();
				
				url = request.getContextPath();
				
			} else if(result == 0) { // 회원탈퇴 실패
				swalIcon = "error";
				swalTitle = "회원 탈퇴에 실패했습니다.";
				
				// 탈퇴페이지 유지
				url = "secession.do";
				
			} else { // 현재 비밀번호 불일치
				swalIcon = "warning";
				swalTitle = "현재 비밀번호가 일치하지 않습니다.";
				
				// 탈퇴페이지 유지
				url = "secession.do";
			}
			
			session.setAttribute("swalIcon", swalIcon);
			session.setAttribute("swalTitle", swalTitle);
			
			response.sendRedirect(url);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			String path = "/WEB-INF/views/common/errorPage.jsp";
			
			request.setAttribute("errorMsg", "회원 탈퇴 중 오류 발생");
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
