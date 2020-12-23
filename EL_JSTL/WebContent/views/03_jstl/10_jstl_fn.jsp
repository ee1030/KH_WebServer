<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Function Tags</title>
</head>
<body>
	<h2>문자열 관련 함수 태그 : fn</h2>
	문자열 처리에 관한 메소드들을 EL 형식에서 사용할 수 있게 제공<br>
	
	<c:set var="str" value="How are you?"/>
	str : ${str } <br>
	모두 대문자 : ${fn:toUpperCase(str) }<br>
	모두 소문자 : ${fn:toLowerCase(str) }<br>
	문자열 길이 : ${fn:length(str) }<br>
	are의 시작 위치 : ${fn:indexOf(str,"are") }<br>
	are -> were 변경 : ${fn:replace(str,"are","were") }<br>
	replace 후 str : ${str }<br> <%--원본 문자열에 영향을 주지 않는다. --%>
</body>
</html>