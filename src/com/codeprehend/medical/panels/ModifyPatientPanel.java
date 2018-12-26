package com.codeprehend.medical.panels;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.listeners.BackFromListOfPatientsPanelButtonActionListener;
import com.codeprehend.medical.listeners.CancelNewPatientButtonActionListener;
import com.codeprehend.medical.listeners.SaveModificationsForPatientButtonActionListener;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Patient;

public class ModifyPatientPanel extends JPanel {

	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	private MedicalRecordGUI parentPanel;
	private Patient pacient;

	private JLabel labelSearchPatient = new JLabel("Inregistrare Pacient: ");
	private JLabel labelDate = new JLabel("Data nastere: ");
	private JLabel labelName = new JLabel("Nume: ");
	private JLabel labelFirstName = new JLabel("Prenume: ");
	private JLabel labelRegNumber = new JLabel("CNP: ");
	private JLabel labelPhoneNumber = new JLabel("Tel: ");
	private JLabel naturalBirthsNumber = new JLabel("Nasteri naturale: ");
	private JLabel cSectionBirthNumber = new JLabel("Cezariene: ");
	private JLabel requestedAbortionNumber = new JLabel("Avorturi la cerere:");
	private JLabel spontaneousAbortionNumber = new JLabel("Avorturi spontane:");
	private JLabel antecedents = new JLabel("Antecedente la data ");
	private JLabel antecedentsDate = new JLabel();
	
//	private String numeAnterior;
//	private String prenumeAnterior;
//	private String cnpAnterior;
//	private LocalDate dataNastereAnterioara;
//	private String numarTelefonAnterior;
//	private int nasteriNaturaleAnterioare;
//	private int cezarieneAnterioare;
//	private int avorturispontaneAnterioare;
//	private int avorturiLaCerereAnterioare;
	
	private JTextField textFieldDate;
	private JTextField textFieldName;
	private JTextField textFieldFirstName;
	private JTextField textFieldRegNumber;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldNaturalBirthsNumber;
	private JTextField textFieldcSectionBirthNumber;
	private JTextField textFieldRequestedAbortionNumber;
	private JTextField textFieldSpotaneousAbortionNumber;
	private JTextArea  textAreaAntecedents;
	
	//it saves in DB and moves to screen CurrentDiagnosisPanel
	private JButton saveNewPatientButton = new JButton("Salveaza");
	private JButton cancelNewPatientButton = new JButton("Renunta");
	
	private GridBagConstraints gc = new GridBagConstraints();
	
	public ModifyPatientPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(new GridBagLayout());
		this.parentPanel = parent;
		
		cancelNewPatientButton.addActionListener(new BackFromListOfPatientsPanelButtonActionListener(parentPanel));

		// make a separate function
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String stringCurrentDate = format.format(currentDate);
		
		antecedentsDate.setText(stringCurrentDate);
		Font fontDate = new Font("TimesNewRoman", Font.BOLD, 16);
		antecedentsDate.setFont(fontDate);

		textFieldDate = new JTextField(15);
		textFieldDate.setText(stringCurrentDate);
		textFieldName = new JTextField(15);
		textFieldFirstName = new JTextField(15);
		textFieldRegNumber = new JTextField(15); 
		textFieldPhoneNumber = new JTextField(15);
		
		textFieldNaturalBirthsNumber =  new JTextField(2);
		textFieldcSectionBirthNumber = new JTextField(2);
		textFieldRequestedAbortionNumber = new JTextField(2);
		textFieldSpotaneousAbortionNumber = new JTextField(2);
		
		Font font1 = new Font("TimesNewRoman", Font.BOLD, 14);
		textFieldName.setFont(font1);
		textFieldFirstName.setFont(font1);
		textFieldDate.setFont(font1);
		textFieldRegNumber.setFont(font1);
		textFieldPhoneNumber.setFont(font1);
		
		textFieldNaturalBirthsNumber.setFont(font1);
		textFieldcSectionBirthNumber.setFont(font1);
		textFieldRequestedAbortionNumber.setFont(font1);
		textFieldSpotaneousAbortionNumber.setFont(font1);
		
		textAreaAntecedents = new JTextArea(10, 20);

		cancelNewPatientButton.addActionListener(new CancelNewPatientButtonActionListener(parentPanel));

		Border operBorder = BorderFactory.createTitledBorder("Pacienta noua:");
		this.setBorder(operBorder);
		
		this.setLayout(new GridBagLayout());
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		
		gc.gridy = 1;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		this.add(labelName, gc);
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(textFieldName, gc);
		
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		this.add(labelFirstName, gc);
		gc.gridx = 4;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(textFieldFirstName, gc);
		
		gc.gridy = 2;
		gc.gridx = 1;
		this.add(new JLabel(" "), gc);

		gc.gridy = 3;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		this.add(labelDate, gc);
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(textFieldDate, gc);
		
		gc.gridy = 3;
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		this.add(labelRegNumber, gc);
		gc.gridx = 4;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(textFieldRegNumber, gc);

		gc.gridy = 4;
		gc.gridx = 1;
		this.add(new JLabel(" "), gc);
		
		gc.gridy = 5;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		this.add(labelPhoneNumber, gc);
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(textFieldPhoneNumber, gc);

		gc.gridy = 6;
		gc.gridx = 1;
		this.add(new JLabel(" "), gc);
		
		gc.gridy = 7;
		
		gc.gridx = 1;
		this.add(naturalBirthsNumber, gc);
		gc.gridx = 2;
		this.add(textFieldNaturalBirthsNumber, gc);
		gc.gridx = 3;
		this.add(cSectionBirthNumber, gc);
		gc.gridx = 4;
		this.add(textFieldcSectionBirthNumber, gc);
		
		gc.gridy = 8;
		gc.gridx = 1;
		this.add(new JLabel(" "), gc);
		
		gc.gridy = 9;
				
		gc.gridx = 1;
		this.add(requestedAbortionNumber, gc);
		gc.gridx = 2;
		this.add(textFieldRequestedAbortionNumber, gc);
		gc.gridx = 3;
		this.add(spontaneousAbortionNumber, gc);
		gc.gridx = 4;
		this.add(textFieldSpotaneousAbortionNumber, gc);
		
		gc.gridwidth = 1;
		gc.gridy = 10;
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.CENTER;
		this.add(saveNewPatientButton, gc); // Adds Button to content pane of frame
		
		gc.gridx = 4;
		gc.gridy = 10;
		this.add(cancelNewPatientButton, gc);
		
		gc.gridy = 11;
		gc.gridx = 1;
		this.add(new JLabel(" "), gc);
		gc.gridy = 12;
		gc.gridx = 1;
		this.add(new JLabel(" "), gc);
		gc.gridy = 13;
		this.add(antecedents, gc);
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(antecedentsDate, gc);
		gc.gridx = 1;
		gc.gridy = 14;
		gc.gridwidth = 4;
		gc.fill = GridBagConstraints.HORIZONTAL;
		this.add(textAreaAntecedents, gc);
		
		this.setVisible(false);
	}
	
	/**
	 * Loads the list of Antecedent objects into JPanels
	 * 
	 * @param antecedents
	 */
	public void setAntecedentEntries(List<Antecedent> antecedents) {
		JPanel antecedentsEntryPanel = new JPanel();
		JScrollPane scrollPanelModifyPatient = new JScrollPane(antecedentsEntryPanel);
		this.add(scrollPanelModifyPatient);
		
		int i = 16;
		GridBagLayout gcInner = new GridBagLayout();
		
		antecedentsEntryPanel.setLayout(gcInner);
//		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		for (Antecedent antecedent : antecedents) { 
			JPanel antecedentEntry = new JPanel();
			JLabel dateLabel = new JLabel(antecedent.getRegistrationDate().format(
					DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			JLabel antecedentTextLabel = new JLabel(antecedent.getAntecedentText());
			
			antecedentEntry.add(dateLabel);
			antecedentEntry.add(antecedentTextLabel);

			antecedentEntry.setVisible(true);

			gc.gridx = 1;
			gc.gridy = i;
			antecedentsEntryPanel.add(antecedentEntry, gc);
			i++;
		}
	}
	
	/**
	 * Loads the data for the Patient data into JPanels
	 * 
	 * @param antecedents
	 */
	public void setPatientEntry(Patient patient) {
		this.pacient = patient;

		textFieldDate.setText(patient.getDataNasterii().toString());
		textFieldName.setText(patient.getNume());
		textFieldFirstName.setText(patient.getPrenume());
		textFieldRegNumber.setText(patient.getCnp()); 
		textFieldPhoneNumber.setText(patient.getNumarTelefon());
		
		textFieldNaturalBirthsNumber.setText(String.valueOf(patient.getNasteriNaturale()));
		textFieldcSectionBirthNumber.setText(String.valueOf(patient.getCezariene()));
		textFieldRequestedAbortionNumber.setText(String.valueOf(patient.getAvorturiLaCerere()));
		textFieldSpotaneousAbortionNumber.setText(String.valueOf(patient.getAvorturiSpontane()));
		
//		numeAnterior = patient.getNume();
//		prenumeAnterior = patient.getPrenume();
//		cnpAnterior = patient.getCnp();
//		numarTelefonAnterior = patient.getNumarTelefon();
//		dataNastereAnterioara = patient.getDataNasterii();
		
		saveNewPatientButton.addActionListener(
				new SaveModificationsForPatientButtonActionListener(parentPanel, patient));
	}


	public MedicalRecordGUI getParentPanel() {
		return parentPanel;
	}

	public void setParentPanel(MedicalRecordGUI parentPanel) {
		this.parentPanel = parentPanel;
	}

	public Patient getPacient() {
		return pacient;
	}

	public void setPacient(Patient pacient) {
		this.pacient = pacient;
	}

	public JLabel getLabelSearchPatient() {
		return labelSearchPatient;
	}

	public void setLabelSearchPatient(JLabel labelSearchPatient) {
		this.labelSearchPatient = labelSearchPatient;
	}

	public JLabel getLabelDate() {
		return labelDate;
	}

	public void setLabelDate(JLabel labelDate) {
		this.labelDate = labelDate;
	}

	public JLabel getLabelName() {
		return labelName;
	}

	public void setLabelName(JLabel labelName) {
		this.labelName = labelName;
	}

	public JLabel getLabelFirstName() {
		return labelFirstName;
	}

	public void setLabelFirstName(JLabel labelFirstName) {
		this.labelFirstName = labelFirstName;
	}

	public JLabel getLabelRegNumber() {
		return labelRegNumber;
	}

	public void setLabelRegNumber(JLabel labelRegNumber) {
		this.labelRegNumber = labelRegNumber;
	}

	public JLabel getLabelPhoneNumber() {
		return labelPhoneNumber;
	}

	public void setLabelPhoneNumber(JLabel labelPhoneNumber) {
		this.labelPhoneNumber = labelPhoneNumber;
	}

	public JLabel getNaturalBirthsNumber() {
		return naturalBirthsNumber;
	}

	public void setNaturalBirthsNumber(JLabel naturalBirthsNumber) {
		this.naturalBirthsNumber = naturalBirthsNumber;
	}

	public JLabel getcSectionBirthNumber() {
		return cSectionBirthNumber;
	}

	public void setcSectionBirthNumber(JLabel cSectionBirthNumber) {
		this.cSectionBirthNumber = cSectionBirthNumber;
	}

	public JLabel getRequestedAbortionNumber() {
		return requestedAbortionNumber;
	}

	public void setRequestedAbortionNumber(JLabel requestedAbortionNumber) {
		this.requestedAbortionNumber = requestedAbortionNumber;
	}

	public JLabel getSpotaneousAbortionNumber() {
		return spontaneousAbortionNumber;
	}

	public void setSpotaneousAbortionNumber(JLabel spotaneousAbortionNumber) {
		this.spontaneousAbortionNumber = spotaneousAbortionNumber;
	}

	public JLabel getAntecedents() {
		return antecedents;
	}

	public void setAntecedents(JLabel antecedents) {
		this.antecedents = antecedents;
	}

	public JTextField getTextFieldDate() {
		return textFieldDate;
	}

	public void setTextFieldDate(JTextField textFieldDate) {
		this.textFieldDate = textFieldDate;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public void setTextFieldName(JTextField textFieldName) {
		this.textFieldName = textFieldName;
	}

	public JTextField getTextFieldFirstName() {
		return textFieldFirstName;
	}

	public void setTextFieldFirstName(JTextField textFieldFirstName) {
		this.textFieldFirstName = textFieldFirstName;
	}

	public JTextField getTextFieldRegNumber() {
		return textFieldRegNumber;
	}

	public void setTextFieldRegNumber(JTextField textFieldRegNumber) {
		this.textFieldRegNumber = textFieldRegNumber;
	}

	public JTextField getTextFieldPhoneNumber() {
		return textFieldPhoneNumber;
	}

	public void setTextFieldPhoneNumber(JTextField textFieldPhoneNumber) {
		this.textFieldPhoneNumber = textFieldPhoneNumber;
	}

	public JTextField getTextFieldNaturalBirthsNumber() {
		return textFieldNaturalBirthsNumber;
	}

	public void setTextFieldNaturalBirthsNumber(JTextField textFieldNaturalBirthsNumber) {
		this.textFieldNaturalBirthsNumber = textFieldNaturalBirthsNumber;
	}

	public JTextField getTextFieldcSectionBirthNumber() {
		return textFieldcSectionBirthNumber;
	}

	public void setTextFieldcSectionBirthNumber(JTextField textFieldcSectionBirthNumber) {
		this.textFieldcSectionBirthNumber = textFieldcSectionBirthNumber;
	}

	public JTextField getTextFieldRequestedAbortionNumber() {
		return textFieldRequestedAbortionNumber;
	}

	public void setTextFieldRequestedAbortionNumber(JTextField textFieldRequestedAbortionNumber) {
		this.textFieldRequestedAbortionNumber = textFieldRequestedAbortionNumber;
	}

	public JTextField getTextFieldSpotaneousAbortionNumber() {
		return textFieldSpotaneousAbortionNumber;
	}

	public void setTextFieldSpotaneousAbortionNumber(JTextField textFieldSpotaneousAbortionNumber) {
		this.textFieldSpotaneousAbortionNumber = textFieldSpotaneousAbortionNumber;
	}

	public JTextArea getTextAreaAntecedents() {
		return textAreaAntecedents;
	}

	public GridBagConstraints getGc() {
		return gc;
	}

	public void setGc(GridBagConstraints gc) {
		this.gc = gc;
	}

}
