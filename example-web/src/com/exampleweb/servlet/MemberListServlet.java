package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 브라우저에서 member-list 경로로 요청이 들어오면 이 서블릿을 사용해서 처리하세요
@WebServlet("/member-list")
public class MemberListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter(); //응답 컨텐츠를 출력하는 IO 객체 가져오기
		
		out.append("<!DOCTYPE html>")
		   .append("<html>")
		   .append("<head>")
		   .append("	<title>Member List</title>")
		   .append("</head>")
		   .append("<body>")
		   .append("	<h3 style='text-align:center'>회원 목록</h3>")
		   .append("	<table border='1' align='center' style='width:600px'>");
		
		for (int i = 0; i < 10; i++) {
		   out.append("		<tr style='height:30px'>")
		      .append("			<td style='text-align:center'>" + (i + 1) + "</td>")
		      .append("			<td style='padding: 10px'>장동건</td>")
		      .append("			<td style='padding: 10px'>jdk@example.com</td>")
		      .append("		</tr>");
		}
		
		out.append("	</table>")
		   .append("</body>")
		   .append("</html>");
		
	}

}
