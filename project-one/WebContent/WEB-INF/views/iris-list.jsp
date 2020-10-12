<%@page import="com.projectone.vo.IrisVO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<h3 style='text-align:center'>
RESULT CREATED AT <%= new Date().toString() %>>
</h3>     <!-- home.jsp에 있는 $('#iris-list').load("demo/three")가 오는것.  -->

<table border="1" style="width:500px;margin:0 auto">
	<tr	style='higth:30px'>
		<th>SEPAL.LENGTH</th>
		<th>SEPAL.WIDTH</th>
		<th>PETAL.LENGTH</th>
		<th>PETAL.WIDTH</th>
		<th>SPECIES</th>
	</tr>
	<% IrisVO[] irisList = (IrisVO[])request.getAttribute("iris-list"); %>
	<% for (IrisVO iris : irisList) { %>
	<tr style='height:30px'>
		<th><%=iris.getSepalLength() %></th>
		<th><%=iris.getSepalWidth() %></th>
		<th><%=iris.getPetalLength() %></th>
		<th><%=iris.getPetalWidth() %></th>
		<th><%=iris.getSpecies() %></th>
	</tr>
	<% } %>
</table>



































