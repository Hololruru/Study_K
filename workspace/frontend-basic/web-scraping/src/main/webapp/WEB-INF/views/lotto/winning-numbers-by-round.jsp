<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회차별 당첨 번호 조회</title>
</head>
<body>

	<table border="1" style="margin: 0 auto">
		<tr>
			<td colspan="7" style="height:70px">
				<select id="round">
					<c:forEach var="idx" begin="1" end="${ round }">
						<option>${ round - idx + 1 }</option>
					</c:forEach>
				</select>
				<button id="search-btn">조회</button>
			</td>
		</tr>
		<tr>
		<c:forEach var="number" items="${ numbers }">
			<td style="width:70px;height:70px;text-align:center">${ number }</td>
		</c:forEach>			
		</tr>
	</table>
	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#search-btn').on('click', function(event) {			
			const round = $('#round option:selected').text();
			$.ajax({
				"url": "winning-numbers-by-round",
				"method": "post",
				"data" : "round=" + round,
				"dataType": "json",
				"success": function(data, status, xhr) {
					
				},
				"error": function(xhr, status, err) {
					
				}
			});
		});
	});
	</script>

</body>
</html>










