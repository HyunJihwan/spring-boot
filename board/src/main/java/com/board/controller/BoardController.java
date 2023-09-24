package com.board.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.BoardDTO;
import com.board.service.BoardService;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Locale locale, Model model) throws Exception {
		List list = boardService.list();
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping(value= "/regiView", method = RequestMethod.GET)
	public String regiView(Locale locale, Model model) throws SQLException {
		return "/board/regi";
	}
	
	@ResponseBody
	@RequestMapping(value = "/regi", method = RequestMethod.POST)
	public ResponseEntity<String> regi(BoardDTO dto, Locale locale, Model model, HttpServletRequest request) throws Exception {
	    
	    Date date = new Date(System.currentTimeMillis());
	    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
	    
	    dto.setName(request.getParameter("name"));
	    dto.setContent(request.getParameter("content"));
	    dto.setSubject(request.getParameter("subject"));
	    dto.setReg_date(format.format(date));
	    
	    if (boardService.regi(dto) == 1) {
	        return new ResponseEntity<>("Y", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("N", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("seq") int seq, ModelAndView mnv) throws SQLException {
	    String url = "/board/view";
		BoardDTO dto = boardService.view(seq);
	    mnv.addObject("view", dto);
	    mnv.setViewName(url);
	    return mnv;
	}
	
	@RequestMapping(value = "/goUpdateView", method = RequestMethod.GET)
	public String updateView(Locale locale, Model model, HttpServletRequest request) throws Exception {
		BoardDTO dto = boardService.view(Integer.parseInt((String)request.getParameter("seq").trim()));
		System.out.println("ㅎㅇ");
		model.addAttribute("view", dto);
		System.out.println("ㅎ2ㅇ");
		return "/board/update";
	}
	
	@ResponseBody
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ResponseEntity<String> update(Locale locale, Model model, BoardDTO dto) throws Exception {
	       	if (boardService.update(dto) == 1) {
	            return new ResponseEntity<>("Y", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("N", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Locale locale, Model model, HttpServletRequest request) throws Exception {
		if(boardService.delete(Integer.parseInt((String)request.getParameter("seq"))) == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	
	
}
