<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Member List</title>
</head>
<body>
	<h3 style='text-align:center'>회원 목록 (at <%= new java.util.Date().toString() %>)</h3>
	<table border='1' align='center' style='width:600px'>
			
		<% for (int i = 0; i < 10; i++) { %>
		<tr style='height:30px'>
			<td style='text-align:center'><%= (i + 1) %></td>
			<td style='padding: 10px'>장동건 <%= (i + 1) %></td>
			<td style='padding: 10px'>jdk<%= (i + 1) %>@example.com</td>
		</tr>
		<% } %>
			
	</table>
</body>
</html>