package com.board.service;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionException;

import com.board.domain.MemberDTO;

public interface MemberService {

	public MemberDTO login(MemberDTO dto) throws SQLException;


	public MemberDTO selectMemberById(String id) throws SQLException;


	public void register(MemberDTO dto) throws SQLException;


	public int getMail(Map<String, String> map) throws SQLException;


	public String joinEmail(String email) throws SQLException;
	
	
	
}
