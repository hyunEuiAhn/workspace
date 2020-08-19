<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <form name = "writeForm" method="post" action="/springProject/member/write.do">
 <h3>회원가입</h3>
 <table border="1" cellpadding="5" cellspacing = "0">
  <tr>
   <td align ="center" width="80">* 이름</td>
   <td>
   		<input type = "text" size ="7" name = "name" placeholder="이름입력" id="name">
   		<div id="nameDiv"></div>
   </td>
  </tr>
  
  <tr>
   <td align ="center">* 아이디</td>
   <td><input type ="text" size ="10" name ="id" id="writeId">
	   <input type ="button" value="중복체크" id="checkId" name="checkId">
	   <div id="idDiv"></div>
	   <input type ="hidden" size ="10" name="check" id="check">
   </td>
  </tr>
  
  <tr>
   <td align ="center">* 비밀번호</td>
   <td>
   		<input type ="password" size ="13" name ="pwd" id="writePwd">
   		<div id="pwdDiv"></div>
   </td>
  </tr>
  
  <tr>
   <td align ="center">* 재확인</td>
   <td>
   		<input type ="password" size ="13" name="repwd" id="repwd">
   		<div id="repwdDiv"></div>
   </td>
  </tr>
  
  <tr>
   <td align ="center">성별</td>
   <td><input type = "radio" name = "gender" value =0 checked>남자
       <input type = "radio" name = "gender" value =1>여자
   </td>
  </tr>
  
  <tr>
   <td align="center">이메일</td>
   <td><input type = "text" size ="12" name="email1">@
   		<input type = "text" list = "email2" name="email2" placeholder="직접입력">
   		<datalist id = "email2">
   		<!-- select name ="email3" style="width : 100px;"-->
   		<!-- option value="">직접입력</option-->
   		<option value="naver.com">naver.com</option>
   		<option value="google.com">google.com</option>
   		<option value="daum.net">daum.net</option>
   		<!--/select-->
   		</datalist>
   </td>
  </tr>
  
  <tr>
   <td align="center">핸드폰</td>
   <td><select name = tel1>
        <option value = "010">010</option>
        <option value = "011">011</option>
        <option value = "017">017</option>
       </select> - 
   	   <input type ="text" size="5" name = tel2> - 
   	   <input type ="text" size="5" name = tel3>
   </td>
  </tr>
  
  <tr>
   <td align="center">주소</td>
   <td><input type="text" size = "7" name ="zipcode" id="daum_zipcode" readonly>
   	   <input type="button" value="우편번호찾기" id = "checkPost">
   <br>
   	   <input type="text" size = "50" name="addr1" id="daum_addr1" placeholder="기본주소" readonly><br>
   	   <input type="text" size = "50" name="addr2" id="daum_addr2" placeholder="상세주소">
   </td>
  </tr>
  
  <tr>
   <td colspan ="2" align="center">
    <input type="button" value = "회원가입" id="checkWrite">
    <!--input type="submit" value = "회원가입"-->
    <input type="reset" value = "다시작성">
    <div id="checkDiv"></div>
   </td>
  </tr>
  
 </table>
 </form>

<!-- <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
 <script src="http://localhost:8080:/memberServlet/js"> -->
<!--  
 <script src="../js/member.js">

 </script>
 head에 쓰는 게 맞지만 body가 빠름 
 -->
 <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.0.min.js"></script>
 <script type="text/javascript">
$(function(){
	$.getScript('../js/member.js');
	
});
</script>
 
 
</html>