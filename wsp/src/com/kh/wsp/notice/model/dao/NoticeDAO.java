package com.kh.wsp.notice.model.dao;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

	/** 공지사항 상세조회 DAO
	 * @param conn
	 * @param noticeNo
	 * @return notice
	 * @throws Exception
	 */
	public Notice selectNotice(Connection conn, int noticeNo) throws Exception{
		Notice notice = null;
		
		String query = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setMemberId(rset.getString("MEMBER_ID"));
				notice.setReadCount(rset.getInt("READ_COUNT"));
				notice.setNoticeCreateDate(rset.getDate("NOTICE_CREATE_DT"));
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}

	/** 조회수 증가 DAO
	 * @param conn
	 * @param noticeNo
	 * @return result
	 * @throws Exception
	 */
	public int increaseReadCount(Connection conn, int noticeNo) throws Exception {
		int result = 0;
		
		String query = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 공지사항 등록 시 사용 될 번호 반환용 DAO
	 * @param conn
	 * @param map
	 * @return noticeNo
	 * @throws Exception
	 */
	public int selectNextNo(Connection conn) throws Exception {
		int noticeNo = 0;
		
		String query = prop.getProperty("selectNextNo");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				noticeNo = rset.getInt(1);
			}
			
		} finally {
			close(rset);
			close(stmt);
		}
		return noticeNo;
	}

	/** 공지사항 작성 DAO
	 * @param conn
	 * @param map
	 * @return result
	 * @throws Exception
	 */
	public int insertNotice(Connection conn, Map<String, Object> map) throws Exception {
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (int)map.get("noticeNo"));
			pstmt.setString(2, (String)map.get("noticeTitle"));
			pstmt.setString(3, (String)map.get("noticeContent"));
			pstmt.setInt(4, (int)map.get("noticeWriter"));
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 공지사항 수정 DAO
	 * @param conn
	 * @param map
	 * @return result
	 * @throws Exception
	 */
	public int updateNotice(Connection conn, Map<String, Object> map) throws Exception {
		int result = 0;
		
		String query = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, (String)map.get("noticeTitle"));
			pstmt.setString(2, (String)map.get("noticeContent"));
			pstmt.setInt(3,  (int)map.get("noticeNo"));
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 공지사항 삭제 DAO
	 * @param conn
	 * @param noticeNo
	 * @return result
	 * @throws Exception
	 */
	public int updateNoticeFl(Connection conn, int noticeNo) throws Exception {
		int result = 0;
		
		String query = prop.getProperty("updateNoticeFl");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
