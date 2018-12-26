package com.codeprehend.medical.panels;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.listeners.ModifyPatientButtonActionListener;
import com.codeprehend.medical.listeners.SaveExaminationButtonActionListener;
import com.codeprehend.medical.resources.Antecedent;
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
	
	private JButton homeButton = new JButton("Ecran principal");
	private JButton backFromExaminationPanel = new JButton("Inapoi");
	private JButton modifyPatientInfoButton = new JButton("Modifica info");
	private JButton saveExaminationButton = new JButton("Salveaza Consultatia");
	
	
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
		this.currentPatient = pacient;
		
		loadExaminationGUIForPatient(currentPatient);
		
		examinationDiagnosis = new JTextArea();
		examinationDiagnosis.setSize(100, 100);
		saveExaminationButton.addActionListener(new SaveExaminationButtonActionListener(parentPanel, currentPatient));
		
		this.add(examinationDiagnosis);
		this.add(saveExaminationButton);
	}
	
	private void loadExaminationGUIForPatient(Patient pacient) {
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
		patientPersonalInfoText.concat((pacient.getNumarTelefon() != null) ? pacient.getNumarTelefon() : "");
		
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
		
		gcExaminationPatientPanel.anchor = GridBagConstraints.FIRST_LINE_START;
		gcExaminationPatientPanel.gridx = 1;
		gcExaminationPatientPanel.gridy = 1;
		this.add(patientInformationsPanel, gcExaminationPatientPanel);

	}
	
	
	public void setAntecedents(List<Antecedent> antecedents) {
		
		JPanel antecedentsPanel = new JPanel();
		antecedentsPanel.setLayout(new GridBagLayout());
		
		Border operBorder = BorderFactory.createTitledBorder("");
		antecedentsPanel.setBorder(operBorder);
		
		GridBagConstraints gcAntecedentsPanel = new GridBagConstraints();
		
		Font font1 = new Font("TimesNewRoman", Font.BOLD, 15);
		Font font2 = new Font("TimesNewRoman", Font.BOLD, 13);
		
	    JLabel textAntecedents = new JLabel("Antecedente ");
	    textAntecedents.setFont(font1);
	    
	    gcAntecedentsPanel.anchor = GridBagConstraints.FIRST_LINE_START;
	    gcAntecedentsPanel.gridx = 1;
	    gcAntecedentsPanel.gridy = 1;
	    antecedentsPanel.add(textAntecedents, gcAntecedentsPanel);

		gcExaminationPatientPanel.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gcExaminationPatientPanel.gridx = 1;
		gcExaminationPatientPanel.gridy = 2;

		this.add(new JLabel(" "), gcExaminationPatientPanel);
		
		int i = 3;
		
		for (Antecedent antecedent : antecedents) {
//			gcAntecedentsPanel.gridx = 1;
			gcAntecedentsPanel.gridy = i;
			JLabel labelAntecedentDate = new JLabel(antecedent.getRegistrationDate().toString());
			antecedentsPanel.add(labelAntecedentDate, gcAntecedentsPanel);
			
			gcAntecedentsPanel.gridy = i + 1;
			JLabel labelAntecedentText = new JLabel(antecedent.getAntecedentText());
			antecedentsPanel.add(labelAntecedentText, gcAntecedentsPanel);
			
			gcAntecedentsPanel.gridy = i + 2;
			JLabel labelSpace = new JLabel("c");
			antecedentsPanel.add(labelSpace, gcAntecedentsPanel);
			i = i + 3;
		}

		gcExaminationPatientPanel.gridx = 1;
		gcExaminationPatientPanel.gridy = i + 1;

		this.add(new JLabel(" "), gcExaminationPatientPanel);
		
		this.add(antecedentsPanel, gcExaminationPatientPanel);
	    
	}
		

	
	public void setButtons(){
		JPanel patientButtonsPanel = new JPanel();
		patientButtonsPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gcButtonsPanel = new GridBagConstraints();
		
		patientButtonsPanel.add(homeButton);
		patientButtonsPanel.add(new JLabel("   "));
		patientButtonsPanel.add(backFromExaminationPanel);
		patientButtonsPanel.add(new JLabel("   "));
		patientButtonsPanel.add(modifyPatientInfoButton);
		
		gcExaminationPatientPanel.anchor = GridBagConstraints.FIRST_LINE_START;
		gcExaminationPatientPanel.gridx = 1;
		gcExaminationPatientPanel.gridy = 4;
		this.add(new JLabel(" "), 		gcExaminationPatientPanel);
		gcExaminationPatientPanel.gridy = 5;
		this.add(new JLabel(" "), 		gcExaminationPatientPanel);
		
		gcExaminationPatientPanel.anchor = GridBagConstraints.FIRST_LINE_END;
		gcExaminationPatientPanel.gridx = 1;
		gcExaminationPatientPanel.gridy = 6;
		this.add(patientButtonsPanel, gcExaminationPatientPanel);
		
		modifyPatientInfoButton.addActionListener(new ModifyPatientButtonActionListener(this.parentPanel, currentPatient));
	}
	
	/**
	 * Loads the list of history Examination objects into JPanel
	 * 
	 * @param patients
	 */
	public void setPreviousExaminationEntries(List<Examination> examinations) {
		
		int i = 10;
		for (Examination exam: examinations) { 
			JPanel examinationEntry = new JPanel();
			JLabel dateLabel = new JLabel(exam.getConsultationDate().toString());
			JTextArea textAreaExaminationFromHistory = new JTextArea(exam.getText());
			textAreaExaminationFromHistory.setEditable(false);
			
			examinationEntry.add(dateLabel);
			examinationEntry.add(textAreaExaminationFromHistory);
			examinationEntry.setVisible(true);
			
			gcExaminationPatientPanel.anchor = GridBagConstraints.FIRST_LINE_START;
			gcExaminationPatientPanel.gridx = 1;
			gcExaminationPatientPanel.gridy = i;
			i = i + 1;
			
			this.add(examinationEntry, gcExaminationPatientPanel);
		}
	}
	
	public JTextArea getExaminationDiagnosis() {
		return examinationDiagnosis;
	}
}
	

	
	
