package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TakeDao;
import Data.Take;

@WebServlet("/takeCourse")
public class TakeCourse extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		String student_id = request.getParameter("student_id");
		Take take = new Take(course_id, student_id);
		TakeDao dao = new TakeDao();
		boolean success = dao.addTakeTemp(take);
		if (success) {
			response.sendRedirect("getCourseList");
		}
	}
}
