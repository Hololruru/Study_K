<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
    	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로또 당첨 예상 번호</title>
</head>
<body>
	<% int[] numbers = (int[])request.getAttribute("numbers"); %>
	
	<table border="1" style="width:500px;margin:0 auto">
		<caption style="text-align:center;font-size:25pt">당첨 예상 번호</caption>
		<tr>
		<% for (int number : numbers) { %>
			<th><%= number %></th>
		<% } %>
		</tr>
	</table>

</body>
</html>