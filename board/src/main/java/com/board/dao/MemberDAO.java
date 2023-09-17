package com.board.dao;

import java.sql.SQLException;

import com.board.domain.MemberDTO;

public interface MemberDAO {

	public MemberDTO login(MemberDTO dto) throws SQLException;

	public String regist(MemberDTO member) throws SQLException;

}
