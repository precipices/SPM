package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Data.StudentUser;

public class StudentUserDao extends BaseDao {
	// ѧ��ע��ʱ����
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

	// ���ע��ʱ�û����Ƿ��ظ�
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

	// ѧ����¼ʱ����
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
