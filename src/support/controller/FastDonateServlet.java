package support.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;
import support.model.service.SupportService;
import support.model.vo.Support;

/**
 * Servlet implementation class FastDonateServlet
 */
@WebServlet("/donate/move")
public class FastDonateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FastDonateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int rank1 = Integer.parseInt(request.getParameter("rank1"));
		int rank2 = Integer.parseInt(request.getParameter("rank2"));
//		System.out.println(rank1 +","+ rank2);
		Member member = new MemberService().getMemberTotalPoint(userId);
		Support firstRank = new SupportService().getFirstSupportNotice(rank1);
		Support secondRank = new SupportService().getSecondSupportNotice(rank2);
		int firstNow = firstRank.getNowSupport();
		int firstNeed = firstRank.getNeedSupport();
		int secondNow = secondRank.getNowSupport();
		int secondNeed = secondRank.getNeedSupport();
		double percentage1 = (double)firstNow / (double) firstNeed * 100;
		double percentage2 = (double)secondNow / (double)secondNeed * 100;
		System.out.println(firstRank.getPicName());
		System.out.println(percentage2);
		request.setAttribute("member", member);
		request.setAttribute("percentage1", percentage1);
		request.setAttribute("percentage2", percentage2);
		request.setAttribute("firstRank", firstRank);
		request.setAttribute("secondRank", secondRank);
		request.getRequestDispatcher("/WEB-INF/views/donate/fastDonate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
