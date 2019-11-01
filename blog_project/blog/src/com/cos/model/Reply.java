package com.cos.model;

import java.sql.Timestamp;

public class Reply {
	private int id;
	private int userId;	//FK
	private int boardId;//FK
	private String content;
	private Timestamp createDate;
	
	public Reply() {}

	public Reply(int id, int userId, int boardId, String content, Timestamp createDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.boardId = boardId;
		this.content = content;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	
	
}
