package com.kh.wsp.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.wsp.board.model.service.BoardService;
import com.kh.wsp.board.model.vo.Board;
import com.kh.wsp.board.model.vo.PageInfo;

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
			
			// 현재 페이지를 얻어옴
			String cp = request.getParameter("cp");
			
			// 게시글 목록 조회 Controller *****************************************
			if(command.equals("/list.do")) {
				errorMsg = "게시글 목록 조회 과정에서 오류 발생";
				
				// 1. 페이징 처리를 위한 값 계산
				PageInfo pInfo = service.getPageInfo(cp);
				//System.out.println(pInfo);
				
				// 2. 게시글 목록 조회 비즈니스 로직 수행
				List<Board> bList = service.selectBoardList(pInfo);
				// pInfo에 있는 currentPage, limit를 사용해야지만
				// 현재 페이지에 맞는 게시글 목록만 조회할 수 있음.
				
				/*for(Board b : bList) {
					System.out.println(b);
				}*/
				
				path = "/WEB-INF/views/board/boardList.jsp";
				
				request.setAttribute("bList", bList);
				request.setAttribute("pInfo", pInfo);
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
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
