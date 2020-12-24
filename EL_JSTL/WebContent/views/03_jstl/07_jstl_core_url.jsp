<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - core tag(url)</title>
</head>
<body>
	<h3>&lt;c:url> 태그</h3>
	- url 경로를 생성하고, 해당 url의 param 속성을 선언하여 쿼리스트링을 정의할 수 있는 태그<br>
	- 해당 태그를 통해 url 경로와 관련 쿼리스트링의 값을 미리 설정하여 이를 제어할 수 있음
	<br><br>

	<c:url var="url" value="07_jstl_core_urlEnd.jsp">
		<c:param name="pname">아메리카노</c:param>
		<c:param name="pcount">1</c:param>
		<c:param name="option">응애샷</c:param>
		<c:param name="option">애응추가</c:param>
	</c:url>
	
	<a href="${url}"> 07_jstl_core_urlEnd.jsp </a>
</body>
</html>