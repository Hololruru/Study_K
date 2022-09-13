<%@page import="java.util.Date"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example web home</title>
</head>
<body>

	<h1 style='text-align:center'>Java based ExamplesWeb Home</h1>
	<h1 style='text-align:center'><%= new Date().toString() %></h1>
	<br><br>
	<div style="width:700px;margin:0 auto">
	<h2>1. <a href="hello-servlet">Hello, Servlet ( GET 방식 )</a></h2>
	<h2>2. <a href="hello-servlet2">Hello, Servlet 2 ( GET 방식 )</a></h2>
	</div>

</body>
</html>










