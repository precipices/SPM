package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TeacherDao;
import Dao.TeacherTempDao;
import Dao.TeacherUserDao;
import Data.TeacherUser;

@WebServlet("/addTeacher")
public class AddTeacher extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacher_id = request.getParameter("teacher_id");
		TeacherTempDao dao1 = new TeacherTempDao();
		TeacherUser teacher = dao1.findOneTeacherTemp(teacher_id);
		TeacherDao dao2 = new TeacherDao();
		TeacherUserDao dao3 = new TeacherUserDao();
		boolean success1 = dao3.addTeacherUser(teacher);
		boolean success2 = dao2.addTeacher(teacher);
		boolean success3 = dao1.deleteTeacherTemp(teacher_id);
		if (success1 && success2 && success3) {
			response.sendRedirect("getTempTeacher");
		}
	}
}
