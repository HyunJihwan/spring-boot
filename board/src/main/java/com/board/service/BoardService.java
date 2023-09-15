package com.board.service;

import java.sql.SQLException;
import java.util.List;

import com.board.domain.BoardDTO;

public interface BoardService {

	public List list() throws Exception;

	public int regi(BoardDTO dto) throws SQLException;

	public BoardDTO view(int seq) throws SQLException;


	 

}
