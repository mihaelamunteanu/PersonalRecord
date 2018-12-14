package com.codeprehend.medical.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeprehend.medical.database.DatabaseConnection;
import com.codeprehend.medical.resources.Patient;

public class PatientsDAO {
	/**
	 * Data Access Method to save a Patient into Database.
	 * 
	 * @param patient
	 * @return Integer - the id generated for the Patient
	 */
	public static Integer savePatient(Patient patient) {
		Integer generatedId = -1;
		String SQL = "INSERT into paciente "
				+ "(nume, prenume, data_nasterii, cnp, data_inscriere, "
				+ "nasteri_naturale, cezariene, avorturiLaCerere, avorturiSpontane, altele) "
				+ "values (" + patient.getNume() + "," + patient.getPrenume() + ", " 
				+ patient.getDataNasterii() + ", " + patient.getCnp() + ", " 
				+ patient.getPrimaConsultatie() + ", " + patient.getNasteriNaturale() + ", " 
				+ patient.getCezariene() + ", " + patient.getAvorturiLaCerere() + ", " 
				+ patient.getAvorturiSpontane() + ", " + patient.getAltele() + ")";
		
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
	public static List<Patient> getPatientsByBirthDate(String date) {
		List<Patient> patientsWithDate =new ArrayList<Patient>();

		String SQL = "SELECT id, nume, prenume, data_nasterii, cnp, data_inscriere, altele FROM paciente";

		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			// get the patient information
			while(rs.next()) {
				Patient pacient = new Patient(rs.getInt("id"), rs.getString("nume"),
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
		
//		pacient = new Pacient("Ailenei", "Tara", "2232323443411", 
//		new Date(2352345436L), 
//		new Date((new java.util.Date()).getTime()), "Museului  12, Galati");
//		patientWithDate.add(pacient);

		return patientsWithDate;
	}

}
