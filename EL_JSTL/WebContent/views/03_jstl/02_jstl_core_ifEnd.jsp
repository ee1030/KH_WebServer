<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - core tag(if)</title>
</head>
<body>
	<h3>&lt;c:if> 태그 </h3>
	- Java의 if 문과 비슷한 역할을 하는 태그.<br>
	- &lt;c:if> 태그에서 조건식은 test라는 속성의 값으로 지정해야 함<br>
		이 때 조건식은 반드시 EL 형식으로 기술
	 
	 
	<hr> 
	
	<c:set var="n1" value="${param.num1}" />
	<c:set var="n2" value="${param.num2}" />
	
	<%-- 
		input 태그의 값(파라미터)은 문자열의 형태를 띄고 있으므로
		문자열 크기 비교가 일어남.
	--%>
	<c:if test="${n1 > n2}">
		${n1}은 ${n2}보다 큽니다. -> 문자열 비교
	</c:if>
	
	<c:if test="${Integer.parseInt(n1) > Integer.parseInt(n2)}">
		${n1}은 ${n2}보다 큽니다. -> 숫자 비교
	</c:if>
	
	<c:if test="${Integer.parseInt(n1) < Integer.parseInt(n2)}">
		${n1}은 ${n2}보다 작습니다. -> 숫자 비교
	</c:if>
	
	<c:if test="${Integer.parseInt(n1) == Integer.parseInt(n2)}">
		${n1}과 ${n2}는 같습니다. -> 숫자 비교
	</c:if>
</body>
</html>