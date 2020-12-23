<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El - Param</title>
</head>
<body>
	<h3>스크립팅 원소로 파라미터를 얻어와 출력하기</h3>
	<%
		String pname = request.getParameter("pname");
		String pcount = request.getParameter("pcount");
		String[] optionArr = request.getParameterValues("option");
	%>
	
	상품명 : <%=pname %><br>
	수량 : <%=pcount %><br>
	옵션 1 : <%=optionArr[0] %><br>
	옵션 2 : <%=optionArr[1] %>
	
	<hr>
	
	<h3>EL의 param을 이용하여 출력하기</h3>
	<p>
		param : 전달된 단일 파라미터값을 얻어올 때 사용.<br>
		paramValues : 전달된 복수 파라미터 값을 배열로 얻어올 때 사용.
	</p>
	
	상품명 : ${param.pname}<br>
	수량 : ${param.pcount}<br>
	옵션 1 : ${paramValues.option[0]}<br>
	옵션 2 : ${paramValues.option[1]}<br>
</body>
</html>