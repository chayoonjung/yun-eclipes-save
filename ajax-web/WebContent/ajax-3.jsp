<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>사용자등록</title>
	<link rel="Stylesheet" href="styles/default.css" />
	<link rel="Stylesheet" href="styles/input.css" />

</head>
<body>

	<div id="pageContainer">
	
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">회원기본정보</div>

		        <table>
		            <tr>
		                <th>아이디(ID)</th>
		                <td>
		                    <input type="text" id="memberId" name="memberId" style="width:230px" />
		                    <button id="btn-search">검색</button>
		                </td>
		            </tr>
		            
		            <tr>
		                <th>이메일</th>
		                <td>
		                	<input type="text" id="email" name="email" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>사용자구분</th>
		                <td>
		                	<input type="text" id="userType" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>활성여부</th>
		                <td>
		                    <input type="text" id="active" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>등록일자</th>
		                <td>
		                    <input type="text" id="regDate" style="width:280px" />
		                </td>
		            </tr>
		                       		            
		        </table>
		        
		       
		    </div>
		</div>   	
	
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript">
	
	$(function() {
		
		$('#btn-search').on('click',function(event){
			var memberId = $('#memberId').val(); 
			if (memberId.length == 0) {
				alert('아이디를 입력하세요');
				return;
			}

			$.ajax({ "url": "search-member",
					 "method":"GET",
					// "data" : "memberId=" + memberId,  //서버로 보내는 데이터
					 "data": {"memberId": memberId},   //서버로 보내는 데이터
					 "dataType":"text", // 수신하는 데이터 종류: xml,json,html ......
					 "success": function(data, status, xhr) { //수신 성공
						var member = data.split(':');
					 	$('#memberId').val(member[0]);
					 	$('#email').val(member[1]);
					 	$('#userType').val(member[2]);
					 	$('#active').val(member[3]);
					 	$('#regDate').val(member[4]);
					},
					"error" : function(xhr, status, err) {  //수신 실패
						
					}
				});
			
		});
	});
		
	</script>

</body>
</html>














