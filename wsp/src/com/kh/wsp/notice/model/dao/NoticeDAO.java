package com.kh.wsp.notice.model.dao;

import static com.kh.wsp.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

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
}
