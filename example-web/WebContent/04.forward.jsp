<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<%

//04.result.jsp에서 읽을 수 있도록 request 객체에 데이터 저장
request.setAttribute("forward", "Data From forward.jsp");

//04.result.jsp 처리기로 forward 이동
pageContext.forward("04.result.jsp");
	

%>