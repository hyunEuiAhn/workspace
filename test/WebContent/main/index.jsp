<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="test.css" type="text/css"></link>
</head>
<body>
<header id="header">
	<h1 align="center">Web Site</h1>
</header>
<article id="login">

</article>


<section id="main">
		
</section>

</body>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#login').load('login.jsp');
	$('.check').hide();
	$.getScript('test.js');	//script파일 호출
});
</script>
</html>
