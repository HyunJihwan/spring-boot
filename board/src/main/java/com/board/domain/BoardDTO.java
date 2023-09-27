package com.board.domain;

import lombok.Data;

@Data
public class BoardDTO {
	
	private int seq;
	private String subject;
	private String content;
	private String name;
	private String reg_date;
	private int readCount;
	
	
}
