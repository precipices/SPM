package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDao;
import Dao.TeacherDao;
import Data.Student;
import Data.Teacher;

@WebServlet("/viewUser")
public class ViewUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeacherDao dao1 = new TeacherDao();
		ArrayList<Teacher> teacherList = dao1.findAllTeacher();
		StudentDao dao2 = new StudentDao();
		ArrayList<Student> studentList = dao2.findAllStudent();

		String p1 = request.getParameter("page1");
		String p2 = request.getParameter("page2");
		int page1;
		int page2;
		try {
			page1 = Integer.parseInt(p1);
		} catch (NumberFormatException e) {
			page1 = 1;
		}
		try {
			page2 = Integer.parseInt(p2);
		} catch (NumberFormatException e) {
			page2 = 1;
		}
		int totalTeacher = teacherList.size();
		int totalStudent = studentList.size();
		int userPerPage = 10;
		int totalPage1;
		if (totalTeacher % userPerPage == 0) {
			totalPage1 = totalTeacher / userPerPage;
		} else {
			totalPage1 = totalTeacher / userPerPage + 1;
		}
		int totalPage2;
		if (totalStudent % userPerPage == 0) {
			totalPage2 = totalStudent / userPerPage;
		} else {
			totalPage2 = totalStudent / userPerPage + 1;
		}
		int start1 = (page1 - 1) * userPerPage;
		int start2 = (page2 - 1) * userPerPage;
		int end1 = start1 + userPerPage;
		if (end1 > totalTeacher) {
			end1 = totalTeacher;
		}
		int end2 = start2 + userPerPage;
		if (end2 > totalStudent) {
			end2 = totalStudent;
		}

		request.setAttribute("page1", page1);
		request.setAttribute("totalTeacher", totalTeacher);
		request.setAttribute("totalPage1", totalPage1);
		request.setAttribute("start1", start1);
		request.setAttribute("end1", end1);
		request.setAttribute("page2", page2);
		request.setAttribute("totalStudent", totalStudent);
		request.setAttribute("totalPage2", totalPage2);
		request.setAttribute("start2", start2);
		request.setAttribute("end2", end2);

		request.setAttribute("teacherList", teacherList);
		request.setAttribute("studentList", studentList);
		RequestDispatcher rd = request.getRequestDispatcher("admin/viewUser.jsp");
		rd.forward(request, response);
	}
}
