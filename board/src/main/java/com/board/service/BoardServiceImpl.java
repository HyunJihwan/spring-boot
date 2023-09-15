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

	@Override
	public int regi(BoardDTO dto) throws SQLException {
		if (boardDAO.getMaxSeq() == null) { // 게시글이 존재하지 않을 때
			dto.setSeq(1); // SEQ는 1
		} else { // 게시글이 존재할 때
			dto.setSeq(boardDAO.getMaxSeq() + 1); // 최대값에 +1
		}
		return boardDAO.regi(dto);
	}

	@Override
	public BoardDTO view(int seq) throws SQLException {
		boardDAO.updateReadCount(seq);
		return boardDAO.view(seq);
	}

	@Override
	public int update(BoardDTO dto) throws SQLException {
		return boardDAO.update(dto);
		
	}

	@Override
	public int delete(int seq) throws SQLException {
		
		return boardDAO.delete(seq);
	}

	

	

	
	
}
