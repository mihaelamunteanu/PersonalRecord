package com.codeprehend.medical.listeners;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.resources.Patient;

public class AccesFilesExaminationButtonActionListener {
	
	private MedicalRecordGUI mainWindow;
	private Patient patient; 
	
	public AccesFilesExaminationButtonActionListener(MedicalRecordGUI mainWindow, Patient patient){
		this.mainWindow = mainWindow;
		this.patient = patient;
		this.actionPerformed(); //e vina mea, am facut praf ActionListenerul ala, aveai dreptate
	}
	
	public void actionPerformed(){
		mainWindow.showFilesPatientPanel(patient);
	}
}
