package ask.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ask.model.vo.Ask;
import common.JDBCTemplate;

public class AskDAO {

	public int insertAsk(Connection conn, Ask ask) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO ASK VALUES(SEQ_ASK.NEXTVAL,?,?,?,DEFAULT,DEFAULT)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, ask.getAskSubject());
			pstmt.setString(2, ask.getAskContents());
			pstmt.setString(3, ask.getUserId());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY ASK_NO DESC) AS NUM, ASK_NO, ASK_SUBJECT, ASK_CONTENTS, USER_ID, ASK_DATE) WHERE NUM BETWEEN ? AND ?";
		
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
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return aList;
	}

	public String getPageNavi(Connection conn, int currentPage) {
		return null;
	}

	

}
