package manager.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.order.model.service.M_orderService;
import manager.order.model.vo.M_order;
import manager.order.model.vo.M_orderPage;

/**
 * Servlet implementation class M_orderSearchServlet
 */
@WebServlet("/manager/m_order_search")
public class M_orderSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_orderSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int searchNo = Integer.parseInt(request.getParameter("searchNo"));
		int currentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		
		if(currentPageVal != null) {
			currentPage = Integer.parseInt(currentPageVal);
		}
		
		M_orderPage pd = new M_orderService().printSearchOrder(searchNo, currentPage);
		List<M_order> oList = pd.getOpList();
		if(!oList.isEmpty()) {
			request.setAttribute("oList", oList);
			request.setAttribute("pageNavi", pd.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/manager/manager_order/m_order_search.jsp").forward(request, response);
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
