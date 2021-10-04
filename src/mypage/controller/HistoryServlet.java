package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;
import mypage.model.service.MypageService;
import mypage.model.vo.History;
import mypage.model.vo.HistoryPage;

/**
 * Servlet implementation class MypageHistory
 */
@WebServlet("/mypage/history")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int historyPage = 0;
		String getHistoryPage = request.getParameter("historyPage");
		if(getHistoryPage == null) {
			historyPage = 1; 
		}else {
			historyPage = Integer.parseInt(getHistoryPage);
		}
		HistoryPage hisPage = new MypageService().printAllList(historyPage);
		List<History> hList = hisPage.gethList();
		if(!hList.isEmpty()) {
			request.setAttribute("hList", hList);
			request.setAttribute("pageNavi", hisPage.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/mypage/mypageHistory.jsp").forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/mypageHistory.jsp");
			view.forward(request, response);
	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
