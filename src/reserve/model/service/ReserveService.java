package reserve.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import hospital.model.dao.HospitalDAO;
import hospital.model.vo.Hospital;
import mypage.model.vo.History;
import patient.model.vo.Patient;
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

	public int orderComplete(Patient patient) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result= new ReserveDAO().orderCom(conn, patient);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}

	public int payComplete(History history) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ReserveDAO().payCom(conn, history);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}
}


