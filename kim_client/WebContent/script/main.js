const apiKey="6Bq2SNPavRoT8QHnv4Vj11p4IBuuzh";
const username="bbbbbbbb12"; 


//1.입력 체크 실패 메시지 출력
function printErrorMessage(element, message) {
	element.text(message).css({"color":"red","font-size":"0.75em"});
	return false;
}
//2.입력 체크 성공 메시지 출력
function printMessage(element, message) {
	element.text(message).css({"color":"green","font-size":"0.75em"})
}
//서버에서 실패 응답이 왔을때
function printError(xhr, massage) {
	toastr.error(massage, "처리 오류");
	console.log("에러코드:"+xhr.status+",에러 메시지:"+xhr.responseText);
}

//3. ES6 of 반복문 이용한 formData출력
function fd(formData) {
	for(var key of formData.keys())
		console.log(key);
	
	for(var value of formData.values())
		console.log(value);
	
}

//js 공용 출력 메소드

$(function() {
	$('#header').load("/kim_client/include/header.html");
	$('#nav').load("/kim_client/include/nav.html");
	$('#aside').load("/kim_client/include/aside.html");
	$('#footer').load("/kim_client/include/footer.html");
});


