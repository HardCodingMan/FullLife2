package reserve.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;
import reserve.model.service.ReserveService;

/**
 * Servlet implementation class organTrans
 */
@WebServlet("/reserve/organ")
public class OrganTransServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganTransServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/reserve/organTrans.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userId = request.getParameter("userId");
//		Member member = new MemberService().printOneById(userId);
//		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/reserve/reservation.jsp").forward(request, response);
		}
		
		
		
		
		
	}
//		HttpSession session = request.getSession();
//		String name = (String)session.getAttribute("userName");
//		int zumin = (int)session.getAttribute("userZumin");
//		String phone = (String)session.getAttribute("userPhone");
//		String addr = (String)session.getAttribute("userAddr");
//		Reserve reserve = new Reserve();
//		reserve.setUserName(name);
//		reserve.setUserZumin(zumin);
//		reserve.setUserPhone(phone);
//		reserve.setUserAddr(addr);
//		int result = new ReserveService().patientInfoCheck(reserve);
//		if(result>0) {
//			response.sendRedirect("/reserve/reservation");
//		} else {
//			request.getRequestDispatcher("/WEB-INF/views/members/error.html");
//		}
//	}

