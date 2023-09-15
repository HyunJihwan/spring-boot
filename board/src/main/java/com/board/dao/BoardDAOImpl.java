package com.board.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static String namespace = "com.board.mappers.board";

	@Override
	public List list() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".list");
	}
	
	@Override
	public Integer getMaxSeq() {
		return sqlSession.selectOne(namespace+".maxSeq");
	}

	@Override
	public int regi(BoardDTO dto) {
		return sqlSession.insert(namespace+".regi", dto);
	}

	@Override
	public void updateReadCount(int seq) throws SQLException {
		sqlSession.update(namespace+".updateReadCount", seq);
		
	}

	@Override
	public BoardDTO view(int seq) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".view", seq);
	}

	@Override
	public int update(BoardDTO dto) throws SQLException {
		
		return sqlSession.update(namespace+".update", dto);
	}

	
}
