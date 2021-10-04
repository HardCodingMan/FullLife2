package manager.ask.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ask.model.service.M_askService;
import manager.ask.model.vo.M_ask;
import manager.ask.model.vo.M_askPage;

/**
 * Servlet implementation class M_askSearchServlet
 */
@WebServlet("/manager/m_ask_search")
public class M_askSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_askSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchId = request.getParameter("searchId");
		int currentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		
		if(currentPageVal != null) {
			currentPage = Integer.parseInt(currentPageVal);
		}
		
		M_askPage pd = new M_askService().printSearchAsk(searchId, currentPage);
		List<M_ask> aList = pd.getaPdList();
		if(!aList.isEmpty()) {
			request.setAttribute("aList", aList);
			request.setAttribute("pageNavi", pd.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/manager/manager_ask/m_ask_search.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/manager/manager_fail/m_search_fail.jsp").forward(request, response);
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
