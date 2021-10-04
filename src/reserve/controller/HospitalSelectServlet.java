package reserve.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.model.service.HospitalService;
import hospital.model.vo.Hospital;
import reserve.model.service.ReserveService;

/**
 * Servlet implementation class HospitalSelectServlet
 */
@WebServlet("/reserve/select")
public class HospitalSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location = request.getParameter("location1");
		String done = "";
		System.out.println(location);
		if(location.equals("gwangju")) {
			done = "광주";
		} else if(location.equals("seoul")) {
			done = "서울";
		} else if(location.equals("daejeon")) {
			done = "대전";
		} else if(location.equals("busan")) {
			done = "부산";
		} else if(location.equals("daegu")) {
			done = "대구";
		}
		ArrayList<Hospital> hospitals = new ReserveService().getAllHospital(done);
		if(!hospitals.isEmpty()) {
			request.setAttribute("hospitals", hospitals);
			request.setAttribute("city", done);
			request.setAttribute("location", location);
			request.getRequestDispatcher("/WEB-INF/views/reserve/reservation.jsp").forward(request, response);
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
