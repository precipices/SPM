package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.TeacherUser;

public class TeacherTempDao extends BaseDao {
	// 教师注册时调用
	public boolean addTeacherTemp(TeacherUser teacher) {
		String sql = "insert into teacherTemp values(?,?,?)";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, teacher.getTeacher_id());
			stmt.setString(2, teacher.getPassword());
			stmt.setString(3, teacher.getTeacher_name());
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

	// 管理员审核通过之后调用
	public TeacherUser findOneTeacherTemp(String teacher_id) {
		TeacherUser teacher = new TeacherUser();
		String sql = "select * from teacherTemp where teacher_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, teacher_id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			teacher.setTeacher_id(rs.getString("teacher_id"));
			teacher.setPassword(rs.getString("password"));
			teacher.setTeacher_name(rs.getString("teacher_name"));
			stmt.close();
			con.close();
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 显示管理员审核页面时调用
	public ArrayList<TeacherUser> findAllTeacherTemp() {
		ArrayList<TeacherUser> teacherList = new ArrayList<TeacherUser>();
		String sql = "select teacher_id,teacher_name from teacherTemp";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TeacherUser teacher = new TeacherUser();
				teacher.setTeacher_id(rs.getString("teacher_id"));
				teacher.setTeacher_name(rs.getString("teacher_name"));
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

	// 审核通过或拒绝时调用
	public boolean deleteTeacherTemp(String teacher_id) {
		String sql = "delete from teacherTemp where teacher_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, teacher_id);
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
