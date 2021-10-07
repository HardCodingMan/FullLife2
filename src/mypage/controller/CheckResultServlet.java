package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypage.model.service.MypageService;
import mypage.model.vo.CheckResult;
import mypage.model.vo.CheckResultPage;

/**
 * Servlet implementation class MypageCheckResult
 */
@WebServlet("/mypage/checkResult")
public class CheckResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int checkResultPage = 0;
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId"); 
		String getCheckResultPage = request.getParameter("checkResultPage");
		if(getCheckResultPage == null) {
			checkResultPage = 1; 
		}else {
			checkResultPage = Integer.parseInt(getCheckResultPage);
		}
		CheckResultPage result = new MypageService().printCheckResult(checkResultPage,userId);
		List<CheckResult> cList = result.getcList();
		if(!cList.isEmpty()) {
			request.setAttribute("cList", cList);
			request.setAttribute("pageNavi", result.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/mypage/mypageCheckResult.jsp").forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/mypageCheckResult.jsp");
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