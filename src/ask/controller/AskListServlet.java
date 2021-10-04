package ask.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ask.model.service.AskService;
import ask.model.vo.Ask;
import ask.model.vo.PageData;

/**
 * Servlet implementation class AskBoard
 */
@WebServlet("/ask/list")
public class AskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		String getCurrentPage = request.getParameter("currentPage");
		if(getCurrentPage == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(getCurrentPage);
		}
		PageData pageData = new AskService().printAllAsk(currentPage);
		List<Ask> aList = pageData.getAskList();
		if(!aList.isEmpty()) {
			request.setAttribute("aList", aList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/ask/askList.jsp").forward(request, response);
		}else {
			RequestDispatcher views=request.getRequestDispatcher("/WEB-INF/views/members/error.html"); 
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
