package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDao;
import Dao.StudentUserDao;
import Dao.TeacherTempDao;
import Dao.TeacherUserDao;
import Data.StudentUser;
import Data.TeacherUser;

@WebServlet("/TeacherRegister")
public class TeacherRegister extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String teacher_name = request.getParameter("teacher_name");
		if (password1.equals(password2)) {
			TeacherUserDao dao1 = new TeacherUserDao();
			TeacherTempDao dao2 = new TeacherTempDao();
			if (dao1.usernameRepeat(username)) {
				System.out.println("用户名重复");
				response.sendRedirect("teacherRegister.jsp");
			} else {
				TeacherUser teacher = new TeacherUser(username, password1);
				teacher.setTeacher_name(teacher_name);
				boolean success = dao2.addTeacherTemp(teacher);
				if (success) {
					response.sendRedirect("getArticleList");
				} else {
					System.out.println("未知错误");
					response.sendRedirect("teacherRegister.jsp");
				}
			}
		} else {
			System.out.println("两次输入的密码不一样");
			response.sendRedirect("teacherRegister.jsp");
		}
	}
}
