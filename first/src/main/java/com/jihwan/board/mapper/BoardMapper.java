package com.jihwan.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jihwan.board.vo.BoardVO;
import com.webjjang.util.PageObject;


public interface BoardMapper {
	
	// 게시판 리스트
	public List<BoardVO> list(PageObject pageObject);
	
	// 전체갯수
	public Integer getCount();
	
	
}
