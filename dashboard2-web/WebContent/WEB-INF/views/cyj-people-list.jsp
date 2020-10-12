
<%@page import="com.dashboardweb.vo.CyjPeopleVO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<h3 style='text-align:center'>
</h3>     <!-- home.jsp에 있는 $('#iris-list').load("demo/three")가 오는것.  -->


	<table id="example2" class="table table-bordered table-striped">
		<thead>
		<tr	style='higth:30px'>
			<th>연도/분기</th>
			<th>시군구</th>
			<th>상권 코드 명</th>
			<th>행정동</th>
			<th>총 유동인구수</th>
			<th>총 상주인구수</th>
			<th>총 직장인구수</th>
		</tr>
		</thead>	
		<tbody>
		<%
			CyjPeopleVO[] peopleList = (CyjPeopleVO[])request.getAttribute("people-list");
		%>
		<%
			for (CyjPeopleVO people : peopleList) {
		%>	
		<tr style='height:30px'>
			<th><%=people.getYesrSe() %></th>
			<th><%=people.getGuName() %></th>
			<th><%=people.getSgCdName() %></th>
			<th><%=people.getDongName() %></th>
			<th><%=people.getTotalFlowPop() %></th>
			<th><%=people.getTotalStayPop() %></th>
			<th><%=people.getTotalOffPop() %></th>
		</tr>
		<% } %>
		</tbody>
	</table>
	



































