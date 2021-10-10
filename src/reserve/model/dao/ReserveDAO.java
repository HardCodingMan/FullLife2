package reserve.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import hospital.model.vo.Hospital;
import mypage.model.vo.History;
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
		java.util.Date date = new java.util.Date();

        long hosTime = date.getTime();
        java.sql.Date date1 = new java.sql.Date(hosTime);
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO PATIENT VALUES(SEQ_PATIENT.NEXTVAL, ?,?,?,?,?,?,?,?,?,SEQ_HISTORY.CURRVAL)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, patient.getPatientName());
			pstmt.setString(2, patient.getPatientAddr());
			pstmt.setString(3, patient.getPatientPhone());
			pstmt.setString(4, patient.getRelation());
			pstmt.setString(5, patient.getPatientZumin());
			pstmt.setInt(6, patient.getOrganNo());
//			pstmt.setDate(7, Date.valueOf(patient.getHospitalTime().toString()));
			pstmt.setDate(7, date1);
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
	
	public int payCom(Connection conn, History history) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="INSERT INTO HISTORY VALUES(SEQ_HISTORY.NEXTVAL,?,?,SYSDATE,?,SYSDATE,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, history.getOrganNo());
			pstmt.setInt(2, history.getOrganQuantity());
			pstmt.setInt(3, history.getPayment());
			pstmt.setInt(4, history.getUsedPoint());
			pstmt.setString(5, history.getUserId());
			pstmt.setInt(6, history.getHospitalNo());
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
