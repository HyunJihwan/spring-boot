package com.board.service;

import java.lang.reflect.Member;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.MemberDAO;
import com.board.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberDTO login(MemberDTO dto) throws SQLException {
		
		return memberDAO.login(dto);
	}

	@Override
	public void registerMember(String password, String name ,String id) throws SQLException {
		
		memberDAO.regist(id,password,name);
		
	}

	@Override
	public MemberDTO selectMemberById(String id) throws SQLException {
		
		return memberDAO.selectMemberById(id);
	}

	
	
	
}
