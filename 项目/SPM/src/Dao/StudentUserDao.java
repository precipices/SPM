package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Data.StudentUser;

public class StudentUserDao extends BaseDao {
	// 学生注册时调用
	public boolean addStudentUser(StudentUser student) {
		String sql = "insert into studentUser values(?,?)";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, student.getStudent_id());
			stmt.setString(2, student.getPassword());
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

	// 检查注册时用户名是否重复
	public boolean usernameRepeat(String username) {
		String sql = "select * from studentUser where student_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				stmt.close();
				con.close();
				return false;
			}
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// 学生登录时调用
	public boolean checkUser(StudentUser user) {
		String sql = "select * from studentUser where student_id=? and password=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getStudent_id());
			stmt.setString(2, user.getPassword());
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				stmt.close();
				con.close();
				return false;
			}
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
