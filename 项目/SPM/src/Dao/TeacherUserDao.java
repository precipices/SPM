package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Data.TeacherUser;

public class TeacherUserDao extends BaseDao {
	// ���ͨ��֮�����
	public boolean addTeacherUser(TeacherUser teacher) {
		String sql = "insert into teacherUser values(?,?)";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, teacher.getTeacher_id());
			stmt.setString(2, teacher.getPassword());
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
		String sql = "select * from teacherUser where teacher_id=?";
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

	// ��ʦ��¼ʱ����
	public boolean checkUser(TeacherUser user) {
		String sql = "select * from teacherUser where teacher_id=? and password=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getTeacher_id());
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
