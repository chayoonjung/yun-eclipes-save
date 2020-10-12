<%@page import="com.projectone.vo.PeopleVO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<h3 style='text-align:center'>
RESULT CREATED AT <%= new Date().toString() %>>
</h3>     <!-- home.jsp에 있는 $('#iris-list').load("demo/three")가 오는것.  -->

<table border="1" style="width:500px;margin:0 auto">
	<tr	style='higth:30px'>
		<th>연도/분기</th>
		<th>상권_구분_코드명</th>
		<th>시군구</th>
		<th>행정동</th>
		<th>총 유동인구수</th>
		<th>총 상주인구수</th>
		<th>총 직장인구수</th>
	</tr>
	<% PeopleVO[] peopleList = (PeopleVO[])request.getAttribute("people-list"); %>
	<% for (PeopleVO people : peopleList) { %>
	<tr style='height:30px'>
		<th><%=people.getYesrSe() %></th>
		<th><%=people.getSgSeCdName() %></th>
		<th><%=people.getSgCdName() %></th>
		<th><%=people.getGuName() %></th>
		<th><%=people.getTotalFlowPop() %></th>
		<th><%=people.getTotalStayPop() %></th>
		<th><%=people.getTotalOffPop() %></th>
	</tr>
	<% } %>
</table>



































