package manager.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import manager.member.model.dao.M_memberDAO;
import manager.member.moder.vo.M_PageData;
import manager.member.moder.vo.M_member;

public class M_memberService {

	private JDBCTemplate jdbcTemplate;
	public M_memberService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public M_PageData printSearchMember(String searchId, int currentPage) {
		Connection conn = null;
		List<M_member> mList = null;
		String searchPageNavi = null;
		M_PageData pd = new M_PageData();
		M_memberDAO mDao = new M_memberDAO();
		
		try {
			conn=jdbcTemplate.createConnection();
			mList = mDao.getSearchMember(conn, searchId, currentPage);
			searchPageNavi = mDao.getSearchPageNavi(conn, searchId, currentPage);
			pd.setMemList(mList);
			pd.setPageNavi(searchPageNavi);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
	}

	public M_PageData printAllMember(int currentPage) {
		M_PageData pd = new M_PageData();
		Connection conn = null;
		M_memberDAO mDao = new M_memberDAO();
		
		try {
			conn=jdbcTemplate.createConnection();
			pd.setMemList(mDao.selectAllMember(conn, currentPage));
			pd.setPageNavi(mDao.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
	}

	public int modifyMember(M_member member) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new M_memberDAO().updateMember(conn, member);
			
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

	public M_member printOneByMem(int mNo) {
		M_member mOne = null;
		Connection conn = null;
		
		try {
			conn=jdbcTemplate.createConnection();
			mOne = M_memberDAO.selectOneByMem(conn, mNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return mOne;
	}

	public int deleteMember(String mId) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn=jdbcTemplate.createConnection();
			result = new M_memberDAO().deleteUser(conn, mId);
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

	
	
	
	
	
	
	
	
	
	
}
