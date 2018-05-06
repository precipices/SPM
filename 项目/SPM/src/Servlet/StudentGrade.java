package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.TakeDao;
import Data.Take;

@WebServlet("/studentGrade")
public class StudentGrade extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String userType = (String) session.getAttribute("userType");
		if (userType.equals("Ñ§Éú")) {
			TakeDao dao = new TakeDao();
			ArrayList<Take> gradeList = dao.getStudentGrade(username);
			request.setAttribute("gradeList", gradeList);
			RequestDispatcher rd = request.getRequestDispatcher("studentGrade.jsp");
			rd.forward(request, response);
		}
	}
}
