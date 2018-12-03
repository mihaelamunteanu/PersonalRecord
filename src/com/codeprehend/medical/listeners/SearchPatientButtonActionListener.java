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
		mainWindow.showPanelListOfPatients(PatientsDAO.getPatientsByBirthDate(
				mainWindow.getSearchPatientPanel().getTextFieldDate().getSelectedText()));
		
	}
	
	
	// Verification if the wanted text fields are not empty TODO
	public boolean verifyTextFields(){
		return true;
	}
}