package manager.login.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import manager.login.model.vo.M_Login_Admin;

public class M_LoginDAO {

	public M_Login_Admin selectOneAdmin(String adminId, String adminPwd, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		M_Login_Admin admin = null;
		String query = "SELECT * FROM ADMIN WHERE ADMIN_ID = ? AND ADMIN_PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPwd);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				admin = new M_Login_Admin();
				admin.setAdminId(rset.getString("ADMIN_ID"));
				admin.setAdminPwd(rset.getString("ADMIN_PWD"));
				admin.setAdminNo(rset.getInt("ADMIN_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return admin;
	}
}
	


