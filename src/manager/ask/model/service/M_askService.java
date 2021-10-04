package manager.ask.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import manager.ask.model.dao.M_askDAO;
import manager.ask.model.vo.M_ask;
import manager.ask.model.vo.M_askPage;

public class M_askService {
	
	private JDBCTemplate jdbcTemplate;
	public M_askService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public M_askPage printAllAsk(int currentPage) {
		Connection conn = null;
		M_askPage pd = new M_askPage();
		M_askDAO aDao = new M_askDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			pd.setaPdList(aDao.selectAllAsk(conn, currentPage));
			pd.setPageNavi(aDao.getPageNavi(conn, currentPage));	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}	
		return pd;
	}

	public M_ask printOneByAsk(int aNo) {
		M_ask aOne = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			aOne = M_askDAO.selectOneByAsk(conn, aNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return aOne;
	}

	public int modifyAnswer(M_ask ask) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new M_askDAO().updateAnswer(conn, ask);
			
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

	public M_askPage printSearchAsk(String searchId, int currentPage) {
		Connection conn = null;
		List<M_ask> aList = null;
		String searchPageNavi = null;
		M_askPage pd = new M_askPage();
		M_askDAO aDao = new M_askDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			aList = aDao.getSearchAsk(conn, searchId, currentPage);
			searchPageNavi = aDao.getSearchPageNavi(conn, searchId, currentPage);
			pd.setaPdList(aList);
			pd.setPageNavi(searchPageNavi);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
