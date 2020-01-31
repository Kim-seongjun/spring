<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	.subject{
		text-align: center;
		height: 30px;
	}
</style>
</head>
<body>
	<form name="joinFrm" action="memberjoin" method="post"
		onsubmit="return check()">
		<table>
			<tr>
				<td colspan="2" class="subject">회원가입</td>
			</tr>
			<tr>
				<td width="100">ID</td>
				<td><input type="text" name="m_id"></td>
			</tr>
			<tr>
				<td width="100">PW</td>
				<td><input type="text" name="m_pwd"></td>
			</tr>
			<tr>
				<td width="100">NAME</td>
				<td><input type="text" name="m_name"></td>
			</tr>
			<tr>
				<td width="100">BIRTH</td>
				<td><input type="text" name="m_birth"></td>
			</tr>
			<tr>
				<td width="100">ADDR</td>
				<td><input type="text" name="m_addr"></td>
			</tr>
			<tr>
				<td width="100">PHONE</td>
				<td><input type="text" name="m_phone"></td>
			</tr>
			<tr>
				<td colspan="2" class="subject"><input type="submit" value="회원가입" /></td>
			</tr>
		</table>
	</form>
	<script>
		function check() {
			var frm = document.joinFrm;
			var length = frm.length-1;
			for(var i=0;i<length;i++){
				if(frm[i].value==""){
					alret(frm[i].name + "을 입력하세요~!!");
					frm[i].focus();
					return false; //실패시
				}
			}
			return true; //성공시 서버로 전송
		}
	</script>
</body>
</html>