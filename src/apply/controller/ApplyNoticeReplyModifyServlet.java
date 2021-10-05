package apply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apply.model.service.ApplyNoticeService;

/**
 * Servlet implementation class ApplyNoticeReplyModifyServlet
 */
@WebServlet("/Notice/Apply/ApplyReplyModify")
public class ApplyNoticeReplyModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyNoticeReplyModifyServlet() {
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
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String replyContents = request.getParameter("replyContents");
		int result = new ApplyNoticeService().modifyReplyOne(replyNo, replyContents);
		if(result > 0) {
			response.sendRedirect("/Notice/Apply/ApplyContents?noticeNo="+noticeNo);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/notice/noticeError.html").forward(request, response);
		}
	}

}
