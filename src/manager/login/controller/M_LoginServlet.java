package manager.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.login.model.service.M_LoginService;
import manager.login.model.vo.M_Login_Admin;

/**
 * Servlet implementation class M_LoginServlet
 */
@WebServlet("/manager/login")
public class M_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/manager/manager_m_login/m_login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId = request.getParameter("admin-id");
		String adminPwd = request.getParameter("admin-pwd");
		M_Login_Admin admin = new M_LoginService().getAdminByIdAndPw(adminId, adminPwd);
		if(admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("adminId", admin.getAdminId());
			response.sendRedirect("/manager/m_member_list");
		} else {
			request.getRequestDispatcher("/WEB-INF/manager/manager_m_login/m_login.jsp").forward(request, response);
		}	
	}

}
