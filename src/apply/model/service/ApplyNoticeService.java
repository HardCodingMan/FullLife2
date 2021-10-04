package apply.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.tagext.PageData;

import apply.model.dao.ApplyNoticeDAO;
import apply.model.vo.Notice;
import apply.model.vo.NoticeLike;
import apply.model.vo.ApplyNoticeFile;
import apply.model.vo.ApplyNoticeReply;
import apply.model.vo.ApplyPage;
import common.JDBCTemplate;

public class ApplyNoticeService {

	private JDBCTemplate jdbcTemplate;
	
	public ApplyNoticeService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	
	public int noticeWrite(Notice notice) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ApplyNoticeDAO().insertNotice(conn, notice);
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

	public ApplyPage printAllApply(int currentPage) {
		ApplyPage ap = new ApplyPage();
		Connection conn = null;
		ApplyNoticeDAO applyDAO = new ApplyNoticeDAO();
		
		try {
			conn = jdbcTemplate.createConnection();
			ap.setaList(applyDAO.pageAllNotice(conn, currentPage));
			ap.setPageNavi(applyDAO.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return applyNotice;
	}
	
	public NoticeLike updateLike(int noticeNo) {
		Connection conn = null;
		NoticeLike nLike = null;
		ApplyNoticeDAO applyDAO = new ApplyNoticeDAO();
		try {
			conn = jdbcTemplate.createConnection();
			nLike = applyDAO.updateLike(conn, noticeNo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = jdbcTemplate.createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nLike;
	}

	public int registerApplyReply(String replyContents, int noticeNo, String userId) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result =  new ApplyNoticeDAO().insertNoticeReply(conn, replyContents, noticeNo, userId);
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

	public int removeNotice(int noticeNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ApplyNoticeDAO().deleteApply(conn, noticeNo);
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return notice;
	}

	public int registerSupportReply(String replyContents, int noticeNo, String userId) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result =  new ApplyNoticeDAO().insertSupportNoticeReply(conn, replyContents, noticeNo, userId);
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



}
