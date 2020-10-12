package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.service.AccountService;
import com.demoweb.vo.MemberVO;

@WebServlet(urlPatterns = {"/account/login.action"})
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청처리(여기서는 특별히 할 일 없음)
		
		// JSP로 forward 이동해서  응답 컨텐츠 생산
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 데이터 읽기
		req.setCharacterEncoding("utf-8");
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		
//		System.out.println(memberId + " / " + passwd);
		
		//2. 요청처리(로그인처리-세션에 데이터 저장)
		AccountService accountService = new AccountService();
		MemberVO member = 
				accountService.findMemberByIdAndPasswd(memberId, passwd);
		boolean login = false;
		if (member != null) {
			
			// JSP에서는 Session이 내장 객체이지만 서블릿에서는 직접 가져와야함.
			 HttpSession session = req.getSession();
			 session.setAttribute("loginuser", member);   //로그인 처리
			 login = true;
		} 
		
		//3. 응답컨텐츠 생산(JSP로 이동)
		if (login) { // 로그인 성공한 경우  
			//-> home.action으로 이동
			resp.sendRedirect("/demoweb/home.action");
//			아래 주석 지금 상황으로는 적절치 않음(위험함).중요한 데이터 변경작업시 Redirect가 적절&안전함.
//			RequestDispatcher rd =
//					req.getRequestDispatcher("/WEB-INF/views/home.jsp");
//			rd.forward(req, resp);
			
		} else { //로그인 실패한 경우 
			//-> 로그인 페이지로 이동 
			resp.sendRedirect("/demoweb/account/login.action");
//			아래 주석 지금 상황으로는 적절치 않음(위험함). 중요한 데이터 변경작업시 Redirect가 적절&안전함.
//			RequestDispatcher rd =
//					req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
//			rd.forward(req, resp);
		}
		
	}
	
}
