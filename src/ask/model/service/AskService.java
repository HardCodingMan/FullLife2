package ask.model.service;

import java.sql.Connection;
import java.sql.SQLException;

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
		PageData pd = new PageData();
		Connection conn = null;
		AskDAO aDAO = new AskDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			pd.setAskList(aDAO.selectAllAsk(conn,currentPage));
			pd.setPageNavi(aDAO.getPageNavi(conn,currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}

}
