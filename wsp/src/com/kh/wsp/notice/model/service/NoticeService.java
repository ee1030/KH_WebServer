package com.kh.wsp.notice.model.service;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.wsp.notice.model.dao.NoticeDAO;
import com.kh.wsp.notice.model.vo.Notice;

public class NoticeService {
	private NoticeDAO dao = new NoticeDAO();

	/** 공지사항 목록 조회 Service
	 * @return list
	 * @throws Exception
	 */
	public List<Notice> selectList() throws Exception {
		Connection conn = getConnection();
		
		List<Notice> list = dao.selectList(conn);
		
		close(conn);
		
		return list;
	}
}
