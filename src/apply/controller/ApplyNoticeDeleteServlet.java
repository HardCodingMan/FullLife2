package apply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apply.model.service.ApplyNoticeService;

/**
 * Servlet implementation class ApplyNoticeDeleteServlet
 */
@WebServlet("/Notice/Apply/ApplyNoticeDelete")
public class ApplyNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyNoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		int result = new ApplyNoticeService().removeNotice(noticeNo);
		if(result > 0) {
			// 삭제 성공하면 게시글 리스트로 이동 
			response.sendRedirect("/Notice/Apply/ApplyNotice");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/Notice/NoticeError.jsp").forward(request, response);		
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
