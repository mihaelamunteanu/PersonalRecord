package com.codeprehend.medical.listeners;

import java.util.List;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Examination;
import com.codeprehend.medical.resources.Patient;

public class BackFromModifyPatientPanelButtonActionListener {
	public static void backButtonPressed(MedicalRecordGUI mainPanel, Patient patient, 
			List<Antecedent> antecedents, List<Examination> examinations){
		//TODO validation of fields
		mainPanel.showExaminationPatientPanel(patient, antecedents, examinations);
	}
	
	// Verification if the wanted text fields are not empty and the format is correct: number date, telephone
	//TODO
	public boolean verifyTextFields(){
		return true;
	}
}
