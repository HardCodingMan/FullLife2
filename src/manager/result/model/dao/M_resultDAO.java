package manager.result.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import manager.result.model.vo.M_patient;
import manager.result.model.vo.M_result;
import oracle.jdbc.proxy.annotation.Pre;

public class M_resultDAO {

//	public List<M_result> selectFileList(Connection conn, String mId) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		List<M_result> fList = null;
//		String query = "SELECT * FROM RESULT";
//		
//		return null;
//	}

	public List<M_patient> selectAllPatient(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY RESULT_NO DESC)AS NUM, RESULT_NO,PATIENT.USER_ID,PATIENT_NAME,FILE_NAME FROM PATIENT LEFT JOIN RESULT ON PATIENT.USER_ID=RESULT.USER_ID) WHERE NUM BETWEEN ? AND ?";
		List<M_patient> fList = null;
		
		try {
			pstmt=conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage -(viewCountPerPage-1);
			int end = currentPage*viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			fList = new ArrayList<M_patient>();
			while(rset.next()) {
				M_patient patient = new M_patient();
				patient.setResultNo(rset.getInt("RESULT_NO"));
				patient.setUserId(rset.getString("USER_ID"));
				patient.setpName(rset.getString("PATIENT_NAME"));
				patient.setFileName(rset.getString("FILE_NAME"));

				fList.add(patient);
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
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PATIENT";
		
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

<<<<<<< HEAD
<<<<<<< HEAD
	public int insertResultFile(Connection conn, M_result m_result) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		return 0;
=======
=======
>>>>>>> ssolol
	public int insertResultFile(Connection conn, M_patient patient) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO RESULT VALUES(SEQ_RESULT.NEXTVAL, ?,?,?,SYSDATE,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, patient.getFileName());
			pstmt.setString(2, patient.getFilePath());
			pstmt.setLong(3, patient.getFileSize());
			pstmt.setString(4, patient.getUserId());
			pstmt.setInt(5, patient.getHosNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
<<<<<<< HEAD
>>>>>>> 0b8b31763b892601bd08fbfdfc73c26b044b36ce
=======

>>>>>>> ssolol
	}

	public int deleteFile(Connection conn, String fileUser, String fileName) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM RESULT WHERE USER_ID=? AND FILE_NAME=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, fileUser);
			pstmt.setString(2, fileName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public List<M_patient> getSearchResult(Connection conn, int keyword, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<M_patient> pList = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY RESULT_NO DESC)AS NUM,RESULT_NO,PATIENT.USER_ID,PATIENT_NAME,FILE_NAME FROM PATIENT LEFT JOIN RESULT ON PATIENT.USER_ID=RESULT.USER_ID WHERE RESULT_NO=?) WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, keyword);
			int viewCountPerPage = 10;
			int start = currentPage * viewCountPerPage -(viewCountPerPage -1);
			int end = currentPage * viewCountPerPage;
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			pList = new ArrayList<M_patient>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				M_patient patient = new M_patient();
				patient.setResultNo(rset.getInt("RESULT_NO"));
				patient.setUserId(rset.getString("USER_ID"));
				patient.setpName(rset.getString("PATIENT_NAME"));
				patient.setFileName(rset.getString("FILE_NAME"));
				pList.add(patient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return pList;
	}

	public String getSearchPageNavi(Connection conn, int keyword, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = searchTotalCount(conn, keyword);
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
			sb.append("<a href='/manager/m_result_search?searchKeyword="+keyword+"&currentPage="+(startNavi-1)+"'> [이전] </a>");			
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/manager/m_result_search?searchKeyword="+keyword+"&currentPage="+i+"'> "+i+" </a>");
		}
		if(needNext) {
			sb.append("<a href='/manager/m_result_search?searchKeyword="+keyword+"&currentPage="+(endNavi+1)+"'> [다음] </a>");
		}
		
		return sb.toString();
	}
	
	private int searchTotalCount(Connection conn, int keyword) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PATIENT WHERE RESULT_NO="+keyword;
		
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
