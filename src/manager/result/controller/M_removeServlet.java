package manager.result.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.result.model.service.M_resultService;

/**
 * Servlet implementation class M_removeServlet
 */
@WebServlet("/manager/m_file_remove")
public class M_removeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_removeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fileUser = request.getParameter("file-user");
		String fileName = request.getParameter("file-name");
		String filePath = request.getParameter("file-path");
		int result = new M_resultService().removeFile(fileUser, fileName);
		File removeFile = new File(filePath); 
		if(result > 0) {
			removeFile.delete();
			response.sendRedirect("/manager/m_result_list");
		}else {
			request.getRequestDispatcher("/WEB-INF/manager/manager_result/m_result_list.jsp").forward(request, response);
		}
	}

}
