package mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import mypage.model.service.MypageService;

/**
 * Servlet implementation class ModifyInfoServlet
 */
@WebServlet("/mypage/modify")
public class ModifyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String userNewPwd =  request.getParameter("user-pw");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String emailId = request.getParameter("email-id");
		String emailAddr = request.getParameter("email-addr");
		String userAddr = request.getParameter("user-addr");
//		System.out.println(userNewPwd);
		String phone = tel1+tel2+tel3;
		String email = emailId+"@"+emailAddr;
		Member member = new Member(userId, userNewPwd, phone, email, userAddr);
		int result = new MypageService().modifyMemberInfo(member);
		if(result > 0) {
			response.sendRedirect("/mypage/main");
		}
	}

}
