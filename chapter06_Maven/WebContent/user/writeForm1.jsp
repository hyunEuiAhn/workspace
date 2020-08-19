<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="writeForm" method="post" action="/chapter06_Maven/user/write.do">
	<table>
		<tr>
			<td>이름 : </td>
			<td>
				<input type="text" id="name" name="name">
				<div id="nameDIV"></div>
			</td>
		</tr>
		<tr>
			<td>아이디 : </td>
			<td>
				<input type="text" id="id" name="id">
				<div id="idDIV"> </div>
			</td>

		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><input type="password" id="pwd" name="pwd">
				<div id="pwdDIV"> </div>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" id="writeBtn" value="login">
				<input type="button" id="resetBtn" value="초기화">
			</td>
		</tr>
	</table>
</form>
</body>
 <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.0.min.js"></script>
 <script type="text/javascript">
	$('#writeBtn').click(function(){
		$('#nameDIV').empty();
		$('#idDIV').empty();
		$('#pwdDIV').empty();
		
		if($('#name').val()==''){
			$('#nameDIV').text("이름을 입력하세요.").css('color','red').css('font-size', '8pt').css('font-weight','bold');
		}else if($('#id').val() ==''){
			$('#idDIV').text("아이디를 입력하세요").css('color','red').css('font-size', '8pt').css('font-weight','bold');
		}else if($('#pwd').val() ==''){
			$('#pwdDIV').text("패스워드를 입력하세요").css('color','red').css('font-size', '8pt').css('font-weight','bold');
		}else{
			document.writeForm.submit();
		} 
	});
	 $('#resetBtn').click(function(){
		$('#nameDIV').empty();
		$('#idDIV').empty();
		$('#pwdDIV').empty();
		
		$('#name').val('');
		$('#id').val('');
		$('#pwd').val('');
	}); 

</script>
</html>