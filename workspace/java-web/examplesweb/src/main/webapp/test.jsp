<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>발표 순서</title>
</head>
<body>
	<%
	
	int[] teamNumbers = new int[4];
	for (int i = 0; i < teamNumbers.length; i++) {
		teamNumbers[i] = (int)(Math.random() * 4) + 1;
		for (int j = 0; j < i; j++) {
			if (teamNumbers[i] == teamNumbers[j]) {
				i = -1;
			}
		}
	}
	%>
	
	<table border="1" style="width:500px;margin: 0 auto">
		<tr style="height: 150px">
			<% for (int i = 1; i < 5; i++) { %>			
			<th><%= i %>번째</th>
			<% } %>
		</tr>
		<tr style="height: 150px">
			<% for (int i = 0; i < teamNumbers.length; i++) { %>
				<th><%= teamNumbers[i] %></th>
			<% } %>
		</tr>
	</table>

</body>
</html>