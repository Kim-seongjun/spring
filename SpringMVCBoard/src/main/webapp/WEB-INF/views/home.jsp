<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>Home.jsp(로그인페이지)</h1>
<form action="access" name="logFrm" method="post">
	<table border="1">
		<tr>
			<td colspan="2" align="center" bgcolor="skyblue">로그인</td>
		</tr>
		<tr>
			<td><input type="text" name="m_id"></td>
			<td rowspan="2"><button>로그인</button>
		</tr>
		<tr>
			<td><input type="password" name="m_pwd"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" bgcolor="skyblue">com.board.icia</td>
		</tr>
		<tr>
			<td colspan="2" align="center" bgcolor="skyblue"><a href="./joinfrm">회원가입</a></td>
		</tr>
	</table>
</form>
	<script>window.onload=function(){
		var chk=${check};
		if(chk==1){
			alert("회원가입 성공");
		}
		if(chk==2){
			alert("로그인 실패");
		}
	}
	</script>
</body>
</html>
