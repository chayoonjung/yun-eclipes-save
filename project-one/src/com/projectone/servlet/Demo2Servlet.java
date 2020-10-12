package com.projectone.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/demo/two"})
public class Demo2Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String path = String.format("%s?sl=%s&sw=%s&pl=%s&pw=%s",
				"http://127.0.0.1:5000/demo/predict-species",
				req.getParameter("pl"),
				req.getParameter("pw"),
				req.getParameter("sl"),
				req.getParameter("sw"));
		
		// 자바 프로그램에서 다른 서버에 요청을 보내고 응답을 수신하는 도구
		URL url = new URL(path);  //경로 지정

		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		
		String result = "";
		
		 int status = conn.getResponseCode();
		 if (status == 200) {
			 //네트워크를 통해 수신된 데이터를 읽는 도구
			 InputStream is = conn.getInputStream();
			 InputStreamReader isr = new InputStreamReader(is);
			 BufferedReader br = new BufferedReader(isr);
			 
			 while (true) {
				 String line = br.readLine();
				 if (line == null) break;
				 result += line;
			 }
		 } else {
			 result = String.format("%d 오류가 발생했습니다.", status);
			 }
		conn.disconnect();
		
		
		 // 브라우저에 응답
		 resp.setContentType("text/plain;charset=utf-8");
//		 resp.setContentType("text/html;charset=utf-8");
		 PrintWriter out = resp.getWriter();
		 out.println(result);
		 
	}
}






















