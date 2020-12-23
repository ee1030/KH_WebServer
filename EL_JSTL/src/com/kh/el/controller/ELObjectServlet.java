package com.kh.el.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/01_el/elObject.do")
public class ELObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ELObjectServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cookie 생성
		// Cookie란?
		// 웹 페이지에서 사용할 정보를
		// 클라이언트 측에 저장하고 불러다 사용할 수 있는 파일
		// ex) 아이디 저장
		
		Cookie cookie = new Cookie("saveId", "user01");
		cookie.setMaxAge(7 * 24 * 60 * 60); // 1주일
		
		// 생성한 쿠키 객체를 응답객체에 추가
		// -> 응답 성공 시 클라이언트 컴퓨터에 쿠키 파일을 자동 저장
		response.addCookie(cookie);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/01_el/03_elObject.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
