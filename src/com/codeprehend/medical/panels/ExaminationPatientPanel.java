package com.codeprehend.medical.panels;

import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.resources.Examination;
import com.codeprehend.medical.resources.Patient;

public class ExaminationPatientPanel extends JPanel {
	/**
	 * Default serial key. 
	 */
	private static final long serialVersionUID = 1L;
	
	private MedicalRecordGUI parentPanel;
	private Patient currentPatient; 

	private JLabel labelName;
	private JLabel labelFirstName;
	private JLabel examDate;
	
	private JTextArea examinationDiagnosis;
	private List<JTextArea> previousExaminations;
	
	private JButton saveExamination = new JButton("Salveaza Consultatia");
	
	public ExaminationPatientPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(new GridBagLayout());

		this.parentPanel = parent;
		this.setVisible(false);
	}
	
	/**
	 * Loads the list of history Examination objects into JPanel
	 * 
	 * @param patients
	 */
	public void setPreviousExaminationEntries(List<Examination> examinations) {
		
		for (Examination exam: examinations) { 
			JPanel examinationEntry = new JPanel();
			JLabel dateLabel = new JLabel(exam.getConsultationDate().toString());
			JTextArea textAreaExaminationFromHistory = new JTextArea(exam.getText());
			textAreaExaminationFromHistory.setEditable(false);
			
			examinationEntry.add(dateLabel);
			examinationEntry.add(textAreaExaminationFromHistory);
			examinationEntry.setVisible(true);
			
			this.add(examinationEntry);
		}
	}

}
