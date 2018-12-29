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
import com.codeprehend.medical.resources.Patient;

public class PatientsDAO {
	
	//TODO throws Exception for all and add Message Dialog Boxes to know what was wrong
	public static Patient getPatientById(Long patientId) {
		Patient pacient = null;
		String SQL = "SELECT * FROM paciente WHERE id = ?";
		
		System.out.println(" Select Patient by patient id : " + SQL);
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, patientId);
			
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				pacient = new Patient(rs.getLong("id"), rs.getString("nume"),
						rs.getString("prenume"), rs.getString("cnp"), LocalDate.parse(rs.getString("data_nasterii")), 
						LocalDate.parse(rs.getString("data_inscriere")), rs.getString("altele"), null);
//				pacient.setAdresa(rs.getString("adresa")); TODO Add address
				pacient.setNumarTelefon(rs.getString("telefon"));
				pacient.setNasteriNaturale(rs.getInt("nasteri_naturale"));
				pacient.setCezariene(rs.getInt("cezariene"));
				pacient.setAvorturiLaCerere(rs.getInt("avorturi_cerere"));
				pacient.setAvorturiSpontane(rs.getInt("avorturi_spontane"));
				rs.close();
			}
 		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return pacient;
	}
	
	public static Long updatePatient(Patient patient) throws Exception {
		String SQL = "UPDATE paciente " + 
				"SET nume = ?, prenume = ?, data_nasterii = ?, cnp = ?, telefon = ?, "
				+ "nasteri_naturale = ?, cezariene = ?, avorturi_cerere = ?, avorturi_spontane = ? " + 
				"WHERE id = ?;";
		
		System.out.println(" Update patient : " + SQL);
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmt.setObject(1, patient.getNume());
			stmt.setObject(2, patient.getPrenume());
			stmt.setObject(3, patient.getDataNasterii());
			stmt.setObject(4, patient.getCnp());
			stmt.setObject(5, patient.getNumarTelefon());
			stmt.setObject(6, patient.getNasteriNaturale());
			stmt.setObject(7, patient.getCezariene());
			stmt.setObject(8, patient.getAvorturiLaCerere());
			stmt.setObject(9, patient.getAvorturiSpontane());
			stmt.setObject(10, patient.getId());
						
			stmt.executeUpdate();
 		} 
		
		return patient.getId();
	}
	
	/**
	 * Data Access Method to save a Patient into Database.
	 * 
	 * @param patient
	 * @return Integer - the id generated for the Patient
	 */
	public static Long savePatient(Patient patient) {
		Long generatedId = -1L;
		String SQL = "INSERT into paciente "
				+ "(nume, prenume, data_nasterii, cnp, data_inscriere, telefon, "
				+ "nasteri_naturale, cezariene, avorturi_cerere, avorturi_spontane, altele) "
				+ "values ('" + patient.getNume() + "','" + patient.getPrenume() + "', '" 
				+ patient.getDataNasterii() + "', '" + patient.getCnp() + "', '" 
				+ Date.valueOf(patient.getPrimaConsultatie()) + "', " + patient.getNumarTelefon() + ", " + 
				+ patient.getNasteriNaturale() + ", " 
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
			rs.close();
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
						rs.getString("prenume"), rs.getString("cnp"), LocalDate.parse(rs.getString("data_nasterii")), 
						LocalDate.parse(rs.getString("data_inscriere")), rs.getString("altele"), null);
				
				patientsWithDate.add(pacient);	
			}
			rs.close();
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
			whereClauseBuilder.append(filterName + " = '" + LocalDate.parse(filter, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "'");
			nextAndNeeded = true;
		} else if (andNeeded) {
			nextAndNeeded = true;
		}
		
		return nextAndNeeded;
	}
}
