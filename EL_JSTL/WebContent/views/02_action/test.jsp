<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String year = String.format("%tY", new Date());
%>

<p>
	2005 ~ <%= year %> 이 웹페이지는 저작권은 KH 정보교육원에 있습니다.
</p>

<h1>age : ${param.age}</h1>