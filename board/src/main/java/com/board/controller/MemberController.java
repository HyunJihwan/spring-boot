package com.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.domain.MemberDTO;
import com.board.service.MemberService;


@Controller
public class MemberController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Locale locale, Model model) {
        return "member/login";
    }
    
    @ResponseBody
    @RequestMapping(value = "/member/login", method = RequestMethod.POST)
    public String regi(Locale locale, Model model, MemberDTO dto, HttpSession session) throws Exception {
        MemberDTO dto2 = memberService.login(dto);
        System.out.println("세션 dto2 : " +  dto2);
        if (dto2 != null && !dto2.equals("")) { // 수정: dto가 아닌 dto2로 비교
            session.setAttribute("id", dto2.getId());
            session.setAttribute("name", dto2.getName());
            session.setAttribute("user", dto2);
            System.out.println("왜 널임" + dto2.getName());
            return "Y";
        } else {
            return "N";
        }
    }

    @RequestMapping(value = "/member/joinForm", method = RequestMethod.GET)
    public String joinForm(Locale locale, Model model) {
        return "member/join";
    }


    
    @RequestMapping(value = "/member/register", method = RequestMethod.POST)
    public String register(MemberDTO dto, String domainselect, HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
         dto.setEmail(dto.getEmail() + domainselect);
         memberService.register(dto);
         
          res.setContentType("text/html; charset=utf-8");
	      PrintWriter out = res.getWriter();
	      out.println("<script>");
	      out.println("alert('회원가입이 정상적으로 되었습니다.');");
	      out.println("</script>");
	      
	      return "member/login";
         
         
    }

    
    @ResponseBody
    @RequestMapping(value ="/member/idCheck", method = RequestMethod.POST)
	public ResponseEntity<String> idCheck(String id, HttpServletRequest req){
		
		ResponseEntity<String> entity = null;
			
		try {
			MemberDTO member = memberService.selectMemberById(id);
			entity = new ResponseEntity<String>(member == null ? id : "", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
  //이메일 인증
  		@RequestMapping(value="member/mailCheck", method = RequestMethod.GET)
  		@ResponseBody
  		public String mailCheck(String email) throws Exception{
  			return memberService.joinEmail(email);
  					
  		};
  		
  	@ResponseBody
    @RequestMapping(value="/member/mailChecked", method = RequestMethod.GET)
    public String mail (String email,String name) throws SQLException {
    	
    	Map<String, String> map = new HashMap<>();
    	
    	map.put("email", email);
    	map.put("name", name);
    	
    	int num = memberService.getMail(map);
    	
    	System.out.println("나는넘 " + num);
    	return Integer.toString(num);
    	
    }
    
    
}
