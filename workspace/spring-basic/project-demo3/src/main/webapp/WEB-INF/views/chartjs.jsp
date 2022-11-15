<%@page import="java.util.Date"%>
<%@page language="java" 
		contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
    	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chart.js Demo</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>

<div class="container">
	<button type="button" id="load-iris" class="btn btn-primary mt-3">load iris dataset</button>
	<hr>
	<canvas id="the-chart"></canvas>
</div>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>   
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script type="text/javascript">
$(function() {
	
	var dataset = null;
	
	$('#load-iris').on('click', function(event) {
		$.ajax({
			"url": "load-iris-dataset",
			"method": "get",
			"dataType": "json", // 수신하는 데이터 형식
			"success": function(data, status, xhr) {
				dataset = data;
				alert('데이터 준비 완료');
			},
			"error": function(xhr, status, err) {
				alert('fail to load dataset');
			}
		});
	});
	
	$('#chart-demo-1').on('click', function(event) {
		
	  const ctx = document.getElementById('the-chart');

	  new Chart(ctx, {
	    type: 'bar',
	    data: {
	      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'], // x축 tick
	      datasets: [{
	        label: '# of Votes',			// data series name
	        data: [12, 19, 3, 5, 2, 3], 	// y축 data
	        borderWidth: 1
	      }]
	    },
	    options: {
	      scales: {
	        y: {
	          beginAtZero: true
	        }
	      }
	    }
	  });
	});
});
</script>

</body>
</html>












