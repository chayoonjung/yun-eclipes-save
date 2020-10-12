<%@page import="java.util.Date"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

<button id='sync-update'>동기 방식 요청</button>   
&nbsp;&nbsp;
<button id='async-update'>비동기 방식 요청</button>   
<hr>
<div><%= new Date().toString() %></div> <!-- 서버에서 실행되는 코드 -->
<div id="message"></div>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">

$(function() {
	$('#sync-update').on('click', function(event) {   //동기방식 - 정체화면 갱신
		location.href ='ajax-1.jsp'; 
	});
	
	//비동기 요청 처리 객체
	var proxy = new XMLHttpRequest();
	
	$('#async-update').on('click', function(event) {
		proxy.open('GET', 'get-time', true)    //(method,path,async)
		proxy.onreadystatechange = handleResult;  //비동기 응답이 도착하면 호출할 함수
		proxy.send(null); //비동기 요청 시작   null : 보내는 데이터가 없다. 있으면 null부분에 넣어주면 된다.
	});
	
	function handleResult() {
		if (proxy.readyState == 4) {  //응답이 도착했다면
			var time = proxy.responseText;   //비동기 갱신 - 기존화면은 놔두고 원하는 곳만 작업 수행
			$('#message').text(time);	
		}
	}
	
});

</script>   


</body>
</html>





