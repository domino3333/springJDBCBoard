package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDAO;

	@Override
	public int insertBoard(Board board) throws Exception {
		int count = boardDAO.insertBoard(board);
		return count;
	}

	@Override
	public Board selectByNo(Board b) throws Exception {
		Board board = boardDAO.selectByNo(b);
		return board;
	}

	@Override
	public int updateBoard(Board board) throws Exception {
		return boardDAO.updateBoard(board);
	}

	@Override
	public int deleteBoard(Board board) throws Exception {
		int count = boardDAO.deleteBoard(board);
		return count;
	}

	@Override
	public List<Board> boardList() throws Exception {
		List<Board> boardList = boardDAO.boardList();
		return boardList;
	}

	@Override
	public List<Board> boardSearch(Board board) throws Exception {
		List<Board> boardList = boardDAO.boardSearch(board);
		return boardList;
	}
}
