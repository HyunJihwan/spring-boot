package com.board.service;

import java.lang.reflect.Member;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionException;

import com.board.domain.MemberDTO;

public interface MemberService {

	public MemberDTO login(MemberDTO dto) throws SQLException;

	public void registerMember(String password, String name, String id) throws SQLException;

	public MemberDTO selectMemberById(String id) throws SQLException;
	
}
