package cn.edu.imnu.itoffter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.itoffter.dao.ApplicantDAO;

/**
 * Servlet implementation class ApplicantRegisterServlet
 */
@WebServlet("/ApplicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantRegisterServlet() {
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
		PrintWriter out =response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("varifyCode");
		
		ApplicantDAO dao = new ApplicantDAO();
		boolean flag = dao.isExistEmail(email);
		String sessionValidateCode = (String)request.getSession().getAttribute("SESSION_VALIDATECODE");
		
		if (flag) {
			out.print("<script type = 'text/javascript'>");
			out.print("alert('�����ѱ�ע�ᣬ����������');");
			out.print("window.location = 'register.jsp';");
			out.print("</script>");
		}else {
			dao.save(email,password);
			response.sendRedirect("login.jsp");
		}
	}

}
