package manager.result.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.result.model.service.M_resultService;
import manager.result.model.vo.M_FilePage;
import manager.result.model.vo.M_patient;

/**
 * Servlet implementation class M_resultSearchServlet
 */
@WebServlet("/manager/m_result_search")
public class M_resultSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_resultSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int keyword = Integer.parseInt(request.getParameter("searchKeyword"));
		int currentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		
		if(currentPageVal != null) {
			currentPage = Integer.parseInt("currentPage");
		}
		M_FilePage pd = new M_resultService().printSearchResult(keyword, currentPage);
		List<M_patient> pList = pd.getfPdList();
		if(!pList.isEmpty()) {
			request.setAttribute("pList", pList);
			request.setAttribute("pageNavi", pd.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/manager/manager_result/m_result_search.jsp").forward(request, response);
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
