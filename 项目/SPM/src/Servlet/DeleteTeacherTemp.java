package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TeacherTempDao;

@WebServlet("/deleteTeacherTemp")
public class DeleteTeacherTemp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacher_id = request.getParameter("teacher_id");
		TeacherTempDao dao = new TeacherTempDao();
		boolean success = dao.deleteTeacherTemp(teacher_id);
		if (success) {
			response.sendRedirect("getTempTeacher");
		}
	}
}
