package ask.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ask.model.dao.AskDAO;
import ask.model.vo.Ask;
import ask.model.vo.PageData;
import common.JDBCTemplate;

public class AskService {
	private JDBCTemplate jdbcTemplate;
	
	public AskService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	

	public PageData printAllAsk(int currentPage) {
		Connection conn = null;
		PageData pageData = new PageData();
		AskDAO aDAO = new AskDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			pageData.setAskList(aDAO.selectAllAsk(conn,currentPage));
			pageData.setPageNavi(aDAO.getPageNavi(conn,currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pageData;
	}


	public int registerAsk(Ask ask) {
		int result = 0;
		Connection conn =null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new AskDAO().insertAsk(conn,ask);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}


	public PageData printSearchAsk(String searchKeyword, int currentPage) {
		Connection conn = null;
		List<Ask> aList = null;
		String searchPageNavi = null;
		PageData pageData = new PageData();
		AskDAO aDAO = new AskDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			aList = new AskDAO().selectSearchAsk(conn, searchKeyword, currentPage);
			searchPageNavi = aDAO.getSearchPageNavi(conn, searchKeyword, currentPage);
			pageData.setAskList(aList);
			pageData.setPageNavi(searchPageNavi);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pageData;
	}


	public Ask printOneByNo(int askNo) {
		Connection conn = null;
		int result= 0;
		Ask askOne = null;
		AskDAO aDAO = new AskDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			askOne = aDAO.selectOneByNo(conn, askNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return askOne;
	}


	public int removeAsk(int askNo) {
		int result = 0;
		Connection conn =null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new AskDAO().deleteAsk(conn,askNo);
//			if(result > 0) {
//				JDBCTemplate.commit(conn);
//			}else {
//				JDBCTemplate.rollback(conn);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
}
