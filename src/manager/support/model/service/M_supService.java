package manager.support.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import manager.support.model.dao.M_supDAO;
import manager.support.model.vo.M_supPage;
import manager.support.model.vo.M_supReply;
import manager.support.model.vo.M_support;

public class M_supService {

	private JDBCTemplate jdbcTemplate;
	public M_supService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	
	
	public M_supPage printAllSup(int currentPage) {
		M_supPage pd = new M_supPage();
		Connection conn = null;
		M_supDAO sDao = new M_supDAO();
		
		try {
			conn=jdbcTemplate.createConnection();
			pd.setsList(sDao.selectAllSup(conn, currentPage));
			pd.setPageNavi(sDao.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}

		return pd;
	}


	public M_support printOneBySup(int notiNo) {
		M_support sup = null;
		Connection conn = null;
		
		List<M_supReply> reList = null;
		M_supDAO sDao = new M_supDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			sup = sDao.selectOneBySup(conn, notiNo);
			//댓글
			reList = sDao.selectAllReply(conn, notiNo);
			sup.setReplies(reList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return sup;
	}


	public int removeReplyOne(int replyNo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new M_supDAO().deleteReplyOne(conn, replyNo);
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

<<<<<<< HEAD
<<<<<<< HEAD
=======

=======
>>>>>>> ssolol
	public int updateSup(int notiNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn=jdbcTemplate.createConnection();
			result = new M_supDAO().levelCheckSup(conn, notiNo);
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


	public M_supPage printSearchSup(String keyword, int currentPage) {
		Connection conn = null;
		List<M_support> sList = null;
		String searchPageNavi = null;
		M_supPage pd = new M_supPage();
		M_supDAO sDao = new M_supDAO();
		System.out.println("service"+keyword);
		try {
			conn = jdbcTemplate.createConnection();
			sList = sDao.getSearchSup(conn, keyword, currentPage);
			searchPageNavi = sDao.getSearchPageNavi(conn, keyword, currentPage);
			pd.setsList(sList);
			pd.setPageNavi(searchPageNavi);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}

		return pd;
	}

<<<<<<< HEAD
>>>>>>> 0b8b31763b892601bd08fbfdfc73c26b044b36ce
=======
>>>>>>> ssolol
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
