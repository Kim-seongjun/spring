<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/jquery.serializeObject.js"></script>
<style>
html, body {
	height: 100%;
	margin: 0
}

#articleView_layer {
	display: none;
	position: fixed;
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%
}

#articleView_layer.open {
	display: block;
	color: red
}

#articleView_layer #bg_layer {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50);
	z-index: 100
}

#contents_layer {
	position: absolute;
	top: 40%;
	left: 40%;
	width: 400px;
	height: 400px;
	margin: -150px 0 0 -194px;
	padding: 28px 28px 0 28px;
	border: 2px solid #555;
	background: #fff;
	font-size: 12px;
	z-index: 200;
	color: #767676;
	line-height: normal;
	white-space: normal;
	overflow: scroll
}
</style>
</head>
<body>
${msg}

	<h3>게시판리스트</h3>
	<c:if test="${!empty id }">
		<div align="right">

			<!-- <a href="logout">로그아웃</a> -->
			<form id="logoutFrm" action="logout" method="post">
				<a href="javascript:logout()">로그아웃</a>
			</form>

		</div>
	</c:if>
	<table id="one_table">
		<!-- 회원정보 -->
		<tr height="30">
			<td width="80" bgcolor="pink" align="center">ID</td>
			<td>${mb.m_id}</td>
		</tr>
		<tr height="30">
			<td width="80" bgcolor="pink" align="center">NAME</td>
			<td>${mb.m_name}</td>
		</tr>
		<tr height="30">
			<td width="80" bgcolor="pink" align="center">GNAME</td>
			<td>${mb.g_name}</td>
		</tr>
		<tr height="30">
			<td width="80" bgcolor="pink" align="center">POINT</td>
			<td>${mb.m_point}</td>
		</tr>
	</table>
	<br>
	<table>
		<!-- 게시판리스트 -->
		<tr bgcolor="skyblue" height="30">
			<td width="100">번호</td>
			<td width="100">제목</td>
			<td width="100">작성자</td>
			<td width="100">작성일</td>
			<td width="100">조회수</td>
		</tr>
		<c:forEach var="board" items="${bList}">
			<tr height="25">
				<td align="center">${board.b_num}</td>
				<td align="center"><a href="#"
					onclick="articleView(${board.b_num})">${board.b_title}</a></td>
				<td align="center">${board.b_id}</td>
				<td align="center">${board.b_date}</td>
				<td align="center">${board.b_views}</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 모달박스 -->
	<div id="articleView_layer">
		<div id="bg_layer"></div>
		<div id="contents_layer"></div>
	</div>

	<table>
		<!-- 회원리스트 -->
<!-- 		<tr bgcolor="sktblue" height="30"> -->
<!-- 			<th width="100">회원아이디</th> -->
<!-- 			<th width="100">회원이름</th> -->
<!-- 			<th width="100">회원등급</th> -->
<!-- 			<th width="100">회원포인트</th> -->
<!-- 		</tr> -->

		<c:forEach var="member" items="${mList}">
			<tr height="25">
				<td align="center">${member.m_id}</td>
				<td align="center">${member.m_name}</td>
				<td align="center">${member.g_name}</td>
				<td align="center">${member.m_point}</td>
			</tr>
		</c:forEach>
	</table>
	
	<form action="test">
		컬럼명:<input type="text" name="cName"><br>
		검색:<input type="text" name="search"/>
		<button>컬럼 검색</button>
	</form>
	
	
	
	
	<!-- 맴버리스트 -->
	
	<button onclick="memberlist()">맴버리스트</button>
	<div id="memberlist"></div>
	
	<!-- 글쓰기 -->
	<form action="writefrm">
		<button>글쓰기</button>
	</form>
	
<!-- 페이징 -->
<div align="center">${paging}</div>



	<script>
	function memberlist() {
		var str='';
		console.log(${mList});
		str+="<table>";
		str+="<tr bgcolor='sktblue' height='30'>";
		str+="<th width='100'>회원아이디</th>";
		str+="<th width='100'>회원이름</th>";
		str+="<th width='100'>회원등급</th>";
		str+="<th width='100'>회원포인트</th>";
		str+="</tr>";
		str+="</table>";
		
		$('#memberlist').html(str);
	}

	
	
	console.log('${mList}');
	function logout() {
		$('#logoutFrm').submit();
	}
	
	function articleView(num) {
		$('#articleView_layer').addClass('open'); //모달박스 나타내기
		$.ajax({
			type:'get',
			url:'contents',
			data:{bNum:num},
			dataType:'html', //boardContentsAjax.jsp
			success:function(data){
				//alert(data);
				$('#contents_layer').html(data);
			},
			error:function(error){
				//alert:function(error);
			}
		});//ajax End
	}//fct End
	
	//모달박스 해제
	
	var $layerWindow=$('#articleView_layer');	
	$layerWindow.find('#bg_layer').on('mousedown',function(event){
		console.log(event);
		$layerWindow.removeClass('open');
	}); //onEnd
	$(document).keydown(function(event) {
		if(event.keyCode!=27) return;
		else if($layerWindow.hasClass('open')){
			$layerWindow.removeClass('open');
		}
	});
	
	$(function() {
		var result = '${bNum}';
		console.log(result);
		if(result===''){
			return;
		}
	if(parseInt(result)>0){
		alert('${bNum}'+'번 글을 삭제하였습니다.');
	}
	});
</script>
</body>
</html>