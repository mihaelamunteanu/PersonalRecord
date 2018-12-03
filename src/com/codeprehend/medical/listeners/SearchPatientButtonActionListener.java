package com.codeprehend.medical.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.PatientsDAO;


public class SearchPatientButtonActionListener implements ActionListener{
	
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

//		
//		if(mainWindow.getTextFieldValue().getText().equals("") || mainWindow.getTextFieldValue().getText().substring(0, 1).equals(" ")){
//			JOptionPane.showMessageDialog(mainWindow, "Introduceti valoarea!", "Error", JOptionPane.ERROR_MESSAGE);
//			return false;
//		}
//		
//		if(mainWindow.getTextFieldNoFact().getText().equals("") || mainWindow.getTextFieldNoFact().getText().substring(0, 1).equals(" ")){
//			JOptionPane.showMessageDialog(mainWindow, "Introduceti numarul facturii!", "Error", JOptionPane.ERROR_MESSAGE);
//			return false;
//		}
		

		
		return true;
	}
}