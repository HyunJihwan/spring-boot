package com.board.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardDTO;


@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List list() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.list();
	}

	

	
	
}
