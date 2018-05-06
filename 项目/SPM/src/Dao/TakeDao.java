package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Course;
import Data.Student;
import Data.Take;

public class TakeDao extends BaseDao {
	public boolean addTakeTemp(Take take) {
		String sql = "insert into takeTemp values(?,?)";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, take.getCourse_id());
			stmt.setString(2, take.getStudent_id());
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

	public boolean addTake(Take take) {
		String sql = "insert into take(course_id,student_id) values(?,?)";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, take.getCourse_id());
			stmt.setString(2, take.getStudent_id());
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

	public ArrayList<Course> findTakeTemp(String student_id) {
		ArrayList<Course> tempCourseList = new ArrayList<Course>();
		String sql = "select * from takeTemp where student_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, student_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Course course = getCourse(rs.getInt("course_id"));
				tempCourseList.add(course);
			}
			stmt.close();
			con.close();
			return tempCourseList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public ArrayList<Course> findTake(String student_id) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		String sql = "select * from take where student_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, student_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Course course = getCourse(rs.getInt("course_id"));
				courseList.add(course);
			}
			stmt.close();
			con.close();
			return courseList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public ArrayList<Student> findStudentByCourseInTakeTemp(int course_id) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		String sql = "select * from takeTemp where course_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, course_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Student student = getStudent(rs.getString("student_id"));
				studentList.add(student);
			}
			stmt.close();
			con.close();
			return studentList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public ArrayList<Student> findStudentByCourseInTake(int course_id) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		String sql = "select * from take where course_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, course_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Student student = getStudent(rs.getString("student_id"));
				studentList.add(student);
			}
			stmt.close();
			con.close();
			return studentList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public boolean deleteTakeTemp(int course_id, String student_id) {
		String sql = "delete from takeTemp where course_id=? and student_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, course_id);
			stmt.setString(2, student_id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public boolean deleteTake(int course_id, String student_id) {
		String sql = "delete from take where course_id=? and student_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, course_id);
			stmt.setString(2, student_id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public Take getGrade(Take take) {
		String sql = "select grade from take where course_id=? and student_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, take.getCourse_id());
			stmt.setString(2, take.getStudent_id());
			ResultSet rs = stmt.executeQuery();
			rs.next();
			take.setGrade(rs.getFloat("grade"));
			stmt.close();
			con.close();
			return take;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Take> getStudentGrade(String student_id) {
		ArrayList<Take> gradeList = new ArrayList<Take>();
		String sql = "select * from take where student_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, student_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Take take = new Take();
				take.setCourse_name(getCourse(rs.getInt("course_id")).getCourse_name());
				take.setGrade(rs.getFloat("grade"));
				gradeList.add(take);
			}
			stmt.close();
			con.close();
			return gradeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean setGrade(Take take) {
		String sql = "update take set grade=? where course_id=? and student_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setFloat(1, take.getGrade());
			stmt.setInt(2, take.getCourse_id());
			stmt.setString(3, take.getStudent_id());
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

	private Student getStudent(String student_id) {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDao();
		return dao.findOneStudent(student_id);
	}

	private Course getCourse(int course_id) {
		// TODO Auto-generated method stub
		CourseDao dao = new CourseDao();
		return dao.findOneCourse(course_id);
	}
}
