<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
#loginFormId {font-size: 10pt;}
</style>

<form name ="loginForm" method="post" action="/springProject/member/login.do"><!-- 앞에를 /꼭 넣어줘야   -->
<!--form name ="loginForm" method="post" action="http://localhost:8080/memberServlet/login"-->
 <h3>로그인</h3>
 <table border="1" cellpadding="5" cellspacing="0">
  <tr>
   <td id= "loginFormId">아이디</td>
   <td>
   		<input type="text" name = "id" size="10" id="loginId">
   		<div id="loginIdDiv"></div>
   </td>
  </tr>
  
  <tr>
   <td id= "loginFormId">비밀번호</td>
   <td>
   		<input type="password" size ="15" name = "pwd" id="loginPwd">
   		<div id="loginPwdDiv"></div>
   
   </td>
  </tr>
  
  <tr>
   <td colspan="2" align="center">
    <input type = "button" value="로그인" id="loginBtn">
    <!-- input type = "button" value="회원가입" onclick = "javascript : checkWrite()"-->
    <input type = "button" value="회원가입" onclick = "location.href='/springProject/member/writeForm.do'">
    </td>
   
  </tr>
  
 </table>
 <br>
 <div id="loginResult" style="font-weight:bold;"></div>
</form>
 <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.0.min.js"></script>

 <script type ="text/javascript">
 $('#loginBtn').click(function(){
	 $('#loginIdDiv').empty();
	 $('#loginPwdDiv').empty();

	 if($('#loginId').val()==''){
		 $('#loginIdDiv').text('아이디를 입력하세요').css('color','red').css('font-size','9pt');
	 }else if($('#loginPwd').val()==''){
		 $('#loginPwdDiv').text('비밀번호를 입력하세요').css('color','red').css('font-size','9pt');
	 }else
		 alert("sdf");
		 $.ajax({
			 type : 'POST',
			 url : '/springProject/member/login.do',
			 data : 'id='+$('#loginId').val()+'&pwd='+$('#loginPwd').val(),
			 dataType : 'text',
			 success : function(data){
				 if(data=='exist')
					 location.href='/springProject/main/index.do';
				 else if(data=='not_exsit')
					 $('#loginResultDiv').text('로그인 실패').css('color','red').css('font-size','9pt');
			 }
		 });
 });
 </script>
