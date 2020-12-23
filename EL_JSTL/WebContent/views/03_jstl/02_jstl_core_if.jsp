<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <form action="02_jstl_core_ifEnd.jsp">
		첫번째 수 : <input type="text" name="num1" /><br/>
		두번째 수 : <input type="text" name="num2" /><br/>
		<button type="submit">확인</button> 
	</form>
</body>
</html>