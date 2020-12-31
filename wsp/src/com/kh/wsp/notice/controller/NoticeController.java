package com.kh.wsp.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.wsp.notice.model.service.NoticeService;
import com.kh.wsp.notice.model.vo.Notice;

// 모든 notice 관련 요청을 받아들임
@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Front Controller 패턴
		// - 클라이언트의 요청을 한 곳으로 집중시켜 개발하는 패턴
		// - 요청마다 Servlet을 생성하는 것이 아닌 하나의 Servlet에 작성하여
		//	 관리가 용이해짐.
		
		// Controller 역할 : 요청에 맞는 Service 호출, 응답을 위한 View 선택
		
		String uri = request.getRequestURI(); // 전체 요청 주소
		// ex) /wsp/notice/list.do
		
		String contextPath = request.getContextPath();
		// ex) /wsp
		
		String command = uri.substring((contextPath + "/notice").length());
		
		//System.out.println(uri);
		//System.out.println(contextPath);
		//System.out.println(command);
		
		// 컨트롤러 내에서 공용으로 사용할 변수 미리 선언
		String path = null; // forward 또는 redirect 경로를 저장할 변수
		RequestDispatcher view = null; // 요청 위임 객체
		
		String swalIcon = null; // sweet alert로 메세지 전달하는 용도
		String swalTitle = null;
		String swalText = null;
		
		String errorMsg = null; // 에러메시지 전달용 변수
		
		try {
			NoticeService service = new NoticeService();
			
			// 공지사항 목록 조회 Controller
			if(command.equals("/list.do")) {
				errorMsg = "공지사항 목록 조회 중 오류 발생";
				
				// 비즈니스 로직 처리 후 결과 반환 받기
				List<Notice> list = service.selectList();
				
				// 요청을 위임할 jsp 경로 지정
				path = "/WEB-INF/views/notice/noticeList.jsp";
				
				// 요청 위임 시 전달할 값 세팅
				request.setAttribute("list", list);
				
				// 요청 위임 객체 생성 후 위임 진행
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
