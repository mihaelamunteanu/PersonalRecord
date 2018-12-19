package com.codeprehend.medical.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.codeprehend.medical.database.DatabaseConnection;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Patient;

public class PatientsDAO {
	/**
	 * Data Access Method to save a Patient into Database.
	 * 
	 * @param patient
	 * @return Integer - the id generated for the Patient
	 */
	public static Long savePatient(Patient patient) {
		Long generatedId = -1L;
		String SQL = "INSERT into paciente "
				+ "(nume, prenume, data_nasterii, cnp, data_inscriere, "
				+ "nasteri_naturale, cezariene, avorturi_cerere, avorturi_spontane, altele) "
				+ "values ('" + patient.getNume() + "','" + patient.getPrenume() + "', '" 
				+ patient.getDataNasterii() + "', '" + patient.getCnp() + "', '" 
				+ Date.valueOf(patient.getPrimaConsultatie()) + "', " + patient.getNasteriNaturale() + ", " 
				+ patient.getCezariene() + ", " + patient.getAvorturiLaCerere() + ", " 
				+ patient.getAvorturiSpontane() + ", '" + patient.getAltele() + "');";
		
		System.out.println(" New patient: " + SQL);
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(SQL, new String[] {"id"});
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs != null && stmt.getGeneratedKeys().next()) {
				generatedId = stmt.getGeneratedKeys().getLong(1);
			}
 		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return generatedId;
	}

	//TODO change to Date type instead String
	public static List<Patient> getPatientsByFilter(String name, String firstname, String cnp, String phoneNo, String birthDate) {
		List<Patient> patientsWithDate =new ArrayList<Patient>();
		StringBuilder filterBuilder = new StringBuilder();
		

		boolean nextAndNeeded = addWhereClause("nume", name, filterBuilder, false);
		nextAndNeeded = addWhereClause("prenume", firstname, filterBuilder, nextAndNeeded);
		nextAndNeeded = addWhereClause("cnp", cnp, filterBuilder, nextAndNeeded);
		nextAndNeeded = addWhereClause("telefon", phoneNo, filterBuilder, nextAndNeeded);
		nextAndNeeded = addWhereClauseForDate("data_nasterii", birthDate, filterBuilder, nextAndNeeded);
		filterBuilder.append(";");
		
		String SQL = "SELECT id, nume, prenume, data_nasterii, cnp, data_inscriere, altele FROM paciente " + filterBuilder.toString();
//				+ "WHERE data_nasterii='" + 
//				LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd")) + "';";
		System.out.println(" Searching patient: " + SQL);
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			// get the patient information
			while(rs.next()) {
				Patient pacient = new Patient(rs.getLong("id"), rs.getString("nume"),
						rs.getString("prenume"), rs.getString("cnp"), rs.getDate("data_nasterii"), 
						LocalDate.parse(rs.getString("data_inscriere")), rs.getString("altele"), null);
				
				patientsWithDate.add(pacient);	
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return patientsWithDate;
	}
	
	/**
	 * Method to add filters to where
	 * For example for ("name", "Astanei", empty, true) the return will be true 
	 * which means an ' AND ' has to be added for the next filters and 
	 * the StringBuilder object will have the value: " AND name='Astanei' "
	 * 
	 * @param filterName
	 * @param filter
	 * @param whereClauseBuilder
	 * @param andNeeded
	 * @return
	 */
	private static boolean addWhereClause(String filterName, String filter, StringBuilder whereClauseBuilder, boolean andNeeded) {
		boolean nextAndNeeded = false;
		if (filter !=  null && filter.length() > 0) {
			if (andNeeded) whereClauseBuilder.append(" AND ");
			else whereClauseBuilder.append(" WHERE ");
			whereClauseBuilder.append(filterName + " = '" + filter + "'");
			nextAndNeeded = true;
		} else if (andNeeded) {
			nextAndNeeded = true;
		}
		
		return nextAndNeeded;
	}

	private static boolean addWhereClauseForDate(String filterName, String filter, StringBuilder whereClauseBuilder, boolean andNeeded) {
		boolean nextAndNeeded = false;
		if (filter !=  null && filter.length() > 0) {
			if (andNeeded) whereClauseBuilder.append(" AND ");
			else whereClauseBuilder.append(" WHERE ");
			whereClauseBuilder.append(filterName + " = '" + LocalDate.parse(filter, DateTimeFormatter.ofPattern("yyyy/MM/dd")) + "'");
			nextAndNeeded = true;
		} else if (andNeeded) {
			nextAndNeeded = true;
		}
		
		return nextAndNeeded;
	}
}
