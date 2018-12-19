package com.codeprehend.medical.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeprehend.medical.database.DatabaseConnection;
import com.codeprehend.medical.resources.Antecedent;

public class AntecedentsDAO {
	/**
	 * Method to save antecedent into DB.
	 * 
	 * @param antecedent
	 * @return the generated id from sequence 
	 */
	public static Long saveAntecedente(Antecedent antecedent) {
		Long generatedId = -1L;
		String SQL = "INSERT into antecedente "
				+ "(pacient_id, antecedent, data_inregistrare) "
				+ "values (?,?,?);";
		
		System.out.println(" Antecendent for pacient : " + SQL);
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmt.setObject(1, antecedent.getPacientId());
			stmt.setObject(2, antecedent.getAntecedentText());
			stmt.setObject(3, antecedent.getRegistrationDate());
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs != null && stmt.getGeneratedKeys().next()) {
				generatedId = stmt.getGeneratedKeys().getLong(1);
			}
 		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return generatedId;	
	}
	
}
