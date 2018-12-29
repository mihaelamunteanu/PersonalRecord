package com.codeprehend.medical.resources;

import java.time.LocalDate;

/**
 * 
 * Bean class to keep antecedent data per pacient
 * 
 * @since 19th December 2018
 *
 */
public class Antecedent {
	Long id;
	Long pacientId; 
	String antecedentText; 
	LocalDate registrationDate; //use LocalDate instead java.sql.Date
	
	public Antecedent( ) {
		
	}

	public Antecedent(Long pacientId, String antecedent, LocalDate registrationDate) {
		this.pacientId = pacientId;
		this.antecedentText = antecedent; 
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

	public String getAntecedentText() {
		return antecedentText;
	}

	public void setAntecedentText(String antecedentText) {
		this.antecedentText = antecedentText;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
}
