package com.codeprehend.medical.resources;

import java.io.InputStream;
import java.time.LocalDate;

/**
 * 
 * Bean class to keep attachements per patient
 * 
 * @since 19th December 2018
 *
 */
public class Attachement {
	Long id;
	Long pacientId; 
	String fileName; 
	String fileType;
	Long fileLength;
	byte[] fileStream;
	LocalDate registrationDate; //use LocalDate instead java.sql.Date
	
	public Attachement( ) {
		
	}

	public Attachement(Long pacientId, String fileName, String fileType, 
			long fileLength, byte[] fileStream, LocalDate registrationDate) {
		this.pacientId = pacientId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileLength = fileLength;
		this.fileStream = fileStream;
		this.registrationDate = registrationDate;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPacientId() {
		return pacientId;
	}

	public void setPacientId(Long pacientId) {
		this.pacientId = pacientId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public Long getFileLength() {
		return fileLength;
	}

	public void setFileLength(Long fileLength) {
		this.fileLength = fileLength;
	}

	public byte[] getFileStream() {
		return fileStream;
	}

	public void setFileInputStream(byte[] fileStream) {
		this.fileStream = fileStream;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
}
