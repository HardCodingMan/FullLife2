package apply.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import apply.model.dao.ApplyNoticeDAO;
import apply.model.vo.Notice;
import apply.model.vo.NoticeLike;
import apply.model.vo.ApplyNoticeReply;
import apply.model.vo.ApplyPage;
import common.JDBCTemplate;
import member.model.vo.Member;

public class ApplyNoticeService {

	private JDBCTemplate jdbcTemplate;
	
	public ApplyNoticeService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	
	public int noticeWrite(Notice notice) {
		Connection conn = null;
		int insertNotice = 0;
		int insertPoint = 0;
		
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			insertNotice = new ApplyNoticeDAO().insertNotice(conn, notice);
			insertPoint = new ApplyNoticeDAO().insertPoint(conn, notice);
			if(insertNotice > 0 && insertPoint > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			result = (insertNotice + insertPoint);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public ApplyPage printAllApply(int currentPage) {
		ApplyPage ap = new ApplyPage();
		Connection conn = null;
		ApplyNoticeDAO applyDAO = new ApplyNoticeDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			ap.setaList(applyDAO.pageAllNotice(conn, currentPage));
			ap.setPageNavi(applyDAO.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return ap;
	}

	public Notice printOneByNo(int noticeNo) {
		Notice applyNotice = null;
		Connection conn = null;
		List<ApplyNoticeReply> aList = null;
		ApplyNoticeDAO applyDAO = new ApplyNoticeDAO();
		try {
			conn = jdbcTemplate.createConnection();
			applyNotice = applyDAO.selectOneByNo(conn, noticeNo);
			aList = applyDAO.selectAllNoticeReply(conn, noticeNo);
			applyNotice.setReplist(aList);
			if(applyNotice != null) {
				JDBCTemplate.commit(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return applyNotice;
	}
	
	public NoticeLike updateLike(int noticeNo, String userId) {
		Connection conn = null;
		NoticeLike nLike = null;
		ApplyNoticeDAO applyDAO = new ApplyNoticeDAO();
		try {
			conn = jdbcTemplate.createConnection();
			nLike = applyDAO.updateLike(conn, noticeNo, userId);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			conn = jdbcTemplate.createConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nLike;
	}

	public int registerApplyReply(String replyContents, int noticeNo, String userId) {
		Connection conn = null;
		int result = 0;
		int insertReply = 0;
		int insertPoint = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			insertReply =  new ApplyNoticeDAO().insertNoticeReply(conn, replyContents, noticeNo, userId);
			insertPoint = new ApplyNoticeDAO().insertReplyPoint(conn, userId);
			if(insertReply > 0 && insertPoint > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			result = (insertReply + insertPoint);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int removeNotice(int noticeNo, String userId) {
		int result = 0;
		int deleteReply = 0;
		int stealPoint = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			deleteReply = new ApplyNoticeDAO().deleteApply(conn, noticeNo);
			stealPoint = new ApplyNoticeDAO().stealPointNotice(conn, userId);
			if(deleteReply > 0 && stealPoint > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			result = (deleteReply + stealPoint);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int deleteLike(String userId, int noticeNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ApplyNoticeDAO().deleteLike(conn, userId, noticeNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int insertLike(String userId, int noticeNo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ApplyNoticeDAO().insertLike(conn, userId, noticeNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public ApplyPage printAllSupport(int currentPage) {
		ApplyPage ap = new ApplyPage();
		Connection conn = null;
		ApplyNoticeDAO applyDAO = new ApplyNoticeDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			ap.setaList(applyDAO.pageAllSupportNotice(conn, currentPage));
			ap.setPageNavi(applyDAO.getSupportPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return ap;
	}

	public Notice printOneBySupportNo(int noticeNo) {
		Notice notice = null;
		Connection conn = null;
		List<ApplyNoticeReply> aList = null;
		ApplyNoticeDAO applyDAO = new ApplyNoticeDAO();
		try {
			conn = jdbcTemplate.createConnection();
			notice = applyDAO.selectOneBySupportNo(conn, noticeNo);
			aList = applyDAO.selectAllSupportNoticeReply(conn, noticeNo);
			notice.setReplist(aList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return notice;
	}

	public int registerSupportReply(String replyContents, int noticeNo, String userId) {
		Connection conn = null;
		int result = 0;
		int insertPoint = 0;
		int insertReply = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			insertReply =  new ApplyNoticeDAO().insertSupportNoticeReply(conn, replyContents, noticeNo, userId);
			insertPoint = new ApplyNoticeDAO().insertReplyPoint(conn, userId);
			if(insertPoint > 0 && insertReply > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			result = (insertPoint + insertReply);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int removeNoitceReplyOne(int replyNo, String userId) {
		Connection conn = null;
		int result = 0;
		int deleteReply = 0;
		int stealPoint = 0;
		try {
			conn = jdbcTemplate.createConnection();
			deleteReply = new ApplyNoticeDAO().deleteNoticeReplyOne(conn, replyNo);
			stealPoint = new ApplyNoticeDAO().stealPoint(conn, userId);
			if(deleteReply > 0 && stealPoint > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			result = (deleteReply + stealPoint);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int modifyReplyOne(int replyNo, String replyContents) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ApplyNoticeDAO().updateReplyOne(conn, replyNo, replyContents);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int removeSupportReplyOne(int replyNo, String userId) {
		Connection conn = null;
		int result = 0;
		int stealReply = 0;
		int stealPoint = 0;
		try {
			conn = jdbcTemplate.createConnection();
			stealReply = new ApplyNoticeDAO().deleteSupportReplyOne(conn, replyNo);
			stealPoint = new ApplyNoticeDAO().stealPoint(conn, userId);
			if(stealReply > 0 && stealPoint > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			result = (stealReply + stealPoint);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int modifySupportReplyOne(int replyNo, String replyContents) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ApplyNoticeDAO().updateSupportReplyOne(conn, replyNo, replyContents);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public ApplyPage printSearchNotice(String searchKeyword, int currentPage) {
		Connection conn = null;
		List<Notice> nList = null;
		String searchPageNavi = null;
		ApplyPage ap = new ApplyPage();
		ApplyNoticeDAO nDAO = new ApplyNoticeDAO();
		try {
			conn = jdbcTemplate.createConnection();
			nList = new ApplyNoticeDAO().selectSearchNotice(conn, searchKeyword, currentPage);
			searchPageNavi = nDAO.getSearchPageNaiv(conn, searchKeyword, currentPage);
			ap.setaList(nList);
			ap.setPageNavi(searchPageNavi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return ap;
	}

	public ApplyPage printSearchSupport(String searchKeyword, int currentPage) {
		Connection conn = null;
		List<Notice> nList = null;
		String searchPageNavi = null;
		ApplyPage ap = new ApplyPage();
		ApplyNoticeDAO nDAO = new ApplyNoticeDAO();
		try {
			conn = jdbcTemplate.createConnection();
			nList = new ApplyNoticeDAO().selectSearchSupport(conn, searchKeyword, currentPage);
			searchPageNavi = nDAO.getSearchPageNaiv(conn, searchKeyword, currentPage);
			ap.setaList(nList);
			ap.setPageNavi(searchPageNavi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return ap;
	}

	public int updatePoint(String userId, int noticeNo, int point) {
		Connection conn = null;
		int userPoint = 0;
		int nowSupport = 0;
		int supportHuman = 0;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			userPoint = new ApplyNoticeDAO().updateUserPoint(conn, userId, point);
			nowSupport = new ApplyNoticeDAO().updateNowSupport(conn,noticeNo, point);
			supportHuman = new ApplyNoticeDAO().updateSupportHuman(conn, noticeNo);
			boolean check1 = false;
			boolean check2 = false;
			boolean check3 = false;
			if(userPoint > 0 ) {
				check1 = true;
			}
			if(nowSupport > 0) {
				check2 = true;
			}
			if(nowSupport > 0) {
				check3 = true;
			}
			if(check1 == true && check2 == true && check3 == true) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
				System.out.println("펄스");
			}
			result = (userPoint+nowSupport+supportHuman);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public Member getPoint(String userId) {
		Connection conn = null;
		Member member = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			member = new ApplyNoticeDAO().getPoint(conn, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}



}
