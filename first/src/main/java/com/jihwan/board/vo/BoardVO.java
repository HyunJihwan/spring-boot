package com.jihwan.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private int no;
	private String title, content, writer;
	private Date writeDate;
	private int hit;
	private String pw;
	
}
