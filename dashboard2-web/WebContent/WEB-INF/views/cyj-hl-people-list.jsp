<%@page import="com.dashboardweb.vo.CyjHlPeopleVO"%>
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
			CyjHlPeopleVO[] hlpeopleList = (CyjHlPeopleVO[])request.getAttribute("hl-people-list");
		%>
		<%
			for (CyjHlPeopleVO hlpeople : hlpeopleList) {
		%>	
		<tr style='height:30px'>
			<th><%=hlpeople.getYesrSe() %></th>
			<th><%=hlpeople.getGuName() %></th>
			<th><%=hlpeople.getSgCdName() %></th>
			<th><%=hlpeople.getDongName() %></th>
			<th><%=hlpeople.getHlTotalFlowPop() %></th>
			<th><%=hlpeople.getHlTotalStayPop() %></th>
			<th><%=hlpeople.getHlTtotalOffPop() %></th>
		</tr>
		<% } %>
		</tbody>
	</table>
	



































