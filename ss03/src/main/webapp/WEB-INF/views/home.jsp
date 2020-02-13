<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><a href="/ss03/guest/list">비로그인만 접근 가능</a></li>
		<li><a href="/ss03/system/login">로그인 화면 - 비로그인만 접근 가능</a></li>
		<li><a href="/ss03/user/list">로그인하면 접근 가능</a></li>
		<li><a href="/ss03/member/list">권한이 있으면 접근 가능</a></li>
		<li><a href="/ss03/manager/list">매니저 이상 접근 가능 - 매니저, 관리자</a></li>
		<li><a href="/ss03/admin/list">admin</a></li>
	</ul>
	<sec:authorize access="isAuthenticated()">
		<form method="post" action="/ss03/system/logout">
			<input type="submit" value="로그아웃">
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>     
		</form>
	</sec:authorize>
</body>
</html>