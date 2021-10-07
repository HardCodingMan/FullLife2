package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDAO {

	public Member selectOneMember(String userId, String userPw, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";
		Member member = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserNo(rset.getInt("USER_NO"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setTotalPoint(rset.getInt("TOTALPOINT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return member;
	}

	public String selectOneMemberByZumin(String zumin, String userName, Connection conn) {
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM MEMBER WHERE ZUMIN = ? AND USER_NAME = ?";
		ResultSet rset = null;
		String userId = "";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, zumin);
			pstmt.setString(2, userName);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				userId = rset.getString("USER_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return userId;
	}

	public String selectOneMemberByNameAndId(String userName, String userId, Connection conn) {
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM MEMBER WHERE USER_NAME = ? AND USER_ID = ?";
		ResultSet rset = null;
		String userPwd = "";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, userId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				userPwd = rset.getString("USER_PWD");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return userPwd;
	}

	public int insertMember(Connection conn, Member member) {
			PreparedStatement pstmt = null;
			int result = 0;
			String query= "INSERT INTO MEMBER VALUES (?,SEQ_MEMBER.NEXTVAL,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT,?)";
//			INSERT INTO MEMBER VALUES (?,SEQ_MEMBER.NEXTVAL,?,?,?,?,?,DEFAULT,DEFAULT,')
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, member.getUserId());
				pstmt.setString(2, member.getUserPwd());
				pstmt.setString(3, member.getUserName());
				pstmt.setString(4, member.getUserZumin());
				pstmt.setString(5, member.getUserAddr());
				pstmt.setString(6, member.getUserPhone());
				pstmt.setString(7, member.getUserEmail());
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}

	public boolean duplicateIdCheck(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean x = false;
		
		StringBuffer query = new StringBuffer();
		query.append("SELECT USER_ID FROM MEMBER WHERE USER_ID = ?");
		
		return false;
	}

	public Member updateMemberPage(String userId, Connection conn) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Member member = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserZumin(rset.getString("ZUMIN"));
				member.setUserName(rset.getString("USER_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}

	public Member getTotalpoint(String userId, Connection conn) {
		Member member = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setTotalPoint(rset.getInt("TOTALPOINT"));
				member.setUserName(rset.getString("USER_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return member;
	}

	public int checkMyId(String userId, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = 1;
			} else {
				result = 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteMember(String userId, Connection conn) {
		int result = 0;
		String query = "DELETE FROM MEMBER WHERE USER_ID = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int modifyMember(String userId, Member member, Connection conn) {
		int result = 0;
		String query = "UPDATE MEMBER SET USER_PWD = ?, PHONE = ?, EMAIL = ? WHERE USER_ID = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserPwd());
			pstmt.setString(2, member.getUserPhone());
			pstmt.setString(3, member.getUserEmail());
			pstmt.setString(4, userId);
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