<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	h3{color:blue;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
// 	$.ajax({        
// 	      url: 'PublicData.do',
// 	      type: 'get',
// 	      dataType: 'json',
// 	      success: function(data){
// 	    	  console.log(data);
// // 	          console.log(data.response.body.items.item);
// 	          var myItem = data.response.body.items.item;
	           
// 	          for(var i=0; myItem.length; i++){
// 	              var output = '';
// 	              console.log(myItem.length);
// 	              output += '<h3>'+ i + '번째 서울 축제 데이터' +'</h3>';
// 	              output += '<h4>'+myItem[i].addr1+'</h4>';
// 	              output += '<h4>'+myItem[i].title+'</h4>';
// 	              output += '<h4>'+myItem[i].tel+'</h4>';
// 	              document.body.innerHTML += output;
// 	          }
// 	      },
//     	error: function(XMLHttpRequest, textStatus, errorThrown) { 
//         	alert("Status: " + textStatus); alert("Error: " + errorThrown); 
//     	} 
// });

</script>
<script>
      $.ajax({          
            url: 'PublicData.do',
            type: 'get',
            dataType: 'json',
            success: function(msg){
            	console.log(msg);
                console.log(msg.response.body.items.item[1]);
                var myItem = msg.response.body.items.item;
                console.log("111",myItem[2]);
                
                 for(var i=0; i<myItem.length; i++){
                     var output = '';
                     //console.log(myItem.length);
                     output += '<h3>'+ i + '번째 제ㅜ 축제 데이터' +'</h3>';
                     output += '<h4>'+myItem[i].addr1+'</h4>';
                     output += '<input type="text" value="'+myItem[i].addr1+'">';
                     output += '<h4>'+myItem[i].title+'</h4>';
                     output += '<input type="text" value="'+myItem[i].title+'">';
                     output += '<h4>'+myItem[i].tel+'</h4>';
                     output += '<input type="text" value="'+myItem[i].tel+'">';
                      document.body.innerHTML += output;
                 }
            }
        });    
 
</script>
</head>
<body>
<form action="PublicData.do" method="get">
<input type="submit" value="데이터보기"/>
<button id="myButton1">축제 보기</button>
</form>
</body>
</html>