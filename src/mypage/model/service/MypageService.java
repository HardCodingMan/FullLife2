package mypage.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import common.JDBCTemplate;
import mypage.model.dao.MypageDAO;
import mypage.model.vo.HistoryPage;

public class MypageService {
	private JDBCTemplate jdbcTemplate;
	
	public MypageService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	


	public HistoryPage printAllList(int historyPage) {
		HistoryPage hisPage = new HistoryPage();
		Connection conn = null;
		MypageDAO hDao = new MypageDAO();
		
		try {
			conn=jdbcTemplate.createConnection();
			hisPage.sethList(hDao.selectAllList(conn, historyPage));
			hisPage.setPageNavi(hDao.getPageNavi(conn, historyPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return hisPage;
	} 


	
	
}




