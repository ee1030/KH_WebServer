<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - core tag(forEach)</title>
</head>
<body>
<!--  
	EL 3.0 버전 이상을 지원하는 was에서만 EL컬렉션객체 사용 가능
	톰캣 8.0부터 EL 3.0을 지원함.
-->
<c:set var="myList" value='${["A","B","C","D","E"]}' scope="request" />

<c:set var="mySet" value='${{"A","B","C","B","A"}}' scope="request" />

<c:set var="myMap" value='${{"name":"홍길동", "job":"학생", "age":20}}' scope="request" />
<!-- Map객체의 키값은 문자열로 전달함. -->

<jsp:forward page="05_jstl_core_forEach2End.jsp"/>
<!-- 현재 페이지에서 선언된 요청 정보(request scope)를
	page 속성에 작성된 주소로 위임하겠다.
 -->
</body>
</html>