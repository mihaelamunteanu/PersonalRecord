package com.codeprehend.medical.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.medical.MedicalRecordGUI;

public class GoHomeFromExaminationPatientButtonListener implements ActionListener{
	
	private MedicalRecordGUI mainWindow;
	
	public GoHomeFromExaminationPatientButtonListener(MedicalRecordGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		mainWindow.showSearchPatientPanel();
		
	}
}
