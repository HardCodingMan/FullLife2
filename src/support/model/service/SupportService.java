package support.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import support.model.dao.SupportDAO;
import support.model.vo.Support;

public class SupportService {
	
	private JDBCTemplate jdbcTemplate;
	
	public SupportService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public Support getFirstSupportNotice(int firstRank) {
		Support firstSupport = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			firstSupport = new SupportDAO().selectFirstSupport(conn, firstRank);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return firstSupport;
	}

	public Support getSecondSupportNotice(int secondRank) {
		Support secondSupport = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			secondSupport = new SupportDAO().selectSecondSupport(conn, secondRank);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return secondSupport;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
