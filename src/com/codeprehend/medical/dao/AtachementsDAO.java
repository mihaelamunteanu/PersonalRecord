
package com.codeprehend.medical.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.codeprehend.medical.database.DatabaseConnection;
import com.codeprehend.medical.resources.Attachement;

public class AtachementsDAO {
	
	/**
	 * Method to save attachment into DB.
	 * 
	 * @param antecedent
	 * @return the generated id from sequence 
	 */
	public static Long saveAttachment(Attachement attachment) {
		Long generatedId = -1L;
		String SQL = "INSERT into atasamente "
				+ "(pacient_id, nume_fisier, tip_fisier, lungime_fisier, "
				+ "atasament, data_salvare) values (?,?,?,?,?,?);";
		
		System.out.println(" Attachment for pacient : " + SQL);
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmt.setObject(1, attachment.getPacientId());
			stmt.setObject(2, attachment.getFileName());
			stmt.setObject(3, attachment.getFileType());
			stmt.setObject(4, attachment.getFileLength());
			stmt.setBinaryStream(5, attachment.getFileInputStream());
			stmt.setObject(6, attachment.getRegistrationDate());
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs != null && stmt.getGeneratedKeys().next()) {
				generatedId = stmt.getGeneratedKeys().getLong(1);
			}
			
			attachment.getFileInputStream().close();
			rs.close();
 		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return generatedId;	
	}
	
	//TODO change to Date type instead String
	public static List<Attachement> getAttachmentsByPatientId(Long patientId) {
		List<Attachement> attachmentsForPatient = new ArrayList<Attachement>();
		String SQL = "SELECT * from  atasamente "
				+ "where pacient_id = ?; ";
		
		System.out.println(" Attachments for pacient : " + SQL);
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, patientId);
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				Attachement attachement = new Attachement(patientId, rs.getString("nume_fisier"),
						rs.getString("tip_fisier"), 0, null, 
						LocalDate.parse(rs.getString("data_salvare"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				attachement.setId(rs.getLong("id"));
				attachmentsForPatient.add(attachement);
			}
			rs.close();
 		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		/*
		 * PreparedStatement ps = conn.prepareStatement("SELECT img FROM images WHERE imgname = ?");
ps.setString(1, "myimage.gif");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    byte[] imgBytes = rs.getBytes(1);
    // use the data in some way here
}
rs.close();
ps.close();
		 */
		
		return attachmentsForPatient;	
	}
	
	//TODO change to Date type instead String
	public static Attachement getAttachmentsById(Long attachmentId) {
		Attachement attachmentById = null;
		String SQL = "SELECT * from  atasamente "
				+ "where id = ?; ";
		
		System.out.println(" Attachments for id : " + SQL);
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, attachmentId);
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				byte[] pdfAttachment = rs.getBytes("atasament");
				attachmentById = new Attachement(rs.getLong("pacient_id"), rs.getString("nume_fisier"),
						rs.getString("tip_fisier"), 0, new ByteArrayInputStream(pdfAttachment), 
						LocalDate.parse(rs.getString("data_salvare"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				attachmentById.setId(rs.getLong("id"));
			}
			rs.close();
 		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return attachmentById;
	}
}
