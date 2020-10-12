package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이 클래스를 서블릿 컨테이너에 등록하는 어노테이션 (web.xml에 등록하는 것과 같은 기능)
@WebServlet(urlPatterns = {"/hello2"})

// HttpServelt 상속 : Servlet Class가 구현해야할 인터페이스 자동 구현
public class HelloServlet2 extends HttpServlet {

//	 규격에 맞게 클래스 만들기 (interface 구현) < get, doPost >
	
	//Get 방식의 요청이 발생했을 때 호출되는 약속된 메소드        
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//네트워크를 통해서 텍스트 데이터를 출력하는 객체
		PrintWriter writer = resp.getWriter();
		//클라이언트(브라우저)에 데이터 전송.
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Hello, servlet</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2 style='color :red'> Hello, Servlet2 !!! </h2>");
		writer.println("<h2>");
		writer.println(new Date().toString());
		writer.println("</h2>");
		writer.println("</body>");
		writer.println("</html>");
		
	}
	
	//Post 방식의 요청이 발생했을 때 호출되는 약속된 메소드 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
