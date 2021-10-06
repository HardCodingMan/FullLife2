package support.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import apply.model.service.ApplyNoticeService;
import apply.model.vo.Notice;
import member.model.vo.Member;

/**
 * Servlet implementation class SupportContentsServlet
 */
@WebServlet("/Notice/Support/SupportContents")
public class SupportContentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportContentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice sOne = new ApplyNoticeService().printOneBySupportNo(noticeNo);
		Member point = new ApplyNoticeService().getPoint(userId); 
		int sOnePercentage = (int)((double)sOne.getNowSupport() / (double)sOne.getNeedSupport() * 100);
		if(sOne != null) {
			request.setAttribute("point", point);
			request.setAttribute("percentage", sOnePercentage);
			request.setAttribute("userId", userId);
			request.setAttribute("sOne", sOne);
			// NoticeReply setAttribute 해줌
			request.getRequestDispatcher("/WEB-INF/views/Notice/Support/SupportContents.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/Notice/ApplyError.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
