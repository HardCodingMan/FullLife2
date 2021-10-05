package apply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import apply.model.service.ApplyNoticeService;

/**
 * Servlet implementation class ApplyNoticeReplyWriterServlet
 */
@WebServlet("/Notice/Apply/ApplyNoticeReplyWriter")
public class ApplyNoticeReplyWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyNoticeReplyWriterServlet() {
        super();
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId"); 
		String replyContents = request.getParameter("replyContents");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		int result = new ApplyNoticeService().registerApplyReply(replyContents, noticeNo, userId);
		if(result > 0) {
			//상세페이지 (댓글을 작성한 페이지로 이동)
			response.sendRedirect("/Notice/Apply/ApplyContents?noticeNo="+noticeNo);
		}else {
			//실패페이지
			request.getRequestDispatcher("/WEB-INF/views/Notice/NoticeError.jsp").forward(request, response);
		}  
	}
}
