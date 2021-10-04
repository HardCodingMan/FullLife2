package ask.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ask.model.service.AskService;
import ask.model.vo.Ask;

/**
 * Servlet implementation class AskContents
 */
@WebServlet("/ask/askContents")
public class AskContentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskContentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int askNo = Integer.parseInt(request.getParameter("askNo"));
		Ask askOne = new AskService().printOneByNo(askNo);
		if(askOne != null) {
			request.setAttribute("askOne", askOne);
			request.getRequestDispatcher("/WEB-INF/views/ask/askContents.jsp").forward(request, response);
		}else {
		request.getRequestDispatcher("/WEB-INF/views/reserve/organTrans.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
