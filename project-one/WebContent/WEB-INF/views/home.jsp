<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<form id="form">

		<table border="1" style="width:500px;margin:0 auto">
			<tr>
				<th>SEPAL LENGTH</th>
				<td><input type="text" name="sl" id="sl"></td>
			</tr>
			<tr>
				<th>SEPAL WIDTH</th>
				<td><input type="text" name="sw" id="sw"></td>
			</tr>
			<tr>
				<th>PETAL LENGTH</th>
				<td><input type="text" name="pl" id="pl"></td>
			</tr>
			<tr>
				<th>PETAL WIDTH</th>
				<td><input type="text" name="pw" id="pw"></td>
			</tr>
		</table>
	</form>
	
	<br>
	<div style="text-align:center">
		<button id="btn-predict" style="width:150px;hight:50px">품종 예측</button>
	</div>
	<br>
	<h2 id="result-view" style="text-align:center"></h2>   <!-- btn-predict 누르면 결과 보여준다는 의미 -->
	
	<script src="http://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#btn-predict').on('click', function(event) {
			
			var params = $('#form').serialize();     //데이터 전송할때 유용하게 쓰임.
			
			//서버에 요청을 보내고 결과를 받는 코드..
			$.ajax({
				"url": "demo/two",
				"method" : "get",
				"data" : params,
				"success" : function(result, status, xhr) {
					$('#result-view').text(result);
				},
				"error" : function(xhr, status, err) {
					
				}
			});
			
			//$('#result-view').text(''+ Math.random())
			//$('#result-view').text(params)
		});
	});
	</script>

	<hr>
	<div style="text-align:center">
		<button id="btn-iris-list" style="width:150px;hight:50px">데이터 목록 보기</button>
	</div>
	
	<br>
	<div id="iris-list"></div>
	
	<script type="text/javascript">
	$(function() {
		$('#btn-iris-list').on('click', function(event) {
			// 지정된 주소에서 html을 수신한 후 id가 iris-list인 요소에  추가하세요.
			$('#iris-list').load("demo/three")
		
		});
	});
	</script>
	

</body>
</html>
























