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
import javax.servlet.http.HttpSession;

import Dao.CourseDao;
import Dao.TakeDao;
import Data.Course;
import Data.Student;

@WebServlet("/getStudentList")
public class GetStudentList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		CourseDao dao1 = new CourseDao();
		ArrayList<Course> idList = dao1.findCourseListByTeacher(username);
		HashMap<Course, ArrayList<Student>> studentTempMap = new HashMap<Course, ArrayList<Student>>();
		HashMap<Course, ArrayList<Student>> studentMap = new HashMap<Course, ArrayList<Student>>();
		TakeDao dao2 = new TakeDao();
		for (int i = 0; i < idList.size(); i++) {
			ArrayList<Student> studentTempList = dao2.findStudentByCourseInTakeTemp(idList.get(i).getCourse_id());
			ArrayList<Student> studentList = dao2.findStudentByCourseInTake(idList.get(i).getCourse_id());
			studentTempMap.put(idList.get(i), studentTempList);
			studentMap.put(idList.get(i), studentList);
		}

		request.setAttribute("studentTempMap", studentTempMap);
		request.setAttribute("studentMap", studentMap);
		RequestDispatcher rd = request.getRequestDispatcher("teacherCourse.jsp");
		rd.forward(request, response);
	}
}
