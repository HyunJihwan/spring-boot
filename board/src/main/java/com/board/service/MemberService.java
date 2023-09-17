package com.board.service;

import java.sql.SQLException;

import com.board.domain.MemberDTO;

public interface MemberService {

	public MemberDTO login(MemberDTO dto) throws SQLException;

	public void register(MemberDTO member) throws SQLException;
	
}
