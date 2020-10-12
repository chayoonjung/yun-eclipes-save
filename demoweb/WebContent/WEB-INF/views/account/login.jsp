<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>로그인</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input.css" />	
</head>
<body>
	
	<div id="pageContainer">

		<%-- 다른 jsp의 내용을 삽입하는 구문 --%>
		<jsp:include page="/WEB-INF/views/module/header.jsp"/>
			
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">로그인정보</div>
		        
		        <form action="login.action" method="post">
		       
		        <table>
		            <tr>
		                <th>아이디(ID)</th>
		                <td>
		                    <input type="text" name="memberId" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호</th>
		                <td>
		                	<input type="password" name="passwd" style="width:280px" />
		                </td>
		            </tr>
		        </table>
		        
		        <div class="buttons">
		        	<input type="submit" value="로그인" style="height:25px" />
		        	<input type="button" id="btn-cancel" value="취소" style="height:25px" />
		        </div>
		        </form>
		        
		    </div>
		</div>   	
	
	</div>
	<script type="text/javascript">

	// window.addEventListener('load', ...) : main 함수 역할(시작점)
	window.addEventListener('load', function (event) {
		var btnCancel = document.querySelector('#btn-cancel')
		btnCancel.addEventListener('click', function(event) {
			//location.href : 브라우저의 주소 입력창 내용
			//현재경로 :   /demoweb/account/login.action
			
			//절대경로 사용
			//location.href="/demoweb/home.action";
						
			//상대경로 사용
			location.href = "../home.action"
		});
	});
	</script>
	
	
	
	
	
	

</body>
</html>