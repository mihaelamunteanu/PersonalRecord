package com.codeprehend.medical.panels;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

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


	private JTextArea examinationDiagnosis;
	private List<JTextArea> previousExaminations;
	
	private GridBagConstraints gcExaminationPatientPanel = new GridBagConstraints();
	
	private JButton saveExamination = new JButton("Salveaza Consultatia");
	
	
	public ExaminationPatientPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(new GridBagLayout());

		this.parentPanel = parent;
		this.setVisible(false);
	}
	/**
	 * Loads the patient into JPanel
	 * 
	 * @param patients
	 */
	public void setPatientInformations(Patient pacient){
		
		JPanel patientInformationsPanel = new JPanel();
		patientInformationsPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gcPatientInfoPanel = new GridBagConstraints();
		
		Border operBorder = BorderFactory.createTitledBorder("Date pacienta:");
		patientInformationsPanel.setBorder(operBorder);
		
		Font font1 = new Font("TimesNewRoman", Font.BOLD, 15);
		
		String patientPersonalInfoText = new String("");
		
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getNume());
		patientPersonalInfoText = patientPersonalInfoText.concat(" ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getPrenume());
		patientPersonalInfoText = patientPersonalInfoText.concat("    data nasterii: ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getDataNasterii().toString());
		patientPersonalInfoText = patientPersonalInfoText.concat("     CNP: ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getCnp());
		patientPersonalInfoText = patientPersonalInfoText.concat("     Tel: ");
		//patientPersonalInfoText.concat(pacient.getNumarTelefon());
		JLabel patientPersonalInfoLabel = new JLabel(patientPersonalInfoText);
		patientPersonalInfoLabel.setFont(font1);

		
		String patientMedicalInfoText = new String("");
		patientMedicalInfoText = patientMedicalInfoText.concat("Nasteri naturale: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getNasteriNaturale()));
		patientMedicalInfoText = patientMedicalInfoText.concat("   Cezariene: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getCezariene()));
		patientMedicalInfoText = patientMedicalInfoText.concat("   Avorturi la cerere: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getAvorturiLaCerere()));
		patientMedicalInfoText = patientMedicalInfoText.concat("    Avorturi spontane: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getAvorturiSpontane()));

		JLabel patientMedicalInfoLabel = new JLabel(patientMedicalInfoText);
		Font font2 = new Font("TimesNewRoman", Font.BOLD, 13);
		patientMedicalInfoLabel.setFont(font2);
		
		gcPatientInfoPanel.anchor = GridBagConstraints.FIRST_LINE_START;
		gcPatientInfoPanel.gridx = 1;
		gcPatientInfoPanel.gridy = 1;
		patientInformationsPanel.add(patientPersonalInfoLabel, gcPatientInfoPanel);
		gcPatientInfoPanel.gridy = 2;
		patientInformationsPanel.add(patientMedicalInfoLabel, gcPatientInfoPanel);
		this.add(patientInformationsPanel);
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
