package cn.edu.imnu.itoffter.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.edu.imnu.itoffter.dao.ResumeDAO;

/**
 * Servlet implementation class ResumePicUploadServlet
 */
@WebServlet("/ResumePicUploadServlet")
public class ResumePicUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumePicUploadServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Part part = request.getPart("headShot");
		String fileName = part.getSubmittedFileName();
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		String filepath = getServletContext().getRealPath("/applicant/images");
		System.out.println("ͷ�񱣴�·��Ϊ��" + filepath);
		File f =new File(filepath);
		if(!f.exists())
			f.mkdirs();
		part.write(filepath + "/" + newFileName);
		int resumeID = (Integer)request.getSession().getAttribute("SESSION_RESUMEID");
		ResumeDAO dao = new ResumeDAO();
		dao.updateHeadShot(resumeID,newFileName);
		response.sendRedirect("applicant/resume.jsp");
		
	}

}
