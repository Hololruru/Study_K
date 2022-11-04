<%@page import="java.util.Date"%>
<%@page language="java" 
		contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
    	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">

</head>
<body>

<form action="summernote-write" method="post">
	<input type="text" name="title">
	<textarea id="summernote" name="content"></textarea>
	<input type="submit" value="글쓰기">
</form>
    
	
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

<script>
$(function() {
  $('#summernote').summernote({
    placeholder: 'Hello Bootstrap 4',
    tabsize: 2,
    height: 400,
    callbacks: {
    	onImageUpload: function(files) {
    		// 서버로 이미지 전송
    		upload_image_file(files[0], this);
    	}
    }  
  	
  });
  
  function upload_image_file(file, editor) {
	  formData = new FormData();
		formData.append("file", file);
		$.ajax({
			data : formData,
			type : "POST",
			url : "/demo-one/demo/upload-image-file",
			contentType : false,
			processData : false,
			success : function(data) {
				$(editor).summernote('insertImage', data);
			}
		});
  }
});
</script>

</body>
</html>












