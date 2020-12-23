package com.kh.el.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.el.model.vo.Person;

// @WebServlet 어노테이션
// 서버 주소로 요청이 왔을 때 이를 매핑해주는 web.xml 구문을 대체하는 어노테이션
@WebServlet("/01_el/el.do")
public class ELServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ELServlet1() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// servlet / jsp 에서의 객체 범위(scope)
		// 1. page scope : 해당 페이지(servlet/jsp)
		// 2. request scope : 요청 받은 페이지 
		// 						+ 요청 위임 페이지
		// 3. session scope : 브라우저가 종료되거나 세션이 만료되기 전 까지
		// 4. application scope
		//	  : 프로젝트 전체에서 사용 가능
		
		// request scope
		request.setAttribute("classRoom", "A강의장");
		request.setAttribute("person", new Person("홍길동", 20, '남'));
		
		// session scope
		// Session 객체 얻어오기
		HttpSession session = request.getSession();
		session.setAttribute("academyName", "KH정보교육원");
		
		// request, session 객체가
		// 동일한 속성명의 속성을 가진 경우
		request.setAttribute("scope", "request scope");
		session.setAttribute("scope", "session scope");
		
		// 요청 위임
		RequestDispatcher view = request.getRequestDispatcher("/views/01_el/01_el.jsp");
								// views 앞에 '/' == 최상단 폴더(WebContent)
		
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
