package mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import common.JDBCTemplate;
import member.model.vo.Member;
import mypage.model.vo.BookedHospitalInfo;
import mypage.model.vo.CheckResult;
import mypage.model.vo.History;
public class MypageDAO {
   

   public List<History> selectAllList(Connection conn, int historyPage, String userId) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      List<History>hList = null;
      String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY HISTORY_NO DESC)AS NUM, HISTORY_NO, ORGAN_NAME, ORGAN_QUANTITY, HISTORY_DATE, PAYMENT, PAYMENT_DATE, USED_POINT, USER_ID, HOSPITAL_NAME FROM HOSPITAL LEFT JOIN HISTORY ON HISTORY.HOSPITAL_NO=HOSPITAL.HOSPITAL_NO RIGHT JOIN ORGAN ON HISTORY.ORGAN_NO=ORGAN.ORGAN_NO WHERE USER_ID = ?)WHERE NUM BETWEEN ? AND ?";
      
      try {
         pstmt = conn.prepareStatement(query);
//         pstmt.setString(1, history.getUserId());
         int viewCountPerPage =10;
         int start = historyPage*viewCountPerPage -(viewCountPerPage-1);
         int end = historyPage*viewCountPerPage;
         pstmt.setString(1, userId);
         pstmt.setInt(2, start);
         pstmt.setInt(3, end);
         rset = pstmt.executeQuery();
         hList = new ArrayList<History>();
         while(rset.next()) {
            History his = new History();
            his.setHistoryNo(rset.getInt("HISTORY_NO"));
            his.setOrganName(rset.getString("ORGAN_NAME"));
            his.setOrganQuantity(rset.getInt("ORGAN_QUANTITY"));
            his.setHistoryDate(rset.getDate("HISTORY_DATE"));
            his.setPayment(rset.getInt("PAYMENT"));
            his.setPaymentDate(rset.getDate("PAYMENT_DATE"));
            his.setUsedPoint(rset.getInt("USED_POINT"));
            his.setUserId(rset.getString("USER_ID"));
            his.setHospitalName(rset.getString("HOSPITAL_NAME"));
            hList.add(his);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         JDBCTemplate.close(rset);
         JDBCTemplate.close(pstmt);
      }
      return hList;
      
   }
   

   
   
   public String getPageNavi(Connection conn, int historyPage) {
      int pageCountPerView = 5;
      int viewTotalCount = totalCount(conn);
      int viewCountPerPage = 10;
      int pageTotalCount = 0;
      int pageTotalCountMod = viewTotalCount % viewCountPerPage;
      if(pageTotalCountMod > 0) {
         pageTotalCount = viewTotalCount / viewCountPerPage +1;
      }else {
         pageTotalCount = viewTotalCount / viewCountPerPage;
      }
      
      int startNavi = ((historyPage -1)/pageCountPerView)* pageCountPerView +1;
      int endNavi = startNavi + pageCountPerView -1;
      boolean needPrev = true;
      boolean needNext = true;
      if(startNavi ==1) {
         needPrev = false;
      }
      if(endNavi == pageTotalCount) {
         needNext = false;
      }
      if(endNavi > pageTotalCount) {
         endNavi = pageTotalCount;
      }
      
      StringBuilder sb = new StringBuilder();
      if(needPrev) {
         sb.append("<a href='/mypage/mypageHistory?historyPage="+(startNavi-1)+"'> [이전] </a>");
      }
      for(int i = startNavi; i<=endNavi; i++) {
         if(i==historyPage) {
            sb.append(i);
         }else {
            sb.append("<a href='/mypage/mypageHistory?historyPage="+i+"'>"+i+"</a>");
         }
      }
      if(needNext) {
         sb.append("<a href='/mypage/mypageHistory?historyPage="+(endNavi+1)+"'> [다음] </a>");
      }


      return sb.toString();
   }

   private int totalCount(Connection conn) {
      int totalValue = 0;
      Statement stmt = null;
      ResultSet rset = null;
      String query = "SELECT COUNT(*) AS TOTALCOUNT FROM HISTORY";
      
      try {
         stmt = conn.createStatement();
         rset = stmt.executeQuery(query);
         if(rset.next()) {
            totalValue = rset.getInt("TOTALCOUNT");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         JDBCTemplate.close(rset);
         JDBCTemplate.close(stmt);
      }
      
      return totalValue; 
   }
   


    	public BookedHospitalInfo getHospitalTime(Connection conn, String userId) {
    		BookedHospitalInfo info = null;
    		String query = "SELECT HOSPITAL_NAME, HOSPITAL_ADDR, CHECK_DATE, HOSPITAL_TIME, ORGAN_NAME FROM PATIENT JOIN ORGAN USING(ORGAN_NO) JOIN HOSPITAL USING(HOSPITAL_NO) JOIN RESULT USING(USER_ID) WHERE USER_ID = ?";
    		ResultSet rset = null;
    		PreparedStatement pstmt = null;
    		
    		try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					info = new BookedHospitalInfo();
					info.setHospitalName(rset.getString("HOSPITAL_NAME"));
					info.setHospitalAddr(rset.getString("HOSPITAL_ADDR"));
					info.setCheckDate(rset.getString("CHECK_DATE"));
					info.setHospitalTime(rset.getDate("HOSPITAL_TIME"));
					info.setOrgan(rset.getString("ORGAN_NAME"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
    		
    		return info;
    	}

		public int deleteHospitalInfo(String userId, Connection conn) {
			int result = 0;
			PreparedStatement pstmt = null;
			String query = "DELETE FROM BOOKED_HOSPITAL_INFO WHERE USER_ID = ?";
			
			try {
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}


		public int modifyMemberInfo(Member member, Connection conn) {
			int result = 0;
			PreparedStatement pstmt = null;
			String query = "UPDATE MEMBER SET EMAIL = ?, PHONE = ?, USER_PWD = ?, ADDRESS = ? WHERE USER_ID = ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, member.getUserEmail());
				pstmt.setString(2, member.getUserPhone());
				pstmt.setString(3, member.getUserPwd());
				pstmt.setString(4, member.getUserAddr());
				pstmt.setString(5, member.getUserId());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}

	   public List<CheckResult> selectCheckResult(Connection conn,  int checkResultPage, String userId) {
		      PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      List<CheckResult>cList = null;
		      String query="SELECT *FROM(SELECT ROW_NUMBER() OVER(ORDER BY FILE_NO DESC)AS NUM, FILE_NO, FILE_SIZE,FILE_NAME,FILE_PATH, HOSPITAL_NAME, CHECK_DATE FROM RESULT LEFT JOIN HOSPITAL ON HOSPITAL.HOSPITAL_NO=RESULT.HOSPITAL_NO WHERE USER_ID=?) WHERE NUM BETWEEN ? AND ?";
		      
		      try {
				 pstmt = conn.prepareStatement(query);
				 int viewCountPerPage =10;
		         int start = checkResultPage*viewCountPerPage -(viewCountPerPage-1);
		         int end = checkResultPage*viewCountPerPage;
		         pstmt.setString(1, userId);
		         pstmt.setInt(2, start);
		         pstmt.setInt(3, end);
		         rset = pstmt.executeQuery();
		         cList= new ArrayList<CheckResult>();
		         while(rset.next()) {
		        	 CheckResult result = new CheckResult();
		        	 result.setFileNo(rset.getInt("FILE_NO"));
		        	 result.setFileSize(rset.getLong("FILE_SIZE"));
		        	 result.setFileName(rset.getString("FILE_NAME"));
		        	 result.setFilePath(rset.getString("FILE_PATH"));
		        	 result.setHospitalName(rset.getString("HOSPITAL_NAME"));
		        	 result.setCheckDate(rset.getDate("CHECK_DATE"));
		             cList.add(result);
		          }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
		         JDBCTemplate.close(rset);
		         JDBCTemplate.close(pstmt);
		      }
		      return cList;
	}
		public String getresPageNavi(Connection conn, int checkResultPage) {
			int pageCountPerView = 5;
			int viewTotalCount = totalCount(conn);
			int viewCountPerPage = 10;
			int pageTotalCount = 0;
			int pageTotalCountMod = viewTotalCount % viewCountPerPage;
			if(pageTotalCountMod > 0) {
				pageTotalCount = viewTotalCount / viewCountPerPage +1;
			}else {
				pageTotalCount = viewTotalCount / viewCountPerPage;
			}
			
			int startNavi = ((checkResultPage -1)/pageCountPerView)* pageCountPerView +1;
			int endNavi = startNavi + pageCountPerView -1;
			boolean needPrev = true;
			boolean needNext = true;
			if(startNavi ==1) {
				needPrev = false;
			}
			if(endNavi == pageTotalCount) {
				needNext = false;
			}
			if(endNavi > pageTotalCount) {
				endNavi = pageTotalCount;
			}

	      StringBuilder sb = new StringBuilder();
	      if(needPrev) {
	         sb.append("<a href='/mypage/mypageCheckResult?checkResultPage="+(startNavi-1)+"'> [이전] </a>");
	      }
	      for(int i = startNavi; i<=endNavi; i++) {
	         if(i==checkResultPage) {
	            sb.append(i);
	         }else {
	            sb.append("<a href='/mypage/mypageCheckResult?checkResultPage="+i+"'>"+i+"</a>");
	         }
	      }
	      if(needNext) {
	         sb.append("<a href='/mypage/mypageCheckResult?checkResultPage="+(endNavi+1)+"'> [다음] </a>");
	      }


	      return sb.toString();
	   }
	

	   private int resultCount(Connection conn) {
	      int totalValue = 0;
	      Statement stmt = null;
	      ResultSet rset = null;
	      String query = "SELECT COUNT(*) AS TOTALCOUNT FROM RESULT";
	      
	      try {
	         stmt = conn.createStatement();
	         rset = stmt.executeQuery(query);
	         if(rset.next()) {
	            totalValue = rset.getInt("TOTALCOUNT");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(stmt);
	      }
	      
	      return totalValue; 
	   }



	}
