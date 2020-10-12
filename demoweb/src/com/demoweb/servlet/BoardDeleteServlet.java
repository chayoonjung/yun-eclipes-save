package com.demoweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.service.BoardService;
import com.demoweb.vo.BoardVO;
//서버에서 절대경로일 경우 애플리케이션 이름 사용하지 않는다.
@WebServlet(urlPatterns = {"/board/delete.action"})
public class BoardDeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//요청데이터 읽기  //넘버의 유효성 검사
		int boardNo = 0;
		try {
			String sBoardNo = req.getParameter("boardNo");
			boardNo = Integer.parseInt(sBoardNo); // "4" -> 4
		} 	catch (Exception ex) {
			resp.sendRedirect("list.action");
			return;
		}
		
		// 요청처리(데이터베이스에서 데이터 삭제-실제로는 수정)
		BoardService boardService = new BoardService();
		boardService.deleteBoard(boardNo);    //모든 게시물다 가져오라는 의미
		
		
		// 리스트 화면으로 이동 (redirect)
		resp.sendRedirect("list.action");
	}

}











