package manager.result.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import manager.result.model.service.M_resultService;
import manager.result.model.vo.M_patient;
import manager.result.model.vo.M_result;

/**
 * Servlet implementation class M_uploadServlet
 */
@WebServlet("/manager/m_file_upload")
public class M_uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public M_uploadServlet() {
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
		HttpSession session = request.getSession();
		
		String uploadFilePath = request.getServletContext().getRealPath("upload");
		int uploadFileLimit = 5*1024*1024;
		System.out.println(uploadFilePath);
		String encType = "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileLimit, encType, new DefaultFileRenamePolicy());
		
		//2. 파일에 대한 정보 저장
		String fileUser = multi.getParameter("user-id");
		String fileName = multi.getFilesystemName("upFile");
		File uploadFile = multi.getFile("upFile");
		String filePath = uploadFile.getPath();
		long fileSize = uploadFile.length();

		M_patient patient = new M_patient();
		patient.setUserId(fileUser);
		patient.setFileName(fileName);
		patient.setFilePath(filePath);
		patient.setFileSize(fileSize);
		
		int result = new M_resultService().registerResultFile(patient);
		if(result > 0) {
			response.sendRedirect("/manager/m_result_list");
		}else {
			request.getRequestDispatcher("/WEB-INF/manager/manager_fail/m_search_fail.jsp").forward(request, response);
		}
		
		
	}

}
