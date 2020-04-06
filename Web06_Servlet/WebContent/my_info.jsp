<%@ page import="edu.web.servlet05.InfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 페이지</title>
</head>
<body>
	<%!
	String name;
	String lived;
	int age;
	InfoVO vo;
	%>
	
	<%
	name = (String)request.getAttribute("name");
	lived = (String)request.getAttribute("lived");
	age = (Integer)request.getAttribute("age");
	%>
	
	<p>이름 : <%=name %></p>
    <p>나이 : <%=age %></p>
    <p>사는 곳 : <%= lived %></p>
</body>
</html>