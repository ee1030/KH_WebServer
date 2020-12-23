<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - fmt tag</title>
</head>
<body>
	<h2>JSTL Formatting Tags</h2>
	날짜, 시간, 숫자 데이터의 출력 형식을 지정할 때 사용하는 태그<br>
	
	<hr>
	
	<h3>숫자 데이터 포맷 지정 : formatNumber 태그</h3>
	- 표현하고자 하는 숫자의 포맷을 통화 기호, ‘ , ’ 표시, %표시 등 <br>
	   원하는 쓰임에 맞게 지정할 수 있다<br><br>
	   
 	<h4>groupingUsed : 숫자 단위의 구분자(,) 표시 여부 </h4>
	숫자 그대로 출력 : <fmt:formatNumber value="123456789" groupingUsed="false"/><br>
	천단위 구분 기호 적용 : <fmt:formatNumber value="123456789" groupingUsed="true"/><br>

	<hr>
	
	<h4>pattern : 화면에 표현할 데이터 스타일을 지정</h4>
	실수값 소숫점 아래 자릿수 지정 : #, 0 을 자릿수로 사용하며, 초과된 부분은 반올림 됨.<br><br>
	#을 사용한 경우 : <fmt:formatNumber value="1.234567" pattern="#.##"/><br>
	0을 사용한 경우 : <fmt:formatNumber value="1.234567" pattern="#.000"/><br>
	
	<hr>
	
	<h4>type : 백분율, 통화 기호등 표시 타입 지정</h4>
	type 속성 종유 : number, currency, percent
	<fmt:formatNumber value="0.12" type="percent"/><br>
	<fmt:formatNumber value="123456789" type="currency"/><br>
	<fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/><br>
	currencySymbol : type 속성이 "currency"일 경우, 표시할 화폐 기호<br>
	
	<hr>
	
	<h4>setLocale : 지역대 설정</h4>
	<fmt:formatNumber value="123456789" type="currency"/><br>
	<fmt:setLocale value="en-US"/>
	<fmt:formatNumber value="123456789" type="currency"/><br>
</body>
</html>