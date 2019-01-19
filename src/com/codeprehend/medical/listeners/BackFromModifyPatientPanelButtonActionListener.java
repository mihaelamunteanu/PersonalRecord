package com.codeprehend.medical.listeners;

import java.util.List;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.ExaminationDAO;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Examination;
import com.codeprehend.medical.resources.Patient;

public class BackFromModifyPatientPanelButtonActionListener {
	
	public static void backButtonPressed(MedicalRecordGUI mainPanel, Patient patient, 
			List<Antecedent> antecedents){
		List<Examination> examinations = ExaminationDAO.getExaminationsByPatientId(patient.getId());
		mainPanel.showExaminationPatientPanel(patient, antecedents, examinations);
	}
}
