<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Board * Reply Contents</h3>
<a href="boardDelete?bNum=${board.b_num }">삭제</a>
<table>
	<tr height="30">
		<td width="100" bgcolor="pink" align="center">NUM</td>
		<td colspan="5">${board.b_id }</td>
		</tr>
	<tr height="30">
		<td bgcolor="pink" align="center">WRITER</td>
		<td width="150">${board.b_id}</td>
		<td bgcolor="pink" align="center">DATE</td>
		<td width="150">${board.b_date}</td>
		<td bgcolor="pink" align="center">VIEWS</td>
		<td width="150">${board.b_views}</td>
	</tr>
	<tr height="30">
		<td bgcolor="pink" align="center">TITLE</td>
		<td colspan="5">${board.b_title}</td>
	</tr>
	<tr height="30">
		<td bgcolor="pink" align="center">CONTENTS</td>
		<td colspan="5">${board.b_contents}</td>
	</tr>
</table>
<form name="rFrm" id="rFrm">
	<table>
		<tr>
			<td><textarea rows="3" cols="50" name="r_contents" id="r_contents"></textarea></td>
			<td><input type="button" value="댓글전송" onclick="replyInsert(${board.b_num})" style="width: 70px;height: 50px;"></td>
		</tr>
	</table>
</form>
<table id="rTable">
<c:forEach var="r" items="${rList}">
	<tr height="25" align="center">
		<td width="100">${r.r_id}</td>
		<td width="200">${r.r_contents}</td>
		<td width="200">${r.r_date}</td>
	</tr>
</c:forEach>
</table>
<script>
	function replyInsert(bNum) {
		var obj = $('#rFrm').serializeObject(); //js객체 생성{속성:값, 속성:값}
		obj.r_bnum = bNum;
		console.log(obj);
		//js객체 --->json으로 변환
		var jsonStr =JSON.stringify(obj); 
		
		
		$.ajax({								
			type:'post', //json으로 넘길땐 get은 안됨
			url:'rest/replyinsert',
			//1.쿼리스트링 방식
			//data:{r_bnum:bNum, r_contents:$('#r_contents').val()},
			data:obj,
			//2.jQuery 방식
			//data:$('#rFrm').serialize(), //폼 전체 데이터 전송
			//3.json 방식으로 넘김
			//data:jsonStr,
			//쿼리스트링이 아닌 json방식으로 전송시 명시할것
			//contentType:'application/json',
			dataType:'json',
			success:function(data, status, xhr){
				console.log(status);
				console.log(xhr);
				console.log(data);
				var str="";
	             $.each(data.rList, function(index,item){
	                str+= "<tr height='25' align='center'><td width='100'>"+item.r_id
	                +"</td ><td width='200'>"+item.r_contents
	                +"</td><td width='200'>"+item.r_date+"</td></tr>"
	             });
	             $("#rTable").html(str);
				
			},
			error:function(xhr,status){
				console.log(xhr);
				console.log(status);				
			}
		}); //end ajax
	}
</script>
</body>
</html>