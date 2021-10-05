package manager.login.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import manager.login.model.dao.M_LoginDAO;
import manager.login.model.vo.M_Login_Admin;

public class M_LoginService {
private JDBCTemplate jdbcTemplate;
	
	public M_LoginService(){
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public M_Login_Admin getAdminByIdAndPw(String adminId, String adminPwd) {
		M_Login_Admin admin = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			admin = new M_LoginDAO().selectOneAdmin(adminId, adminPwd, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return admin;
	}

}
