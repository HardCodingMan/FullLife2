package mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import common.JDBCTemplate;
import mypage.model.vo.History;

public class MypageDAO {
   

   public List<History> selectAllList(Connection conn, int historyPage) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      List<History>hList = null;
      String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY HISTORY_NO DESC)AS NUM, HISTORY_NO, ORGAN_NO, ORGAN_QUANTITY, HISTORY_DATE, PAYMENT, PAYMENT_DATE, USED_POINT, USER_ID, HOSPITAL_NO FROM HISTORY) WHERE NUM BETWEEN ? AND ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         int viewCountPerPage =10;
         int start = historyPage*viewCountPerPage -(viewCountPerPage-1);
         int end = historyPage*viewCountPerPage;
         pstmt.setInt(1, start);
         pstmt.setInt(2, end);
         rset = pstmt.executeQuery();
         hList = new ArrayList<History>();
         while(rset.next()) {
            History his = new History();
            his.setHistoryNo(rset.getInt("HISTORY_NO"));
            his.setOrganNo(rset.getInt("ORGAN_NO"));
            his.setOrganQuantity(rset.getInt("ORGAN_QUANTITY"));
            his.setHistoryDate(rset.getDate("HISTORY_DATE"));
            his.setPayment(rset.getInt("PAYMENT"));
            his.setPaymentDate(rset.getDate("PAYMENT_DATE"));
            his.setUsedPoint(rset.getInt("USED_POINT"));
            his.setUserId(rset.getString("USER_ID"));
            his.setHospitalNo(rset.getInt("HOSPITAL_NO"));
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

}
