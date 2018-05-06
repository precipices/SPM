package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TeacherTempDao;
import Data.TeacherUser;

@WebServlet("/getTempTeacher")
public class GetTempTeacher extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeacherTempDao dao = new TeacherTempDao();
		ArrayList<TeacherUser> teacherList = dao.findAllTeacherTemp();

		String p = request.getParameter("page");
		int page;
		try {
			page = Integer.parseInt(p);
		} catch (NumberFormatException e) {
			page = 1;
		}
		int totalTeacher = teacherList.size();
		int teacherPerPage = 10;
		int totalPage;
		if (totalTeacher % teacherPerPage == 0) {
			totalPage = totalTeacher / teacherPerPage;
		} else {
			totalPage = totalTeacher / teacherPerPage + 1;
		}
		int start = (page - 1) * teacherPerPage;
		int end = start + teacherPerPage;
		if (end > totalTeacher) {
			end = totalTeacher;
		}
		
		request.setAttribute("page", page);
		request.setAttribute("totalTeacher", totalTeacher);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("teacherList", teacherList);
		RequestDispatcher rd = request.getRequestDispatcher("admin/tempTeacher.jsp");
		rd.forward(request, response);
	}
}
