package apply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import apply.model.service.ApplyNoticeService;

/**
 * Servlet implementation class ApplyLikeServlet
 */
@WebServlet("/Notice/Apply/ApplyLike")
public class ApplyLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId"); 
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		int result = new ApplyNoticeService().insertLike(userId, noticeNo);
		if(result > 0) {
			response.sendRedirect("/Notice/Apply/ApplyContents?noticeNo="+noticeNo);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/Notice/ApplyError.jsp").forward(request, response);
		}
	}

}
