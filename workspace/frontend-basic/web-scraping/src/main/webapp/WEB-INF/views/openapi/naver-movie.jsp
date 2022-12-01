<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 영화 검색</title>
</head>
<body>

	<h2>네이버 영화 검색</h2>
	<input type="text" id="movie-title">
	<button id="search-btn">검색</button>
	<hr>
	
	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#search-btn').on('click', function(event) {
			const title = $('#movie-title').val();
			if (title.length == 0) {
				alert('검색어를 입력하세요');
				return;
			}
			
			$.ajax({
				"url": "search-movie",
				"data": "title=" + title,
				"method": "get",
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