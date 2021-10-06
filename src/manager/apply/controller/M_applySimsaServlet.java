package manager.apply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.apply.model.service.M_applyService;

/**
 * Servlet implementation class M_applySimsaServlet
 */
@WebServlet("/manager/m_apply_simsa")
public class M_applySimsaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_applySimsaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int notiNo = Integer.parseInt(request.getParameter("notiNo"));
		int result = new M_applyService().updateSimsa(notiNo);
		if(result > 0) {
			response.sendRedirect("/manager/m_apply_list");
		}else {
			request.getRequestDispatcher("/WEB-INF/manager/manager_apply/m_apply_list.jsp").forward(request, response);
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
