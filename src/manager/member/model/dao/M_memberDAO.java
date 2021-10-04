package manager.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import manager.member.moder.vo.M_member;

public class M_memberDAO {
	
	public M_memberDAO() {}

	public List<M_member> getSearchMember(Connection conn, String searchId, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<M_member> mList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY USER_NO DESC)AS NUM,USER_ID, USER_NO, USER_PWD, USER_NAME, ZUMIN, ADDRESS, PHONE, REG_DATE, ENROLLED, TOTALPOINT, EMAIL FROM MEMBER WHERE USER_ID LIKE ?)WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchId+"%");
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage -(viewCountPerPage -1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			mList = new ArrayList<M_member>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				M_member member = new M_member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserNo(rset.getInt("USER_NO"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setZumin(rset.getString("ZUMIN"));
				member.setAddr(rset.getString("ADDRESS"));
				member.setPhone(rset.getString("PHONE"));
				member.setRegDate(rset.getDate("REG_DATE"));
				member.setEnrolled(rset.getString("ENROLLED"));
				member.setTotalPoint(rset.getInt("TOTALPOINT"));
				member.setEmail(rset.getString("EMAIL"));
				mList.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mList;
	}

	public List<M_member> selectAllMember(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY USER_NO DESC)AS NUM, USER_NO, USER_ID, USER_PWD, USER_NAME, ZUMIN, ADDRESS, PHONE, REG_DATE, ENROLLED, TOTALPOINT, EMAIL FROM MEMBER) WHERE NUM BETWEEN ? AND ?";
		List<M_member> mList = null;
		
		try {
			pstmt=conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage -(viewCountPerPage-1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			mList = new ArrayList<M_member>();
			while(rset.next()) {
				M_member member = new M_member();
				member.setUserNo(rset.getInt("USER_NO"));
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setZumin(rset.getString("ZUMIN"));
				member.setAddr(rset.getString("ADDRESS"));
				member.setPhone(rset.getString("PHONE"));
				member.setRegDate(rset.getDate("REG_DATE"));
				member.setEnrolled(rset.getString("ENROLLED"));
				member.setTotalPoint(rset.getInt("TOTALPOINT"));
				member.setEmail(rset.getString("EMAIL"));
				mList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mList;
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
			sb.append("<a href='/manager/m_member_list?currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/manager/m_member_list?currentPage="+i+"'>"+i+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/manager/m_member_list?currentPage="+(endNavi+1)+"'> [다음] </a>");
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

	public int updateMember(Connection conn, M_member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "UPDATE MEMBER SET USER_PWD = ?, ADDRESS = ?, PHONE = ?, TOTALPOINT = ?,EMAIL = ? WHERE USER_ID= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserPwd());
			pstmt.setString(2, member.getAddr());
			pstmt.setString(3, member.getPhone());
			pstmt.setInt(4, member.getTotalPoint());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return result;
	}

	public static M_member selectOneByMem(Connection conn, int mNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		M_member mOne = null;
		String query = "SELECT * FROM MEMBER WHERE USER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mOne = new M_member();
				mOne.setUserId(rset.getString("USER_ID"));
				mOne.setUserPwd(rset.getString("USER_PWD"));
				mOne.setUserName(rset.getString("USER_NAME"));
				mOne.setZumin(rset.getString("ZUMIN"));
				mOne.setAddr(rset.getString("ADDRESS"));
				mOne.setPhone(rset.getString("PHONE"));
				mOne.setTotalPoint(rset.getInt("TOTALPOINT"));
				mOne.setEmail(rset.getString("EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return mOne;
	}

	public int deleteUser(Connection conn, String mId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "DELETE FROM MEMBER WHERE USER_ID = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, mId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return result;
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
			sb.append("<a href='/manager/m_member_search?searchId="+searchId+"&currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/manager/m_member_search?searchId="+searchId+"&currentPage="+i+"'> "+i+" </a>");
		}
		if(needNext) {
			sb.append("<a href='/manager/m_member_search?searchId="+searchId+"&currentPage="+(endNavi+1)+"'> [다음] </a>");
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
