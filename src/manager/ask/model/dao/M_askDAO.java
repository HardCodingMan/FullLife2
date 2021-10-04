package manager.ask.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import manager.ask.model.vo.M_ask;

public class M_askDAO {

	public List<M_ask> selectAllAsk(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY ASK_NO DESC)AS NUM,ASK_NO,ASK_SUBJECT,ASK_CONTENTS,ASK_DATE,USER_ID,REPLY FROM ASK_BOARD) WHERE NUM BETWEEN ? AND ?";
		List<M_ask> aList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage -(viewCountPerPage-1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			aList = new ArrayList<M_ask>();
			while(rset.next()) {
				M_ask ask = new M_ask();
				ask.setAskNo(rset.getInt("ASK_NO"));
				ask.setAskSub(rset.getString("ASK_SUBJECT"));
				ask.setAskCon(rset.getString("ASK_CONTENTS"));
				ask.setAskDate(rset.getDate("ASK_DATE"));
				ask.setUserId(rset.getString("USER_ID"));
				ask.setReply(rset.getString("REPLY").charAt(0));
				aList.add(ask);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return aList;
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
			pageTotalCount = viewTotalCount / viewCountPerPage;
		}
		
		int startNavi = ((currentPage -1)/pageCountPerView)* pageCountPerView +1;
		int endNavi = startNavi + pageCountPerView -1;
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
			sb.append("<a href='/manager/m_ask_list?currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/manager/m_ask_list?currentPage="+i+"'>"+i+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/manager/m_ask_list?currentPage="+(endNavi+1)+"'> [다음] </a>");
		}

		return sb.toString();
	}

	
	private int totalCount(Connection conn) {
		int totalValue = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MEMBER";
		
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

	public static M_ask selectOneByAsk(Connection conn, int aNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		M_ask aOne = null;
		String query = "SELECT * FROM ASK_BOARD WHERE ASK_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, aNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				aOne = new M_ask();
				aOne.setAskNo(rset.getInt("ASK_NO"));
				aOne.setAskSub(rset.getString("ASK_SUBJECT"));
				aOne.setAskCon(rset.getString("ASK_CONTENTS"));
				aOne.setAnswerCon(rset.getString("ANSWER_CONTENTS"));
				aOne.setAskDate(rset.getDate("ASK_DATE"));
				aOne.setAnswerDate(rset.getDate("ANSWER_DATE"));
				aOne.setUserId(rset.getString("USER_ID"));
				aOne.setDisclosure(rset.getString("DISCLOSURE").charAt(0));
				aOne.setReply(rset.getString("REPLY").charAt(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return aOne;
	}

	public int updateAnswer(Connection conn, M_ask ask) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "UPDATE ASK_BOARD SET ASK_SUBJECT=?, ASK_CONTENTS=?, ANSWER_CONTENTS=?, REPLY='Y' WHERE ASK_NO = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, ask.getAskSub());
			pstmt.setString(2, ask.getAskCon());
			pstmt.setString(3, ask.getAnswerCon());
			pstmt.setInt(4, ask.getAskNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<M_ask> getSearchAsk(Connection conn, String searchId, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<M_ask> aList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY ASK_NO DESC)AS NUM,ASK_NO, ASK_SUBJECT, ASK_CONTENTS, ANSWER_CONTENTS, ASK_DATE, ANSWER_DATE, USER_ID, DISCLOSURE, REPLY FROM ASK_BOARD WHERE USER_ID LIKE ?)WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchId+"%");
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage -(viewCountPerPage-1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			aList = new ArrayList<M_ask>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				M_ask ask = new M_ask();
				ask.setAskNo(rset.getInt("ASK_NO"));
				ask.setAskSub(rset.getString("ASK_SUBJECT"));
				ask.setAskCon(rset.getString("ASK_CONTENTS"));
				ask.setAnswerCon(rset.getString("ANSWER_CONTENTS"));
				ask.setAskDate(rset.getDate("ASK_DATE"));
				ask.setAnswerDate(rset.getDate("ANSWER_DATE"));
				ask.setUserId(rset.getString("USER_ID"));
				ask.setDisclosure(rset.getString("DISCLOSURE").charAt(0));
				ask.setReply(rset.getString("REPLY").charAt(0));
				aList.add(ask);
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

	public String getSearchPageNavi(Connection conn, String searchId, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = searchTotalCount(conn, searchId);
		int viewCountPerPage = 10;
		int pageTotalCount = 0;
		if(viewTotalCount % viewCountPerPage > 0) {
			pageTotalCount = viewTotalCount/ viewCountPerPage +1;
		}else {
			pageTotalCount = viewTotalCount / viewCountPerPage;
		}
		
		int startNavi = ((currentPage -1)/pageCountPerView)*pageCountPerView+1;
		int endNavi = startNavi + pageCountPerView -1;
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
			sb.append("<a href='/manager/m_ask_search?searchId="+searchId+"&currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/manager/m_ask_search?searchId="+searchId+"&currentPage="+i+"'> "+i+" </a>");
		}
		if(needNext) {
			sb.append("<a href='/manager/m_ask_search?searchId="+searchId+"&currentPage="+(endNavi+1)+"'> [다음] </a>");
		}
		
		return sb.toString();
	}
	
	
	private int searchTotalCount(Connection conn, String searchId) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MEMBER WHERE USER_ID LIKE '%"+searchId+"%'";
		
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
