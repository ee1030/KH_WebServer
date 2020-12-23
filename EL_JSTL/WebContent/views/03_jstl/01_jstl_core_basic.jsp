<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - core tag</title>
</head>
<body>
	<h3>라이브러리 등록 방법</h3>
	1) https://tomcat.apache.org/download-taglibs.cgi 접속<br>
	2) Standard-1.2.5 -> jar files -> 4개 다 다운로드<br>
	3) WebContent/WEB-INF/lib 에 추가<br>
	
	<hr>
	
	<h3>JSTL 선언 방법</h3>
	<pre>
	JSTL을 사용 하고자하는 JSP 페이지의 상단
 	page 지시자 아래에 taglib 지시자를 사용.
 	
	&lt;%@ taglib prefix="사용하고자 하는 접두사" uri="tld 파일상의 uri"  %> 
	
	prefix : 접두사. 다른 태그와 구별할 수 있는 namespace를 제공함.
	uri : 실제 웹상주소가 아니라, 태그라이브러리를 나타내는 식별자임. 
		tlb파일상의 uri값을 가리키며,
		이 지시자를 통해 작성한 태그이름과 매칭되는 자바코드를 찾음. <br />

	* tld(Tag Library Descriptor) 파일 : 커스텀 태그 정보를 갖고 있는 라이브러리 파일.
	* uri : (Uniform Resource Identifier) : 자원을 나타내는 유일한 주소
	
	</pre>
	
	<hr>
	
	<h3>JSTL core Library</h3>
	
	
	<p>
		<h4>1. 변수의 선언 - &lt;c:set> </h4>
	
		<pre>
		
		- 변수를 선언하고 초기값을 대입하는 기능을 가진 태그
		- 변수를 선언 할 때 scope를 지정할 수 있음. (기본값 page)
		
		- 사용법
		1) 변수 타입을 별도로 선언하지 않는다.
		2) c:set 태그로 선언한 변수를 사용할 경우 EL로 사용해야 한다.
		3) c:set으로 선언된 변수는 EL 구문에서는 사용할 수 있지만
		   scriptlet 내에서는 사용할 수 없다.
		</pre>
		
		<c:set var="car" value="람보르기니"/>
		<h3>${car}</h3>
		
		<!-- 전달된 파라미터 두개를 c:set을 이용하여 변수에 저장 -->
		
		<c:set var="n1" value="${param.num1}"/>
		<c:set var="n2" value="${param.num2}" scope="request"/>
		<c:set var="result" value="${n1*n2}" scope="session"/>
		
		${n1} * ${n2} = ${result}<br>
		${pageScope.n1} * ${requestScope.n2} = ${sessionScope.result}<br>
		
		
	</p>
	
	
	<hr>
	
	<p>
		<h4> 2. 변수의 삭제 - &lt;c:remove> </h4>
		
		<c:set var="result" value="9999" scope="request" />
		
		[삭제전]<br>
		request : ${requestScope.result}<br>
		session : ${sessionScope.result}<br>
		
		1)모든 스코프에서 삭제<br>
		<%-- <c:remove var="result" /> --%>
		
		2) 특정 스코프에서 삭제 <br>
		<c:remove var="result" scope="request"/>
		
		[삭제후]<br>
		request : ${requestScope.result}<br>
		session : ${sessionScope.result}<br>
	</p>	   
	
	<hr>
	<p>
		<h4> 3. 변수의 출력 - &lt;c:out> </h4>
		&lt;c:out> 태그는 데이터를 출력할 때 사용하는 태그<br>
		&lt;, >, & 특수 문자를 자동으로 이스케이프 시퀀스(escape sequance)로 바꿔줌.<br>
		
		<pre>
		* 특수 문자 이스케이프 시퀀스(escape sequance)
		< &lt;
		> &gt;
		& &amp;
		</pre>
		
		<c:out value="<h4>c:out 테스트 응애</h4>"/>
		<c:out value="<h4>c:out 테스트 응애</h4>" escapeXml="false"/>
			
			
	</p>
</body>
</html>