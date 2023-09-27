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
        if (dto2 != null) { // 수정: dto가 아닌 dto2로 비교
            session.setAttribute("id", dto2.getId());
            System.out.println(dto2.getId());
            return "Y";
        } else {
            return "N";
        }
    }

    @RequestMapping(value = "/member/joinForm", method = RequestMethod.GET)
    public String joinForm(Locale locale, Model model) {
        return "member/join";
    }

    @ResponseBody
	@RequestMapping(value = "/emailAuth", method = RequestMethod.POST)
	public String emailAuth(String email) {		
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;

		/* 이메일 보내기 */
        String setFrom = "lsi6930@naver.com";
        String toMail = email;
        String title = "회원가입 인증 이메일 입니다.";
        String content = 
                "홈페이지를 방문해주셔서 감사합니다." +
                "<br><br>" + 
                "인증 번호는 " + checkNum + "입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        
        try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return Integer.toString(checkNum);
 
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

    
    @RequestMapping(value ="/member/idCheck", method = RequestMethod.POST)
    @ResponseBody
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
  		@GetMapping("/mailCheck")
  		@ResponseBody
  		public String mailCheck(String email) throws Exception{
  			return memberService.joinEmail(email);
  					
  		};
    @RequestMapping(value= "/member/mailChecked" ,method = RequestMethod.GET)
    @ResponseBody
    public String mail (String email,String name) throws SQLException {
    	
    	Map<String, String> map = new HashMap<>();
    	
    	map.put("email", email);
    	map.put("name", name);
    	
    	int num = memberService.getMail(map);
    	
    	return Integer.toString(num);
    	
    }
    
    
}
