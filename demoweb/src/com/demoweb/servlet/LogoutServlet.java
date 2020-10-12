package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/account/logout.action"})
public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청처리(로그아웃 처리 ->세션에서 데이터 제거)
		 HttpSession session= req.getSession();
		 session.removeAttribute("loginuser");
		 
		
		// JSP로 이동해서  응답 컨텐츠 생산 #
		resp.sendRedirect("/demoweb/home.action");
	}

}
