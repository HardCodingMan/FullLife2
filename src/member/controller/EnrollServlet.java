package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;


@WebServlet("/member/enroll")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/enroll.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String name = request.getParameter("UserName");
		String zumin = request.getParameter("UserZumin");
		String phone = request.getParameter("UserPhone");
		String address = request.getParameter("UserAddr");
		String email = request.getParameter("UserEmail");
		System.out.println(userId);
			
		Member member = new Member(userId, userPwd, name, zumin, phone, address, email);
		int result = new MemberService().registerMember(member);
		
		if(result > 0) {
			request.getRequestDispatcher("/WEB-INF/views/members/success.html").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/members/error.html").forward(request, response);
		}
	
	
		}
}
