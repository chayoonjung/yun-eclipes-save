package com.exampleweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

// Filter 고를때 잘 선택해야함.
public class FilterOne implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// do something !!!
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println(req.getRequestURL());
		
		
		// chain을 이용하여 이동 // move to next filter or (servlet or jsp)
		chain.doFilter(request, response);
		
	}

}
