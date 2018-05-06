package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDao;
import Dao.StudentUserDao;
import Data.StudentUser;

@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		if (password1.equals(password2)) {
			StudentUserDao dao1 = new StudentUserDao();
			StudentDao dao2 = new StudentDao();
			if (dao1.usernameRepeat(username)) {
				System.out.println("用户名重复");
				response.sendRedirect("studentRegister.jsp");
			} else {
				StudentUser student = new StudentUser(username, password1);
				boolean success1 = dao1.addStudentUser(student);
				boolean success2 = dao2.addStudent_id(username);
				if (success1 && success2) {
					response.sendRedirect("getArticleList");
				} else {
					System.out.println("未知错误");
					response.sendRedirect("studentRegister.jsp");
				}
			}
		} else {
			System.out.println("两次输入的密码不一样");
			response.sendRedirect("studentRegister.jsp");
		}
	}
}
