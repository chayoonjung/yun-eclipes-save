<%@page import="com.demoweb.vo.MemberVO"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>

    <div id="header" style='background-color:palegreen'>    	
            <div class="title">
                <a href="/demoweb/home.action">DEMO WEBSITE</a>
            </div>
            <div class="links">
            <% MemberVO member = (MemberVO)session.getAttribute("loginuser"); %>
            <% if (member == null) { %>
            	<a href="/demoweb/account/login.action">로그인</a>
                <a href="/demoweb/account/register.action">회원가입</a>
                <% } else { %>
                <%= member.getMemberId() %>님 환영합니다.
                <a href="/demoweb/account/logout.action">로그아웃</a>
               <% } %>
            </div>
        </div>
                
        <div id="menu">
            <div>
                <ul>
                    <li><a href="#">사용자관리</a></li>
					<li><a href="#">메일보내기</a></li>
					<li><a href="#">자료실</a></li>
					<li><a href="/demoweb/board/list.action">게시판</a></li>
                </ul>
            </div>
		</div>