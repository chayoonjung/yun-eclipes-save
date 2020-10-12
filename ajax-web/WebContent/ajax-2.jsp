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

//ajax-1.jsp와 동일한 기능.

$(function() {
	$('#sync-update').on('click', function(event) {   //동기방식 - 정체화면 갱신
		location.href ='ajax-1.jsp'; 
	});
	
	//비동기 요청 처리 객체
	$('#async-update').on('click', function(event) {
		/*
		$.ajax({
			"url": "get-time",
			"method" : "get",      //method 설정 안해도 기본이 get
			"async":true,          //async 설정 안해도 기본이 true
			"success": function(data, status, xhr) {
				$('#message').text(data);	
			}
		});
		*/
///////////////////////////////////////////////////////////////////		
		/*
		$.get({
			"url": "get-time",
			"success": function(data, status, xhr) {
				$('#message').text(data);	
			}
		});
		*/
////////////////////////////////////////////////////////////////////
		
		$('#message').load('get-time');    //결과만 화면에 붙이는 것.
		
///////////////////////////////////////////////////////////////////
		/*
		$.post({
			"url": "get-time",
			"success": function(data, status, xhr) {
				$('#message').text(data);	
			}
		});
		*/
		

	});
	
});

</script>   


</body>
</html>





