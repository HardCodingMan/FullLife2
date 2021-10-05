package apply.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import apply.model.service.ApplyNoticeService;
import apply.model.vo.ApplyPage;
import apply.model.vo.Notice;


/**
 * Servlet implementation class ApplyNoticeSearchServlet
 */
@WebServlet("/Notice/Apply/ApplyNoticeSearch")
public class ApplyNoticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyNoticeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String searchKeyword = request.getParameter("searchKeyword");
		int currentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		if(currentPageVal != null) {
			currentPage = Integer.parseInt(currentPageVal);
		}
		ApplyPage ap = new ApplyNoticeService().printSearchNotice(searchKeyword, currentPage);
		List<Notice> aList = ap.getaList();
		if(!aList.isEmpty()) {
			request.setAttribute("userId", userId);
			request.setAttribute("aList", aList);
			request.setAttribute("pageNavi", ap.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/Notice/Apply/ApplyNoticeSearch.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/notice/noticeError.html").forward(request, response);
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
