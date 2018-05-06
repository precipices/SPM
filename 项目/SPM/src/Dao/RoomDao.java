package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Room;

public class RoomDao extends BaseDao{
	public String findRoom(int id) {
		String room;
		String sql = "select room from room where room_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			room = rs.getString("room");
			stmt.close();
			con.close();
			return room;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Room> findAllRoom() {
		ArrayList<Room> roomList = new ArrayList<Room>();
		String sql = "select * from room";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Room room = new Room();
				room.setId(rs.getInt("room_id"));
				room.setRoom(rs.getString("room"));
				roomList.add(room);
			}
			stmt.close();
			con.close();
			return roomList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
