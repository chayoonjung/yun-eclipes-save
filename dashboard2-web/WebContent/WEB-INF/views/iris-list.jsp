<%@page import="com.dashboardweb.vo.IrisVO"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>
    	 
				<table class="table table-head-fixed text-nowrap">
                  <thead>
                    <tr>
                      <th>SEPAL.LENGTH</th>
                      <th>SEPAL.WIDTH</th>
                      <th>PETAL.LENGTH</th>
                      <th>PETAL.WIDTH</th>
                      <th>SPECIES</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<% IrisVO[] irisList =
                  		(IrisVO[])request.getAttribute("iris-list"); %>
                  	<% for (IrisVO iris : irisList) { %>
                    <tr>
                      <td><%= iris.getSepalLength() %></td>
					  <td><%= iris.getSepalWidth() %></td>
					  <td><%= iris.getPetalLength() %></td>
					  <td><%= iris.getPetalWidth() %></td>
					  <td><%= iris.getSpecies() %></td>
                    </tr>
                    <% } %>
                  </tbody>
                </table>
                
                
                
                
                