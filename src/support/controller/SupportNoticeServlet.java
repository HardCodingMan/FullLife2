package support.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apply.model.service.ApplyNoticeService;
import apply.model.vo.ApplyPage;
import apply.model.vo.Notice;

/**
 * Servlet implementation class SupportNoticeServlet
 */
@WebServlet("/Notice/Support/SupportNotice")
public class SupportNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		String getCurrentPage =	request.getParameter("currentPage");
		if(getCurrentPage == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(getCurrentPage);
		}
		ApplyPage applyPage = new ApplyNoticeService().printAllSupport(currentPage);
		List<Notice> sList = applyPage.getaList(); 
		if(!sList.isEmpty()) {
			request.setAttribute("sList", sList);
			request.setAttribute("pageNavi", applyPage.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/Notice/Support/SupportNotice.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/Notice/NoticeError.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
