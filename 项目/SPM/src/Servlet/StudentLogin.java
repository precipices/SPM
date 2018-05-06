package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StudentUserDao;
import Data.StudentUser;

@WebServlet("/studentLogin")
public class StudentLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		StudentUser user = new StudentUser(username, password);
		StudentUserDao dao = new StudentUserDao();
		boolean success = dao.checkUser(user);
		if (success) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userType", "学生");
			response.sendRedirect("getArticleList");
		} else {
			System.out.println("用户名或密码错误");
			response.sendRedirect("studentLogin.jsp");
		}
	}
}
