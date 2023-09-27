package com.board.dao;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.Map;

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
	public MemberDTO selectMemberById(String id) throws SQLException {
		
		return sqlSession.selectOne(namespace + ".selectMemberById", id);
	}



	@Override
	public void insert(MemberDTO dto) throws SQLException {
		
		sqlSession.insert(namespace + ".insertMember", dto);
		
	}



	@Override
	public int getMail(Map<String, String> map) throws SQLException {
		
		return sqlSession.selectOne(namespace + ".getMail" ,map);
	}



	
}
