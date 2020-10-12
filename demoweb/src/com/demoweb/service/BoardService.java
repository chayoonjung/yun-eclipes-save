package com.demoweb.service;

import java.util.List;

import com.demoweb.dao.BoardDao;
import com.demoweb.vo.BoardVO;

public class BoardService {
	
	private BoardDao boardDao = new BoardDao();

	public void writeBoard(BoardVO board) {
		
		boardDao.insertBoard(board);
		
	}

	public List<BoardVO> findAllBoard() {
		
		List<BoardVO> boards = boardDao.selectAllBoard();
		return boards;
		
	}
	
	public List<BoardVO> findBoardsWithPaging(int from, int to) {
		
		List<BoardVO> boards = boardDao.selectBoardsWithPaging(from, to);
		return boards;
		
	}
	
	public int getBoardCount() {
		
		int count = boardDao.selectBoardCount();
		return count;
		
	}

	public BoardVO findBoardByBoardeNo(int boardNo) {
		
		BoardVO board = boardDao.selectBoardByBoardNo(boardNo);
		return board;
	}

	public void increaseReadCount(int boardNo) {
		
		BoardDao.updateReadCount(boardNo, 1);
		
	}

	public void deleteBoard(int boardNo) {
		
		
		boardDao.updateDeleteFlag(boardNo);
		
		
	
		
		
	}

	public static void updateBoard(BoardVO b) {
		
		BoardDao.updateBoard(b);
		
	}

}
