package com.dashboardweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/table-template" })   //1. 싸이트 경로 지정  (페이지 5개 만든다면 경로 5개 지정)
public class TableTemplateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/table-template.jsp"); //2. jsp가 forword로 이동
		dispatcher.forward(req, resp);

	}

}
