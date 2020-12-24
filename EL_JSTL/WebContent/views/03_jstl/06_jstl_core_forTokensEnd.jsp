<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - core tag(forTokens)</title>
</head>
<body>
	<h3>&lt;c:forTokens> 태그</h3>
	- 문자열에 포함된 구분자를 통해 토큰을 분리해서 반복 처리
	- items 속성에는 토큰을 포함하는 문자열을 지정하고, 
	   delims 속성에는 토큰을 분리하는데 사용할 구획 문자를 기술.

	<h3>device</h3>
	<!-- 컴퓨터,핸드폰,TV,에어컨,냉장고,세탁기 -->
	<ul>
		<c:forTokens var="i" items="${device}" delims=",">
			<li>${i}</li>
		</c:forTokens>
	</ul>
	
	<hr>
	
	
	<h3>device2</h3>
	<ul>
		<c:forTokens var="i" items="${device2}" delims=",./">
			<li>${i}</li>
		</c:forTokens>
	</ul>
</body>
</html>