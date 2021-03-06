package com.codeprehend.medical.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.AtachementsDAO;
import com.codeprehend.medical.dao.ExaminationDAO;
import com.codeprehend.medical.pdf.ExaminationToPdf;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Attachement;
import com.codeprehend.medical.resources.Examination;
import com.codeprehend.medical.resources.Patient;
import com.codeprehend.medical.util.Utils;
import com.itextpdf.text.DocumentException;

public class SaveExaminationButtonActionListener implements ActionListener {
	
	private MedicalRecordGUI mainWindow;
	private Patient patient;
	private List<Antecedent> antecedents;
	private List<Examination> examinations;
	
	public SaveExaminationButtonActionListener(MedicalRecordGUI mainWindow, Patient patient, 
			List<Antecedent> antecedents, List<Examination> examinations){
		this.mainWindow = mainWindow;
		this.patient = patient;
		this.antecedents = antecedents;
		this.examinations = examinations;
	}
	
	public void actionPerformed(ActionEvent e) {
		String textDiagnosis = mainWindow.getExaminationPatientPanel().getExaminationDiagnosis().getText();
		
		if (textDiagnosis == null || textDiagnosis.trim().isEmpty()) {
			JOptionPane.showMessageDialog(mainWindow, "Textul pentru consultatie este necompletat", 
			"Avertizare", JOptionPane.WARNING_MESSAGE);
			mainWindow.showExaminationPatientPanel(patient, antecedents, examinations);
			return;
		}
		
		Long examinationId = ExaminationDAO.saveExamination(new Examination(patient.getId(), textDiagnosis, LocalDate.now()));
		if (examinationId <= 0) {
			JOptionPane.showMessageDialog(mainWindow, "Consultatia pentru " + patient.getNume() + " " + 
					patient.getPrenume() + " nu a putut fi inregistrata!", 
					"Erroare", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(mainWindow, "Consultatie pentru " + patient.getNume()
					+ " " + patient.getPrenume() + " inregistrata cu succes", 
					"Confirmare inregistrare", JOptionPane.INFORMATION_MESSAGE);
		} 
		
		mainWindow.getExaminationPatientPanel().getExaminationDiagnosis().setEditable(false);
		try {
			Attachement attachment = ExaminationToPdf.createAndOpenPdf(patient.getId(), patient.getNume(), patient.getPrenume(), 
					patient.getCnp(), patient.getNumarTelefon(), Utils.fromDateToString(LocalDate.now()), 
					mainWindow.getExaminationPatientPanel().getExaminationDiagnosis().getText());
			AtachementsDAO.saveAttachment(attachment);
			AccessExamButtonActionListener.actionPerformed(mainWindow, patient);
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(mainWindow, e1.getLocalizedMessage(), "Erroare", JOptionPane.ERROR_MESSAGE);
		} catch (DocumentException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(mainWindow, e1.getLocalizedMessage(), "Erroare", JOptionPane.ERROR_MESSAGE);
		}
	}
}
