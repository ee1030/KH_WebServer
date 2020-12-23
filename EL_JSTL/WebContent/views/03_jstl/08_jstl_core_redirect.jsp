<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - core tag(redirect)</title>
</head>
<body>
	<h3>&lt;c:redirect> 태그</h3>
	- response.sendRedirect() 메소드와 같음
	
	<!-- 주소창에 쿼리 스트링 ?test=1를 추가해서 요청해봄 -->
	<c:set var="test" value="${param.test}"/>
	
	<c:if test="${test == 1 }">
		<c:redirect url="01_jstl.jsp"/>
	</c:if>	
</body>
</html>