package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Day;

public class DayDao extends BaseDao {
	public String findDay(int id) {
		String day;
		String sql = "select day from day where day_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			day = rs.getString("day");
			stmt.close();
			con.close();
			return day;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Day> findAllDay() {
		ArrayList<Day> dayList = new ArrayList<Day>();
		String sql = "select * from day";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Day day = new Day();
				day.setId(rs.getInt("day_id"));
				day.setDay(rs.getString("day"));
				dayList.add(day);
			}
			stmt.close();
			con.close();
			return dayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
