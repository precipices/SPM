package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CourseDao;
import Data.Course;

@WebServlet("/viewCourse")
public class ViewCourse extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CourseDao dao = new CourseDao();
		ArrayList<Course> courseList = dao.findAllCourse();

		String p = request.getParameter("page");
		int page;
		try {
			page = Integer.parseInt(p);
		} catch (NumberFormatException e) {
			page = 1;
		}
		int totalCourse = courseList.size();
		int coursePerPage = 10;
		int totalPage;
		if (totalCourse % coursePerPage == 0) {
			totalPage = totalCourse / coursePerPage;
		} else {
			totalPage = totalCourse / coursePerPage + 1;
		}
		int start = (page - 1) * coursePerPage;
		int end = start + coursePerPage;
		if (end > totalCourse) {
			end = totalCourse;
		}

		request.setAttribute("page", page);
		request.setAttribute("totalCourse", totalCourse);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("courseList", courseList);
		RequestDispatcher rd = request.getRequestDispatcher("admin/viewCourse.jsp");
		rd.forward(request, response);
	}
}
