<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동적 include 방식</title>
</head>
<body>
	<h3>JSP Action Tag란?</h3>
	<pre>
	JSP Action 태그는 XML 기술을 이용하여 
	기존의 JSP 문법을 확장하는 메커니즘을 제공하는 태그로, 
	
	웹 브라우저에서 실행되는 것이 아니라, 
	웹 컨테이너에서 실행되고 결과만 브라우저로 보냄.
	
	JSP 페이지에서 바로 사용 가능하고
	태그 앞에 jsp: 접두어가 붙음
	
	<%--
		<jsp:include page="jsp파일 경로"></jsp:include>
	--%>
	</pre>
	
	<h3>동적 include</h3>
	<pre>
	현재 페이지에 삽입되는 페이지가
	컴파일 이전이 아닌, 현재 페이지가 요청되어 출력되는 시점에
	하나로 합쳐지는 방식
	
	특징 : 정적 include에서의 문제점인 변수명 중복이 발생하지 않는다.
			(변수명 중복 검사는 컴파일 시에 수행됨.)
			
			+ 현재 페이지에서 삽입 되는 페이지로 데이터 전달이 가능함.
	</pre>
	<%-- 전달하고자 하는 값을 작성할 수 있음. --%>
	<jsp:include page="test.jsp">
		<jsp:param name="age" value="30"/>
	</jsp:include>
</body>
</html>