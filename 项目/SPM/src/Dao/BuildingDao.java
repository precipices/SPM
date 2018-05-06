package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Building;

public class BuildingDao extends BaseDao{
	public String findBuilding(int id) {
		String building;
		String sql = "select building from building where building_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			building = rs.getString("building");
			stmt.close();
			con.close();
			return building;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Building> findAllBuilding() {
		ArrayList<Building> buildingList = new ArrayList<Building>();
		String sql = "select * from building";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Building building = new Building();
				building.setId(rs.getInt("building_id"));
				building.setBuilding(rs.getString("building"));
				buildingList.add(building);
			}
			stmt.close();
			con.close();
			return buildingList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
