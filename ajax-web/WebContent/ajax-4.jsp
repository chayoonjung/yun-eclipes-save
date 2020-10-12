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

				<form autocomplete="off"> 
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
		        </form>
		        
		       
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

			$.ajax({ "url": "search-member2",
					 "method":"GET",
					// "data" : "memberId=" + memberId,  //서버로 보내는 데이터
					 "data": {"memberId": memberId},   //서버로 보내는 데이터
					 "dataType":"json", // 수신하는 데이터 종류: xml,json,html ......
					 "success": function(member, status, xhr) { //수신 성공
					 	$('#memberId').val(member.memberId);
					 	$('#email').val(member.email);
					 	$('#userType').val(member.userType);
					 	$('#active').val(member.active);
					 	$('#regDate').val(member.regDate);
					},
					"error" : function(xhr, status, err) {  //수신 실패
						alert(err)
						
					}
				});
			
			});
		
		/////////////////////////////////////////////////////////////
			var outerBox = $('<div></div>');
			outerBox.css({
				"border": "solid 1px",
				"background-color": "white",
				"width": "235px",
				//"height" : "200px",
				"display": "none",    //붙여 놓고 보이지 않게해주는 기능
				"position": "absolute",    //중첩할수 있게 해주는것  position,left,top  //absolute 절대좌표 지정
				"left": getLeft(),
				"top": getTop()
			});
			outerBox.appendTo("body"); //$('body').append(outerBox)
			
			$('body').on('click', function(event) {
				outerBox.css({'display': "none"});
			});
			
			//window.addEventListener('resize')
			
		
		 	//'keypress' : 논리 이벤트 //
			$('#memberId').on('keyup', function(event) {
				var id = $(this).val();
				// console.log( id );   // console에서 타이핑 한거 확인 가능
				
				if (id.length == 0) {
					outerBox.css({'display':'none'});
					return;
				}
				
				$.ajax({
					"url" : "get-ids",   //서버에 get-ids를 조회하는 서블릿를 만들어야함. 
					"mehhod": "GET",
					"data": { "id": id} , // "id=" + id
					"dataType" : "json",
					"success": function(data, status, xhr) {
						//console.log( data );
						//var ids = data.split(":"); // 'a:b:c' -> [a, b, c]
						
						if (data.length == 0) {
							outerBox.css({'display':'none'});
							return;
						}
						outerBox.empty(); // remove all child (남아있는거 다 지우기)
						$.each(data, function(idx, id) { 
							var innerBox = $('<div></div>');
							innerBox.text(id)
									.css({'padding': '5px'})
									.on('mouseenter', function(event) {
										$(this).css({'background-color': 'gray'})
									})
									.on('mouseleave', function(event) {
										$(this).css({'background-color': 'white'})
									})
									.on('click', function(event){
										$('#memberId').val($(this).text());
										outerBox.css({'display':'none'});
									})
									.appendTo(outerBox);
						});
						outerBox.css({'display' : 'block'});
					},
					"errer" : function(xhr, status,err) {
							
					}
				});
			});
		
	});
	
	function getTop() {
		var	t =	document.getElementById("memberId");

		var	topPos = 2 + t.offsetHeight;//현재 요소의 높이
		while(t.tagName.toLowerCase() != "body" && 
			  t.tagName.toLowerCase() != "html") {
			topPos += t.offsetTop;//offsetTop : 상위 요소와의 y축 거리
			t = t.offsetParent;	//상위 요소를 현재 요소에 대입
		}
		return topPos;
	}
  
	function getLeft() {
		var	t =	document.getElementById("memberId");

		var	leftPos	= 0;
		while(t.tagName.toLowerCase() != "body" && 
			  t.tagName.toLowerCase() != "html") {
			leftPos += t.offsetLeft;//t와 상위 요소 사이의 x축 거리
			t = t.offsetParent;//t의 부모 요소
		}
		return leftPos;
	}
	
	
	
		
	</script>

</body>
</html>














