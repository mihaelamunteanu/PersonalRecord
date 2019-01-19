package com.codeprehend.medical.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codeprehend.medical.resources.CabinetData;
import com.codeprehend.medical.util.DatabaseConnection;

public class CabinetDataDAO {
	private static final Logger LOGGER = Logger.getLogger(CabinetDataDAO.class.getName());
	
	public static CabinetData getCabinetData() {
		CabinetData cabinetData = null;
		String SQL = "SELECT * FROM cabinet ORDER BY data_modificare DESC LIMIT 1";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				cabinetData = new CabinetData(rs.getString("nume"), rs.getString("adresa"), 
						rs.getString("telefon"), rs.getString("folder_salvare"));
			}
			rs.close();
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE, ex.getMessage());
			ex.printStackTrace();
		}

		return cabinetData;
	}

}
