package com.codeprehend.medical.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.medical.MedicalRecordGUI;

public class BackFromExaminationPatientPanelButtonActionListener implements ActionListener {
	
private MedicalRecordGUI mainWindow;
	
	public BackFromExaminationPatientPanelButtonActionListener(MedicalRecordGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		mainWindow.showPanelListOfPatients();
		
	}
}
