package support.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import support.model.vo.Support;

public class SupportDAO {

	public Support selectFirstSupport(Connection conn, int firstRank) {
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY (NOW_SUPPORT/NEED_SUPPORT)*100 DESC) AS NUM, NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENTS, VIEWS, SUPPORT_HUMAN, NEED_SUPPORT, NOW_SUPPORT, PIC_PATH FROM SUPPORT_NOTICE) WHERE NUM = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Support support = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, firstRank);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				support = new Support();
				support.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				support.setViews(rset.getInt("VIEWS"));
				support.setPicPath(rset.getString("PIC_PATH"));
				support.setNoticeNo(rset.getInt("NOTICE_NO"));
				support.setNeedSupport(rset.getInt("NEED_SUPPORT"));
				support.setNowSupport(rset.getInt("NOW_SUPPORT"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return support;
	}

	public Support selectSecondSupport(Connection conn, int secondRank) {
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY (NOW_SUPPORT/NEED_SUPPORT)*100 DESC) AS NUM, NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENTS, VIEWS, SUPPORT_HUMAN, NEED_SUPPORT, NOW_SUPPORT, PIC_PATH FROM SUPPORT_NOTICE) WHERE NUM = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Support support = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, secondRank);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				support = new Support();
				support.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				support.setViews(rset.getInt("VIEWS"));
				support.setPicPath(rset.getString("PIC_PATH"));
				support.setNoticeNo(rset.getInt("NOTICE_NO"));
				support.setNeedSupport(rset.getInt("NEED_SUPPORT"));
				support.setNowSupport(rset.getInt("NOW_SUPPORT"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		
		return support;
	}

}
