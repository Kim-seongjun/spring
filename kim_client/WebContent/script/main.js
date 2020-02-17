//js 공용 출력 메소드

$(function() {
	$('#header').load("/kim_client/include/header.html");
	$('#nav').load("/kim_client/include/nav.html");
	$('#aside').load("/kim_client/include/aside.html");
	$('#footer').load("/kim_client/include/footer.html");
});
//1.입력 체크 실패 메시지 출력
function printErrorMessage(element, message) {
	element.text(message).css({"color":"red","font-size":"0.75em"});
	return false;
}
//2.입력 체크 성공 메시지 출력
function printMessage(element, message) {
	element.text(message).css({"color":"green","font-size":"0.75em"})
}