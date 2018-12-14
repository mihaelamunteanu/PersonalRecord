package com.codeprehend.medical.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.PatientsDAO;

public class NewPatientButtonActionListener implements ActionListener {
	private MedicalRecordGUI mainWindow;
	
	public NewPatientButtonActionListener(MedicalRecordGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		//TODO validation of fields
		mainWindow.showNewPatientPanel();
		
	}
	
	// Verification if the wanted text fields are not empty and the format is correct: number date, telephone
	//TODO
	public boolean verifyTextFields(){
		return true;
	}
}
