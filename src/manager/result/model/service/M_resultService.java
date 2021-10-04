package manager.result.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import manager.result.model.dao.M_resultDAO;
import manager.result.model.vo.M_FilePage;
import manager.result.model.vo.M_result;

public class M_resultService {
	
	private JDBCTemplate jdbcTemplate;
	
	public M_resultService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	

//	public List<M_result> printFileList(String mId) {
//		Connection conn = null;
//		List<M_result> fList = null;
//		
//		try {
//			conn= jdbcTemplate.createConnection();
//			fList = new M_resultDAO().selectFileList(conn, mId);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(conn);
//		}
//		
//		return fList;
//	}


	public M_FilePage printAllResult(int currentPage) {
		M_FilePage fPd = new M_FilePage();
		Connection conn = null;
		M_resultDAO rDao = new M_resultDAO();
		
		try {
			conn=jdbcTemplate.createConnection();
			fPd.setfPdList(rDao.selectAllResult(conn, currentPage));
			fPd.setPageNavi(rDao.getFileNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return fPd;
	}


	public int registerResultFile(M_result m_result) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new M_resultDAO().insertResultFile(conn, m_result);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}

		return result;
	}

}
