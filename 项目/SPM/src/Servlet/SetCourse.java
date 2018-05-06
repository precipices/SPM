package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BuildingDao;
import Dao.CourseDao;
import Dao.DayDao;
import Dao.RoomDao;
import Dao.TeacherDao;
import Dao.TimeDao;
import Data.Building;
import Data.Course;
import Data.Day;
import Data.Room;
import Data.Teacher;
import Data.Time;

@WebServlet("/setCourse")
public class SetCourse extends HttpServlet {
	private static int id;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		id = Integer.parseInt(request.getParameter("id"));
		CourseDao dao1 = new CourseDao();
		Course course = dao1.findOneCourse(id);
		TeacherDao dao2 = new TeacherDao();
		ArrayList<Teacher> teacherList = dao2.findAllTeacher();
		BuildingDao dao3 = new BuildingDao();
		ArrayList<Building> buildingList = dao3.findAllBuilding();
		RoomDao dao4 = new RoomDao();
		ArrayList<Room> roomList = dao4.findAllRoom();
		DayDao dao5 = new DayDao();
		ArrayList<Day> dayList = dao5.findAllDay();
		TimeDao dao6 = new TimeDao();
		ArrayList<Time> timeList = dao6.findAllTime();

		request.setAttribute("course_name", course.getCourse_name());
		request.setAttribute("teacher_id", course.getTeacher_id());
		request.setAttribute("building_id", course.getBuilding_id());
		request.setAttribute("room_id", course.getRoom_id());
		request.setAttribute("day_id", course.getDay_id());
		request.setAttribute("time_id", course.getTime_id());
		request.setAttribute("teacherList", teacherList);
		request.setAttribute("buildingList", buildingList);
		request.setAttribute("roomList", roomList);
		request.setAttribute("dayList", dayList);
		request.setAttribute("timeList", timeList);
		RequestDispatcher rd = request.getRequestDispatcher("admin/setCourse.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String course_name = request.getParameter("course_name");
		String teacher_id = request.getParameter("teacher");
		int building_id = Integer.parseInt(request.getParameter("building"));
		int room_id = Integer.parseInt(request.getParameter("room"));
		int day_id = Integer.parseInt(request.getParameter("day"));
		int time_id = Integer.parseInt(request.getParameter("time"));
		CourseDao dao = new CourseDao();
		Course course = new Course(course_name, teacher_id, building_id, room_id, day_id, time_id);
		boolean success = dao.setCourse(course, id);
		if (success) {
			response.sendRedirect("viewCourse");
		}
	}
}
