package com.codeprehend.medical.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.listeners.AccesFilesExaminationButtonActionListener;
import com.codeprehend.medical.listeners.BackFromExaminationPatientPanelButtonActionListener;
import com.codeprehend.medical.listeners.GoHomeFromExaminationPatientButtonListener;
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

	private JTextField patientPersonalInfoTextField = new JTextField();
	private JTextField patientMedicalInfoTextField = new JTextField();
	
	private JScrollPane scrollPane = new JScrollPane();
	private JScrollPane scrollPane_1 = new JScrollPane();
	private JScrollPane scrollPane_2 = new JScrollPane();
	
	private JPanel panel_2 = new JPanel();
	
	private JTextArea antecedentsTextAreea = new JTextArea();
	private JTextArea previousExamination = new JTextArea();
	private JTextArea examinationDiagnosis = new JTextArea();
	private List<JTextArea> previousExaminations;
	
	private JButton homeButton = new JButton("Ecran principal");
	private JButton backFromExaminationPanel = new JButton("Inapoi la lista");
	private JButton modifyPatientInfoButton = new JButton("Modifica info");
	private JButton saveExaminationButton = new JButton("Salveaza Consultatia");
	private JButton fileExaminationButton = new JButton("Acceseaza fisiere");
	
	
	public ExaminationPatientPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(null);

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
		
		//examinationDiagnosis = new JTextArea();
		//examinationDiagnosis.setSize(100, 100);
		
		//this.add(examinationDiagnosis);
		//this.add(saveExaminationButton);
	}
	
	private void loadExaminationGUIForPatient(Patient pacient) {
		
		String patientPersonalInfoText = new String("");
		
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getNume());
		patientPersonalInfoText = patientPersonalInfoText.concat(" ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getPrenume());
		patientPersonalInfoText = patientPersonalInfoText.concat("    data nasterii: ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getDataNasterii().toString());
		patientPersonalInfoText = patientPersonalInfoText.concat("     CNP: ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getCnp());
		patientPersonalInfoText = patientPersonalInfoText.concat("     Tel: ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getNumarTelefon());
		
		String patientMedicalInfoText = new String("");
		patientMedicalInfoText = patientMedicalInfoText.concat("Nasteri naturale: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getNasteriNaturale()));
		patientMedicalInfoText = patientMedicalInfoText.concat("   Cezariene: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getCezariene()));
		patientMedicalInfoText = patientMedicalInfoText.concat("   Avorturi la cerere: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getAvorturiLaCerere()));
		patientMedicalInfoText = patientMedicalInfoText.concat("    Avorturi spontane: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getAvorturiSpontane()));

		this.setBounds(10, 11, 882, 532);
		this.setLayout(null);
		
		saveExaminationButton.setBounds(656, 75, 156, 52);
		this.add(saveExaminationButton);
		
		modifyPatientInfoButton.setBounds(656, 254, 156, 52);
		this.add(modifyPatientInfoButton);
		
		backFromExaminationPanel.setBounds(681, 459, 131, 39);
		this.add(backFromExaminationPanel);
		
		homeButton.setBounds(681, 409, 131, 39);
		this.add(homeButton);
		
		fileExaminationButton.setBounds(656, 146, 156, 52);
		this.add(fileExaminationButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Date pacienta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(28, 23, 573, 77);
		this.add(panel_1);
		panel_1.setLayout(null);
		
		patientPersonalInfoTextField.setText(patientPersonalInfoText);
		patientPersonalInfoTextField.setBackground(Color.WHITE);
		patientPersonalInfoTextField.setBounds(6, 16, 561, 28);
		panel_1.add(patientPersonalInfoTextField);
		patientPersonalInfoTextField.setEditable(false);
		patientPersonalInfoTextField.setFont(new Font("Times New Roman", Font.BOLD, 13));
		patientPersonalInfoTextField.setColumns(10);
		
		patientMedicalInfoTextField.setText(patientMedicalInfoText);
		patientMedicalInfoTextField.setBackground(Color.WHITE);
		patientMedicalInfoTextField.setBounds(6, 42, 561, 28);
		panel_1.add(patientMedicalInfoTextField);
		patientMedicalInfoTextField.setEditable(false);
		patientMedicalInfoTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		patientMedicalInfoTextField.setColumns(10);
		
		antecedentsTextAreea.setEditable(false);
		antecedentsTextAreea.setBounds(33, 122, 561, 137);
		this.add(antecedentsTextAreea);
		
		scrollPane_1.setBounds(33, 122, 561, 137);
		this.add(scrollPane_1);
		
		scrollPane_1.setViewportView(antecedentsTextAreea);
		antecedentsTextAreea.setEditable(false);
		
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String stringCurrentDate = format.format(currentDate);
		
		String str = new String ("Consultatie curenta - ");
		str = str.concat(stringCurrentDate);
		
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), str, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(27, 284, 573, 113);
		this.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane.setBounds(6, 16, 561, 92);
		panel_2.add(scrollPane);
		
		scrollPane.setViewportView(examinationDiagnosis);
		
		scrollPane_2.setBounds(28, 409, 573, 112);
		this.add(scrollPane_2);
		
		previousExamination = new JTextArea();
		scrollPane_2.setViewportView(previousExamination);
		previousExamination.setEditable(false);
		previousExamination.setBackground(new Color(220, 220, 220));
		
		
		
		//Action Listeners
		
		backFromExaminationPanel.addActionListener(new BackFromExaminationPatientPanelButtonActionListener(this.parentPanel));
		homeButton.addActionListener(new GoHomeFromExaminationPatientButtonListener(this.parentPanel));
		modifyPatientInfoButton.addActionListener(new ModifyPatientButtonActionListener(this.parentPanel, currentPatient));
		saveExaminationButton.addActionListener(new SaveExaminationButtonActionListener(parentPanel, currentPatient));
		
		fileExaminationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AccesFilesExaminationButtonActionListener(parentPanel, currentPatient);
			}
		});
	}
	
	
	public void setAntecedents(List<Antecedent> antecedents) {
		
		/*JPanel antecedentsPanel = new JPanel();
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
		*/
		
		String str = new String("");
		
		for (Antecedent antecedent : antecedents) {
			str = str.concat("Antecedente la data ");
			str = str.concat(antecedent.getRegistrationDate().toString());
			str = str.concat("\n");
			str = str.concat(antecedent.getAntecedentText());
			str = str.concat("\n\n");
			
		}
		antecedentsTextAreea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		antecedentsTextAreea.setText(str);
		

	}
		

	
	/*public void setButtons(){
		JPanel patientButtonsPanel = new JPanel();
		patientButtonsPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gcButtonsPanel = new GridBagConstraints();
		
		examinationDiagnosis.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
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
	}*/
	
	/**
	 * Loads the list of history Examination objects into JPanel
	 * 
	 * @param patients
	 */
	public void setPreviousExaminationEntries(List<Examination> examinations) {
		
		String str = new String("");
		
		for (Examination exam: examinations) { 
			str = str.concat("Consultatie la data ");
			str = str.concat(exam.getConsultationDate().toString());
			str = str.concat("\n");
			str = str.concat(exam.getText());
			str = str.concat("\n\n");
			
			
		}
		
		previousExamination.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		previousExamination.setText(str);
	}
	
	public JTextArea getExaminationDiagnosis() {
		return examinationDiagnosis;
	}
}
	

	
	
