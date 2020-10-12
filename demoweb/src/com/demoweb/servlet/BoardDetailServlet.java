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
@WebServlet(urlPatterns = {"/board/detail.action"})
public class BoardDetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인 여부 확인은 공통된 코드라 filter에 넣음
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
		
		boardService.increaseReadCount(boardNo);    //조회수 1 증가
		board.setReadCount(board.getReadCount() + 1);    // 조회하는 즉시 바로 증가할수 있게 해줌
		
		//JSP에서 읽을수 있도록 request 객체에 데이터 저장
		req.setAttribute("board", board);
		
		
		// JSP로 forward 이동해서  응답 컨텐츠 생산
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp");
		dispatcher.forward(req, resp);
	}

}











