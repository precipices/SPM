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

@WebServlet("/getCourseList")
public class GetCourseList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		CourseDao dao1 = new CourseDao();
		ArrayList<Course> courseList = dao1.findAllCourse();
		TakeDao dao2 = new TakeDao();
		ArrayList<Course> tempResultList = dao2.findTakeTemp(username);
		ArrayList<Course> resultList = dao2.findTake(username);

		request.setAttribute("courseList", courseList);
		request.setAttribute("tempResultList", tempResultList);
		request.setAttribute("resultList", resultList);
		RequestDispatcher rd = request.getRequestDispatcher("takeCourse.jsp");
		rd.forward(request, response);
	}
}