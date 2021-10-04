package manager.ask.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ask.model.service.M_askService;
import manager.ask.model.vo.M_ask;

/**
 * Servlet implementation class AskAnswerServlet
 */
@WebServlet("/manager/m_ask_answer")
public class M_askAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_askAnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int aNo = Integer.parseInt(request.getParameter("askNo"));
		M_ask aOne = new M_askService().printOneByAsk(aNo);
		request.setAttribute("ask", aOne);
		request.getRequestDispatcher("/WEB-INF/manager/manager_ask/m_ask_answer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String aSub = request.getParameter("ask-sub");
		String aCon = request.getParameter("ask-con");
		String awCon = request.getParameter("answer-con");
		int aNo = Integer.parseInt(request.getParameter("ask-no"));
		char reply = request.getParameter("reply").charAt(0);
		M_ask ask = new M_ask(aSub, aCon, awCon,aNo);
		
		int result = new M_askService().modifyAnswer(ask);
		if(result>0) {
			response.sendRedirect("/manager/m_ask_list");
		}else {
			request.getRequestDispatcher("/WEB-INF/manager/manager_fail/m_search_fail.jsp").forward(request, response);
		}
		
//		char a = (char) b;

		
	}

}
