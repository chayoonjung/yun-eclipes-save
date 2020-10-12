<%@page import="com.dashboardweb.vo.CyjSgChoiceVO"%>
<%@page import="com.dashboardweb.vo.IrisVO"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
<h3 style='text-align:center'>
</h3>
    	 
	<table id="example2" class="table table-head-fixed text-nowrap">
               <thead>
                 <tr>
                   <th>연도/분기</th>
                   <th>상권 구분</th>
                   <th>자치구</th>
                   <th>행정동</th>
                   <th>서비스업종</th>
                   <th>당월 매출금액</th>
                   <th>여성 매출금액</th>
                   <th>남성 매출금액</th>
                   <th>점포수</th>
                   <th>프랜차이즈 점포수</th>
                 </tr>
               </thead>
               <tbody>
               	<%
               		CyjSgChoiceVO[] sgchoiceList = (CyjSgChoiceVO[])request.getAttribute("sg-choice-list");
               	%>
               	<%
               		for (CyjSgChoiceVO sgchoice : sgchoiceList) {
               	%>
                 <tr>
                   <td><%= sgchoice.getYesrSe() %></td>
                   <td><%= sgchoice.getSgSeCdName() %></td>
                   <td><%= sgchoice.getGuName() %></td>
                   <td><%= sgchoice.getDongName() %></td>
                   <td><%= sgchoice.getServiceKind()%></td>
                   <td><%= sgchoice.getMonthSales() %></td>
                   <td><%= sgchoice.getWomenSales() %></td>
                   <td><%= sgchoice.getMenSales() %></td>
                   <td><%= sgchoice.getStoreCnt() %></td>
                   <td><%= sgchoice.getFranchiseCnt() %></td>
		  
                 </tr>
                 <% } %>
               </tbody>
             </table>
                
                
                
                
                