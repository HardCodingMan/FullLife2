package reserve.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import hospital.model.dao.HospitalDAO;
import hospital.model.vo.Hospital;
import reserve.model.dao.ReserveDAO;

public class ReserveService {
	private JDBCTemplate jdbcTemplate;
	
	public ReserveService() {
		jdbcTemplate= JDBCTemplate.getConnection();
	}

	public ArrayList<Hospital> getAllHospital(String done) {
		ArrayList<Hospital> hospitals = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			hospitals = new ReserveDAO().selectAllHospital(conn, done);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return hospitals;
	}

}
