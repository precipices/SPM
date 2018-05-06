package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Student;

public class StudentDao extends BaseDao {
	public boolean addStudent_id(String student_id) {
		String sql = "insert into student(student_id) values(?)";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, student_id);
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

	public Student findOneStudent(String id) {
		String sql = "select * from student where student_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Student student = new Student();
			student.setStudent_id(id);
			student.setStudent_name(rs.getString("student_name"));
			student.setSex(rs.getString("sex"));
			student.setAge(rs.getInt("age"));
			student.setSdept(rs.getString("sdept"));
			stmt.close();
			con.close();
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Student> findAllStudent() {
		ArrayList<Student> studentList = new ArrayList<Student>();
		String sql = "select * from student";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudent_id(rs.getString("student_id"));
				student.setStudent_name(rs.getString("student_name"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getInt("age"));
				student.setSdept(rs.getString("sdept"));
				studentList.add(student);
			}
			stmt.close();
			con.close();
			return studentList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean setStudent(Student student) {
		String sql = "update student set student_name=?,sex=?,age=?,sdept=? where student_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, student.getStudent_name());
			stmt.setString(2, student.getSex());
			stmt.setInt(3, student.getAge());
			stmt.setString(4, student.getSdept());
			stmt.setString(5, student.getStudent_id());
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
}
