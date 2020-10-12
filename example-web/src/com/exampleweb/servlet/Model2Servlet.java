package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

// HttpServelt 상속 : Servlet Class가 구현해야할 인터페이스 자동 구현
@WebServlet(urlPatterns={"/model2"})
public class Model2Servlet extends HttpServlet {

//	 규격에 맞게 클래스 만들기 (interface 구현) < get, dopost >
	
	//Get 방식의 요청이 발생했을 때 호출되는 약속된 메소드        
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 요청처리
		// 날짜를 지정된 형식의 문자열로 변환하는 도구
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		
		String dateString = sdf.format(new Date());
		
		Date d = new Date(); //현재시간
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d); //끝나는 시간용
		c2.set(Calendar.HOUR_OF_DAY, 18);
		c2.set(Calendar.MINUTE, 35);
		c2.set(Calendar.SECOND, 0);
		
		//초단위 시간차
		long diff = (c2.getTime().getTime() - d.getTime()) / 1000;
		
		// jsp에서 사용할 수 있도록 데이터 전달 : request 객체에 데이터 저장
		req.setAttribute("date", dateString);
		req.setAttribute("diff", diff);
		
		// jsp로 forward 방식 이동
		//PageContext.forward("05.model2.jsp");   // 서블릿에는 padeContext가 없음. 서블릿에서는 http생성코드 사용x
		RequestDispatcher rd = //요청을 지정된 다른 곳으로 전달하는 도구
				req.getRequestDispatcher("05.model2.jsp"); 
		rd.forward(req, resp);
		
	}
	
	
	
	
}
