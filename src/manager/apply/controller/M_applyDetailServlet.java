package manager.apply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.apply.model.service.M_applyService;
import manager.apply.model.vo.M_apply;

/**
 * Servlet implementation class M_applyDetailServlet
 */
@WebServlet("/manager/m_apply_detail")
public class M_applyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_applyDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int notiNo = Integer.parseInt(request.getParameter("noticeNo"));
		M_apply apply = new M_applyService().printOneByApply(notiNo);
		
		if(apply != null) {
			request.setAttribute("apList", apply);
			request.getRequestDispatcher("/WEB-INF/manager/manager_apply/m_apply_detail.jsp").forward(request, response);
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
