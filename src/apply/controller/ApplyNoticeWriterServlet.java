package apply.controller;

import java.io.File;
import java.io.IOException;

import javax.activation.FileDataSource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import apply.model.service.ApplyNoticeService;
import apply.model.vo.Notice;
import apply.model.vo.ApplyNoticeFile;


/**
 * Servlet implementation class ApplyNoticeWriterServlet
 */
@WebServlet("/Notice/Apply/ApplyNoticeWriter")
public class ApplyNoticeWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyNoticeWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Notice/Apply/ApplyNoticeWriter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글인코딩
		request.setCharacterEncoding("UTF-8");
		/////////////// 로그인 세션 가져오기 //////////
		HttpSession session = request.getSession();
		String writeId = (String)session.getAttribute("userId");
		/////////////// 사진///////////
		String uploadFilePath = request.getServletContext().getRealPath("fileupload");
		int uploadFileLimit = 50*1024*1024;
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileLimit, encType, new DefaultFileRenamePolicy());
		File uploadFile = multi.getFile("apply-File");
		String fileName = multi.getFilesystemName("apply-File");
		String filePath = uploadFile.getPath();
		long fileSize = uploadFile.length();
		///////////////////////////////
		String subject = multi.getParameter("apply-notice-sub");
		String Contents = multi.getParameter("apply-notice-contents");
		int needSupport = Integer.parseInt(multi.getParameter("need-supprot"));
//		int needSupport = Integer.parseInt(request.getParameter("needSupport"));
		//ApplyNotice 객체에 정보 세팅
		Notice notice = new Notice();
		notice.setNoticeTitle(subject);
		notice.setNoticeContents(Contents);
		notice.setUserId(writeId);
		notice.setNeedSupport(needSupport);
		//ApplyNoticeFile 객체에 사진 정보 세팅
		notice.setPicPath(filePath);
		notice.setPicSize(fileSize);
		notice.setPicName(fileName);
		int result = new ApplyNoticeService().noticeWrite(notice);
		if(result > 0) {
			response.sendRedirect("/Notice/Apply/ApplyNotice");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/Notice/NoticeError.jsp").forward(request, response);
		}
	}
}
