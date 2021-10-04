package ask.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ask.model.vo.Ask;
import common.JDBCTemplate;
import manager.ask.model.vo.M_ask;

public class AskDAO {

	public int insertAsk(Connection conn, Ask ask) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO ASK_BOARD VALUES(SEQ_ASK.NEXTVAL,?,?,NULL,SYSDATE,NULL,?,?,DEFAULT)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, ask.getAskSubject());
			pstmt.setString(2, ask.getAskContents());
			pstmt.setString(3, ask.getUserId());
			pstmt.setString(4, ask.getDisclosure());
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Ask> selectAllAsk(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Ask> aList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY ASK_NO DESC) AS NUM, ASK_NO, ASK_SUBJECT, ASK_CONTENTS, ASK_DATE, USER_ID,REPLY, DISCLOSURE FROM ASK_BOARD ) WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			int viewCountPerPage=10;
			int start = currentPage*viewCountPerPage-(viewCountPerPage - 1);
			int end = currentPage*viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset=pstmt.executeQuery();
			
			aList = new ArrayList<Ask>();
			while(rset.next()) {
				Ask ask = new Ask();
				ask.setAskNo(rset.getInt("ASK_NO"));
				ask.setAskSubject(rset.getString("ASK_SUBJECT"));
				ask.setAskContents(rset.getString("ASK_CONTENTS"));
				ask.setAskDate(rset.getDate("ASK_DATE"));
				ask.setUserId(rset.getString("USER_ID"));
				ask.setReply(rset.getString("REPLY"));
				ask.setDisclosure(rset.getString("DISCLOSURE"));
				aList.add(ask);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			pageTotalCount = viewTotalCount / viewCountPerPage + 1;
		}else {
			pageTotalCount = viewTotalCount/ viewCountPerPage;
		}
				
		int startNavi = ((currentPage-1)/ pageCountPerView)* pageCountPerView +1;
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
			sb.append("<a href='/ask/list?currentPage=" + (startNavi-1)+ "'> [이전] </a>");
		}
		for (int i=startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i);
			}else {
			sb.append("<a href='/ask/list?currentPage=" + i + "'>" + i+ " </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='ask/list?currentPage" + (endNavi+1)+ "'> [다음] </a>");
		}
		return sb.toString();
		
	}
	public int totalCount(Connection conn) {
		int totalValue = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query= "SELECT COUNT(*) AS TOTALCOUNT FROM ASK_BOARD";
		
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
			JDBCTemplate.close(conn);
			JDBCTemplate.close(stmt);
		}
		return totalValue;
	}

	public List<Ask> selectSearchAsk(Connection conn, String searchKeyword, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Ask> aList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY ASK_NO DESC)AS NUM,ASK_NO, ASK_SUBJECT, ASK_CONTENTS, ANSWER_CONTENTS, ASK_DATE, ANSWER_DATE, USER_ID, DISCLOSURE, REPLY FROM ASK_BOARD WHERE ASK_SUBJECT LIKE ? or ASK_CONTENTS LIKE ?)WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setString(2, "%"+searchKeyword+"%");
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage - (viewCountPerPage-1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			aList = new ArrayList<Ask>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Ask ask = new Ask();
				ask.setAskNo(rset.getInt("ASK_NO"));
				ask.setAskSubject(rset.getString("ASK_SUBJECT"));
				ask.setAskContents(rset.getString("ASK_CONTENTS"));
				ask.setAnswerContents(rset.getString("ANSWER_CONTENTS"));
				ask.setAskDate(rset.getDate("ASK_DATE"));
				ask.setAnswerDate(rset.getDate("ANSWER_DATE"));
				ask.setUserId(rset.getString("USER_ID"));
				ask.setDisclosure(rset.getString("DISCLOSURE"));
				ask.setReply(rset.getString("REPLY"));
				aList.add(ask);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return aList;
	}

	public String getSearchPageNavi(Connection conn, String searchKeyword, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = searchTotalCount(conn, searchKeyword);
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
			sb.append("<a href='/ask/search?searchKeyword="+searchKeyword+"&currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/ask/search?searchKeyword="+searchKeyword+"&currentPage="+i+"'> "+i+" </a>");
		}
		if(needNext) {
			sb.append("<a href='/ask/search?searchKeyword="+searchKeyword+"&currentPage="+(endNavi+1)+"'> [다음] </a>");
		}
		
		return sb.toString();
	}

	private int searchTotalCount(Connection conn, String searchKeyword) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM ASK_BOARD WHERE (ASK_SUBJECT LIKE '%" + searchKeyword + "%') or (ASK_contents LIKE '%" + searchKeyword + "%')";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				result = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	public Ask selectOneByNo(Connection conn, int askNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Ask askOne =null;
		String query = "SELECT * FROM ASK_BOARD WHERE ASK_NO =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, askNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				askOne = new Ask();
				askOne.setAskNo(rset.getInt("ASK_NO"));
				askOne.setAskSubject(rset.getString("ASK_SUBJECT"));
				askOne.setAskContents(rset.getString("ASK_CONTENTS"));
				askOne.setAnswerContents(rset.getString("ANSWER_CONTENTS"));
				askOne.setAskDate(rset.getDate("ASK_DATE"));
				askOne.setAnswerDate(rset.getDate("ANSWER_DATE"));
				askOne.setUserId(rset.getString("USER_ID"));
				askOne.setDisclosure(rset.getString("DISCLOSURE"));
				askOne.setReply(rset.getString("REPLY"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
				
		return askOne;
	}

	public int deleteAsk(Connection conn, int askNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM ASK_BOARD WHERE ASK_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, askNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}

	