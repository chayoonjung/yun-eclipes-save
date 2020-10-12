<%@page import="com.demoweb.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시판</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input2.css" />
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/module/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시글 정보</div>
		        <% BoardVO b = (BoardVO)request.getAttribute("board"); %>
		        <form action="update.action" method="post">
		        <input type="hidden" name="boardNo" value="<%=b.getBoardNo()  %>">
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>
		                    <input type="text" name="title" value="<%= b.getTitle() %>" style="width:580px" />
		                </td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td><%= b.getWriter() %></td>
		            </tr>
		            <tr>
		                <th>첨부자료</th>
		                <td>
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td>   <!-- <textarea> </textarea> 사이 엔터 잘 안한다. 하면 의미가 달라진다. -->
		                	<textarea name="content" style="width:580px" 
		                		rows="15"><%=b.getContent() %></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<input type="submit" value="글수정" style="height:25px" />
		        	<input type="button" id="cancel_button" value="취소" style="height:25px"  />
		        	
		        	<script type="text/javascript">
		        	
		        	window.addEventListener('load', function(event) {
		        		// 취소 버튼 이벤트 처리
		        		var btn = document.querySelector("#cancel_button");
		        		btn.addEventListener('click', function(event) {
		        			location.href = "detail.action?boardNo=<%= b.getBoardNo() %>";
		        		});
		        	});	
		        	</script>
		        	
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>