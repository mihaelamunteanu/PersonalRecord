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
		//TODO to get Attachements
		/*Patient newPatient = PatientsDAO.getPatientById(patient.getId());
		List<Antecedent> antecedents = AntecedentsDAO.getAntecedentsByPatientId(patient.getId());
		List<Examination> examinations = ExaminationDAO.getExaminationsByPatientId(patient.getId());*/
		
		mainWindow.showFilesPatientPanel(patient);
		
	}
}
