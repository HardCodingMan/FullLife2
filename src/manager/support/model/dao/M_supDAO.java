package manager.support.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import manager.support.model.vo.M_supReply;
import manager.support.model.vo.M_support;

public class M_supDAO {

	public List<M_support> selectAllSup(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC)AS NUM,NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENTS, VIEWS, ENROLL_DATE,NOW_SUPPORT, NEED_SUPPORT, SUPPORT_HUMAN, PIC_PATH, PIC_SIZE, PIC_NAME,LEVELCHECK,USER_ID,NOTICE_LIKE FROM NOTICE WHERE LEVELCHECK='Y') WHERE NUM BETWEEN ? AND ?";
		List<M_support> sList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage * viewCountPerPage -(viewCountPerPage -1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			sList = new ArrayList<M_support>();
			while(rset.next()) {
				M_support sup = new M_support();
				sup.setNotiNo(rset.getInt("NOTICE_NO"));
				sup.setNotiTitle(rset.getString("NOTICE_TITLE"));
				sup.setNotiCon(rset.getString("NOTICE_CONTENTS"));
				sup.setViews(rset.getInt("VIEWS"));
				sup.setEnroll(rset.getDate("ENROLL_DATE"));
				sup.setNowSup(rset.getInt("NOW_SUPPORT"));
				sup.setNeedSup(rset.getInt("NEED_SUPPORT"));
				sup.setSupHuman(rset.getInt("SUPPORT_HUMAN"));
				sup.setPicPath(rset.getString("PIC_PATH"));
				sup.setPicSize(rset.getLong("PIC_SIZE"));
				sup.setPicName(rset.getString("PIC_NAME"));
				sup.setLevel(rset.getString("LEVELCHECK").charAt(0));
				sup.setUserId(rset.getString("USER_ID"));
				sup.setNotiLike(rset.getInt("NOTICE_LIKE"));
				sList.add(sup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return sList;
	}

	public String getPageNavi(Connection conn, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = totalCount(conn);
		int viewCountPerPage = 10;
		int pageTotalCount = 0;
		int pageTotalCountMod = viewTotalCount % viewCountPerPage;
		if(pageTotalCountMod >0) {
			pageTotalCount = viewTotalCount/viewCountPerPage +1;
		}else {
			pageTotalCount = viewTotalCount/ viewCountPerPage;
		}
		
		int startNavi = ((currentPage -1)/pageCountPerView)*pageCountPerView+1;
		int endNavi = startNavi + pageCountPerView-1;
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/manager/m_support_list?currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/manager/m_support_list?currentPage="+i+"'>"+i+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/manager/m_support_list?currentPage="+(endNavi+1)+"'> [다음] </a>");
		}

		return sb.toString();
	}

	private int totalCount(Connection conn) {
		int totalValue = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return totalValue;
	}

	public M_support selectOneBySup(Connection conn, int notiNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		M_support sup = null;
		String query = "SELECT * FROM NOTICE WHERE NOTICE_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, notiNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				sup = new M_support();
				sup.setNotiNo(rset.getInt("NOTICE_NO"));
				sup.setNotiTitle(rset.getString("NOTICE_TITLE"));
				sup.setNotiCon(rset.getString("NOTICE_CONTENTS"));
				sup.setViews(rset.getInt("VIEWS"));
				sup.setEnroll(rset.getDate("ENROLL_DATE"));
				sup.setNotiLike(rset.getInt("NOTICE_LIKE"));
				sup.setNowSup(rset.getInt("NOW_SUPPORT"));
				sup.setNeedSup(rset.getInt("NEED_SUPPORT"));
				sup.setSupHuman(rset.getInt("SUPPORT_HUMAN"));
				sup.setPicPath(rset.getString("PIC_PATH"));
				sup.setPicSize(rset.getLong("PIC_SIZE"));
				sup.setPicName(rset.getString("PIC_NAME"));
				sup.setLevel(rset.getString("LEVELCHECK").charAt(0));
				sup.setUserId(rset.getString("USER_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return sup;
	}

	public List<M_supReply> selectAllReply(Connection conn, int notiNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<M_supReply> reList = null;
		String query = "SELECT * FROM SUPPORT_REPLY WHERE NOTICE_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, notiNo);
			reList = new ArrayList<M_supReply>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				M_supReply reply = new M_supReply();
				reply.setSupReNo(rset.getInt("SUPPROT_REPLY_NO"));
				reply.setReUserId(rset.getString("USER_ID"));
				reply.setSupReCon(rset.getString("REPLY_CONTENTS"));
				reply.setSupReDate(rset.getDate("REPLY_DATE"));
				reList.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return reList;
	}

	public int deleteReplyOne(Connection conn, int replyNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM SUPPORT_REPLY WHERE SUPPORT_REPLY_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, replyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
