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

@WebServlet("/addCourse")
public class AddCourse extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeacherDao dao = new TeacherDao();
		ArrayList<Teacher> teacherList = dao.findAllTeacher();
		BuildingDao dao1 = new BuildingDao();
		ArrayList<Building> buildingList = dao1.findAllBuilding();
		RoomDao dao2 = new RoomDao();
		ArrayList<Room> roomList = dao2.findAllRoom();
		DayDao dao3 = new DayDao();
		ArrayList<Day> dayList = dao3.findAllDay();
		TimeDao dao4 = new TimeDao();
		ArrayList<Time> timeList = dao4.findAllTime();

		request.setAttribute("teacherList", teacherList);
		request.setAttribute("buildingList", buildingList);
		request.setAttribute("roomList", roomList);
		request.setAttribute("dayList", dayList);
		request.setAttribute("timeList", timeList);
		RequestDispatcher rd = request.getRequestDispatcher("admin/addCourse.jsp");
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
		boolean success = dao.addCourse(course);
		if (success) {
			doGet(request, response);
		}
	}
}
