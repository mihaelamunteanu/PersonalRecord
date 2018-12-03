package com.codeprehend.medical;

import com.codeprehend.medical.resources.Pacient;

/** 
 * Separate class to keep the data for the Panels
 * 
 * @author Mihaela Munteanu
 * @date 12 Dec 2018
 *
 */
public class MedicalRecordSnapshot {
	
	private String searchDate;
	private String searchName;
	private Pacient currentPatient;
	
	public String getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public Pacient getCurrentPatient() {
		return currentPatient;
	}
	public void setCurrentPatient(Pacient currentPatient) {
		this.currentPatient = currentPatient;
	}
}
