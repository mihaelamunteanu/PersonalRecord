package com.codeprehend.medical.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.PatientsDAO;
import com.codeprehend.medical.database.InputValidation;
import com.codeprehend.medical.resources.Patient;


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
		
		Patient newPatient = new Patient();
		if (birthDateFiter != null && birthDateFiter.length() > 0){
			try {
				newPatient.setDataNasterii(LocalDate.parse(birthDateFiter));
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(mainWindow, "Data nasterii nu este corecta", 
						"Erore de Validare", JOptionPane.ERROR_MESSAGE);
				exception.printStackTrace();
				return;
			}
		}
		
		mainWindow.showPanelListOfPatients(PatientsDAO.getPatientsByFilter(name, firstName, cnpFilter, phoneNo, birthDateFiter));
	}
	
	
	// Verification if the wanted text fields are not empty and the format is correct: number date, telephone
	//TODO
	public boolean verifyTextFields(){
		return true;
	}
}