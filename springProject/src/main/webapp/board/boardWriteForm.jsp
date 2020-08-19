<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form id = "boardWriteForm" name="boardWriteForm" method="post" action="/springProject/board/boardWrite.do">
<h3>글쓰기</h3>

<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<td>제목</td>
		<td>
		<input type="text" name="subject" id="subject"size="50">
		<div id="subjectDiv"></div>
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
		<textarea name="content" id="content" cols="70" rows="30"></textarea>
			<div id="contentDiv"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" name="write" value="글쓰기" id="checkBoardWrite">		
		<input type="reset" name="reset" value="다시작성">
		</td>
	</tr>
</table>
</form>
 <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.0.min.js"></script>

<script type="text/javascript">
$('#checkBoardWrite').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();

	if($('#subject').val()==''){
		$('#subjectDiv').text('제목을 입력하세요').css('color','red').css('font-size','9pt');
		}
	else if($('#content').val()==''){
		$('#contentDiv').text('내용을 입력하세요').css('color','red').css('font-size','9pt');
		}
	else
	$('#boardWriteForm').submit();
});
</script>