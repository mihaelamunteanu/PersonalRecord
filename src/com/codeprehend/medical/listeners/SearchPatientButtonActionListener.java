package com.codeprehend.medical.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.PatientsDAO;


public class SearchPatientButtonActionListener implements ActionListener {
	
	private MedicalRecordGUI mainWindow;
	
	public SearchPatientButtonActionListener(MedicalRecordGUI mainWindow){
		this.mainWindow = mainWindow;
	}

	public void actionPerformed(ActionEvent e){
		//TODO validation of fields
		String birthDateFiter = mainWindow.getSearchPatientPanel().getTextFieldDate().getText();
		String cnpFilter = mainWindow.getSearchPatientPanel().getTextFieldRegNumber().getText();
		String firstName = mainWindow.getSearchPatientPanel().getTextFieldFirstname().getText();
		String name = mainWindow.getSearchPatientPanel().getTextFieldName().getText();
		String phoneNo = mainWindow.getSearchPatientPanel().getTextFieldPhoneNumber().getText();
		mainWindow.showPanelListOfPatients(PatientsDAO.getPatientsByFilter(name, firstName, cnpFilter, phoneNo, birthDateFiter));
		
	}
	
	
	// Verification if the wanted text fields are not empty and the format is correct: number date, telephone
	//TODO
	public boolean verifyTextFields(){
		return true;
	}
}