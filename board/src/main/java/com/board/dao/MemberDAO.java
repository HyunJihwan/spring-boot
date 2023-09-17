package com.board.dao;

import java.lang.reflect.Member;
import java.sql.SQLException;

import com.board.domain.MemberDTO;

public interface MemberDAO {

	public MemberDTO login(MemberDTO dto) throws SQLException;

	public void regist(String email, String password, String name, String id) throws SQLException;

}
