<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
	color: magenta;
	font-size:8pt;
}
</style>
</head>
<body>
<table>
		<tr>
			<th colspan = "2" align = "left">수정할 아이디 검색 </th>
		</tr>
		<tr>
			<td colspan = "2" align = "left">
				<input type="text" id="id" name="id">
				<div id="idDiv"></div>
				<input type="button" value="검색" id="searchBtn">
			</td>
		</tr>
</table>
<form action="../user/modify.do" id="modifyForm" method="post" >
	<table>
		<tr></tr>
		<tr>
			<td>이름 : </td>
			<td>
				<input type="text" id="name" name="name">
				<div id="modifyNameDiv"></div>
			</td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td>
				<input type="password" id="pwd" name="pwd">
				<div id="modifyPwdDiv"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button"  value="수정" id="modifyBtn"></td>
		</tr>
	</table>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.0.min.js"></script>
<script>
$(document).ready(function(){
	$('#modifyForm').hide();
	$('#searchBtn').click(function(){
		$.ajax({
			type : 'POST',
			url : '/chapter06_Maven/user/checkId.do',
			data : 'id='+$('#id').val(),
			dataType : 'text',
			success : function(data){
				if(data == 'not_exist'){
					$('#idDiv').text('찾는 아이디가 없습니다.');
				}else if(data == 'empty'){
					$('#idDiv').text('먼저 아이디를 입력하세요');
				}else{
					$.ajax({
						type : 'POST',
						url : '/chapter06_Maven/user/getDTO.do',
						data : 'id='+$('#id').val(),
						dataType : 'json',
						success : function(data){
							$('#modifyForm').show();
							$('#idDiv').empty();
							$('#name').val(data.userDTO.name);
							$('#pwd').val(data.userDTO.pwd);
						}
					});
				}
			}
		});
	});
	$('#modifyBtn').click(function(){
		$.ajax({
			type : 'POST',
			url : '/chapter06_Maven/user/checkId.do',
			data : 'id='+$('#id').val(),
			dataType : 'text',
			success : function(data){
				if(data == 'not_exist'){
					$('#idDiv').text('찾는 아이디가 없습니다.');
					$('#modifyForm').hide();
				}else if(data == 'empty'){
					$('#idDiv').text('먼저 아이디를 입력하세요');
					$('#modifyForm').hide();
				}else{
					$('#idDiv').empty();
					if($('#name').val()==''){
						$('#modifyNameDiv').text('수정할 이름을 입력하세요');
					}else if($('#pwd').val()==''){
						$('#modifyPwdDiv').text('수정할 패스워드를 입력하세요');
					}else{
						$('#modifyForm').submit();	
					}
				}
			}
		});
	});
});

</script>
<!-- script type="text/javascript">
	$('#searchBtn').click(function(){
		$.ajax({
			type : 'POST',
			url : '/chapter06_Maven/user/getUser.do',
			data : 'id='+$('#id').val(),
			dataType : 'json',
			success : function(data){
				alter(JSON.stringify(data));
				
				if(data.map==null){
					$('#showResult').html('<strong>찾고자 하는 아이디가 없습니다.</strong>');
					$('#showResult').css('color', 'red');
					return false;
				}
				$('#modifyForm').show();
				$('#showResult').empty();
				$('#name').val(data.map.NAME);
				$('#id').val(data.map.ID);
				$('#pwd').val(data.map.PWD);
			}
		});
	});
	
	$('modifyBtn').click(function(){
		$('nameDiv').empty();
		$('pwdDiv').empty();
		
		if($(''name).val()==""){
			$('#nameDiv').text('이름을 입력해주세여!');
		}else if($('#pwd').val() == ""){
			$('#pwdDiv').text('패스워드를 입력해주세여!');
		}else{
			$.ajax({
				type : 'POST'
				url : /chapter06_Maven/user/modify.do
				data : { 'name' : $(#name).val(),
						'id' : $(#id).val(),
						'pwd' : $(#pwd).val()}
				success : function(data){
				
				alert("수정성공");
				location.href="/chapter06_Maven/user/getUserList.do";
				}
			});
		}
		
	});
</script-->
</html>