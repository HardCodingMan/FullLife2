package manager.result.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.member.moder.vo.M_PageData;
import manager.result.model.service.M_resultService;
import manager.result.model.vo.M_FilePage;
import manager.result.model.vo.M_result;

/**
 * Servlet implementation class ResultListServlet
 */
@WebServlet("/manager/m_result_list")
public class M_resultListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_resultListServlet() {
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
		M_FilePage fPd = new M_resultService().printAllResult(currentPage);
		List<M_result> fList = fPd.getfPdList();
		if(!fList.isEmpty()) {
			request.setAttribute("fList", fList);
			request.setAttribute("pageNavi", fPd.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/manager/manager_result/m_result_list.jsp").forward(request, response);
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
