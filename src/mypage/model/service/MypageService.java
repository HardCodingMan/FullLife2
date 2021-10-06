package mypage.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.vo.Member;
import mypage.model.dao.MypageDAO;
import mypage.model.vo.BookedHospitalInfo;
import mypage.model.vo.CheckResultPage;
import mypage.model.vo.History;
import mypage.model.vo.HistoryPage;

public class MypageService {
	private JDBCTemplate jdbcTemplate;
	
	public MypageService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	


	public HistoryPage printAllList(int historyPage, String userId) {
		HistoryPage hisPage = new HistoryPage();
		Connection conn = null;
		MypageDAO hDao = new MypageDAO();
		
		try {
			conn=jdbcTemplate.createConnection();
			hisPage.sethList(hDao.selectAllList(conn, historyPage, userId));
			hisPage.setPageNavi(hDao.getPageNavi(conn, historyPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return hisPage;
	}
	
	public CheckResultPage printCheckResult(int checkResultPage) {
		CheckResultPage result = new CheckResultPage();
		Connection conn = null;
		MypageDAO cDao = new MypageDAO();
		
		try {
			conn=jdbcTemplate.createConnection();
			result.setcList(cDao.selectCheckResult(conn, checkResultPage));
			result.setPageNavi(cDao.getPageNavi(conn, checkResultPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}




	public BookedHospitalInfo getBookedHospitalInfo(String userId) {
		BookedHospitalInfo info = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			info = new MypageDAO().getHospitalTime(conn, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return info;
	}



	public int deleteHospitalInfo(String userId) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new MypageDAO().deleteHospitalInfo(userId, conn);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
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

	public int modifyMemberInfo(Member member) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new MypageDAO().modifyMemberInfo(member, conn);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
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


	
}