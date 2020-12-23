<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - core tag(choose)</title>
</head>
<body>
		<h3>&lt;c:choose> 태그 </h3>
		
		<c:choose>
			<c:when test="${Integer.parseInt(param.num1) == 1}">
				문화상품권을 뽑으셨습니다.
			</c:when>
			
			<c:when test="${Integer.parseInt(param.num1) == 2}">
				과자 선물 세트를 뽑으셨습니다.
			</c:when>
			
			<c:when test="${Integer.parseInt(param.num1) == 3}">
				과제를 뽑으셨습니다.
			</c:when>
			
			<c:when test="${Integer.parseInt(param.num1) < 0}">
				잘못 입력하셨습니다.
			</c:when>
			
			<c:otherwise>
				꽝입니다.
			</c:otherwise>
		</c:choose>
		
</body>
</html>