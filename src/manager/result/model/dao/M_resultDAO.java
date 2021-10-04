package manager.result.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import manager.result.model.vo.M_result;

public class M_resultDAO {

//	public List<M_result> selectFileList(Connection conn, String mId) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		List<M_result> fList = null;
//		String query = "SELECT * FROM RESULT";
//		
//		return null;
//	}

	public List<M_result> selectAllResult(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY RESULT_NO DESC)AS NUM, RESULT_NO,FILE_NAME,FILE_PATH,FILE_SIZE,CHECK_DATE,USER_ID,HOSPITAL_NO FROM RESULT) WHERE NUM BETWEEN ? AND ?";
		List<M_result> fList = null;
		
		try {
			pstmt=conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage -(viewCountPerPage-1);
			int end = currentPage*viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			fList = new ArrayList<M_result>();
			while(rset.next()) {
				M_result result = new M_result();
				result.setResultNo(rset.getInt("RESULT_NO"));
				result.setFileName(rset.getString("FILE_NAME"));
				result.setFilePath(rset.getString("FILE_PATH"));
				result.setFileSize(rset.getDouble("FILE_SIZE"));
				result.setCheckDate(rset.getString("CHECK_DATE"));
				result.setUserId(rset.getString("USER_ID"));
				result.setHospitalNo(rset.getInt("HOSPITAL_NO"));
				fList.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return fList;
	}

	public String getFileNavi(Connection conn, int currentPage) {
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
			sb.append("<a href='/manager/m_result_list?currentPage="+(startNavi-1)+"'> [이전] </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/manager/m_result_list?currentPage="+i+"'>"+i+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/manager/m_result_list?currentPage="+(endNavi+1)+"'> [다음] </a>");
		}

		return sb.toString();
	}
	
	private int totalCount(Connection conn) {
		int totalValue = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM RESULT";
		
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

//	public int insertResultFile(Connection conn, M_result m_result) {
//		PreparedStatement pstmt = null;
//		int result = 0;
//		String query = "";
//		return 0;
//	}

}
