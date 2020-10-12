<%@page import="com.demoweb.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>    

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>자료 목록</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<!-- style 하이퍼링크 밑줄 생기지 않게 설정-->
	<style>
	a { text-decoration: none }  
	</style>
</head>
<body>

	<div id="pageContainer">
	
	
		<jsp:include page="/WEB-INF/views/module/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
			[ <a href="write.action">자료 등록</a> ] <!-- 상대경로 // get요청-->
			<br /><br />
			<table border="1" style="width:600px;margin:0 auto">
				<tr style="background-color:orange;height:30px">
					<th style="width:50px">번호</th>
					<th style="width:300px">제목</th>
					<th style="width:125px">작성자</th>
					<th style="width:125px;text-align:center">작성일</th>
				</tr>
				<% List<BoardVO> boards = 
						(List<BoardVO>)request.getAttribute("boards"); %>
				<% for (BoardVO b: boards) { %>
				<tr style="height:30px">
					<td><%= b.getBoardNo() %></td>
					<td>
						<% if (b.isDeleted()) { //삭제된 글인 경우 %>
						<span style='color:Lightgray' onclick="alert('삭제된 글입니다.');">
						<%= b.getTitle() %>[삭제된 글]
						</span>
						<% } else { %>
						<a href="detail.action?boardNo=<%= b.getBoardNo() %>">
						<%= b.getTitle() %>
						
						</a>
						<% } %>
						</td>
						<td><%= b.getWriter() %></td>
						<td style="text-align:center"><%= b.getRegDate() %></td>
					</tr>
					<% } %>
								
			</table>
				<br>
				<%= request.getAttribute("pager") %>
				<br /><br /><br /><br />	
			</div>
			
		
		</div>
		
		

</body>
</html>











