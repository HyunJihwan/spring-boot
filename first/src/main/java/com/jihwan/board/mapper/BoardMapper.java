package com.jihwan.board.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jihwan.board.vo.BoardVO;
import com.webjjang.util.PageObject;

@Mapper
public interface BoardMapper {
	
	// 게시판 리스트
	public List<BoardVO> selectSearchBoardList(PageObject pageObject) throws SQLException;
	
	// 전체갯수
	
	
}
