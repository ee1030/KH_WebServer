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
}
