package Servlet;

import java.io.IOException;
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

@WebServlet("/setUserDetail")
public class SetUserDetail extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String userType = (String) session.getAttribute("userType");
		if (userType.equals("学生")) {
			String student_name = request.getParameter("student_name");
			String sex = request.getParameter("sex");
			int age = Integer.parseInt(request.getParameter("age"));
			String sdept = request.getParameter("sdept");
			Student student = new Student(username);
			student.setStudent_name(student_name);
			student.setSex(sex);
			student.setAge(age);
			student.setSdept(sdept);
			StudentDao dao = new StudentDao();
			boolean success = dao.setStudent(student);
			if (success) {
				response.sendRedirect("PersonalCenter");
			}
		} else {
			if (userType.equals("教师")) {
				String sex = request.getParameter("sex");
				int age = Integer.parseInt(request.getParameter("age"));
				Teacher teacher = new Teacher();
				teacher.setTeacher_id(username);
				teacher.setSex(sex);
				teacher.setAge(age);
				TeacherDao dao = new TeacherDao();
				boolean success = dao.setTeacher(teacher);
				if (success) {
					response.sendRedirect("PersonalCenter");
				}
			}
		}
	}
}
