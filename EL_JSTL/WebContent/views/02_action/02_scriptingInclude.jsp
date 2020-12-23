<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정적 include</title>
</head>
<body>
	<h1>정적 include 방식</h1>
	<pre>
	현재 페이지에 포함되어지는 jsp 파일이
	컴파일 전에 지정된 위치에 삽입되어
	하나의 거대한 jsp파일로 컴파일 됨.
	
	특징 : 추가된 페이지에 선언된 변수를 그대로 사용 할 수 있음.
	문제점 : 현재 페이지와 추가된 페이지가 동일한 이름의 변수를 가질 수 없다.
				(변수명 충돌)
	</pre>
	
	<%@include file="test.jsp" %><br><br>
	
	현재 년도 : <%=year %>
	
	<%-- <% String year = "2021"; %>
		Duplicate local variable year
		== 변수명 중복
	--%>
	

</body>
</html>