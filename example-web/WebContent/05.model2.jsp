<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Model 2</title>
</head>
<body>

	<h2>Response for Model 2 Request</h2>
	<h2>DATA FROM SERVLET <%= request.getAttribute("date") %></h2>
	<h2> <%= request.getAttribute("diff") %> SECONDS REMAIN</h2>

</body>
</html>