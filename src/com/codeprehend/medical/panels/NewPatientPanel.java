package com.codeprehend.medical.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.listeners.SaveNewPatientButtonActionListener;
import com.codeprehend.medical.resources.Patient;

public class NewPatientPanel extends JPanel {

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
	private JLabel requestedAbortionNumber = new JLabel("Avorturi la cerere");
	private JLabel spotaneousAbortionNumber = new JLabel("Avorturi spontane");
	private JLabel antecedents = new JLabel("Antecedente");
	
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
	private JButton saveNewPatientButton = new JButton("Salveaza Pacienta Noua");
	
	private GridBagConstraints gc = new GridBagConstraints();
	
	public NewPatientPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(new GridBagLayout());
		this.parentPanel = parent;

		// make a separate function
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String stringCurrentDate = format.format(currentDate);

		textFieldDate = new JTextField(10);
		textFieldDate.setText(stringCurrentDate);
		textFieldName = new JTextField(10);
		textFieldFirstName = new JTextField(10);
		textFieldRegNumber = new JTextField(10); 
		textFieldPhoneNumber = new JTextField(10);
		
		textFieldNaturalBirthsNumber =  new JTextField(2);
		textFieldcSectionBirthNumber = new JTextField(2);
		textFieldRequestedAbortionNumber = new JTextField(2);
		textFieldSpotaneousAbortionNumber = new JTextField(2);
		
		textAreaAntecedents = new JTextArea();

		saveNewPatientButton.addActionListener(new SaveNewPatientButtonActionListener(parentPanel));

		Border operBorder = BorderFactory.createTitledBorder("Cauta pacienta:");
		this.setBorder(operBorder);
		
		this.setLayout(new GridBagLayout());
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		//Labels and textfields added on the search panel
		gc.gridy = 1;
		
		gc.gridx = 1;
		this.add(labelName, gc);
		gc.gridx = 2;
		this.add(textFieldName, gc);
		
		gc.gridx = 3;
		this.add(labelFirstName, gc);
		gc.gridx = 4;
		this.add(textFieldFirstName, gc);

		gc.gridx = 5;
		this.add(labelDate, gc);
		gc.gridx = 6;
		this.add(textFieldDate, gc);
		
		gc.gridx = 7;
		this.add(labelRegNumber, gc);
		gc.gridx = 8;
		this.add(textFieldRegNumber, gc);

		gc.gridx = 9;
		this.add(labelPhoneNumber, gc);
		gc.gridx = 10;
		this.add(textFieldPhoneNumber, gc);

		
		gc.gridy = 2;
		
		gc.gridx = 1;
		this.add(naturalBirthsNumber, gc);
		gc.gridx = 2;
		this.add(textFieldNaturalBirthsNumber, gc);
		gc.gridx = 3;
		this.add(cSectionBirthNumber, gc);
		gc.gridx = 4;
		this.add(textFieldcSectionBirthNumber, gc);
		gc.gridx = 5;
		this.add(requestedAbortionNumber, gc);
		gc.gridx = 6;
		this.add(textFieldRequestedAbortionNumber, gc);
		gc.gridx = 7;
		this.add(spotaneousAbortionNumber, gc);
		gc.gridx = 8;
		this.add(textFieldSpotaneousAbortionNumber, gc);
		gc.gridheight = 100;
		gc.gridy = 3;
		gc.gridx = 8;
		this.add(saveNewPatientButton, gc); // Adds Button to content pane of frame
		
		this.setVisible(false);
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
		return spotaneousAbortionNumber;
	}

	public void setSpotaneousAbortionNumber(JLabel spotaneousAbortionNumber) {
		this.spotaneousAbortionNumber = spotaneousAbortionNumber;
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

	public void setTextAreaAntecedents(JTextArea textAreaAntecedents) {
		this.textAreaAntecedents = textAreaAntecedents;
	}

	public JButton getSaveNewPatientButton() {
		return saveNewPatientButton;
	}

	public void setSaveNewPatientButton(JButton saveNewPatientButton) {
		this.saveNewPatientButton = saveNewPatientButton;
	}

	public GridBagConstraints getGc() {
		return gc;
	}

	public void setGc(GridBagConstraints gc) {
		this.gc = gc;
	}

}