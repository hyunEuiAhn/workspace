<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../user/delete.do" id="deleteForm" method="post">
	<table>
		<tr>
			<th colspan = "2" align = "left">삭제할 아이디 </th>
		</tr>
		<tr>
			<td colspan = "2" align = "left">
				<input type="text" id="id" name="id">
				<div id="idDiv"></div>
				<input type="button" value="삭제" id="deleteBtn">
			</td>
		</tr>
	</table>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.0.min.js"></script>
<script>
$('#deleteBtn').click(function(){
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
					alert("삭제 완료");
					$('#deleteForm').submit();
				}
			}
		});
	});
</script>
</html>