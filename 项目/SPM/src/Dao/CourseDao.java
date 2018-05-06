package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Course;

public class CourseDao extends BaseDao {
	public boolean addCourse(Course course) {
		String sql = "insert into course(course_name,teacher_id,building_id,room_id,day_id,time_id) values(?,?,?,?,?,?)";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, course.getCourse_name());
			stmt.setString(2, course.getTeacher_id());
			stmt.setInt(3, course.getBuilding_id());
			stmt.setInt(4, course.getRoom_id());
			stmt.setInt(5, course.getDay_id());
			stmt.setInt(6, course.getTime_id());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Course findOneCourse(int id) {
		String sql = "select * from course where course_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Course course = new Course();
			course.setCourse_id(id);
			course.setCourse_name(rs.getString("course_name"));
			course.setTeacher_id(rs.getString("teacher_id"));
			course.setTeacher(getTeacher(rs.getString("teacher_id")));
			course.setBuilding_id(rs.getInt("building_id"));
			course.setBuilding(getBuilding(rs.getInt("building_id")));
			course.setRoom_id(rs.getInt("room_id"));
			course.setRoom(getRoom(rs.getInt("room_id")));
			course.setDay_id(rs.getInt("day_id"));
			course.setDay(getDay(rs.getInt("day_id")));
			course.setTime_id(rs.getInt("time_id"));
			course.setTime(getTime(rs.getInt("time_id")));
			stmt.close();
			con.close();
			return course;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Course> findAllCourse() {
		ArrayList<Course> courseList = new ArrayList<Course>();
		String sql = "select * from course";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_id(rs.getInt("course_id"));
				course.setCourse_name(rs.getString("course_name"));
				course.setTeacher(getTeacher(rs.getString("teacher_id")));
				course.setBuilding(getBuilding(rs.getInt("building_id")));
				course.setRoom(getRoom(rs.getInt("room_id")));
				course.setDay(getDay(rs.getInt("day_id")));
				course.setTime(getTime(rs.getInt("time_id")));
				courseList.add(course);
			}
			stmt.close();
			con.close();
			return courseList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Course> findCourseListByTeacher(String teacher_id) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		String sql = "select * from course where teacher_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, teacher_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_id(rs.getInt("course_id"));
				course.setCourse_name(rs.getString("course_name"));
				courseList.add(course);
			}
			stmt.close();
			con.close();
			return courseList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteCourse(int id) {
		String sql = "delete from course where course_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean setCourse(Course course, int id) {
		String sql = "update course set course_name=?,teacher_id=?,building_id=?,room_id=?,day_id=?,time_id=? where course_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, course.getCourse_name());
			stmt.setString(2, course.getTeacher_id());
			stmt.setInt(3, course.getBuilding_id());
			stmt.setInt(4, course.getRoom_id());
			stmt.setInt(5, course.getDay_id());
			stmt.setInt(6, course.getTime_id());
			stmt.setInt(7, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private String getTeacher(String id) {
		// TODO Auto-generated method stub
		TeacherDao dao = new TeacherDao();
		return dao.findTeacher_name(id);
	}

	private String getBuilding(int id) {
		// TODO Auto-generated method stub
		BuildingDao dao = new BuildingDao();
		return dao.findBuilding(id);
	}

	private String getRoom(int id) {
		// TODO Auto-generated method stub
		RoomDao dao = new RoomDao();
		return dao.findRoom(id);
	}

	private String getDay(int id) {
		// TODO Auto-generated method stub
		DayDao dao = new DayDao();
		return dao.findDay(id);
	}

	private String getTime(int id) {
		// TODO Auto-generated method stub
		TimeDao dao = new TimeDao();
		return dao.findTime(id);
	}
}
