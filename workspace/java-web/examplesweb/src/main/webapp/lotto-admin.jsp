<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lotto Admin</title>
<style type="text/css">
input[type=text] {
	width:50px;
}
</style>
</head>
<body>
	<form action="lotto-admin" method="post">
	<table border="1" style="margin: 0 auto">
		<tr>
			<td><input type="text" name="no1"></td>
			<td><input type="text" name="no2"></td>
			<td><input type="text" name="no3"></td>
			<td><input type="text" name="no4"></td>
			<td><input type="text" name="no5"></td>
			<td><input type="text" name="no6"></td>
		</tr>
		<tr>
			<th colspan="6"><input type="submit" value="저장"></th>
		</tr>
	</table>
	</form>

</body>
</html>





