package com.dashboardweb.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.dashboardweb.servlet.ChartServletOne.AreaChartData;
import com.dashboardweb.vo.CyjPeopleVO;
import com.dashboardweb.vo.CyjSalesVO;

@WebServlet(urlPatterns = {"/cyj/sales"})
public class CyjSalseChartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	
		 // 브라우저에 응답
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/cyj-sales-chart.jsp");
		rd.forward(req, resp);
		
//		resp.setContentType("text/plain;charset=utf-8");
//		 PrintWriter out = resp.getWriter();
//		 out.println(result);
		
		 
	}
	

	
	
	
		
	
		
		
	
}






















