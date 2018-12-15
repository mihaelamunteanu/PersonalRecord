package com.codeprehend.medical.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.PatientsDAO;
import com.codeprehend.medical.resources.Patient;

public class SaveNewPatientButtonActionListener implements ActionListener {
	
	private MedicalRecordGUI mainWindow;
	
	public SaveNewPatientButtonActionListener(MedicalRecordGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		//TODO validation of fields
		String name = mainWindow.getNewPatientPanel().getTextFieldName().getText();
		String firstName = mainWindow.getNewPatientPanel().getTextFieldFirstName().getText();
		String birthDate = mainWindow.getNewPatientPanel().getTextFieldDate().getText();
		String phoneNumber = mainWindow.getNewPatientPanel().getTextFieldPhoneNumber().getText();
		String regNumber = mainWindow.getNewPatientPanel().getTextFieldRegNumber().getText();
		int naturalBirths = Integer.valueOf(mainWindow.getNewPatientPanel().getTextFieldNaturalBirthsNumber().getText());
		int csectionBirths = Integer.valueOf(mainWindow.getNewPatientPanel().getTextFieldcSectionBirthNumber().getText());
		int requestedAborstions = Integer.valueOf(mainWindow.getNewPatientPanel().getTextFieldRequestedAbortionNumber().getText());
		int spontaneusAbortions = Integer.valueOf(mainWindow.getNewPatientPanel().getTextFieldSpotaneousAbortionNumber().getText());
		
		String altele = "Not used";
		String address = "Not needed";
		//save the Patient
		Patient newPatient = new Patient();
		newPatient.setNume(name);
		newPatient.setPrenume(firstName);
		newPatient.setDataNasterii(new Date(100000000000L));
		newPatient.setCnp(regNumber);
		newPatient.setPrimaConsultatie(LocalDate.now());
		newPatient.setAdresa(address);
		newPatient.setNumarTelefon(phoneNumber);
		newPatient.setAltele(altele);
		newPatient.setNasteriNaturale(naturalBirths);
		newPatient.setCezariene(csectionBirths);
		newPatient.setAvorturiLaCerere(requestedAborstions);
		newPatient.setAvorturiSpontane(spontaneusAbortions);

		
		PatientsDAO.savePatient(newPatient);
//		mainWindow.showCurrentDiagnosisPanel(mainWindow.getNewPatientPanel()    );
		 
	}
	
	
	// Verification if the wanted text fields are not empty and the format is correct: number date, telephone
	//TODO
	public boolean verifyTextFields(){
		return true;
	}

}
