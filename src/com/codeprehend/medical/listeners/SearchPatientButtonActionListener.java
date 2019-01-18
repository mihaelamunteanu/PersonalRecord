package com.codeprehend.medical.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.PatientsDAO;
import com.codeprehend.medical.util.InputValidation;
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
			if (name != null && !name.isEmpty()) InputValidation.validateTextField(name);
			if (firstName != null && !firstName.isEmpty()) InputValidation.validateTextField(firstName);
			if (phoneNo != null && !phoneNo.isEmpty()) InputValidation.validatePhoneNumber(phoneNo);
			if (cnpFilter != null && !cnpFilter.isEmpty()) InputValidation.validateRegNumber(cnpFilter);
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
}