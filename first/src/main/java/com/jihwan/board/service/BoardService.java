package com.jihwan.board.service;

import java.sql.SQLException;
import java.util.Map;

import com.webjjang.util.PageObject;

public interface BoardService {
	
	public Map<String, Object> selecBoardList(PageObject pageObject) throws SQLException;
	
	
}
