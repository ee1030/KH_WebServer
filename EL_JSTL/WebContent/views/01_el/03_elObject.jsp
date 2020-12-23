<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL - Object</title>
</head>
<body>
	<h2>그 밖의 EL 내장객체 : cookie, initParam, header, pageContext</h2>
	<h3>cookie</h3>
	
	쿠키에서 얻어온 saveId 값 : ${cookie.saveId.value} <br>
	id : <input type="text" name="userId" value="${cookie.saveId.value}"> <br>
	<br><br>
	
	쿠키에 저장되지 않은 값을 얻어와 출력해보기 : ${cookie.savePwd.value}
	
	<pre>
	EL의 장점 중 하나는
	EL을 처리하는 도중 NullPointerException이 발생해도
	예외를 발생 시키지 않고 빈칸으로 처리함.
	만약 산술 연산에 null이 포함되면 0, 논리 연산에 null이 포함되면 false로 처리함.
	10 + null = 0
	</pre>
	
	<hr>
	

	<h3>컨텍스트 초기화 파라미터 : initParam</h3>
	<p>web.xml에 설정한 초기화 파라미터값을 가져옴. 서블릿초기화 파라미터 아님</p>
	컨텍스트파라미터 : ${initParam.email} <br />
	컨텍스트파라미터(스크립팅) : <%= application.getInitParameter("email") %>
	
	
	<hr>
	
	<h3>기타 request객체의 메소드를 el로 호출하기</h3>
	
	프로젝트의 시작 주소(context-root)를 얻어오는 방법<br>
	
	표현식 : <%= request.getContextPath() %> <br>
	
	EL : ${pageContext.request.contextPath}
	
</body>
</html>