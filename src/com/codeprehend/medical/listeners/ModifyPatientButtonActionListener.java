package com.codeprehend.medical.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.AntecedentsDAO;
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
		List<Antecedent> antecedents = AntecedentsDAO.getAntecedentsByPatientId(pacientId);
		mainWindow.showModifyPatientPanel(patient, antecedents);
	}

}