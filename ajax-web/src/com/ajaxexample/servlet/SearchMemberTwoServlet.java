package com.ajaxexample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.service.AccountService;
import com.demoweb.vo.MemberVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet(urlPatterns= {"/search-member2"})
public class SearchMemberTwoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청 데이터 읽기
		String memberId = req.getParameter("memberId");
		
		//데이터베이스로부터 데이터 조회 (서비스 객체에 요청)
		AccountService service = new AccountService();
		MemberVO member = service.findMemberById(memberId);
		
		PrintWriter out = resp.getWriter();
		
		// 1. Json 응답
//		out.println(
//				"{ \"memberId\":\"demo-user\", " +
//				" \"email\":\"demo-user@example.com\", " + 
//				" \"userType\":\"user\", " +
//				" \"active\": true, " +
//				" \"regDate\" : \"2020-08-26\" } ");
		
//		//2. 조회한 데이터로 처리 하는 방법
//		out.println(
//		String.format("{ \"memberId\":\"%s\", ", member.getMemberId()) +
//		String.format(" \"email\":\"%s\", ",member.getEmail()) + 
//		String.format(" \"userType\":\"%s\", ", member.getUserType()) +
//		String.format(" \"active\": %b, ", member.isActive()) +
//		String.format(" \"regDate\" : \"%s\" } ", member.getRegDate()));
		
		
		//3.Gson 사용
		//out.ptintln(new Gson().toJson(member));
//		Gson gson = new Gson();
//		String json = gson.toJson(member); //MemberVO객체 -> Json String
//		out.println(json);
		
		//4. Gson 사용
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		out.println(gson.toJson(member));
		
		
		
	}
}
