package com.jihwan.board.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jihwan.board.service.BoardService;
import com.webjjang.util.PageObject;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//자동 DI 적용 시키는 어노테이션 2가지 - Inject , Autowired
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/list.do")
	// 실행할 메서드 만들기
	// model 안에 request가 있다. model에 데이터를 저장하면 request에 저장이됨
	public ModelAndView list(PageObject pageObject, ModelAndView mnv) throws SQLException {
		String url = "board/list";
		System.out.println("보드컨트롤러");
		Map<String, Object> dataMap = boardService.selecBoardList(pageObject);
		
		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);
		System.out.println("보드컨트롤러2");
		// /WEB-INF/views/ + board/list + .jsp
		return mnv;
	}
	
}
