package com.codeprehend.medical.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public static Integer saveExamination(Examination exam) {
		Integer generatedId = -1;
		String SQL = "INSERT into consultatie "
				+ "(id_pacienta, data_consultatie, consultatie, alte_observatii) "
				+ "values (" + exam.getPatientId() + "," + exam.getConsultationDate() + ", "
				+ exam.getText() + "," + exam.getOtherObservations() + ");";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			if (rs.next()) {
				generatedId = rs.getInt("id");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return generatedId;
	}
	
	
	//TODO change to Date type instead String
	public static List<Examination> getExaminationsByPatientId(Integer id) {
		List<Examination> examinationsForPatient =new ArrayList<Examination>();

		String SQL = "SELECT id, consultatie, data_dosar FROM dosare";

		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			// get the patient information
			while(rs.next()) {
				Examination exam = new Examination(rs.getInt("id"), id, rs.getString("consultatie"), 
						rs.getDate("data_consultatie"), rs.getString("alte_observatii"));
				examinationsForPatient.add(exam);	
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return examinationsForPatient;
	}

}
