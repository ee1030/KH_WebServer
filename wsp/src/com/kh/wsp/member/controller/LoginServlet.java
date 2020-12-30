package com.kh.wsp.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.wsp.member.model.service.MemberService;
import com.kh.wsp.member.model.vo.Member;

// @WebServlet에 작성되는 요청 주소에서
// 제일 앞에 있는 '/'는 contextPath를 의미한다.
@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. POST 방식으로 전달된 데이터의 문자 인코딩 변경
		// request.setCharacterEncoding("UTF-8");
		
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
			
			// System.out.println(loginMember);
			
			// 로그인 정보는 로그아웃 또는 브라우저가 종료될 때 까지 유지되어야 한다.
			// --> Session을 활용함
			
			// 5. 응답 화면 문서 타입 지정
			response.setContentType("text/html; charset=UTF-8");
			
			// 6. Session 객체를 얻어와 로그인 정보를 추가함
			HttpSession session = request.getSession();
			
			// 6-1. 로그인이 성공 했을때만 Session에 로그인 정보 추가하기
			if(loginMember != null) {
				
				// 6-2. 30분 동안 동작이 없을 경우 Session을 만료시킴
				session.setMaxInactiveInterval(60 * 10); // 테스트용 1분후 만료
												// 초단위
				
				// 6-3. Session에 로그인 정보 추가
				session.setAttribute("loginMember", loginMember);
				
				// cookie -> 사용자 컴퓨터에 저장
				// session -> 서버에 저장
				
				// 서버가 접속한 브라우저 마다 session을 구분하는 방법
				// -> 해당 브라우저의 쿠키 파일에 session을 구분할 수 있는
				//	  session id를 저장 시켜 두었다가
				//	  접속 될 때 마다 쿠키에서 자동으로 session id를 얻어감.
				
				// 6-4. 아이디를 Cookie에 저장 하기
				
				// 2) 쿠키 객체 생성
				Cookie cookie = new Cookie("saveId", memberId);
				
				// 1) 아이디 저장 checkbox가 체크 되었는지 확인
				if(save != null) {
					
					// 3) 1주일 동안 쿠키가 유효하도록 설정(쿠키 생명 주기 설정)
					cookie.setMaxAge(60 * 60 * 24 * 7); // 초 단위 (7일)
				} else {
					// 4) 아이디 저장이 체크가 안된 경우 기존에 있던 쿠키 파일 삭제
					cookie.setMaxAge(0); // 생성 되자마자 삭제
				}
				
				// 5) 쿠키 유효 디렉토리 지정
				cookie.setPath(request.getContextPath());
											// /wsp
				
				// 6) 생성된 쿠키를 클라이언트로 전달(응답)
				response.addCookie(cookie);
				
			} else {
				// 7. 로그인이 실패 했을 때 "아이디 또는 비밀번호를 확인해주세요." 라고 경고창 띄우기
				// -> Session에 "아이디 또는 비밀번호를 확인해주세요." 라는 문자열을 담아서 리다이렉트하기
				
				// session.setAttribute("text", "아이디 또는 비밀번호를 확인해주세요.");
				
				// sweet alert 사용하기
				session.setAttribute("swalIcon", "error");
				session.setAttribute("swalTitle", "로그인 실패");
				session.setAttribute("swalText", "아이디 또는 비밀번호를 확인해주세요.");
			}
			
			// redirect 방식을 이용하여 로그인을 요청했던 페이지로 이동
			
			/*
			 * forward 같은 경우에는 이동하는 페이지로
			 * request, response 객체를 그대로 위임하고,
			 * 주소를 위임 전 주소로 유지하지만,
			 * 
			 * redirect는 이전 request, response를 폐기하고
			 * 새롭게 만들어서 지정된 주소로 새로운 요청을 보냄.
			 * -> 새롭게 요청을 보내기 때문에 이전 요청 주소가 아닌
			 * 	  새로운 요청 주소가 주소창에 나타남.
			 * */
			
	        // referer : 사이트 방문 흔적
	        // request.getHeader("referer") : 요청 전 페이지 주소가 담겨있다.
			response.sendRedirect(request.getHeader("referer"));
			
		} catch (Exception e) {
			e.printStackTrace();
			
			// 로그인 과정에서 오류 발생 시 errorPage.jsp로 forward 진행
			request.setAttribute("errorMsg", "로그인 과정에서 오류가 발생했습니다.");
			
			// 요청 위임 객체 생성
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
			
			view.forward(request, response);
			// redirect는 요청 주소를 적지만 (/wsp/login.do)
			// forward는 요청할 페이지의 파일 경로를 적는다.
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
