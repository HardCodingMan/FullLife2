package manager.apply.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import manager.apply.model.dao.M_applyDAO;
import manager.apply.model.vo.M_apply;
import manager.apply.model.vo.M_applyPage;
import manager.apply.model.vo.M_applyReply;

public class M_applyService {

	private JDBCTemplate jdbcTemplate;
	public M_applyService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	
	public M_applyPage printAllApply(int currentPage) {
		M_applyPage pd = new M_applyPage();
		Connection conn = null;
		M_applyDAO aDao = new M_applyDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			pd.setApList(aDao.selectAllApply(conn, currentPage));
			pd.setPageNavi(aDao.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
	}

	public int deleteApply(int notiNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new M_applyDAO().deleteApply(conn, notiNo);
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

	public M_apply printOneByApply(int notiNo) {
		M_apply apply = null;
		Connection conn = null;
		
		List<M_applyReply> reList = null;
		M_applyDAO aDao = new M_applyDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			apply = aDao.selectOneByApply(conn, notiNo);
			//댓글
			reList = aDao.selectAllReply(conn, notiNo);
			apply.setReplies(reList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return apply;
	}

	public int removeReplyOne(int replyNo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new M_applyDAO().deleteReplyOne(conn, replyNo);
			if(result>0) {
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

	public int updateApply(int notiNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new M_applyDAO().levelCheckApply(conn, notiNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public M_applyPage printSearchApply(String keyword, int currentPage) {
		Connection conn = null;
		List<M_apply> apList = null;
		String searchPageNavi = null;
		M_applyPage pd = new M_applyPage();
		M_applyDAO aDao = new M_applyDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			apList = aDao.getSearchApply(conn, keyword, currentPage);
			searchPageNavi = aDao.getSearchPageNavi(conn, keyword, currentPage);
			pd.setApList(apList);
			pd.setPageNavi(searchPageNavi);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
