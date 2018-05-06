package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TakeDao;
import Data.Student;
import Data.Take;

@WebServlet("/getStudentGrade")
public class GetStudentGrade extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		TakeDao dao = new TakeDao();
		ArrayList<Student> studentList = dao.findStudentByCourseInTake(course_id);
		HashMap<Student, Float> gradeMap = new HashMap<Student, Float>();
		for (int i = 0; i < studentList.size(); i++) {
			Take take = new Take(course_id, studentList.get(i).getStudent_id());
			take = dao.getGrade(take);
			gradeMap.put(studentList.get(i), take.getGrade());
		}

		request.setAttribute("gradeMap", gradeMap);
		RequestDispatcher rd = request.getRequestDispatcher("courseStudent.jsp");
		rd.forward(request, response);
	}
}
