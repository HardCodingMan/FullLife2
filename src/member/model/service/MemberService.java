package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	
	private JDBCTemplate jdbcTemplate;
	
	public MemberService(){
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public Member getMemberByIdAndPw(String userId, String userPw) {
		Member member = null;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			member = new MemberDAO().selectOneMember(userId, userPw, conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return member;
	}

	public String getOneMemberByZumin(String userName, String zumin) {
		String userId = "";
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			userId = new MemberDAO().selectOneMemberByZumin(zumin, userName, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return userId;
	}

	public String getOneMemberForPw(String userName, String userId) {
		Connection conn = null;
		String userPwd = "";
		try {
			conn = jdbcTemplate.createConnection();
			userPwd = new MemberDAO().selectOneMemberByNameAndId(userName, userId, conn); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return userPwd;
	}

	public int registerMember(Member member) {
		int result = 0;
		Connection conn =null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new MemberDAO().insertMember(conn,member);
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

	public Member getMemberTotalPoint(String userId) {
		Member member = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			member = new MemberDAO().updateTotalPoint(conn, userId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return member;
	}

	public Member updateMemberInfo(String userId) {
		Member member = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			member = new MemberDAO().updateOneMember(userId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return member;
	}
	

}
