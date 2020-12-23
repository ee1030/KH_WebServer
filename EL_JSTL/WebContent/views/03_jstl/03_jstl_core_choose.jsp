<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - core tag(choose)</title>
</head>
<body>

	<h3>&lt;c:choose> 태그 </h3>
	- Java의 if-else if-else, switch 문과 비슷한 역할을 하는 태그.
	- &lt;c:when>, &lt;c:otherwise> 태그와 함께 사용되는데,
	각각 switch 문의 case, default 절과 비슷한 역할을 함.

	
	 <form name="genderFrm" action="03_jstl_core_chooseEnd.jsp">
        <h2>경품뽑기</h2>
       		숫자를 입력하세요 : <input type="number" name="num1"><br>
        <button type="submit">확인</button> 
    </form>
</body>
</html>