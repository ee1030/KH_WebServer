<%@page import="com.kh.el.model.vo.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL - Operation</title>
</head>
<body>
	<h2>EL연산 </h2>
	<p>
		el을 가지고 어떤 연산을 처리하지 않음. 속성값들을 화면에 뿌리기 위한 용도임. <br />
		하지만, 산술연산 및 논리연산을 지원함. 간단한 논리연산은 자주 사용함.
	</p>
	
	<h3>산술연산</h3>
	
	10 더하기 5 = ${10 + 5}<br>
	10 빼기 5 = ${10 - 5}<br>
	10 곱하기 5 = ${10 * 5}<br>
	10 나누기 5 = ${10 / 5} 또는<%--  ${10 div 5} --%><br>
	<!-- 에러가 발생하겠지만 문제없음 -->
	
	10 나누기 7의 나머지 = ${10 % 7} 또는 ${10 mod 7}<br>
	
	<hr>
	
	<h3>여리 가지  연산</h3>
	
	<h4>객체 비교 연산</h4>
	<%
		String sOne = "안녕";
		String sTwo = new String("안녕");
		
		// Person VO 만들기
		Person pOne = new Person("홍길동",20,'남');
		Person pTwo = new Person("홍길동",20,'남');
		
		// page socpe 범위(현재 페이지) 에 세팅
		pageContext.setAttribute("sOne", sOne);
		pageContext.setAttribute("sTwo", sTwo);
		pageContext.setAttribute("pOne", pOne);
		pageContext.setAttribute("pTwo", pTwo);
		
	%>	
	
	<table border="1">
		<tr>
			<th>비교식</th>
			<th>scriptlet</th>
			<th>el</th>
		</tr>
		<tr>
			<td>sOne == sTwo</td>
			<td><%=sOne == sTwo %></td>
			<td>${sOne == sTwo} 또는 ${sOne eq sTwo }</td>
			<!-- el의 == 연산은 equals()와 같은 동작을 함 -->
		</tr>
		<tr>
			<td>sOne != sTwo</td>
			<td><%=sOne != sTwo %></td>
			<td>${sOne != sTwo} 또는 ${sOne ne sTwo }</td>
		</tr>
		<tr>
			<td>pOne == pTwo</td>
			<td><%=pOne == pTwo %></td>
			<td>${pOne == pTwo} 또는 ${pOne eq pTwo }</td>
			<!-- el의 == 연산은 equals()와 같은 동작을 함 -->
		</tr>
		<tr>
			<td>pOne != pTwo</td>
			<td><%=pOne != pTwo %></td>
			<td>${pOne != pTwo} 또는 ${pOne ne pTwo }</td>
		</tr>
	</table>
	<br><br>
	
	<h4>숫자형 자동 형변환</h4>
	<%
		// int형 값인 10, 3을 세팅 했지만
		// 웹 애플리케이션 객체에 setAttribute된 값은 Obejct 타입으로 저장됨
		pageContext.setAttribute("big", 10);
		pageContext.setAttribute("small", 3);
	%>
	scriptlet : <%-- <%=  pageContext.getAttribute("big") + pageContext.getAttribute("small")%> --%>
	<!-- Object 타입 끼리 더하기가 성립되지 않음 -->
	<br>
	
	<!-- el은  scope에 속성으로 담긴타입은 Object를 자동으로 인식하여 형변환 후 연산을 처리함 -->
	el : ${big + small }
	<br>
	
	<h4>숫자형 자동 형변환 + 비교 연산</h4>
    big>small : ${big > small } 또는 ${big gt small } <br>
    big&lt;small : ${big<small } 또는 ${big lt small }<br><br>
    big>=small : ${big >= small } 또는 ${big ge small } <br>
    big&lt;=small : ${big <= small } 또는 ${big le small }<br><br>
    
	 \${big+small } : ${big+small } <br /><br /> 
	
	
	
	
	<h4>객체가 null 또는 비어있는지 체크</h4>	
	<%   
		Person person = null; // 아무것도 참조하지 않는 참조 변수 선언
		List<String> list = new ArrayList<>();
		
	    pageContext.setAttribute("person",person); // page scope에 세팅
	%>
	
    \${empty person } = ${empty person} <br><br>
    \${empty list } = ${empty list} <br><br>
    
    <h1 style="color:red">EL은 NullPointerException을 발생시키지 않는 특징이 있음!</h1>
    ${person.name }
    
    
    
    <h4>논리연결연산자/부정연산자</h4>
    ${true and true } 또는 ${true && true } <br>
    ${true or true } 또는 ${true || true } <br>
    ${! (big<small) }
</body>
</html>