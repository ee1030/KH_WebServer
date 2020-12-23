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
	
	
	<hr>
	
	
	<h3>3. el 사용 시 내장객체에 저장된 속성명이 같은 경우</h3>
	
	
	<pre>
	     
	</pre>
	


	<br><br>
	<hr>
	<h3>4. 특정 내장 객체에 저장된 속성 다루기</h3>
	
	

	
</body>
</html>