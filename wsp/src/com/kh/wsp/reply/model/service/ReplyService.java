package com.kh.wsp.reply.model.service;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.wsp.reply.model.dao.ReplyDAO;
import com.kh.wsp.reply.model.vo.Reply;

public class ReplyService {
	private ReplyDAO dao = new ReplyDAO();

	/** 댓글 목록 조회 Service
	 * @param parentBoardNo
	 * @return rList
	 * @throws Exception
	 */
	public List<Reply> selectList(int parentBoardNo) throws Exception {
		Connection conn = getConnection();
		
		List<Reply> rList = dao.selectList(conn, parentBoardNo);
		
		close(conn);
		
		return rList;
	}

	/** 댓글 삽입 Service
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Reply reply) throws Exception {
		Connection conn = getConnection();
		
		// 크로스 사이트 스크립팅 방지 처리
		String replyContent = reply.getReplyContent();
		replyContent = replaceParameter(replyContent);
		
		// 개행문자 변환 처리
		// ajax 통신 시 textarea의 개행문자가 \n하나만 넘어옴. 
		// \n -> <br>
		replyContent = replyContent.replaceAll("\n", "<br>");
		
		reply.setReplyContent(replyContent);
		
		int result = dao.insertReply(conn, reply);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	// 크로스 사이트 스크립트 방지 메소드
	private String replaceParameter(String param) {
		String result = param;
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		
		return result;
	}

	
	
}
