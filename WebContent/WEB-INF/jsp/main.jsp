<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.Tweet" %>
<%@ page import="java.util.List" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
List<Tweet> tweetList = (List<Tweet>) application.getAttribute("tweetList");
String errorMsg = (String) request.getAttribute("errorMsg");
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
<form action="/DokoTsubu/Main" method="post">
<input type="text" name="tweet">
<input type="submit" value="tweet!">
</form>
<% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } %>
<% for(Tweet tweet : tweetList){ %>
	<p><%= tweet.getUserName() %>:<%= tweet.getContext() %></p>
<% } %>
</body>
</html>