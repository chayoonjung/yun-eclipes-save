package com.demoweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("*.action") // web.xml의 필터 설정을 대신하는 annotation
public class AuthFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI(); //요청된 경로
		
		if (uri.contains("/board")) { // 경로에 "/board/가 포함되면 
			//로그인 여부 확인
			//서블릿에서는 session이 내장 객체가 아니므로 request에서 가져오기
			HttpSession session = req.getSession();
			if( session.getAttribute("loginuser") == null) {
				HttpServletResponse resp = (HttpServletResponse)response;
				resp.sendRedirect("/demoweb/account/login.action");
				return;
			}
			
		}
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
