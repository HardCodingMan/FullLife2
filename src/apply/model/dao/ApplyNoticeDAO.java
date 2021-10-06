package apply.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import apply.model.vo.Notice;
import apply.model.vo.NoticeLike;
import apply.model.vo.ApplyNoticeReply;
import common.JDBCTemplate;
import member.model.vo.Member;

public class ApplyNoticeDAO {

	public int insertNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO NOTICE VALUES(SEQ_NOTICE_NO.NEXTVAL, ?, ?,DEFAULT,DEFAULT, DEFAULT, ?, DEFAULT, ?, ?, ?, DEFAULT, ?,DEFAULT,DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContents());
			pstmt.setInt(3, notice.getNeedSupport());
			pstmt.setString(4, notice.getPicPath());
			pstmt.setLong(5, notice.getPicSize());
			pstmt.setString(6, notice.getPicName());
			pstmt.setString(7, notice.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Notice> pageAllNotice(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC)AS NUM, NOTICE_no, USER_ID,(select Count(*) from NOTICE_LIKE l where l.NOTICE_NO=r.NOTICE_NO) as NOTICE_LIKE, NOTICE_TITLE, PIC_NAME, NOTICE_CONTENTS ,VIEWS, SIMSA FROM NOTICE r WHERE LEVELCHECK = 'N' OR LEVELCHECK = 'S') where NUM BETWEEN ? AND ?";
		List<Notice> aList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			// 한 페이지에 나올 게시물의 수
			int viewCountPage = 8;
			int start = (currentPage * viewCountPage) - (viewCountPage - 1);
			int end = currentPage * viewCountPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			aList = new ArrayList<Notice>();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContents(rset.getString("NOTICE_CONTENTS"));
				notice.setViews(rset.getInt("VIEWS"));
				notice.setNoticeLike(rset.getInt("NOTICE_LIKE"));
				notice.setPicName(rset.getString("PIC_NAME"));
				notice.setUserId(rset.getString("USER_ID"));
				notice.setSimsa(rset.getString("SIMSA"));
				aList.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return aList;
	}

	public String getPageNavi(Connection conn, int currentPage) {
		int pageCountView = 5;
		int viewTotalCount = totalCount(conn);
		int viewCountPage = 8;
		int totalCountPage = 0;
		int totalCountPageMod = viewTotalCount % viewCountPage;
		if(totalCountPageMod > 0) {
			totalCountPage = viewTotalCount / viewCountPage +1;
		}else {
			totalCountPage = viewTotalCount / viewCountPage;
		}
		int startNavi =((currentPage - 1) / pageCountView) * pageCountView + 1;
		int endNavi = startNavi + pageCountView - 1;
		if(endNavi > totalCountPage) {
			endNavi = totalCountPage;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == totalCountPage) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/Notice/Apply/ApplyNotice?currentPage=" + (startNavi-1) + "'> [이전] </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/Notice/Apply/ApplyNotice?currentPage=" + i + "'>" + i + " </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/Notice/Apply/ApplyNotice?currentPage=" + (endNavi+1) + "'> [다음] </a>");
		}
		return sb.toString();
	}
	
	public int totalCount(Connection conn) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return totalValue;
	}

	public Notice selectOneByNo(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;
		String query = "SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENTS, VIEWS, ENROLL_DATE,(select count(*) from NOTICE_LIKE N WHERE N.NOTICE_NO=R.NOTICE_NO) AS NOTICE_LIKE, PIC_PATH, PIC_SIZE, PIC_NAME, USER_ID FROM NOTICE R WHERE NOTICE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContents(rset.getString("NOTICE_CONTENTS"));
				int viewsCount = rset.getInt("VIEWS");
				notice.setViews(viewsCount);
				viewsCount++;
				notice.setEnrollDate(rset.getDate("ENROLL_DATE"));
				notice.setNoticeLike(rset.getInt("NOTICE_LIKE"));
				notice.setPicPath(rset.getString("PIC_PATH"));
				notice.setPicSize(rset.getLong("PIC_SIZE"));
				notice.setPicName(rset.getString("PIC_NAME"));
				notice.setUserId(rset.getString("USER_ID"));
				countUpdate(conn, viewsCount, noticeNo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return notice;
	}
	
	private int countUpdate(Connection conn, int viewsCount, int applyNoticeNo) {
		int updateViews = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "UPDATE NOTICE SET VIEWS = ? WHERE NOTICE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, viewsCount);
			pstmt.setInt(2, applyNoticeNo);
			rset = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return updateViews;
	}

	public List<ApplyNoticeReply> selectAllNoticeReply(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		List<ApplyNoticeReply> aList = null;
		String query = "SELECT * FROM APPLY_REPLY WHERE NOTICE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			aList = new ArrayList<ApplyNoticeReply>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ApplyNoticeReply applyReply = new ApplyNoticeReply();
				applyReply.setReplyNo(rset.getInt("APPLY_REPLY_NO"));
				applyReply.setReplyUserId(rset.getString("USER_ID"));
				applyReply.setReplyContents(rset.getString("APPLY_REPLY_CONTENTS"));
				applyReply.setReplyDate(rset.getDate("APPLY_REPLY_DATE"));
				applyReply.setNoticeNo(rset.getInt("NOTICE_NO"));
				aList.add(applyReply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return aList;
	}
	public NoticeLike updateLike(Connection conn, int noticeNo, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from NOTICE_LIKE where NotiCE_NO = ? AND USER_ID = ?";
		NoticeLike nLike = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			pstmt.setString(2, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				nLike = new NoticeLike();
				nLike.setUserId(rset.getString("USER_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return nLike;
	}

	public int insertNoticeReply(Connection conn, String replyContents, int noticeNo, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO APPLY_REPLY VALUES(SEQ_APPLY_REPLY_NO.NEXTVAL,?,?,DEFAULT,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, replyContents);
			pstmt.setInt(3, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteApply(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM NOTICE WHERE NOTICE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertLike(Connection conn, String userId, int noticeNo) {
	      PreparedStatement pstmt = null;
	      int result = 0;
	      String query = "INSERT INTO NOTICE_LIKE VALUES(SEQ_APPLY_LIKE.NEXTVAL,?,?)";
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, noticeNo);
	         pstmt.setString(2, userId);
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(pstmt);
	      }
	      return result;
	   }

	public int deleteLike(Connection conn, String userId, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM NOTICE_LIKE WHERE NOTICE_NO = ? AND USER_ID = ?;";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Notice> pageAllSupportNotice(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from(SELECT ROW_NUMBER() OVER(ORDER BY NOW_SUPPORT DESC)AS NUM, NOTICE_no, USER_ID, NOTICE_TITLE, PIC_NAME, NOTICE_CONTENTS ,VIEWS, ENROLL_DATE, NOW_SUPPORT, NEED_SUPPORT,SUPPORT_HUMAN FROM NOTICE r WHERE LEVELCHECK = 'Y') where NUM BETWEEN ? AND ?";
		List<Notice> aList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			// 한 페이지에 나올 게시물의 수
			int viewCountPage = 8;
			int start = (currentPage * viewCountPage) - (viewCountPage - 1);
			int end = currentPage * viewCountPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			aList = new ArrayList<Notice>();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContents(rset.getString("NOTICE_CONTENTS"));
				notice.setViews(rset.getInt("VIEWS"));
				notice.setNowSupport(rset.getInt("NOW_SUPPORT"));
				notice.setNeedSupport(rset.getInt("NEED_SUPPORT"));
				notice.setSupportHuman(rset.getInt("SUPPORT_HUMAN"));
				notice.setPicName(rset.getString("PIC_NAME"));
				notice.setUserId(rset.getString("USER_ID"));
				aList.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return aList;
	}

	public String getSupportPageNavi(Connection conn, int currentPage) {
		int pageCountView = 5;
		int viewTotalCount = totalCount(conn);
		int viewCountPage = 8;
		int totalCountPage = 0;
		int totalCountPageMod = viewTotalCount % viewCountPage;
		if(totalCountPageMod > 0) {
			totalCountPage = viewTotalCount / viewCountPage +1;
		}else {
			totalCountPage = viewTotalCount / viewCountPage;
		}
		int startNavi =((currentPage - 1) / pageCountView) * pageCountView + 1;
		int endNavi = startNavi + pageCountView - 1;
		if(endNavi > totalCountPage) {
			endNavi = totalCountPage;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == totalCountPage) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/Notice/Support/SupportNotice?currentPage=" + (startNavi-1) + "'> [이전] </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/Notice/Support/SupportNotice?currentPage=" + i + "'>" + i + " </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/Notice/Support/SupportNotice?currentPage=" + (endNavi+1) + "'> [다음] </a>");
		}
		return sb.toString();
	}

	public Notice selectOneBySupportNo(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;
		String query = "select NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENTS, VIEWS, ENROLL_DATE,PIC_PATH, PIC_SIZE, PIC_NAME, USER_ID, NOW_SUPPORT, NEED_SUPPORT, SUPPORT_HUMAN, (select totalpoint from member m where m.user_id= n.user_id ) as totalpoint from notice n where notice_no= ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContents(rset.getString("NOTICE_CONTENTS"));
				int viewsCount = rset.getInt("VIEWS");
				notice.setViews(viewsCount);
				viewsCount++;
				notice.setEnrollDate(rset.getDate("ENROLL_DATE"));
				notice.setNowSupport(rset.getInt("NOW_SUPPORT"));
				notice.setNeedSupport(rset.getInt("NEED_SUPPORT"));
				notice.setSupportHuman(rset.getInt("SUPPORT_HUMAN"));
				notice.setPicPath(rset.getString("PIC_PATH"));
				notice.setPicSize(rset.getLong("PIC_SIZE"));
				notice.setPicName(rset.getString("PIC_NAME"));
				notice.setUserId(rset.getString("USER_ID"));
				notice.setTotalpoint(rset.getInt("totalpoint"));
				supportCountUpdate(conn, viewsCount, noticeNo);
			}
			System.out.println(notice.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return notice;
	}
	
	private int supportCountUpdate(Connection conn, int viewsCount, int applyNoticeNo) {
		int updateViews = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "UPDATE NOTICE SET VIEWS = ? WHERE NOTICE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, viewsCount);
			pstmt.setInt(2, applyNoticeNo);
			rset = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return updateViews;
	}

	public int insertSupportNoticeReply(Connection conn, String replyContents, int noticeNo, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO SUPPORT_REPLY VALUES(SEQ_APPLY_REPLY_NO.NEXTVAL,?,?,DEFAULT,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, replyContents);
			pstmt.setInt(3, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<ApplyNoticeReply> selectAllSupportNoticeReply(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		List<ApplyNoticeReply> aList = null;
		String query = "SELECT * FROM SUPPORT_REPLY WHERE NOTICE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			aList = new ArrayList<ApplyNoticeReply>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ApplyNoticeReply applyReply = new ApplyNoticeReply();
				applyReply.setReplyNo(rset.getInt("SUPPORT_REPLY_NO"));
				applyReply.setReplyUserId(rset.getString("USER_ID"));
				applyReply.setReplyContents(rset.getString("REPLY_CONTENTS"));
				applyReply.setReplyDate(rset.getDate("REPLY_DATE"));
				applyReply.setNoticeNo(rset.getInt("NOTICE_NO"));
				aList.add(applyReply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return aList;
	}

	public int deleteNoticeReplyOne(Connection conn, int replyNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM APPLY_REPLY WHERE APPLY_REPLY_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, replyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateReplyOne(Connection conn, int replyNo, String replyContents) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE APPLY_REPLY SET APPLY_REPLY_CONTENTS = ? WHERE APPLY_REPLY_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, replyContents);
			pstmt.setInt(2, replyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteSupportReplyOne(Connection conn, int replyNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM SUPPORT_REPLY WHERE SUPPORT_REPLY_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, replyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateSupportReplyOne(Connection conn, int replyNo, String replyContents) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE SUPPORT_REPLY SET REPLY_CONTENTS = ? WHERE SUPPORT_REPLY_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, replyContents);
			pstmt.setInt(2, replyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Notice> selectSearchNotice(Connection conn, String searchKeyword, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Notice> aList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY NOTICE_NO DESC) AS NUM, NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENTS, VIEWS, ENROLL_DATE, PIC_PATH, PIC_SIZE, PIC_NAME, USER_ID, NOTICE_LIKE, SIMSA FROM NOTICE WHERE NOTICE_TITLE LIKE ? AND LEVELCHECK = 'N' OR LEVELCHECK = 'S') WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10; // 한 페이지에 10개의 게시물
			int start = currentPage * viewCountPerPage - (viewCountPerPage - 1);
			int end = currentPage * viewCountPerPage;
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			aList = new ArrayList<Notice>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContents(rset.getString("NOTICE_CONTENTS"));
				notice.setViews(rset.getInt("VIEWS"));
				notice.setNoticeLike(rset.getInt("NOTICE_LIKE"));
				notice.setPicName(rset.getString("PIC_NAME"));
				notice.setUserId(rset.getString("USER_ID"));
				notice.setSimsa(rset.getString("SIMSA"));
				aList.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return aList;
	}

	public String getSearchPageNaiv(Connection conn, String searchKeyword, int currentPage) {
		int pageCountView = 5;
		int viewTotalCount = totalCount(conn);
		int viewCountPage = 8;
		int totalCountPage = 0;
		int totalCountPageMod = viewTotalCount % viewCountPage;
		if(totalCountPageMod > 0) {
			totalCountPage = viewTotalCount / viewCountPage +1;
		}else {
			totalCountPage = viewTotalCount / viewCountPage;
		}
		int startNavi =((currentPage - 1) / pageCountView) * pageCountView + 1;
		int endNavi = startNavi + pageCountView - 1;
		if(endNavi > totalCountPage) {
			endNavi = totalCountPage;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == totalCountPage) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/Notice/Apply/ApplyNotice?currentPage=" + (startNavi-1) + "'> [이전] </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/Notice/Apply/ApplyNotice?currentPage=" + i + "'>" + i + " </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/Notice/Apply/ApplyNotice?currentPage=" + (endNavi+1) + "'> [다음] </a>");
		}
		return sb.toString();
	}

	public List<Notice> selectSearchSupport(Connection conn, String searchKeyword, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Notice> aList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY NOTICE_NO DESC) AS NUM, NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENTS, VIEWS, ENROLL_DATE, PIC_PATH, PIC_SIZE, PIC_NAME, USER_ID, NOTICE_LIKE, NOW_SUPPORT, NEED_SUPPORT, SUPPORT_HUMAN FROM NOTICE WHERE NOTICE_TITLE LIKE ? AND LEVELCHECK = 'Y') WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10; // 한 페이지에 10개의 게시물
			int start = currentPage * viewCountPerPage - (viewCountPerPage - 1);
			int end = currentPage * viewCountPerPage;
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			aList = new ArrayList<Notice>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContents(rset.getString("NOTICE_CONTENTS"));
				notice.setViews(rset.getInt("VIEWS"));
				notice.setNoticeLike(rset.getInt("NOTICE_LIKE"));
				notice.setPicName(rset.getString("PIC_NAME"));
				notice.setUserId(rset.getString("USER_ID"));
				notice.setNowSupport(rset.getInt("NOW_SUPPORT"));
				notice.setNeedSupport(rset.getInt("NEED_SUPPORT"));
				notice.setSupportHuman(rset.getInt("SUPPORT_HUMAN"));
				aList.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return aList;
	}

	public int updateUserPoint(Connection conn, String userId, int point) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET TOTALPOINT = TOTALPOINT - ? WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, point);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateNowSupport(Connection conn, int noticeNo, int point) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE SET NOW_SUPPORT = NOW_SUPPORT + ? WHERE NOTICE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, point);
			pstmt.setInt(2, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateSupportHuman(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE SET SUPPORT_HUMAN = SUPPORT_HUMAN + 1 WHERE NOTICE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertPoint(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET TOTALPOINT = TOTALPOINT + 100 WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertReplyPoint(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET TOTALPOINT = TOTALPOINT + 50 WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int stealPoint(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET TOTALPOINT = TOTALPOINT - 50 WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member getPoint(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select totalpoint from member where user_id = ?";
		Member member = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setTotalPoint(rset.getInt("TOTALPOINT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	


}
