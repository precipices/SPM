package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Student;
import Data.Teacher;
import Data.TeacherUser;

public class TeacherDao extends BaseDao {
	// 审核通过之后调用
	public boolean addTeacher(TeacherUser teacher) {
		String sql = "insert into teacher(teacher_id,teacher_name) values(?,?)";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, teacher.getTeacher_id());
			stmt.setString(2, teacher.getTeacher_name());
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

	public String findTeacher_name(String id) {
		String teacher;
		String sql = "select teacher_name from teacher where teacher_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			teacher = rs.getString("teacher_name");
			stmt.close();
			con.close();
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Teacher findOneTeacher(String id) {
		String sql = "select * from teacher where teacher_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Teacher teacher = new Teacher();
			teacher.setTeacher_id(id);
			teacher.setTeacher_name(rs.getString("teacher_name"));
			teacher.setSex(rs.getString("sex"));
			teacher.setAge(rs.getInt("age"));
			stmt.close();
			con.close();
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Teacher> findAllTeacher() {
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		String sql = "select * from teacher";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacher_id(rs.getString("teacher_id"));
				teacher.setTeacher_name(rs.getString("teacher_name"));
				teacher.setSex(rs.getString("sex"));
				teacher.setAge(rs.getInt("age"));
				teacherList.add(teacher);
			}
			stmt.close();
			con.close();
			return teacherList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 教师修改个人信息时调用
	public boolean setTeacher(Teacher teacher) {
		String sql = "update teacher set sex=?,age=? where teacher_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, teacher.getSex());
			stmt.setInt(2, teacher.getAge());
			stmt.setString(3, teacher.getTeacher_id());
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
