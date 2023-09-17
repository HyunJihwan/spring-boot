package com.board.controller;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public  String regi(Locale locale, Model model, MemberDTO dto, HttpSession session) throws Exception { 
		
		MemberDTO dto2 = memberService.login(dto);
		
		if(dto != null) {
			session.setAttribute("id", dto2.getId());
			return "Y";
		}else {
			return "N";
		}
	}
	
	@RequestMapping(value="/member/join", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {
		return "member/join";
	}
	
	@ResponseBody
	@RequestMapping(value = "/emailAuth", method = RequestMethod.POST)
	public String emailAuth(String email) throws Exception {		
	    Random random = new Random();
	    int checkNum = random.nextInt(888888) + 111111;

	    /* 이메일 보내기 */
	    String setFrom = "lsi6930@naver.com"; // 실제 이메일 주소로 변경
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
	        helper.setText(content, true);
	        mailSender.send(message);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return Integer.toString(checkNum);
	}

	@RequestMapping("/register")
	public String register(MemberDTO member, String domainselect, HttpServletRequest req, HttpServletResponse res) throws Exception {
	    member.setEmail(member.getEmail() + domainselect);
	    memberService.register(member);

	    // 회원 가입이 완료되면 회원에게 메시지 표시
	    res.setContentType("text/html; charset=utf-8");
	    PrintWriter out = res.getWriter();
	    out.println("<script>");
	    out.println("alert('회원가입이 정상적으로 완료되었습니다.');");
	    out.println("</script>");

	    // 회원 가입 완료 후 홈페이지 또는 다른 페이지로 리다이렉션
	    return "redirect:/member/login"; // 홈페이지 경로로 변경
	}
	
	
}
