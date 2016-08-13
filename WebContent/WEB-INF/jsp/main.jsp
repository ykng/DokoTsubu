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
<h1>Main Screen of DokoTsubu</h1>
<p>Welcome <%= loginUser.getName() %> !</p>
<p><a href="/DokoTsubu/Logout">logout</a>
</body>
</html>