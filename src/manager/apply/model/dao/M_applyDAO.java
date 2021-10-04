package manager.apply.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import manager.apply.model.vo.M_apply;
import manager.apply.model.vo.M_applyReply;

public class M_applyDAO {

	public List<M_apply> selectAllApply(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC)AS NUM,NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENTS, VIEWS, ENROLL_DATE, NOTICE_LIKE, PIC_PATH, PIC_SIZE, PIC_NAME,LEVELCHECK,USER_ID FROM NOTICE WHERE LEVELCHECK='N') WHERE NUM BETWEEN ? AND ?";
		List<M_apply> apList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage * viewCountPerPage -(viewCountPerPage-1);
			int end = currentPage* viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			apList = new ArrayList<M_apply>();
			while(rset.next()) {
				M_apply apply = new M_apply();
				apply.setNotiNo(rset.getInt("NOTICE_NO"));
				apply.setNotiTitle(rset.getString("NOTICE_TITLE"));
				apply.setNotiCon(rset.getString("NOTICE_CONTENTS"));
				apply.setViews(rset.getInt("VIEWS"));
				apply.setEnroll(rset.getDate("ENROLL_DATE"));
				apply.setNotiLike(rset.getInt("NOTICE_LIKE"));
				apply.setPicPath(rset.getString("PIC_PATH"));
				apply.setPicSize(rset.getLong("PIC_SIZE"));
				apply.setPicName(rset.getString("PIC_NAME"));
				apply.setLevel(rset.getString("LEVELCHECK").charAt(0));
				apply.setUserId(rset.getString("USER_ID"));
				apList.add(apply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return apList;
	}

	public String getPageNavi(Connection conn, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = totalCount(conn);
		int viewCountPerPage = 10;
		int pageTotalCount = 0;
		int pageTotalCountMod = viewTotalCount % viewCountPerPage;
		if(pageTotalCountMod > 0) {
			pageTotalCount = viewTotalCount / viewCountPerPage +1;
		}else {
			pageTotalCount = viewTotalCount/ viewCountPerPage;
		}
		
		int startNavi = ((currentPage -1)/pageCountPerView)*pageCountPerView +1;
		int endNavi = startNavi + pageCountPerView -1;
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
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
			sb.append("<a href='/manager/m_apply_list?currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/manager/m_apply_list?currentPage="+i+"'>"+i+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/manager/m_apply_list?currentPage="+(endNavi+1)+"'> [다음] </a>");
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

	public int deleteApply(Connection conn, int notiNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "DELETE FROM NOTICE WHERE NOTICE_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, notiNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public M_apply selectOneByApply(Connection conn, int notiNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		M_apply apply = null;
		String query = "SELECT * FROM NOTICE WHERE NOTICE_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, notiNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				apply = new M_apply();
				apply.setNotiNo(rset.getInt("NOTICE_NO"));
				apply.setNotiTitle(rset.getString("NOTICE_TITLE"));
				apply.setNotiCon(rset.getString("NOTICE_CONTENTS"));
				apply.setViews(rset.getInt("VIEWS"));
				apply.setEnroll(rset.getDate("ENROLL_DATE"));
				apply.setNotiLike(rset.getInt("NOTICE_LIKE"));
				apply.setPicPath(rset.getString("PIC_PATH"));
				apply.setPicSize(rset.getLong("PIC_SIZE"));
				apply.setPicName(rset.getString("PIC_NAME"));
				apply.setLevel(rset.getString("LEVELCHECK").charAt(0));
				apply.setUserId(rset.getString("USER_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return apply;
	}

	public List<M_applyReply> selectAllReply(Connection conn, int notiNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<M_applyReply> reList = null;
		String query = "SELECT * FROM APPLY_REPLY WHERE NOTICE_NO=?";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, notiNo);
			reList = new ArrayList<M_applyReply>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				M_applyReply reply = new M_applyReply();
				reply.setApReNo(rset.getInt("APPLY_REPLY_NO"));
				reply.setReUserId(rset.getString("USER_ID"));
				reply.setApReCon(rset.getString("APPLY_REPLY_CONTENTS"));
				reply.setApReDate(rset.getDate("APPLY_REPLY_DATE"));
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
		String query = "DELETE FROM APPLY_REPLY WHERE APPLY_REPLY_NO=?";
		
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

	public int levelCheckApply(Connection conn, int notiNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE SET LEVELCHECK=? WHERE NOTICE_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "Y");
			pstmt.setInt(2, notiNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public List<M_apply> getSearchApply(Connection conn, String keyword, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<M_apply> apList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC)AS NUM,NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENTS, VIEWS, ENROLL_DATE, NOTICE_LIKE, PIC_PATH, PIC_SIZE, PIC_NAME,USER_ID FROM NOTICE WHERE LEVELCHECK='N'AND NOTICE_TITLE LIKE ?) WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			int viewCountPerPage = 10;
			int start = currentPage * viewCountPerPage -(viewCountPerPage-1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			apList = new ArrayList<M_apply>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				M_apply apply = new M_apply();
				apply.setNotiNo(rset.getInt("NOTICE_NO"));
				apply.setNotiTitle(rset.getString("NOTICE_TITLE"));
				apply.setNotiCon(rset.getString("NOTICE_CONTENTS"));
				apply.setViews(rset.getInt("VIEWS"));
				apply.setEnroll(rset.getDate("ENROLL_DATE"));
				apply.setPicPath(rset.getString("PIC_PATH"));
				apply.setPicSize(rset.getLong("PIC_SIZE"));
				apply.setPicName(rset.getString("PIC_NAME"));
				apply.setUserId(rset.getString("USER_ID"));
				apply.setNotiLike(rset.getInt("NOTICE_LIKE"));
				apList.add(apply);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return apList;
	}

	public String getSearchPageNavi(Connection conn, String keyword, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = searchTotalCount(conn, keyword);
		int viewCountPerPage = 10;
		int pageTotalCount = 0;
		if(viewTotalCount % viewCountPerPage > 0) {
			pageTotalCount = viewTotalCount/ viewCountPerPage +1;
		}else {
			pageTotalCount = viewTotalCount / viewCountPerPage;
		}
		
		int startNavi = ((currentPage-1)/pageCountPerView)*pageCountPerView+1;
		int endNavi = startNavi +pageCountPerView -1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/manager/m_apply_search?searchKeyword="+keyword+"&currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/manager/m_apply_search?searchKeyword="+keyword+"&currentPage="+i+"'>"+i+"</a>");
		}
		if(needNext) {
			sb.append("<a href='/manager/m_apply_search?searchKeyword="+keyword+"&currentPage="+(endNavi+1)+"'> [다음] </a>");
		}
		
		return sb.toString();
	}
	
	private int searchTotalCount(Connection conn, String keyword) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE WHERE NOTICE_TITLE LIKE '%"+keyword+"%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				result = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(stmt);
			JDBCTemplate.close(rset);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
