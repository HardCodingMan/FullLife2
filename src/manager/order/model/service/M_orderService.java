package manager.order.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import manager.order.model.dao.M_orderDAO;
import manager.order.model.vo.M_order;
import manager.order.model.vo.M_orderPage;

public class M_orderService {

	private JDBCTemplate jdbcTemplate;
	public M_orderService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	
	public M_orderPage printAllOrder(int currentPage) {
		M_orderPage pd = new M_orderPage();
		Connection conn = null;
		M_orderDAO oDao = new M_orderDAO();
		
		try {
			conn=jdbcTemplate.createConnection();
			pd.setOpList(oDao.selectAllOrder(conn, currentPage));
			pd.setPageNavi(oDao.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
	}


	public int deleteOrder(int hNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn=jdbcTemplate.createConnection();
			result = new M_orderDAO().removeOrder(conn,hNo);
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


	public M_orderPage printSearchOrder(int searchNo, int currentPage) {
		Connection conn = null;
		List<M_order> oList = null;
		String searchPageNavi = null;
		M_orderPage pd = new M_orderPage();
		M_orderDAO oDao = new M_orderDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			oList = oDao.getSearchOrder(conn, searchNo, currentPage);
			searchPageNavi = oDao.getSearchPageNavi(conn, searchNo, currentPage);
			pd.setOpList(oList);
			pd.setPageNavi(searchPageNavi);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
