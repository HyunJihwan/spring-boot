package com.jihwan.board.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jihwan.board.mapper.BoardMapper;
import com.jihwan.board.vo.BoardVO;
import com.webjjang.util.PageObject;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired 
	private BoardMapper boardMapper;
	
	@Override
	public Map<String, Object> selecBoardList(PageObject pageObject) throws SQLException {
		
		System.out.println("1");
		List<BoardVO> boardList = null;
		System.out.println("2");

		boardList = boardMapper.selectSearchBoardList(pageObject);
		System.out.println("3");

		Map<String,Object> dataMap = new HashMap<String, Object>();
		System.out.println("4");

		dataMap.put("boardList", boardList);
		return dataMap;
	}

	
	
}
