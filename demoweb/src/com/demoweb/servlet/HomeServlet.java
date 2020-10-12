package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//서버에서 절대경로일 경우 애플리케이션 이름 사용하지 않는다.
@WebServlet(urlPatterns = {"/home.action"})
public class HomeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청처리(여기서는 특별히 할 일 없음)
		
		// JSP로 forward 이동해서  응답 컨텐츠 생산
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/WEB-INF/views/home.jsp");
		dispatcher.forward(req, resp);
	}

}
