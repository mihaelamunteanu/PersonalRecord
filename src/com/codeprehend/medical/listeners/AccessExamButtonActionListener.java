package com.codeprehend.medical.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.resources.Patient;

public class AccessExamButtonActionListener implements ActionListener {
	private MedicalRecordGUI mainWindow;
	private Patient patient; 
	
	public AccessExamButtonActionListener(MedicalRecordGUI mainWindow, Patient patient){
		this.mainWindow = mainWindow;
		this.patient = patient;
	}
	
	public void actionPerformed(ActionEvent e){
		//TODO validation of fields
		e.getSource();
		mainWindow.showExaminationPatientPanel(patient);
		
	}

}
