package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.dao.BoardDao;
import com.board.domain.Board;
import com.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDAO;
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/insertForm")
	public String insertForm(Model model) {
		
		return "board/insertForm";
	}
	
	@PostMapping("/insert")
	public String insert(Board board, Model model) {
		log.info("insert board="+board.toString());
		try {
			int count = boardService.insertBoard(board);
			if(count > 0) {
				return "board/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "board/failed";
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		log.info("boardList");

		try {
			List<Board> boardList = boardService.boardList();
			model.addAttribute("boardList",boardList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/boardList";
	}
	
	@GetMapping("/detail")
	public String detail(Board b, Model model) {
		log.info("boardDetail board="+b.toString());
		
		try {
			Board board = boardService.selectByNo(b);
			if(board==null) {
				return "board/failed";
			}
			model.addAttribute("board",board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/detail";
	}
	
	
	
	
	
	
}

















