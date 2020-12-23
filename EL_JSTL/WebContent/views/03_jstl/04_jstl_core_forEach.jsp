<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - core tag(forEach)</title>
</head>
<body>
	<h3>&lt;c:forEach> 태그 </h3>
	- Java의 for문에 해당하는 기능을 제공하는 태그
	- forEach는 여러가지 속성이 사용됨
	<pre>
	var : 현재 반복 횟수에 해당하는 변수의 이름
	begin : 반복이 시작할 요소 번호 (0 … n)
	end : 반복이 끝나는 요소 번호
	step : 반복 시 증가할 수
	items : 반복할 객체 명 (Collection 객체)
	varStatus : 현재 반복에 해당하는 객체의 요소
	</pre>
	
	<h3>기본 사용법</h3>
	<c:forEach var="i" begin="1" end="6">
		<h<c:out value="${i}" />>c:out으로 반복문 사용</h<c:out value="${i}" />>
		<h${i}>EL로 반복문 사용 </h${i}>
		<p>-------------------------------------------</p>
	</c:forEach>
	
	
	<hr>
	
	<h3>step 속성</h3>
	step속성의 값은 0보다 작거나 같을 수 없음.
	
	<c:forEach var="i" begin="1" end="6" step="2">	
			<h${i}>건너뛰기 ${i}</h${i}>
	</c:forEach>
	
	
	<hr>
	
	<h3>역순</h3>
	<c:forEach var="k" begin="1" end="6">	
		<h${7-k}>역순 ${7-k}</h${7-k}>
	</c:forEach>
	
</body>
</html>