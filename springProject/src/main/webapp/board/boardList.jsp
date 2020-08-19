<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
#subjectA:link { color:black; text-decoration:none;}
#subjectA:visited{color:black;text-decoration:none;}
#subjectA:hover{color:red; text-decoration:underline; cursor:pointer;}
#subjectA:active{text-decoration:none;}
#paging{
	color : black;
	text-decoration:none;
	cursor:pointer
}
#currentPaging{
	color:red;
	text-decoration:underline;
	cursor:pointer
}

</style>

<table id="boardTable" width="500" border="1" cellpadding="3" frame="hsides" rules="rows">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
</table>

<br>
<div style="float: left; width:50px;">

<img src="../image/images.jpeg" width="50" height="50" 
onclick="location.href='../main/index.do'" style="cursor: pointer;">
</div>
<div id="boardPagingDiv" style="float : left; text-align:center; width:650px;">
</div><br>


<form id="boardSearch"method="post" action="/miniproject/board/boardSearch.do">
<input type="hidden" name="pg" value="1">
<div style="float: left; text-align:center;width:675px">
<select name="searchOption" style="width: 70px; height: 22px;" id="select" onclick="">
	<option value="subject" >제목</option>
	<option value="id" >작성자</option>
	
</select>
	<input type="text" name="searchText" value="${searchText }"/>
	<input type="submit" value="검색" onclick="checkSearch()"/>
	</div>
</form>


<script type="text/javascript">
function isLogin(){
		alert("먼저 로그인 하세요");
}
function isLogins(name,seq,memPg){
		location.href="boardView.do?seq="+seq;
}
window.onload=function(){
	if('${searchOption}'=='subject'||'${searchOption}'=='id')
		document.getElementById('select').value='${searchOption}';
}
function boardPaging(pg){
	location.href="/miniproject/board/boardSearch.do?pg="+pg+"&searchOption="+'${searchOption}'+"&searchText="+'${searchText}';
}
</script>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.0.min.js"></script>
<script>
$(document).ready(function(){
	$.ajax({
		type : 'POST',
		url : '/springProject/board/getBoardList.do',
		data : 'pg=${requestScope.pg}',
		dataType : 'json',
		success : function(data){
			//alert(JSON.stringify(data));
			$.each(data.list,function(index,items){
				$('<tr/>').append($('<td/>',{
					align : 'center',
					text : items.seq
				})).append($('<td/>',{

				}).append($('<a/>',{
						id : 'subjectA',
						text : items.subject
					}))
				).append($('<td/>',{
					align : 'center',
					text : items.id
				})).append($('<td/>',{
					align : 'center',
					text : items.logtime
				})).append($('<td/>',{
					align : 'center',
					text : items.hit
				})).appendTo($('#boardTable'));
			});
		//paging
		$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
		}		
	});
	//로그인 여부
	//동적 처리를 하려면 부모가 와야 됨
	$('#boardTable').on('click','#subjectA',function(){
		if('${memId}'=='')
			alert("먼저 로그인 하세요");
		else{
			//alert($(this).prop('tagName'));
			var seq = $(this).parent().prev().text();
			location.href="/springProject/board/boardView.do?seq="+seq+"&pg=1";
		}
	});
});
</script>
