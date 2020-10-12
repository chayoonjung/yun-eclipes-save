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
@WebServlet(urlPatterns = {"/board/update.action"})
public class BoardUpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인 여부 확인 board에 관련된 서블릿에 다 들어감. Filter를 이용하여 서블릿으로 들어감.
		
		//요청데이터 읽기  //넘버의 유효성 검사
		int boardNo = 0;
		try {
			String sBoardNo = req.getParameter("boardNo");
			boardNo = Integer.parseInt(sBoardNo); // "4" -> 4
		} 	catch (Exception ex) {
			resp.sendRedirect("list.action");
			return;
		}
		
		// 요청처리(데이터베이스에서 데이터 조회)
		BoardService boardService = new BoardService();
		BoardVO board = boardService.findBoardByBoardeNo(boardNo);    //모든 게시물다 가져오라는 의미
		if (board == null) { //글 번호에 해당하는 데이터가 없다면 리스트 목록으로 돌려보내라
			resp.sendRedirect("list.action");
			return;
		}
		
		//JSP에서 읽을수 있도록 request 객체에 데이터 저장
		req.setAttribute("board", board);
		
		
		// JSP로 forward 이동해서  응답 컨텐츠 생산
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/WEB-INF/views/board/update.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 요청 데이터 읽기
		req.setCharacterEncoding("utf-8");
		int boardNo = 0;
		try {
			String sBoardNo = req.getParameter("boardNo");
			boardNo = Integer.parseInt(sBoardNo); // "4" -> 4
		} 	catch (Exception ex) {
			resp.sendRedirect("list.action");
			return;
		}
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		// 데이터 처리 (데이터베이스의 데이터 변경 - 서비스 객체에 요청)
		BoardVO b = new BoardVO();
		b.setBoardNo(boardNo);
		b.setTitle(title);
		b.setContent(content);
		
		BoardService boardService = new BoardService();
		BoardService.updateBoard(b);
		
		// 화면으로 이동 (상세보기 화면으로 이동 - redirect)
		resp.sendRedirect("detail.action?boardNo=" + boardNo);
		
		
	}
	

}











