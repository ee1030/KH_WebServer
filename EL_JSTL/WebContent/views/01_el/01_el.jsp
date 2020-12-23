<%@page import="com.kh.el.model.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 이란?</title>
</head>
<body>
	<h3>EL 이란?</h3>
	<pre>
		Expression Language(표현 언어)의 약자
		
		&lt;%= %&ht; 와 같은 JSP 출력에 사용되는 java 코드를
		간결하게 사용하는 방법으로 화면에 표현하고자 하는 코드를
		\${ value } 형식으로 작성하는 것
	</pre>

	<h3>1. scriptlet을 이용하여 request,session 객체에 저장된 속성  화면 출력하기</h3>
	
	<%
		// 1. request, session 객체에 저장된 속성 scriptlet을 이용하여 화면 출력하기
		String classRoom = (String)request.getAttribute("classRoom");
		Person person = (Person)request.getAttribute("person");
		
		// Session scope 속성값 얻어오기
		String academyName = (String)request.getSession().getAttribute("academyName");
		
	%>
	
	
	학원명 : <%=academyName %><br>
	강의장 : <%=classRoom %><br>
	<br>
	수강생 정보
	<ul> 
		<li>이름 : <%=person.getName() %></li>
		<li>나이 : <%=person.getAge() %></li>
		<li>성별 : <%=person.getGender() %></li>
	</ul>
	
	
	<hr>
	
	
	<h3>2. el을 이용하여 request, session 객체에 저장된 속성 화면 출력하기</h3>
	학원명 : ${academyName}<br>
	강의장 : ${classRoom} <br>
	<%-- ${classRoom} == <%= request.getAttribute("classRoom") %>
	
		${속성명} 을 작성한 경우 
		page -> request -> session -> application 범위 순서로 접근하며
		일치하는 속성명이 있는 경우 해당 속성의 값을 얻어와 출력함.
	--%>
	<br>
	수강생 정보
	<ul> 
		<li>이름 : ${person.name}</li>
		<li>나이 : ${person.age}</li>
		<li>성별 : ${person.gender}</li>
		<%--
			EL은 객체에 저장된 필드 값을 얻어올 때
			${객체명.필드명} 을 작성하면
			자동적으로 해당 필드의 getter 메소드를 이용하여 값을 얻어온다.
			
			-> 반대로 생각하면
			   EL을 이용해서 객체의 필드값을 얻어 오려면
			   객체에서 반드시 getter/setter가 작성되어 있어야 한다.
		--%>
	</ul>
	
	<a href="/EL_JSTL/views/01_el/sessionTest.jsp">
		Session Scope Test
	</a>
	
	<hr>
	
	
	<h3>3. el 사용 시 내장객체에 저장된 속성명이 같은 경우</h3>
	
	
	<pre>
	웹 애플리케이션에서 객체는 4가지 영역(범위)를 가짐
	page, request, session, application 
	1. page 영역
	 - 하나의 JSP 페이지 내에서만 객체 공유
	  -> forward 되더라도 해당 페이지에 지정된 변수를 사용할 수 없다.
	 - pageContext라는 JSP 내장 객체를 사용해도 선언 가능
	 
	2. request 영역
	 - 요청을 하는 페이지 + 요청을 위임 받은(응답) 페이지 에서 객체 공유
	 - Servlet에서 JSP로 객체를 공유하는 경우
	  -> request.setAttribute("속성명", 객체); 로 전달
	  -> JSP에서는 Object obj = request.getAttribute("속성명"); 으로 받음.
	  
	3. session 영역
	 - 하나의 브라우저당 1개의 session 객체가 생성되며 같은 브라우저 내에서 객체를 공유.
	 - 브라우저가 종료되거나 session이 만료되면 반환됨.
	 - request.getSession() 메소드를 호출하여 session영역 객체를 얻어옴
	
	    
	4. application 영역
	 - 하나의 웹 애플리케이션당 하나의 application 객체가 생성됨.
	 - 애플리 케이션이 종료되기 전 까지 모든 페이지에서 객체 공유
	 - request.getServletContext() 메소드를 호출하여 application 영역 객체를 얻어옴.
	 
	모든 웹 애플리케이션 객체는 
	setAttribute("속성명", 객체)로 세팅,
	getAttribute("속성명")로 객체를 얻어올 수 있음.
	 
	 el은 page -> request -> sessionS -> applicationScope 순으로 속성을 찾는다.
	 
	</pre>
	
	<br><br>
	<hr>
	<h3>4. 특정 내장 객체에 저장된 속성 다루기</h3>
	scope 출력 : ${scope}<br>
		<!-- request, session 중 범위가 작은 request가 출력됨 -->
	session에 있는 scope를 출력하고 싶을때 : ${sessionScope.scope} <br>
	request에 있는 scope를 출력하고 싶을때 : ${requestScope.scope} <br>
	

	
</body>
</html>