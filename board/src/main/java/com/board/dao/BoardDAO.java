package com.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.board.domain.BoardDTO;

public interface BoardDAO {
 
 public List list() throws Exception;

 public Integer getMaxSeq() throws SQLException;

 public int regi(BoardDTO dto) throws SQLException;

 public void updateReadCount(int seq) throws SQLException;

 public BoardDTO view(int seq) throws SQLException;

 public int update(BoardDTO dto) throws SQLException; 

}