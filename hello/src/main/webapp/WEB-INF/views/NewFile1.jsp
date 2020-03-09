<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
//qna 상세 모달창
$(document).on("click", "#qna_detail",function(e){
	console.log("qna상세 클릭");
	
	var params = e.target.dataset.number; 
	console.log("qna",params);
	
	$.ajaxSetup({         
	      beforeSend : function(xhr){
	         xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");}
	      });//먼저 보냄
      	console.log("qna ajax시작");
      $.ajax({
          url : "qnamodal",
          type : "Post",
          data : {"num":params}, 
          success : function(response) {
				$("#qna_modal_header").empty();
				$("#qna_modal_body").empty();
				response = JSON.parse(response);

				let strn = " ";
				strn += '<div>'+response[0].qna_title+'</div>';
				$("#qna_modal_header").append(strn);
				strn = " ";
				strn += '<div>작 성 자 : '+ response[0].qna_member_id + '<span> 글 번 호 : '+ response[0].qna_number+'<br>';
				strn += '<input type="hidden" name="number" value="'+response[i].qna_number+'">';
				strn += '작성일 : '+response[0].qna_date  +'</div>';
				strn += '<div>'+response[0].qna_body+'</div>';
				strn += '<div style="border-top: 1px solid #D8D8D8">댓글</div>';
					for(i=0;i<response.length;i++){
						strn += '<div>'+response[i].qna_reply+'</div>';
					}
				strn += '<textarea class="form-control" rows="5" id="qnaanswer" name="qnaanswer"></textarea>';
				$("#qna_modal_body").append(strn);
				
				console.log("modal생성"); 
				//$("#board"+response[0].all_notices_number).text(response[0].all_notices_views); //조회수 변경
          }, error : function(jqXHR, status, e) {
              console.error("qna출력모달 에러");
          }
      });	  
}); //qna 상세모달 End

//승인거절 ajax
$('.judge').on('click',function(e){
	console.log(e.target.value);
	var formData = new FormData(document.getElementById("sFrm"));
	
	  console.log(formData.get("number")[0]);
      console.log(formData.getAll("type"));
      var urlRest;
      var params = {
    		  "number" : formData.get("number"),
    		  "type" : formData.get("type"),
      }
      
      if(e.target.value == "승인"){
    	  urlRest = "approved"
      }else if(e.target.value == "거절"){
    	  urlRest = "refuse"
      }
      console.log(urlRest);

    //글쓰기 모달 생성
  	$("#write_modal_button").on("click",function(){
  		console.log("글쓰기 클릭");
  		//$("#write_modal_header").empty();
  		//$("#write_modal_body").empty();
  		
  		
  		var formData = new FormData();
  		formData.append("title",document.getElementById("title").value);
  		
  		//var str = document.getElementById("notices_body").value;
  		var str = $('#content').val();
  		str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
  		document.getElementById("content").value=str;
  		formData.append("content",document.getElementById("content").value);
  		console.log("글쓰기=",formData.get("title"));
  		console.log("글내용=",formData.get("content"));
  		$.ajaxSetup({         
  			beforeSend : function(xhr){
  		    xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");}
  		    });
          	console.log("글쓰기 ajax시작");
          	
  		$.ajax({
  			url : "noticeswrite",
              type : "Post",
              data : formData, 
  			processData:false,//application/x-www-form-urlencoded(쿼리스트링)
              contentType:false,//multipart의 경우 contentType을 false로
              
              success : function(response) {
              	console.log("글쓰기 성공");
              	
              	//$("#board"+response[0].all_notices_number).text(response[0].all_notices_views); //전체회원 공지사항 변경
              	//notices_body
              	
              }, error : function(jqXHR, status, e) {
                  console.log("글쓰기 에러");
              }
              
  		});
              
  	});//글쓰기 ajax End 



</script>
</body>
</html>