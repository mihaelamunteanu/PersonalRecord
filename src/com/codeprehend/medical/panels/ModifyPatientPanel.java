package com.codeprehend.medical.panels;

import java.awt.Color;
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
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.listeners.BackFromListOfPatientsPanelButtonActionListener;
import com.codeprehend.medical.listeners.CancelNewPatientButtonActionListener;
import com.codeprehend.medical.listeners.SaveModificationsForPatientButtonActionListener;
import com.codeprehend.medical.listeners.SaveNewPatientButtonActionListener;
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
	private JLabel labelDateFormat = new JLabel("(aaaa-ll-zz)");
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
	
	private JScrollPane scrollPane_1 = new JScrollPane();
	
	//it saves in DB and moves to screen CurrentDiagnosisPanel
	private JButton saveNewPatientButton = new JButton("Salveaza");
	private JButton cancelNewPatientButton = new JButton("Renunta");
	
	public ModifyPatientPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(null);
		this.parentPanel = parent;
		
		saveNewPatientButton.addActionListener(new SaveNewPatientButtonActionListener(parentPanel));
		cancelNewPatientButton.addActionListener(new CancelNewPatientButtonActionListener(parentPanel));

		// make a separate function
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String stringCurrentDate = format.format(currentDate);
		
		this.setBounds(40, 20, 882, 509);
		this.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pacienta noua:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.setLayout(null);
		
		labelName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelName.setBounds(107, 26, 46, 14);
		this.add(labelName);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldName.setBounds(148, 20, 219, 26);
		this.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldFirstName.setColumns(10);
		textFieldFirstName.setBounds(485, 23, 219, 26);
		this.add(textFieldFirstName);
		
		labelFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelFirstName.setBounds(424, 26, 58, 14);
		this.add(labelFirstName);
		
		labelDate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelDate.setBounds(65, 72, 77, 14);
		this.add(labelDate);
		
		textFieldDate = new JTextField();
		textFieldDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(148, 66, 219, 26);
		this.add(textFieldDate);
		
		labelDateFormat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelDateFormat.setBounds(76, 86, 63, 14);
		this.add(labelDateFormat);
		
		labelRegNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelRegNumber.setBounds(452, 72, 38, 14);
		this.add(labelRegNumber);
		
		textFieldRegNumber = new JTextField();
		textFieldRegNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldRegNumber.setColumns(10);
		textFieldRegNumber.setBounds(485, 66, 219, 26);
		this.add(textFieldRegNumber);
		
		labelPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelPhoneNumber.setBounds(97, 114, 58, 14);
		this.add(labelPhoneNumber);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setBounds(148, 111, 219, 26);
		this.add(textFieldPhoneNumber);
		
		naturalBirthsNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		naturalBirthsNumber.setBounds(34, 163, 94, 14);
		this.add(naturalBirthsNumber);
		
		textFieldNaturalBirthsNumber = new JTextField();
		textFieldNaturalBirthsNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldNaturalBirthsNumber.setColumns(10);
		textFieldNaturalBirthsNumber.setBounds(129, 157, 38, 26);
		this.add(textFieldNaturalBirthsNumber);
		
		textFieldcSectionBirthNumber = new JTextField();
		textFieldcSectionBirthNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldcSectionBirthNumber.setColumns(10);
		textFieldcSectionBirthNumber.setBounds(263, 157, 38, 26);
		this.add(textFieldcSectionBirthNumber);
		
		cSectionBirthNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		cSectionBirthNumber.setBounds(195, 163, 68, 14);
		this.add(cSectionBirthNumber);
		
		requestedAbortionNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		requestedAbortionNumber.setBounds(350, 163, 103, 14);
		this.add(requestedAbortionNumber);
		
		textFieldRequestedAbortionNumber = new JTextField();
		textFieldRequestedAbortionNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldRequestedAbortionNumber.setColumns(10);
		textFieldRequestedAbortionNumber.setBounds(454, 157, 38, 26);
		this.add(textFieldRequestedAbortionNumber);
		
		spontaneousAbortionNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		spontaneousAbortionNumber.setBounds(559, 163, 117, 14);
		this.add(spontaneousAbortionNumber);
		
		textFieldSpotaneousAbortionNumber = new JTextField();
		textFieldSpotaneousAbortionNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldSpotaneousAbortionNumber.setColumns(10);
		textFieldSpotaneousAbortionNumber.setBounds(666, 157, 38, 26);
		this.add(textFieldSpotaneousAbortionNumber);
		
		saveNewPatientButton.setBounds(195, 207, 106, 37);
		this.add(saveNewPatientButton);

		cancelNewPatientButton.setBounds(585, 214, 106, 37);
		this.add(cancelNewPatientButton);
		
		String str = new String("Antecedente la data ");
		
		antecedents = new JLabel(str.concat(stringCurrentDate));
		antecedents.setFont(new Font("Tahoma", Font.BOLD, 11));
		antecedents.setBounds(34, 259, 229, 26);
		this.add(antecedents);
		
		scrollPane_1.setBounds(34, 283, 670, 215);
		this.add(scrollPane_1);
		
		textAreaAntecedents = new JTextArea();
		scrollPane_1.setViewportView(textAreaAntecedents);
		
		antecedentsDate.setText(stringCurrentDate);
		Font fontDate = new Font("TimesNewRoman", Font.BOLD, 16);
		antecedentsDate.setFont(fontDate);
	
	

		
		this.setVisible(false);
	}
	
	/**
	 * Loads the list of Antecedent objects into JPanels
	 * 
	 * @param antecedents
	 */
	public void setAntecedentEntries(List<Antecedent> antecedents) {
	
		String str = new String("");
		
		for (Antecedent antecedent : antecedents) {
			str = str.concat("Antecedente la data ");
			str = str.concat(antecedent.getRegistrationDate().toString());
			str = str.concat("\n");
			str = str.concat(antecedent.getAntecedentText());
			str = str.concat("\n\n");
			
		}
		textAreaAntecedents.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textAreaAntecedents.setText(str);
		
		/*	JPanel antecedentsEntryPanel = new JPanel();
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
		}*/
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



}
