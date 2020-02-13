<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/ss03/system/login" method="post">
		<input type="text" name="username"><br>
		<input type="password" name="password"><br>
		<input type="hidden" name="_csrf" value="${_csrf.token}"><br>
		<button>로그인</button>
	</form>
	<script>
		//system/login/?fail=true
		alert(location.search);
		alert(location.search.substring(1));
	</script>
</body>
</html>