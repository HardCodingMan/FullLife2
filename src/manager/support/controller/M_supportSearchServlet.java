package manager.support.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.support.model.service.M_supService;
import manager.support.model.vo.M_supPage;
import manager.support.model.vo.M_support;

/**
 * Servlet implementation class M_supportSearchServlet
 */
@WebServlet("/manager/m_support_search")
public class M_supportSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_supportSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("searchKeyword");
		System.out.println(keyword);
		int currentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		
		if(currentPageVal != null) {
			currentPage = Integer.parseInt(currentPageVal);
		}
		
		M_supPage pd = new M_supService().printSearchSup(keyword, currentPage);
		List<M_support> sList = pd.getsList();
		if(!sList.isEmpty()) {
			request.setAttribute("sList", sList);
			request.setAttribute("pageNavi", pd.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/manager/manager_support/m_support_search.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/manager/manager_support/m_support_list.jsp").forward(request, response);
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
