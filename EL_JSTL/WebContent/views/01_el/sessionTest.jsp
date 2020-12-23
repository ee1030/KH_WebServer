<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	학원명(session scope) : ${academyName}<br>
	강의장(request scope) : ${classRoom} <br>
	
	<button onclick="history.back();">돌아가기</button>
</body>
</html>