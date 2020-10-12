package com.ajaxexample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.service.AccountService;
import com.google.gson.Gson;

@WebServlet(urlPatterns= {"/get-ids"})
public class GetIDsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청데이터 읽기
		String id = req.getParameter("id");
		
		//데이터베이스로부터 데이터 조회(서비스 객체에 요청)
		AccountService service = new AccountService();
		List<String> ids = service.findIdsById(id);
		
		
		PrintWriter out = resp.getWriter();

		//		out.println( "hoseo:hoseo1:hoseo2" ); 
		
		Gson gson = new Gson();
		out.println( gson.toJson(ids) );
		
		
		
		
	}
}
