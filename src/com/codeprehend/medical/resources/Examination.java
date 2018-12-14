package com.codeprehend.medical.resources;

import java.sql.Date;

/**
 * Class to define a consulation (from chitanta)
 * 
 * @since 30th of September 2015
 * @author Gabriel Munteanu
  *
 */
public class Examination {
	
	private Integer id; 
	
	/**
	 * Consultation date
	 */
	private Date consultationDate;
	
	/**
	 * Client id that has the consultation.
	 */
	private Integer patientId;
	
	/**
	 * Consultation's text
	 */
	private String text;
	
	/** 
	 * Field to be used if the doctor wants to have information that is not printed. 
	 */
	private String otherObservations;
	
	//TODO add attachments BLOBs
	private String attachments; 
	
	/**
	 * Empty default constructor 
	 */
	public Examination(){
		
	}
	
	/**
	 * Constructor with parameters to set all the variables
	 */
	public Examination(int id, Integer patientId, String text, 
			Date consultationDate, String otherObservations){
		this.id = id;
		this.patientId = patientId;
		this.text = text;
		this.consultationDate = consultationDate;
		this.otherObservations = otherObservations;
	}

	public Date getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(Date consultationDate) {
		this.consultationDate = consultationDate;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public Integer getId() {
		return id;
	}

	public String getOtherObservations() {
		return otherObservations;
	}

	public void setOtherObservations(String otherObservations) {
		this.otherObservations = otherObservations;
	}
}