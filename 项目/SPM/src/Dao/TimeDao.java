package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Time;

public class TimeDao extends BaseDao{
	public String findTime(int id) {
		String time;
		String sql = "select time from time where time_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			time = rs.getString("time");
			stmt.close();
			con.close();
			return time;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Time> findAllTime() {
		ArrayList<Time> timeList = new ArrayList<Time>();
		String sql = "select * from time";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Time time = new Time();
				time.setId(rs.getInt("time_id"));
				time.setTime(rs.getString("time"));
				timeList.add(time);
			}
			stmt.close();
			con.close();
			return timeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
