package com.kh.wsp.notice.model.dao;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.wsp.notice.model.vo.Notice;

public class NoticeDAO {
	
	// 자주 사용하는 JDBC 참조변수 미리 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	private Properties prop = null;
	
	// 기본생성자로 NoticeDAO 객체 생성 시 SQL이 작성된 xml 파일 얻어오기
	public NoticeDAO() {
		
		String fileName = NoticeDAO.class.getResource("/com/kh/wsp/sql/notice/notice-query.xml").getPath();
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(fileName)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 공지사항 목록 조회 DAO
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<Notice> selectList(Connection conn) throws Exception {
		List<Notice> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			// SQL 수행 후 DB관련 문제가 발생하지 않으면
			// 조회 내용을 저장할 수 있는 ArrayList를 생성
			list = new ArrayList<Notice>();
			
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setMemberId(rset.getString("MEMBER_ID"));
				notice.setReadCount(rset.getInt("READ_COUNT"));
				notice.setNoticeCreateDate(rset.getDate("NOTICE_CREATE_DT"));
				
				list.add(notice);
			}
			
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
}
