package manager.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.member.model.service.M_memberService;
import manager.member.moder.vo.M_member;

/**
 * Servlet implementation class MemberModifyServlet
 */
@WebServlet("/manager/m_member_modify")
public class M_memberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_memberModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mNo = Integer.parseInt(request.getParameter("userNo"));
		M_member mOne = new M_memberService().printOneByMem(mNo);
		request.setAttribute("member", mOne);
		request.getRequestDispatcher("/WEB-INF/manager/manager_member/m_member_modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mId = request.getParameter("member-id");
		String mPwd = request.getParameter("member-pwd");
		String mName = request.getParameter("member-name");
		String mZumin = request.getParameter("member-zumin");
		String mAddr = request.getParameter("member-addr");
		String mPhone = request.getParameter("member-phone");
		int mPoint = Integer.parseInt(request.getParameter("member-totalPoint"));
		String mEmail = request.getParameter("member-email");
		M_member member = new M_member(mId, mPwd, mName, mZumin, mAddr, mPhone, mPoint, mEmail);
		
		int result = new M_memberService().modifyMember(member);
		if(result > 0) {
			response.sendRedirect("/manager/m_member_list");
		}else {
			request.getRequestDispatcher("/WEB-INF/manager/manager_fail/m_search_fail.jsp").forward(request, response);
		}
	}

}
