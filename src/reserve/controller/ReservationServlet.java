package reserve.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;
import mypage.model.vo.History;
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
		String userId = request.getParameter("userId");
		Member member = new MemberService().printOneById(userId);
		String metroCity = request.getParameter("metro-city");
		request.setAttribute("member", member);
		request.setAttribute("metroCity", metroCity);
		request.getRequestDispatcher("/WEB-INF/views/reserve/reservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int organQuantity = Integer.parseInt(request.getParameter("quantity"));
		int usedPoint = Integer.parseInt(request.getParameter("usedPoint"));
		int payment = Integer.parseInt(request.getParameter("payment"));
		String patientName = request.getParameter("patient-name");
		String patientZumin = request.getParameter("patient-zumin");
		String patientPhone = request.getParameter("patient-phone");
		String patientAddr = request.getParameter("patient-addr");
		String relation = request.getParameter("relation");
		int organNo = Integer.parseInt(request.getParameter("organNo"));

		String date = request.getParameter("hospitalTime");
		String[] dateArr = date.split("-");
		String year = dateArr[0];
		String month = dateArr[1];
		String day = dateArr[2];
		
//		String from = "2013-04-08 10:10:10";
//
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//		Date to = transFormat.parse(from);

		String finalDate = year+"/"+month+"/"+day;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date hosDate = format.parse(finalDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("과연???? "+ finalDate);
		
		int hosNo = Integer.parseInt(request.getParameter("hospitalNo"));
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		Patient patient = new Patient();
		patient.setPatientName(patientName);
		patient.setPatientZumin(patientZumin);
		patient.setPatientPhone(patientPhone);
		patient.setPatientAddr(patientAddr);
		patient.setRelation(relation);
		patient.setOrganNo(organNo);
//		patient.setHospitalTime(hosTime);
		patient.setHospitalNo(hosNo);
		patient.setUserId(userId);
		
		History history = new History();
		history.setOrganNo(organNo);
		history.setOrganQuantity(organQuantity);
		history.setPayment(payment);
		history.setUsedPoint(usedPoint);
		history.setUserId(userId);
		history.setHospitalNo(hosNo);
		int result = new ReserveService().orderComplete(patient);
		int result2 = new ReserveService().payComplete(history);
		if(result > 0) {
			request.getRequestDispatcher("/WEB-INF/views/reserve/orderSuccess.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/members/error.html");
		}
		
	}

}
