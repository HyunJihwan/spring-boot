package com.board.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.domain.MemberDTO;


@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static String namespace = "com.board.mappers.member";

	@Override
	public MemberDTO login(MemberDTO dto) throws SQLException {
		return sqlSession.selectOne(namespace+".login", dto);
	}

	@Override
	public String regist(MemberDTO member) throws SQLException {
	    int result = sqlSession.insert(namespace + ".regist", member);
	    return String.valueOf(result);
	}

	
}
