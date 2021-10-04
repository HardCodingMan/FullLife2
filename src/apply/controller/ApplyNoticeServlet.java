package apply.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apply.model.service.ApplyNoticeService;
import apply.model.vo.Notice;
import apply.model.vo.ApplyPage;

/**
 * Servlet implementation class ApplyNoticeServlet
 */
@WebServlet("/Notice/Apply/ApplyNotice")
public class ApplyNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyNoticeServlet() {
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
		ApplyPage applyPage = new ApplyNoticeService().printAllApply(currentPage);
		List<Notice> aList = applyPage.getaList(); 
		if(!aList.isEmpty()) {
			request.setAttribute("aList", aList);
			request.setAttribute("pageNavi", applyPage.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/Notice/Apply/ApplyNotice.jsp").forward(request, response);
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
