package com.codeprehend.medical.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.PatientsDAO;
import com.codeprehend.medical.database.InputValidation;


public class SearchPatientButtonActionListener implements ActionListener {
	
	private MedicalRecordGUI mainWindow;
	
	public SearchPatientButtonActionListener(MedicalRecordGUI window){
		this.mainWindow = window;
	}

	public void actionPerformed(ActionEvent event){
		
		String birthDateFiter = mainWindow.getSearchPatientPanel().getTextFieldDate().getText();
		String cnpFilter = mainWindow.getSearchPatientPanel().getTextFieldRegNumber().getText();
		String firstName = mainWindow.getSearchPatientPanel().getTextFieldFirstname().getText();
		String name = mainWindow.getSearchPatientPanel().getTextFieldName().getText();
		String phoneNo = mainWindow.getSearchPatientPanel().getTextFieldPhoneNumber().getText();
		
		try {
			InputValidation.validateTextField(name);
			InputValidation.validateTextField(firstName);
			InputValidation.validatePhoneNumber(phoneNo);
			InputValidation.validateRegNumber(cnpFilter);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
					"Erore de Validare", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
			return;
		}
		mainWindow.showPanelListOfPatients(PatientsDAO.getPatientsByFilter(name, firstName, cnpFilter, phoneNo, birthDateFiter));
	}
	
	
	// Verification if the wanted text fields are not empty and the format is correct: number date, telephone
	//TODO
	public boolean verifyTextFields(){
		return true;
	}
}