package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
//@WebServlet(urlPatterns = {"/handle-request"})
@WebServlet("/handle-request")
public class DemoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DemoServlet.doGet");
		
		// request.getParameter("이름") : 브라우저가 전송한 데이터 읽기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.printf("[%s][%s]\n", name, email);
		
		// 출력 객체(브라우저로 데이터를 전송하는 통로)
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(name+ " / " + email);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DemoServlet.doPost");	
		//데이터를 utf-8 인코딩으로 읽기 설정
		request.setCharacterEncoding("utf-8");
		
		
		// request.getParameter("이름") : 브라우저가 전송한 데이터 읽기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.printf("[%s][%s]\n", name, email);
		
		// 출력 객체(브라우저로 데이터를 전송하는 통로)
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(name+ " / " + email);
	}

}
