package com.kh.wsp.reply.model.vo;

import java.sql.Timestamp;

public class Reply {
	private int replyNo; 		 		// 댓글 번호
	private String replyContent; 		// 댓글 내용
	private Timestamp replyCreateDate;	// 댓글 작성일
	private int parentBoardNo;			// 댓글이 작성된 게시글 번호
	private String memberId;			// 댓글 작성 회원
	private String replyStatus;			// 댓글 상태

	public Reply() {}

	public Reply(int replyNo, String replyContent, Timestamp replyCreateDate, int parentBoardNo, String memberId,
			String replyStatus) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyCreateDate = replyCreateDate;
		this.parentBoardNo = parentBoardNo;
		this.memberId = memberId;
		this.replyStatus = replyStatus;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public Timestamp getReplyCreateDate() {
		return replyCreateDate;
	}

	public int getParentBoardNo() {
		return parentBoardNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getReplyStatus() {
		return replyStatus;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public void setReplyCreateDate(Timestamp replyCreateDate) {
		this.replyCreateDate = replyCreateDate;
	}

	public void setParentBoardNo(int parentBoardNo) {
		this.parentBoardNo = parentBoardNo;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyCreateDate=" + replyCreateDate
				+ ", parentBoardNo=" + parentBoardNo + ", memberId=" + memberId + ", replyStatus=" + replyStatus + "]";
	}
	
}
