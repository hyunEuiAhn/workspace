<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="loginForm">
<h3 align="center">로그인</h3>
	<table border="1" cellpadding="0" cellspacing="1" align="center">
		<tr>
			<td>
				<input type="text" size="15" id="loginid" placeholder="ID"><br>
				<div id="checkid" class="check"></div>
			</td>
		</tr>
		<tr>
			<td>
				<input type="password" size="15" id="loginpwd" placeholder="PASSWORD"><br>
				<div id="checkpwd" class="check"></div>
				
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" size="7" id="loginbtn" value="로그인" onclick="javascript:login()">
				<input type="button" size="7" id="createbtn" value="회원가입" onclick="javascript:create()">
			</td>
		</tr>
	</table>
</form>