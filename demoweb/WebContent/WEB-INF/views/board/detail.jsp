<%@page import="com.demoweb.vo.MemberVO"%>
<%@page import="com.demoweb.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시판</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input.css" />
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/module/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">업로드 자료 정보</div>
		        <% BoardVO board = (BoardVO)request.getAttribute("board"); %>
		        <table>
		            <tr>
		                <th>제목</th>
		                <td><%= board.getTitle() %></td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td><%= board.getWriter() %></td>
		            </tr>
		            <tr>
		            	<th>조회수</th>
		            	<td><%= board.getReadCount() %></td>
		            </tr>
		            <tr>
		            	<th>등록일자</th>
		            	<td><%= board.getRegDate() %></td>
		            </tr>
		            <tr>
		                <th>첨부자료</th>
		                <td>
		                </td>
		            </tr>
		            <tr>
		                <th>글내용</th>
		                <td><%= board.getContent() %></td>
		            </tr>
		        </table>
		        <div class="buttons"> 
		         <!-- 편집,삭제 버튼을 작성자만 볼수 있게 설정 -->
					<% MemberVO member = 
							(MemberVO)session.getAttribute("loginuser"); %>
					<% if (member.getMemberId().equals(board.getWriter()))  { %>
		        	<input type="button" id="edit_button" value="편집" style="height:25px" />
		        	<input type="button" id="delete_button" value="삭제" style="height:25px" />
					<% } %>
		        	<input type="button" id="cancel_button" value="목록보기" style="height:25px" />
					
		        	<script type="text/javascript">
		        	
		        	window.addEventListener('load', function(event) {
		        		// 목록 보기 버튼 이벤트 처리
		        		var btn = document.querySelector("#cancel_button");
		        		btn.addEventListener('click', function(event){
		        			location.href = "list.action";
		        		});
		        		//삭제 버튼 이벤트 처리
		        		btn = document.querySelector("#delete_button");
		        		btn.addEventListener('click', function(event){
		        			
		        			var yn = confirm('<%= board.getBoardNo()%>번 게시글을 삭제할까요?');
		        			if (yn) {
		        				location.href = 'delete.action?boardNo=<%= board.getBoardNo() %>';
		        			}
		        		});
		        		// 편집 버튼 이벤트 처리
		        		btn = document.querySelector("#edit_button");
		        		btn.addEventListener('click', function(event){
		        			
		        			location.href = 'update.action?boardNo=<%= board.getBoardNo() %>';
		        			
		        		});
			        		
		        	});
		        	</script>
		        </div>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>