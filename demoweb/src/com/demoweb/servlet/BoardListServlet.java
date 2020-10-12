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
import com.demoweb.ui.ThePager;
import com.demoweb.vo.BoardVO;
//서버에서 절대경로일 경우 애플리케이션 이름 사용하지 않는다.
@WebServlet(urlPatterns = {"/board/list.action"})
public class BoardListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//페이지 번호 읽기 + 페이징을 위한 변수 만들기
		String sPageNo = req.getParameter("pageNo");
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(sPageNo);
		} catch (Exception ex) {
			pageNo = 1;
		}
		int pageSize = 2;
		int from = (pageNo-1) * pageSize + 1;
		int to = from + pageSize;
		int pagerSize = 3;    //페이지 번호 몇개 보여 주려는 건지 설정
		
		
		// 요청처리(데이터베이스에서 데이터 조회)
		BoardService boardService = new BoardService();
//		List<BoardVO> boards = boardService.findAllBoard();    //모든 게시물다 가져오라는 의미
		List<BoardVO> boards = boardService.findBoardsWithPaging(from, to);
		int count = boardService.getBoardCount();
		
		// 페이지 번호 표시(pager) 객체 만들기
		ThePager pager = new ThePager(count, pageNo, pageSize, pagerSize, "list.action");
		
		
		//JSP에서 읽을수 있도록 request 객체에 데이터 저장
		req.setAttribute("boards", boards);
		req.setAttribute("pager", pager);
		
		// JSP로 forward 이동해서  응답 컨텐츠 생산
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		dispatcher.forward(req, resp);
	}

}











