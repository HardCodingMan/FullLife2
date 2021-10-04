package ask.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ask.model.service.AskService;
import ask.model.vo.Ask;
import ask.model.vo.PageData;
import manager.ask.model.service.M_askService;
import manager.ask.model.vo.M_ask;
import manager.ask.model.vo.M_askPage;

/**
 * Servlet implementation class AskSearchServlet
 */
@WebServlet("/ask/search")
public class AskSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchKeyword = request.getParameter("searchKeyword"); // 이거 id로 할지 제목+내용, 제목 할지 정해야함
		int currentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		if(currentPageVal != null) {
			currentPage = Integer.parseInt(currentPageVal);
		}
		
		PageData pageData = new AskService().printSearchAsk(searchKeyword, currentPage);
		List<Ask> aList = pageData.getAskList();
		if(!aList.isEmpty()) {
			request.setAttribute("aList", aList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/ask/askSearch.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/reserve/organTrans.jsp").forward(request, response);
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
