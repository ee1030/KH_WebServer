package com.kh.wsp.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.wsp.board.model.service.BoardService;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/board").length());
	
		
		String path = null;
		RequestDispatcher view = null;
		
		String swalIcon = null;
	    String swalTitle = null;
	    String swalText = null;
	      
	    String errorMsg = null;
		
		try {
			BoardService service = new BoardService();
			
			// 게시글 목록 조회 Controller *****************************************
			if(command.equals("/list.do")) {
				errorMsg = "게시글 목록 조회 과정에서 오류 발생";
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("errorMsg", errorMsg);
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
