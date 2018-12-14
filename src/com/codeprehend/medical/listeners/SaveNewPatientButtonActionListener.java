package com.codeprehend.medical.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.PatientsDAO;
import com.codeprehend.medical.resources.Patient;

public class SaveNewPatientButtonActionListener implements ActionListener {
	
	private MedicalRecordGUI mainWindow;
	
	public SaveNewPatientButtonActionListener(MedicalRecordGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		//TODO validation of fields
		//save the Patient
		Patient newPatient = new Patient();
		PatientsDAO.savePatient(newPatient);
//		mainWindow.showCurrentDiagnosisPanel(mainWindow.getNewPatientPanel()    );
		 
	}
	
	
	// Verification if the wanted text fields are not empty and the format is correct: number date, telephone
	//TODO
	public boolean verifyTextFields(){
		return true;
	}

}
