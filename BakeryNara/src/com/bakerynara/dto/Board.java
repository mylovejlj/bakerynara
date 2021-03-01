package com.bakerynara.dto;

import java.sql.Timestamp;

public class Board {

	//DB에서 사용 할 칼럼명을 변수로 선언
	private int num;				//글 번호
	private String name;			//작성자
	private String email;			//이메일
	private String title;			//글 제목
	private String content;			//글 내용
	private int readcount;			//글 조회수
	private Timestamp writedate;	//작성일
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	
}
