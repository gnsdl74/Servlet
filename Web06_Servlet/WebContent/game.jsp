<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 결과페이지</title>
</head>
<body>
	<%!String name, age, game;%>

	<%
		name = request.getParameter("name");
		age = request.getParameter("age");
		game = request.getParameter("game");
	%>
	
	<h1>설문 조사 결과!</h1>
	<p>이름은 <b>'<%=name %>'</b>이고</p>
	<p>나이는 <b>'<%=age %>세'</b>이며</p>
	<p>선호하는 게임 장르는 <b>'<%=game %>'</b>입니다.</p>
</body>
</html>