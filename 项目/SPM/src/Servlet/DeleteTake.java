package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TakeDao;

@WebServlet("/deleteTake")
public class DeleteTake extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		String student_id = request.getParameter("username");
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		TakeDao dao = new TakeDao();
		boolean success;
		if (type.equals("1")) {
			success = dao.deleteTakeTemp(course_id, student_id);
		} else {
			success = dao.deleteTake(course_id, student_id);
		}
		String userType = (String) request.getSession().getAttribute("userType");
		if (success) {
			if (userType.equals("Ñ§Éú")) {
				response.sendRedirect("getCourseList");
			} else {
				response.sendRedirect("getStudentList");
			}
		}
	}
}
