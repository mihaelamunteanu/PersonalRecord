package com.codeprehend.medical.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.AntecedentsDAO;
import com.codeprehend.medical.dao.PatientsDAO;
import com.codeprehend.medical.database.InputValidation;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Examination;
import com.codeprehend.medical.resources.Patient;

public class SaveNewPatientButtonActionListener implements ActionListener {
	
	private MedicalRecordGUI mainWindow;
	
	public SaveNewPatientButtonActionListener(MedicalRecordGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = mainWindow.getNewPatientPanel().getTextFieldName().getText();
		String firstName = mainWindow.getNewPatientPanel().getTextFieldFirstName().getText();
		String birthDate = mainWindow.getNewPatientPanel().getTextFieldDate().getText();
		String phoneNumber = mainWindow.getNewPatientPanel().getTextFieldPhoneNumber().getText();
		String regNumber = mainWindow.getNewPatientPanel().getTextFieldRegNumber().getText();
		String naturalBirths = mainWindow.getNewPatientPanel().getTextFieldNaturalBirthsNumber().getText();
		String csectionBirths = mainWindow.getNewPatientPanel().getTextFieldcSectionBirthNumber().getText();
		String requestedAborstions = mainWindow.getNewPatientPanel().getTextFieldRequestedAbortionNumber().getText();
		String spontaneusAbortions = mainWindow.getNewPatientPanel().getTextFieldSpotaneousAbortionNumber().getText();
		
		String altele = "Not used";
		String address = "Not needed";
		
		String antecedents = mainWindow.getNewPatientPanel().getTextAreaAntecedents().getText();
		
		validateFields(naturalBirths, csectionBirths, requestedAborstions, spontaneusAbortions);
		
		//save the Patient
		Patient newPatient = new Patient();
		newPatient.setNume(name);
		newPatient.setPrenume(firstName);
		newPatient.setDataNasterii(LocalDate.parse(birthDate));
		newPatient.setCnp(regNumber);
		newPatient.setPrimaConsultatie(LocalDate.now());
		newPatient.setAdresa(address);
		newPatient.setNumarTelefon(phoneNumber);
		newPatient.setAltele(altele);
		newPatient.setNasteriNaturale(Integer.valueOf(naturalBirths));
		newPatient.setCezariene(Integer.valueOf(csectionBirths));
		newPatient.setAvorturiLaCerere(Integer.valueOf(requestedAborstions));
		newPatient.setAvorturiSpontane(Integer.valueOf(spontaneusAbortions));

		Long patientId = PatientsDAO.savePatient(newPatient);
		
		if (patientId <= 0) {
			JOptionPane.showMessageDialog(mainWindow, "Pacientul " + name + " " + firstName + " nu a putut fi inregistrat ", 
					"Erroare", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Antecedent antecedent = new Antecedent(patientId, antecedents, LocalDate.now());
		Long antecedentId = AntecedentsDAO.saveAntecedente(antecedent);
		
		if (antecedentId > 0) {
			JOptionPane.showMessageDialog(mainWindow, "Patient inregistrat " + name + " " + firstName + " cu succes", 
					"Confirmare inregistrare", JOptionPane.INFORMATION_MESSAGE);
			List<Antecedent> antecedentsList = new ArrayList<Antecedent>();
			antecedentsList.add(antecedent);
			List<Examination> examinationsList = new ArrayList<Examination>();
			mainWindow.showExaminationPatientPanel(newPatient, antecedentsList, examinationsList);
		} else {
			JOptionPane.showMessageDialog(mainWindow, "Antecedentele pacientului " + name + " " + firstName + " nu au fost inregistrate ", 
					"Erroare", JOptionPane.ERROR_MESSAGE);
			return;
		}
				
		
		 
	}
	
	private void validateFields(String naturalBirths, String csectionBirths, 
			String requestedAbortions, String spontaneusAbortions) {
		try {
			InputValidation.validateBirthsNumber(naturalBirths, false);
			InputValidation.validateBirthsNumber(csectionBirths, false);
			InputValidation.validateBirthsNumber(requestedAbortions, false);
			InputValidation.validateBirthsNumber(spontaneusAbortions, false);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
					"Erore de Validare", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
			return;
		}
	}
}
