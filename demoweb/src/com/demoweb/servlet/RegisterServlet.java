package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.service.AccountService;
import com.demoweb.vo.MemberVO;

@WebServlet(urlPatterns = {"/account/register.action"})
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청처리(여기서는 특별히 할 일 없음)
		
		// JSP로 forward 이동해서  응답 컨텐츠 생산
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/WEB-INF/views/account/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		String email = req.getParameter("email");
		
		// 입력 데이터의 유효성 검사(여기서는 생략)
		
		//요청 데이터를 VO객체에 저장
		MemberVO member = new MemberVO();
		member.setMemberId(memberId);
		member.setPasswd(passwd);
		member.setEmail(email);
		
		//요청처리 (여기서의 작업은 데이터베이스에 데이터 저장->서비스 객체에 요청)
		AccountService accountService = new AccountService();
//		accountService.register(memberId, passwd, email);
		accountService.register(member);
		
		
		//응답 콘텐츠 생산(로그인 화면으로 이동)
		resp.sendRedirect("/demoweb/account/login.action");
		
	}

}
