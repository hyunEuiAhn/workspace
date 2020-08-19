<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import = "java.net.URLEncoder" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
*** ${sungJukDTO.name} 성적 *** <br>
총점 : ${sungJukDTO.tot}<br>
평균 : <fmt:formatNumber type="number" value="${sungJukDTO.avg}" pattern=".###"/>
</body>
</html>