<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset='utf-8' />
	<title>Home</title>
	<link rel='Stylesheet' href='/demoweb/styles/default.css' />
</head>
<body>

	<div id='pageContainer'>
		
		<%-- 다른 jsp의 내용을 삽입하는 구문 --%>
		<%-- <%@include file="/WEB-INF/views/module/header.jsp" %>--%>
	<%-- <% pageContext.include("/WEB-INF/views/module/header.jsp"); %> --%>
		
		<jsp:include page="/WEB-INF/views/module/header.jsp"/>
		
		<div id='content'>
			<br /><br /><br />
			<h2 style='text-align:center'>Welcome to Demo WebSite !!!</h2>
		</div>
	</div>

</body>
</html>


