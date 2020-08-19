<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/chapter06_1/sungjuk/result.do" method="post" >
	<table>
		<tr>
			<td> name : </td>
			<td><input type="text" name="name"> </td>
		</tr>
		<tr>
			<td> kor : </td>
			<td><input type="text" name="kor"> </td>
		</tr>
		<tr>
			<td> eng : </td>
			<td><input type="text" name="eng"> </td>
		</tr>
		<tr>
			<td> math : </td>
			<td><input type="text" name="math"> </td>
		</tr>
		<tr>
			<td><input type="submit" value="계산"></td>
		</tr>
	</table>
</form>
</body>
</html>