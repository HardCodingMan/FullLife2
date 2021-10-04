package manager.order.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import manager.order.model.vo.M_order;

public class M_orderDAO {

	public List<M_order> selectAllOrder(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY HISTORY_NO DESC)AS NUM,HISTORY_NO,ORGAN_NO,ORGAN_QUANTITY,HISTORY_DATE,PAYMENT,PAYMENT_DATE,USED_POINT,USER_ID,HOSPITAL_NO FROM HISTORY) WHERE NUM BETWEEN ? AND ?";
		List<M_order> oList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage -(viewCountPerPage-1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			oList = new ArrayList<M_order>();
			while(rset.next()) {
				M_order order = new M_order();
				order.setHistoryNo(rset.getInt("HISTORY_NO"));
				order.setOrganNo(rset.getInt("ORGAN_NO"));
				order.setOrganQuan(rset.getInt("ORGAN_QUANTITY"));
				order.setHistoryDate(rset.getDate("HISTORY_DATE"));
				order.setPayment(rset.getInt("PAYMENT"));
				order.setPayDate(rset.getDate("PAYMENT_DATE"));
				order.setUsedPoint(rset.getInt("USED_POINT"));
				order.setUserId(rset.getString("USER_ID"));
				order.setHospitalNo(rset.getInt("HOSPITAL_NO"));
				oList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return oList;
	}

	public String getPageNavi(Connection conn, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = totalCount(conn);
		int viewCountPerPage =10;
		int pageTotalCount = 0;
		int pageTotalCountMod = viewTotalCount % viewCountPerPage;
		if(pageTotalCountMod>0) {
			pageTotalCount = viewTotalCount / viewCountPerPage + 1;
		}else {
			pageTotalCount = viewTotalCount / viewCountPerPage;
		}
		
		int startNavi = ((currentPage -1)/pageCountPerView)*pageCountPerView +1;
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
			sb.append("<a href='/manager/m_order_list?currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/manager/m_order_list?currentPage="+i+"'>"+i+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/manager/m_order_list?currentPage="+(endNavi+1)+"'> [다음] </a>");
		}
		
		return sb.toString();
	}
	
	private int totalCount(Connection conn) {
		int totalValue = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM HISTORY";
		
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

	public int removeOrder(Connection conn, int hNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result =0;
		String query ="DELETE FROM HISTORY WHERE HISTORY_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, hNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public List<M_order> getSearchOrder(Connection conn, int searchNo, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<M_order> oList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY HISTORY_NO DESC)AS NUM,HISTORY_NO, ORGAN_NO, ORGAN_QUANTITY, HISTORY_DATE, PAYMENT, PAYMENT_DATE, USED_POINT, USER_ID, HOSPITAL_NO FROM HISTORY WHERE HISTORY_NO LIKE ?)WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, searchNo);
			int viewCountPerPage = 10;
			int start = currentPage * viewCountPerPage -(viewCountPerPage-1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			oList = new ArrayList<M_order>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				M_order order = new M_order();
				order.setHistoryNo(rset.getInt("HISTORY_NO"));
				order.setOrganNo(rset.getInt("ORGAN_NO"));
				order.setOrganQuan(rset.getInt("ORGAN_QUANTITY"));
				order.setHistoryDate(rset.getDate("HISTORY_DATE"));
				order.setPayment(rset.getInt("PAYMENT"));
				order.setPayDate(rset.getDate("PAYMENT_DATE"));
				order.setUsedPoint(rset.getInt("USED_POINT"));
				order.setUserId(rset.getString("USER_ID"));
				order.setHospitalNo(rset.getInt("HOSPITAL_NO"));
				oList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return oList;
	}

	public String getSearchPageNavi(Connection conn, int searchNo, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = searchTotalCount(conn, searchNo);
		int viewCountPerPage = 10;
		int pageTotalCount = 0;
		if(viewTotalCount % viewCountPerPage >0) {
			pageTotalCount = viewTotalCount / viewCountPerPage+1;
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
			sb.append("<a href='/manager/m_order_search?searchNo="+searchNo+"&currentPage="+(startNavi-1)+"'> [이전] </a>");			
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/manager/m_order_search?searchNo="+searchNo+"&currentPage="+i+"'> "+i+" </a>");
		}
		if(needNext) {
			sb.append("<a href='/manager/m_order_search?searchNo="+searchNo+"&currentPage="+(endNavi+1)+"'> [다음] </a>");
		}
		
		return sb.toString();
	}

	private int searchTotalCount(Connection conn, int searchNo) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM HISTORY WHERE HISTORY_NO="+searchNo;
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
