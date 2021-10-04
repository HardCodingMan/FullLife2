package manager.ask.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ask.model.service.M_askService;
import manager.ask.model.vo.M_ask;
import manager.ask.model.vo.M_askPage;

/**
 * Servlet implementation class AskListServlet
 */
@WebServlet("/manager/m_ask_list")
public class M_askListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_askListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		String getCurrentPage = request.getParameter("currentPage");
		if(getCurrentPage == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(getCurrentPage);
		}
		M_askPage pageData = new M_askService().printAllAsk(currentPage);
		List<M_ask> aList = pageData.getaPdList();
		if(!aList.isEmpty()) {
			request.setAttribute("aList", aList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/manager/manager_ask/m_ask_list.jsp").forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/manager_fail/m_search_fail.jsp");
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
