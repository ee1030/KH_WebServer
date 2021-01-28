package com.kh.wsp.reply.model.service;


import static com.kh.wsp.common.MybatisTemplate.getSqlSession;
import static com.kh.wsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.wsp.reply.model.dao.ReplyDAO;
import com.kh.wsp.reply.model.dao.ReplyDAO2;
import com.kh.wsp.reply.model.vo.Reply;

public class ReplyService2 {
	private ReplyDAO2 dao = new ReplyDAO2();

	/** 댓글 목록 조회 Service
	 * @param parentBoardNo
	 * @return rList
	 * @throws Exception
	 */
	public List<Reply> selectList(int parentBoardNo) throws Exception {
		SqlSession session = getSqlSession();
		
		List<Reply> rList = dao.selectList(session, parentBoardNo);
		
		session.close();
		
		return rList;
	}

	/** 댓글 삽입 Service
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Reply reply) throws Exception {
		SqlSession session = getSqlSession();
		
		String replyContent = reply.getReplyContent();
		replyContent = replaceParameter(replyContent);
		
		replyContent = replyContent.replaceAll("\n", "<br>");
		
		reply.setReplyContent(replyContent);
		
		int result = dao.insertReply(session, reply);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
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

	/** 댓글 수정 Service
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(Reply reply) throws Exception {
		SqlSession session = getSqlSession();
		
		// 크로스 사이트 스크립팅 방지 처리
		String replyContent = reply.getReplyContent();
		replyContent = replaceParameter(replyContent);
		
		// 개행문자 변환 처리
		// ajax 통신 시 textarea의 개행문자가 \n하나만 넘어옴. 
		// \n -> <br>
		replyContent = replyContent.replaceAll("\n", "<br>");
		
		reply.setReplyContent(replyContent);
		
		int result = dao.updateReply(session, reply);
		
		if(result > 0)	session.commit();
		else			session.rollback();
		
		session.close();
		
		return result;
	}
 
	/** 댓글 삭제 Service
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int updateReplyStatus(int replyNo) throws Exception {
		SqlSession session = getSqlSession();
		
		int result = dao.updateReplyStatus(session, replyNo);
		
		if(result > 0)	session.commit();
		else			session.rollback();
		
		session.close();
		
		return result;
	}

}
