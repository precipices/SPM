package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tool.FileTool;

@WebServlet("/ShowTeacherFileServlet")
public class ShowTeacherFileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 需要从session得到登陆类型
		 */
		String user = request.getParameter("userType");
		// 这里的teacherName是从uri里传入的,不要更改!!
		String teacherName = request.getParameter("teacherName");
		File rootPath = new File(this.getServletContext().getRealPath("/WEB-INF/upload"));
		if (!rootPath.exists()) {
			rootPath.mkdirs();
		}
		List<String> checkedList = new ArrayList<String>();
		FileTool.listChecked(rootPath, teacherName, checkedList);
		request.setAttribute("checkedList", checkedList);
		request.setAttribute("teacherName", teacherName);
		if (user == null) {
			request.getRequestDispatcher("fileUpload/studentShowTeacherFile.jsp").forward(request, response);
		} else {
			if (user.equals("admin")) {
				request.getRequestDispatcher("admin/adminShowTeacherFile.jsp").forward(request, response);
			}
		}
	}
}
