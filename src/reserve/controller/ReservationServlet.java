package reserve.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import patient.model.vo.Patient;
import reserve.model.service.ReserveService;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/reserve/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String metroCity = request.getParameter("metro-city");
	//		System.out.println(hospitalNo);
		request.setAttribute("metroCity", metroCity);
		request.getRequestDispatcher("/WEB-INF/views/reserve/reservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String patientName = request.getParameter("patientName");
//		String patientZumin = request.getParameter("patientZumin");
//		String patientPhone = request.getParameter("patientPhone");
//		String patientAddr = request.getParameter("patientAddr");
//		String relation = request.getParameter("relation");
//		int organNo = Integer.parseInt(request.getParameter("organNo"));
//		int hosNo = Integer.parseInt(request.getParameter("hospitlNo"));
//		HttpSession session = request.getSession();
//		String userId = (String)session.getAttribute("userId");
//		Patient patient = new Patient();
//		patient.setPatientName(patientName);
//		patient.setPatientZumin(patientZumin);
//		patient.setPatientPhone(patientPhone);
//		patient.setPatientAddr(patientAddr);
//		patient.setRelation(relation);
//		patient.setOrganNo(organNo);
//		patient.setHospitalNo(hosNo);
//		patient.setUserId(userId);
//		int result = new ReserveService().patientInfoCheck(reserve);
//		if(result>0) {
//			response.sendRedirect("/reserve/reservation");
//		} else {
//			request.getRequestDispatcher("/WEB-INF/views/members/error.html");
//		}
	}
}


