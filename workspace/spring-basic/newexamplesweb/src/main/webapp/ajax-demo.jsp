<%@page import="java.util.Date"%>
<%@page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>
		 
<%
try {
	Thread.sleep(5000); // 1초 중지
} catch(Exception ex) {
	
}
%>
		 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	[<a href="ajax-demo.jsp">현재 시간 보기 (동기방식)</a>]
	[<a href="">현재 시간 보기 (비동기방식)</a>]
	<hr>
	<div>
		<%= new Date() %>
	</div>

</body>
</html>