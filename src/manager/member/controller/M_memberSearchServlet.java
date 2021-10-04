package manager.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.member.model.service.M_memberService;
import manager.member.moder.vo.M_PageData;
import manager.member.moder.vo.M_member;

/**
 * Servlet implementation class M_memberSearchServlet
 */
@WebServlet("/manager/m_member_search")
public class M_memberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_memberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchId = request.getParameter("searchId");
		int currentPage = 1;
		String currentPageVal = request.getParameter("currentPage");
		
		if(currentPageVal != null) {
			currentPage=Integer.parseInt(currentPageVal);
		}
		
		M_PageData pd = new M_memberService().printSearchMember(searchId,currentPage);
		List<M_member> mList = pd.getMemList();
		if(!mList.isEmpty()) {
			request.setAttribute("mList", mList);
			request.setAttribute("pageNavi", pd.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/manager/manager_member/m_member_search.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/manager/manager_fail/m_search_fail.jsp").forward(request, response);
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
