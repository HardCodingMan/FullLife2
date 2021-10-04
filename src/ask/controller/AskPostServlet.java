package ask.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ask.model.service.AskService;
import ask.model.vo.Ask;

/**
 * Servlet implementation class AskPost
 */
@WebServlet("/ask/post")
public class AskPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/ask/askPost.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		String disclosure = request.getParameter("disclosure");
		HttpSession session = request.getSession();
		String writerId = (String)session.getAttribute("userId");
		Ask ask = new Ask();
		ask.setAskSubject(subject);
		ask.setAskContents(contents);
		ask.setDisclosure(disclosure);
		ask.setUserId(writerId);
		int result = new AskService().registerAsk(ask);
		if(result>0){
			request.getRequestDispatcher("/WEB-INF/views/ask/askList.jsp");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/members/error.html");
		}
	}

}
