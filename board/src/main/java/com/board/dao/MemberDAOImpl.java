package com.board.dao;

import java.lang.reflect.Member;
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
	   public void regist(String password, String name, String id) throws SQLException {
	        MemberDTO memberDTO = new MemberDTO();
	        memberDTO.setPassword(password);
	        memberDTO.setName(name);
	        memberDTO.setId(id);
	        sqlSession.insert(namespace + ".regist", memberDTO);
	    }



	@Override
	public MemberDTO selectMemberById(String id) throws SQLException {
		
		return sqlSession.selectOne(namespace + ".selectMemberById", id);
	}



	
}
