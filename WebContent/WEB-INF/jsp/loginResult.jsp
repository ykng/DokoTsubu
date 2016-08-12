<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DokoTsubu</title>
</head>
<body>
<h1>DokoTsubu Login</h1>
<% if(loginUser != null) { %>
	<p>Login sucessed!</p>
	<p>Welcome <%= loginUser.getName() %> !</p>
	<a href="/DokoTsubu/Main">To tweet post and watch</a>
<% } else { %>
	<p>login failed</p>
	<a href="/DokoTsubu/">To Top</a>
<% } %>
</body>
</html>