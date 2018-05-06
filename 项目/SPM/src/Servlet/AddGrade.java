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

import Dao.CourseDao;
import Dao.TakeDao;
import Data.Course;
import Data.Take;

@WebServlet("/addGrade")
public class AddGrade extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		CourseDao dao = new CourseDao();
		ArrayList<Course> courseList = dao.findCourseListByTeacher(username);

		request.setAttribute("courseList", courseList);
		RequestDispatcher rd = request.getRequestDispatcher("addGrade.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		String student_id = request.getParameter("student_id");
		float grade = Float.parseFloat(request.getParameter("grade"));
		Take take = new Take(course_id, student_id);
		take.setGrade(grade);
		TakeDao dao = new TakeDao();
		boolean success = dao.setGrade(take);
		if (success) {
			doGet(request, response);
		}
	}
}
