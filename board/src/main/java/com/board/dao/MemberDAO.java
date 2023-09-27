package com.board.dao;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.Map;

import com.board.domain.MemberDTO;

public interface MemberDAO {

	public MemberDTO login(MemberDTO dto) throws SQLException;

	public MemberDTO selectMemberById(String id) throws SQLException;

	void insert(MemberDTO dto) throws SQLException;

	public int getMail(Map<String, String> map) throws SQLException;

}
