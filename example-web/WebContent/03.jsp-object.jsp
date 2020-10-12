<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP Object</title>
</head>
<body>
	
	<% out.println("<h3> JSP Object </h3>"); %>
	<h3> JSP Object </h3>
	
	<%
		// 내장 객체에 데이터 저장
		pageContext.setAttribute("page-data", "pageContext Data");
		pageContext.setAttribute("page-data2", "pageContext Data2");
	 	request.setAttribute("request-data", "Request Data");
		session.setAttribute("session-data", "Ression Data");
		application.setAttribute("application-data", "Application Data");
	%>
	
	<%= pageContext.getAttribute("page-data") %><br>
	<%= pageContext.getAttribute("page-data2") %><br>
	<%= request.getAttribute("request-data") %><br>
	<%= session.getAttribute("session-data") %><br>
	<%= application.getAttribute("application-data") %><br>

</body>
</html>