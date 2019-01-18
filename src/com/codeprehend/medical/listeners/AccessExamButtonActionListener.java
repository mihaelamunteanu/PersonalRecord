package com.codeprehend.medical.listeners;

import java.util.List;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.AntecedentsDAO;
import com.codeprehend.medical.dao.ExaminationDAO;
import com.codeprehend.medical.dao.PatientsDAO;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Examination;
import com.codeprehend.medical.resources.Patient;

public class AccessExamButtonActionListener  {
	
	public static void actionPerformed(MedicalRecordGUI mainWindow, Patient patient){
		Patient newPatient = PatientsDAO.getPatientById(patient.getId());
		List<Antecedent> antecedents = AntecedentsDAO.getAntecedentsByPatientId(patient.getId());
		List<Examination> examinations = ExaminationDAO.getExaminationsByPatientId(patient.getId());
		
		mainWindow.showExaminationPatientPanel(newPatient, antecedents, examinations);
		
	}

}
