package com.jihwan.board.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jihwan.board.mapper.BoardMapper;
import com.jihwan.board.vo.BoardVO;
import com.webjjang.util.PageObject;

@Service
public class BoardService {
	
	@Inject
	private BoardMapper mapper;
	
	public List<BoardVO> list(PageObject pageObject){
		pageObject.setTotalRow(mapper.getCount());
		System.out.println("여긴 서비스 ㅅㅂ");
		return mapper.list(pageObject);
	}

	
}
