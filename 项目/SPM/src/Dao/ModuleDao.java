package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Module;

public class ModuleDao extends BaseDao {
	public String findModule(int id) {
		String module;
		String sql = "select module from module where module_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			module = rs.getString("module");
			stmt.close();
			con.close();
			return module;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Module> findAllModule() {
		ArrayList<Module> moduleList = new ArrayList<Module>();
		String sql = "select * from module";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Module module = new Module();
				module.setId(rs.getInt("module_id"));
				module.setModule(rs.getString("module"));
				moduleList.add(module);
			}
			stmt.close();
			con.close();
			return moduleList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
