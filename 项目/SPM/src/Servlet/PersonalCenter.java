package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StudentDao;
import Dao.TeacherDao;
import Data.Student;
import Data.Teacher;

@WebServlet("/PersonalCenter")
public class PersonalCenter extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String userType = (String) session.getAttribute("userType");
		if (userType.equals("学生")) {
			StudentDao dao = new StudentDao();
			Student student = dao.findOneStudent(username);
			request.setAttribute("student", student);
			RequestDispatcher rd = request.getRequestDispatcher("personalCenter.jsp");
			rd.forward(request, response);
		} else {
			if (userType.equals("教师")) {
				TeacherDao dao = new TeacherDao();
				Teacher teacher = dao.findOneTeacher(username);
				request.setAttribute("teacher", teacher);
				RequestDispatcher rd = request.getRequestDispatcher("personalCenter.jsp");
				rd.forward(request, response);
			}
		}
	}
}
