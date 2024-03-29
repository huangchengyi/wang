package cn.edu.imnu.itoffter.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.itoffter.dao.ResumeDAO;
import cn.edu.imnu.itoffter.info.Applicant;
import cn.edu.imnu.itoffter.info.ResumeBasicinfo;

/**
 * Servlet implementation class ResumeBasicinfoServlet
 */
@WebServlet("/ResumeBasicinfoServlet")
public class ResumeBasicinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeBasicinfoServlet() {
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
		String type = request.getParameter("type");
		if("add".equals(type)) {
			ResumeBasicinfo basicinfo = this.requestDataObj(request);
			Applicant applicant = (Applicant)request.getSession().getAttribute("SESSION_APPLICANT");
			ResumeDAO dao = new ResumeDAO();
			int basicinfoID = dao.add(basicinfo, 7);
			request.getSession().setAttribute("SESSION_RESUMEID", basicinfoID);
			response.sendRedirect("resume.jsp");
		}
	}

	private ResumeBasicinfo requestDataObj(HttpServletRequest request) {
		ResumeBasicinfo basicinfo = null;
		String realName = request.getParameter("realName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String jobIntension = request.getParameter("jobIntension");
		String jobExperience = request.getParameter("jobExperience");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate = null;
		try {
			birthdayDate=sdf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		basicinfo = new ResumeBasicinfo(realName,gender,birthdayDate,telephone,email,jobIntension,jobExperience);
		return basicinfo;
	}

}
