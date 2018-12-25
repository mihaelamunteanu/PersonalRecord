package com.codeprehend.medical.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.AntecedentsDAO;
import com.codeprehend.medical.database.InputValidation;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Patient;


public class ModifyPatientButtonActionListener implements ActionListener {
	
	private MedicalRecordGUI mainWindow;
	private Patient patient;
	
	public ModifyPatientButtonActionListener(MedicalRecordGUI mainWindow, Patient patient){
		this.mainWindow = mainWindow;
		this.patient = patient;
	}

	public void actionPerformed(ActionEvent event){
		
		Long pacientId = patient.getId();
		String cnpFilter = mainWindow.getSearchPatientPanel().getTextFieldRegNumber().getText();
		String firstName = mainWindow.getSearchPatientPanel().getTextFieldFirstname().getText();
		String name = mainWindow.getSearchPatientPanel().getTextFieldName().getText();
		String phoneNo = mainWindow.getSearchPatientPanel().getTextFieldPhoneNumber().getText();
		
		try {
			InputValidation.validateTextField(name);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
					"Erore de Validare", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
			return;
		}
		List<Antecedent> antecedents = AntecedentsDAO.getAntecedentsByPatientId(pacientId);
		mainWindow.showModifyPatientPanel(antecedents);
	}
	
	
	// Verification if the wanted text fields are not empty and the format is correct: number date, telephone
	//TODO
	public boolean verifyTextFields(){
		return true;
	}
}