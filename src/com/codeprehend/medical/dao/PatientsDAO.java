package com.codeprehend.medical.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeprehend.medical.database.DatabaseConnection;
import com.codeprehend.medical.resources.Pacient;

public class PatientsDAO {

	//TODO change to Date type instead String
	public static List<Pacient> getPatientsByBirthDate(String date) {
		List<Pacient> patientsWithDate =new ArrayList<Pacient>();

		String SQL = "SELECT id, nume, prenume, data_nasterii, cnp, data_inscriere, altele FROM paciente";

		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			// get the patient information
			while(rs.next()) {
				Pacient pacient = new Pacient(rs.getInt("id"), rs.getString("nume"),
						rs.getString("prenume"), rs.getString("cnp"), rs.getDate("data_nasterii"), 
						rs.getDate("data_inscriere"), rs.getString("altele"), null);
				patientsWithDate.add(pacient);	
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

//		//Make mocks with Spring? and remove when added call to DB
//		pacient = new Pacient("Adam", "Luca", "2232323443411", 
//				new Date(2352345436L), 
//				new Date((new java.util.Date()).getTime()), "Museului  12, Galati");
//		patientWithDate.add(pacient);

		return patientsWithDate;
	}

}
