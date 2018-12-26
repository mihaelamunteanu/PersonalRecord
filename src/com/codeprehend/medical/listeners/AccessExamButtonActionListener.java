package com.codeprehend.medical.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.AntecedentsDAO;
import com.codeprehend.medical.dao.ExaminationDAO;
import com.codeprehend.medical.dao.PatientsDAO;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Examination;
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
		Patient newPatient = PatientsDAO.getPatientById(patient.getId());
		List<Antecedent> antecedents = AntecedentsDAO.getAntecedentsByPatientId(patient.getId());
		List<Examination> examinations = ExaminationDAO.getExaminationsByPatientId(patient.getId());
		
		mainWindow.showExaminationPatientPanel(newPatient, antecedents, examinations);
		
	}

}
