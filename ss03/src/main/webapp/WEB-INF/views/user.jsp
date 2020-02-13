<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	유저 화면: "${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}"님 환영합니다
	<br>
	<a href="/ss03/">루트 화면으로</a>
</body>
</html>