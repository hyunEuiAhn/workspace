<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form name = "writeForm" method="post" action="/test/user/write.do">
 <h3>회원가입</h3>
 <table border="1" cellpadding="5" cellspacing = "0">
  <tr>
   <td align ="center" width="80">* 이름</td>
   <td>
   		<input type = "text" size ="7" id="name" name="name" placeholder="이름입력">
   		<div id="nameDiv" class="check2"></div>
   </td>
  </tr>
  
  <tr>
   <td align ="center">* 아이디</td>
   <td>
   	   <input type ="text" size ="10" id ="id" name="id">
   	   <input type="button" value="중복체크" id="idCheck" name="idCheck" onclick="checkId()">
   	   <input type="hidden" id="confirm">
	   <div id="idDiv" class="check2"></div>
   </td>
  </tr>
  
  <tr>
   <td align ="center">* 비밀번호</td>
   <td>
   		<input type ="password" size ="13" id ="pwd" name="pwd">
   		<div id="pwdDiv" class="check2"></div>
   </td>
  </tr>
  
  <tr>
   <td align ="center">* 재확인</td>
   <td>
   		<input type ="password" size ="13" id="repwd" name="repwd">
   		<div id="repwdDiv" class="check2"></div>
   </td>
  </tr>
  
  <tr>
   <td align="center">이메일</td>
   <td><input type = "text" size ="12" name="email1" id="email1">@
   		<input type = "text" list = "email2" name="email2" id="email2" placeholder="직접입력">
   		<datalist id = "email2">
   		<option value="naver.com">naver.com</option>
   		<option value="google.com">google.com</option>
   		<option value="daum.net">daum.net</option>
   		</datalist>
   </td>
  </tr>

  <tr>
   <td colspan ="2" align="center">
    <input type="button" value = "회원가입" onclick="checkWrite()">
    <input type="reset" value = "다시작성">
    <div id="checkDiv"></div>
   </td>
  </tr>
  
 </table>

 </form>
