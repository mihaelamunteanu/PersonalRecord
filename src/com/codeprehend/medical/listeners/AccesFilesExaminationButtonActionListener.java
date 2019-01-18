package com.codeprehend.medical.listeners;

import java.util.List;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.AtachementsDAO;
import com.codeprehend.medical.resources.Attachement;
import com.codeprehend.medical.resources.Patient;

public class AccesFilesExaminationButtonActionListener {
	
	public static void actionPerformed(MedicalRecordGUI mainWindow, Patient patient){
		List<Attachement> attachements = AtachementsDAO.getAttachmentsByPatientId(patient.getId());
		mainWindow.showFilesPatientPanel(patient, attachements);
	}
}
