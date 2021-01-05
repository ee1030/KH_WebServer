package com.kh.wsp.board.model.vo;

import java.sql.Timestamp;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String memberId;
	private int readCount;
	private String categoryName;
	private Timestamp boardCreateDate;
	private Timestamp boardModifyDate;
	private String boardStatus;
	
	public Board() {}

	public Board(int boardNo, String boardTitle, String boardContent, String memberId, int readCount,
			String categoryName, Timestamp boardCreateDate, Timestamp boardModifyDate, String boardStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memberId = memberId;
		this.readCount = readCount;
		this.categoryName = categoryName;
		this.boardCreateDate = boardCreateDate;
		this.boardModifyDate = boardModifyDate;
		this.boardStatus = boardStatus;
	}
	
	public Board(int boardNo, String boardTitle, String memberId, int readCount, String categoryName,
			Timestamp boardCreateDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.memberId = memberId;
		this.readCount = readCount;
		this.categoryName = categoryName;
		this.boardCreateDate = boardCreateDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public String getMemberId() {
		return memberId;
	}

	public int getReadCount() {
		return readCount;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Timestamp getBoardCreateDate() {
		return boardCreateDate;
	}

	public Timestamp getBoardModifyDate() {
		return boardModifyDate;
	}

	public String getBoardStatus() {
		return boardStatus;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setBoardCreateDate(Timestamp boardCreateDate) {
		this.boardCreateDate = boardCreateDate;
	}

	public void setBoardModifyDate(Timestamp boardModifyDate) {
		this.boardModifyDate = boardModifyDate;
	}

	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", memberId=" + memberId + ", readCount=" + readCount + ", categoryName=" + categoryName
				+ ", boardCreateDate=" + boardCreateDate + ", boardModifyDate=" + boardModifyDate + ", boardStatus="
				+ boardStatus + "]";
	}
}
