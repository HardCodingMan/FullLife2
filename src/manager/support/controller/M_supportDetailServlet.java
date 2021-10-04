package manager.support.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.support.model.service.M_supService;
import manager.support.model.vo.M_support;

/**
 * Servlet implementation class SupportReplyServlet
 */
@WebServlet("/manager/m_support_detail")
public class M_supportDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_supportDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int notiNo = Integer.parseInt(request.getParameter("noticeNo"));
		M_support sup = new M_supService().printOneBySup(notiNo);
		
		if(sup != null) {
			request.setAttribute("hList", sup);
			request.getRequestDispatcher("/WEB-INF/manager/manager_support/m_support_detail.jsp").forward(request, response);
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
