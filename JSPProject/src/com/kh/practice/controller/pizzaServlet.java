package com.kh.practice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public pizzaServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 선택된 피자와 토핑, 사이드메뉴의 총 가격을 계산하여
		// 요청 위임 객체에 추가 후
		// 응답 화면용 JSP를 만들어 출력하기
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		
		int totalPrice = 0;
		
		switch(pizza) {
		case "치즈피자" : totalPrice = 5000; break;
		case "콤비네이션피자" : totalPrice = 6000; break;
		case "포테이토피자" : totalPrice = 7000; break;
		case "고구마피자" : totalPrice = 7000; break;
		case "불고기피자" : totalPrice = 8000; break;
		}
		
		if(topping != null) {
			for(String str : topping) {
				switch(str) {
				case "고구마무스" : totalPrice += 1000; break;
				case "콘크림무스" : totalPrice += 1500; break;
				case "파인애플토핑" : totalPrice += 2000; break;
				case "치즈토핑" : totalPrice += 2000; break;
				case "치즈크러스트" : totalPrice += 2000; break;
				case "치즈바이트" : totalPrice += 3000; break;
				}
			}
		}
		
		if(side != null) {
			for(String str : side) {
				switch(str) {
				case "오븐구이통닭" : totalPrice += 9000; break;
				case "치킨스틱&윙" : totalPrice += 4900; break;
				case "치즈오븐스파게티" : totalPrice += 4000; break;
				case "새우링&웨지감자" : totalPrice += 3500; break;
				case "갈릭포테이토" : totalPrice += 3000; break;
				case "콜라" : totalPrice += 1500; break;
				case "사이다" : totalPrice += 1500; break;
				case "갈릭소스" : totalPrice += 500; break;
				case "피클" : totalPrice += 300; break;
				case "핫소스" : totalPrice += 100; break;
				case "파마산 치즈가루" : totalPrice += 100; break;
				}
			}
		}
		
		RequestDispatcher view 
			= request.getRequestDispatcher("views/result.jsp");
		
		request.setAttribute("totalPrice", totalPrice);
		if(topping != null) {
			request.setAttribute("toppingJoin", String.join(", ", topping));
		} else {
			request.setAttribute("toppingJoin", "null");
		}
		
		if(side != null) {
			request.setAttribute("sideJoin", String.join(", ", side));
		} else {
			request.setAttribute("sideJoin", "null");
		}
		
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
