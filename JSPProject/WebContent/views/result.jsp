<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String pizza = request.getParameter("pizza");
	String topping = (String)request.getAttribute("toppingJoin");
	String side = (String)request.getAttribute("sideJoin");
	
	int totalPrice = (int)request.getAttribute("totalPrice");
	
	if(topping.equals("null")) {
		topping = "(없음)";
	}
	
	if(side.equals("null")) {
		side = "(없음)";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.pizza {
		color : red;
	}
	
	.topping {
		color : green;
	}
	
	.side {
		color : blue;
	}
	
	.total {
		text-decoration : underline;
	}
	
	.ment {
		color : coral;
	}
	
</style>
</head>
<body>
	<h1>주문 내역</h1>
	<h2>
	피자는 <span class="pizza"><%=pizza%></span>,
	토핑은 <span class="topping"><%=topping %></span>,
	사이드는 <span class="side"><%=side %></span> 주문하셨습니다.<br><br><br>
	
	총합 : <span class="total"><%=totalPrice %>원</span>
	</h2>
	
	<h2><span class="ment">즐거운 식사시간 되세요 ~</span></h2>
</body>
</html>