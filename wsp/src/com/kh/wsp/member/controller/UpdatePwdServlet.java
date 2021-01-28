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

@WebServlet("/member/updatePwd.do")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 비밀번호, 새로운 비밀번호
		String currentPwd = request.getParameter("currentPwd");
		String newPwd = request.getParameter("newPwd1");
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		try {
			loginMember.setMemberPwd(currentPwd);
			// 비즈니스 로직 처리 후 결과 반환 받기
			int result = new MemberService2().updatePwd(loginMember, newPwd);
			
			String swalIcon = null;
			String swalTitle = null;
		
			if(result > 0) { // 비밀번호 변경 성공
				swalIcon = "success";
				swalTitle = "비밀번호가 변경되었습니다.";
			} else if(result == 0) { // 비밀번호 변경 실패
				swalIcon = "error";
				swalTitle = "비밀번호 변경에 실패했습니다.";
			} else { // 현재 비밀번호 불일치
				swalIcon = "warning";
				swalTitle = "현재 비밀번호가 일치하지 않습니다.";
			}
			
			session.setAttribute("swalIcon", swalIcon);
			session.setAttribute("swalTitle", swalTitle);
			
			response.sendRedirect(request.getHeader("referer"));
			
		} catch (Exception e) {
			e.printStackTrace();
			
			String path = "/WEB-INF/views/common/errorPage.jsp";
			
			request.setAttribute("errorMsg", "비밀번호 변경 중 오류 발생");
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
