package com.board.service;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.board.dao.MemberDAO;
import com.board.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private JavaMailSender mailSender;
	private int authNumber;
	
	public void makeRandomNumber() {
		
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		System.out.println("인증번호 : " + checkNum);
		authNumber = checkNum;
	}
	
	@Override
	public String joinEmail(String email) throws SQLException {
		
		/* 이메일 보내기 */
        String setFrom = "lsi6930@naver.com";
        String toMail = email;
        String title = "회원가입 인증 이메일 입니다.";
        String content = 
                "홈페이지를 방문해주셔서 감사합니다." +
                "<br><br>" + 
                "인증 번호는 " + authNumber + "입니다." + 
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
        
        return Integer.toString(authNumber);
 
	}

	@Override
	public MemberDTO login(MemberDTO dto) throws SQLException {
		
		return memberDAO.login(dto);
	}

	

	@Override
	public MemberDTO selectMemberById(String id) throws SQLException {
		
		return memberDAO.selectMemberById(id);
	}

	@Override
	public void register(MemberDTO dto) throws SQLException {
		
		 memberDAO.insert(dto);
		
	}



	@Override
	public int getMail(Map<String, String> map) throws SQLException {
		
		int num = memberDAO.getMail(map);
		
		
		return num;
	}



	
	
	
}
