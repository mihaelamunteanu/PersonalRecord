package com.codeprehend.medical.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.codeprehend.medical.database.DatabaseConnection;
import com.codeprehend.medical.resources.Examination;;

public class ExaminationDAO {
	/**
	 * Return the generated id from sequence. 
	 * @param exam
	 * @return generated id from sequence for consultatie table. if an error occurs returns -1.
	 */
	public static Long saveExamination(Examination exam) {
		Long generatedId = -1L;
		String SQL = "INSERT into consultatii "
				+ "(id_pacienta, data_consultatie, consultatie, alte_observatii) "
				+ "values (?, ?, ?, ?);";
		
		
		System.out.println(" Insert exam for patient : " + SQL);
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL,  PreparedStatement.RETURN_GENERATED_KEYS)) {
			stmt.setObject(1, exam.getPatientId());
			stmt.setObject(2, exam.getConsultationDate());
			stmt.setObject(3, exam.getText());
			stmt.setObject(4, exam.getOtherObservations());
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs != null && stmt.getGeneratedKeys().next()) {
				generatedId = stmt.getGeneratedKeys().getLong(1);
			}
			rs.close();
 		} catch (SQLException ex) {
 			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		
		return generatedId;	
	}
	
	
	//TODO change to Date type instead String
	public static List<Examination> getExaminationsByPatientId(Long id) {
		List<Examination> examinationsForPatient =new ArrayList<Examination>();

		String SQL = "SELECT * FROM consultatii WHERE id_pacienta = ?";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, id);
			
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				Examination examination = new Examination(rs.getLong("id"), id, rs.getString("consultatie"), 
						LocalDate.parse(rs.getString("data_consultatie"), DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
						rs.getString("alte_observatii"));
				examinationsForPatient.add(examination);
			}
			rs.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return examinationsForPatient;
	}

}
