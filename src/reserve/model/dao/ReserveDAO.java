0package reserve.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import hospital.model.vo.Hospital;
import patient.model.vo.Patient;

public class ReserveDAO {

	public ArrayList<Hospital> selectAllHospital(Connection conn, String done) {
			ArrayList<Hospital> hospitals = null;
			Statement stmt = null;
			ResultSet rset = null;
			
			String query = "SELECT * FROM HOSPITAL WHERE HOSPITAL_ADDR LIKE '%"+done+"%'";
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				hospitals = new ArrayList<Hospital>();
				while(rset.next()) {
					Hospital hospital = new Hospital();
					hospital.setHospitalNo(rset.getInt("HOSPITAL_NO"));
					hospital.setHospitalName(rset.getString("HOSPITAL_NAME"));
					hospital.setHospitalAddr(rset.getString("HOSPITAL_ADDR"));
					hospital.setHospitalPhone(rset.getString("HOSPITAL_PHONE"));
					hospitals.add(hospital);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(stmt);
			}
			return hospitals;
		}

	public int orderCom(Connection conn, Patient patient) {
	
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO PATIENT VALUES(SEQ_PATIENT.NEXTVAL, ?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, patient.getPatientName());
			pstmt.setString(2, patient.getPatientAddr());
			pstmt.setString(3, patient.getPatientPhone());
			pstmt.setString(4, patient.getRelation());
			pstmt.setString(5, patient.getPatientZumin());
			pstmt.setInt(6, patient.getOrganNo());
			pstmt.setDate(7, patient.getHospitalTime());
			pstmt.setInt(8, patient.getHospitalNo());
			pstmt.setString(9, patient.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
