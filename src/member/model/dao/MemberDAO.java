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

	public String selectOneMemberByEmail(String email, String userName, Connection conn) {
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM MEMBER WHERE EMAIL = ? AND USER_NAME = ?";
		ResultSet rset = null;
		String userId = "";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
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
			String query= "";
//			INSERT INTO MEMBER VALUES (?,SEQ_MEMBER.NEXTVAL,?,?,?,?,?,DEFAULT,DEFAULT,'0')
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, member.getUserId());
				pstmt.setString(2, member.getUserPwd());
				pstmt.setString(3, member.getUserName());
				pstmt.setString(4, member.getUserZumin());
				pstmt.setString(5, member.getUserAddr());
				pstmt.setString(6, member.getUserPhone());
				result=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}

	public Member updateTotalPoint(Connection conn, String userId) {
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

	public Member updateOneMember(String userId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setUserName(rset.getString("USER_NAME"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserZumin(rset.getString("ZUMIN"));
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
	}

