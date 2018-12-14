package com.codeprehend.medical.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.listeners.NewPatientButtonActionListener;
import com.codeprehend.medical.listeners.SearchPatientButtonActionListener;

/**
 * Separate class for panel with search patient
 * 
 * @author Gabriel Munteanu,  Mihaela Munteanu
 *
 */
public class SearchPatientPanel extends JPanel {

	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	private static final String CAUTA_PACIENT = "Cautare pacient";

	private MedicalRecordGUI parentPanel;

	private JLabel labelDate = new JLabel("Data nastere: ");
	private JLabel labelName = new JLabel("Nume: ");
	private JLabel labelSurname= new JLabel("Prenume: ");
	private JLabel labelRegNumber = new JLabel("CNP: ");
	private JLabel labelPhoneNumber = new JLabel("Tel: ");
	private JTextField textFieldDate;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldRegNumber;
	private JTextField textFieldPhoneNumber;
	
	private JButton searchPatientButton = new JButton("Cauta Pacienta");
	private JButton newPatientButton = new JButton("Pacienta noua");
	
	private GridBagConstraints gc = new GridBagConstraints();

	public SearchPatientPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(new GridBagLayout());
		this.parentPanel = parent;

		// make a separate function
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String stringCurrentDate = format.format(currentDate);

		textFieldDate = new JTextField(20);
		textFieldDate.setText(stringCurrentDate);
		textFieldName = new JTextField(20);
		textFieldSurname = new JTextField(20);
		textFieldRegNumber = new JTextField(20);
		textFieldPhoneNumber = new JTextField(20);

		searchPatientButton.addActionListener(new SearchPatientButtonActionListener(parentPanel));
		newPatientButton.addActionListener(new NewPatientButtonActionListener(parentPanel));

		Border operBorder = BorderFactory.createTitledBorder(CAUTA_PACIENT);
		this.setBorder(operBorder);
		
		this.setLayout(new GridBagLayout());
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		//gc.gridheight = 10000;
		Font font1 = new Font("TimesNewRoman", Font.BOLD, 15);
		textFieldName.setFont(font1);
		textFieldSurname.setFont(font1);
		textFieldDate.setFont(font1);
		textFieldRegNumber.setFont(font1);
		textFieldPhoneNumber.setFont(font1);
		
		//Labels and textfields added on the search panel
		gc.gridx = 1;
		gc.gridy = 1;
		this.add(labelName, gc);
		gc.gridy = 2;
		this.add(labelSurname, gc);
		gc.gridy = 3;
		this.add(labelDate, gc);
		gc.gridy = 4;
		this.add(labelRegNumber, gc);
		gc.gridy = 5;
		this.add(labelPhoneNumber, gc);

		gc.gridx = 2;
		gc.gridy = 1;
		this.add(textFieldName, gc);
		gc.gridy = 2;
		this.add(textFieldSurname, gc);
		gc.gridy = 3;
		this.add(textFieldDate, gc);
		gc.gridy = 4;
		this.add(textFieldRegNumber, gc);
		gc.gridy = 5;
		this.add(textFieldPhoneNumber, gc);
		
		gc.gridx = 2;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.CENTER;
		this.add(searchPatientButton, gc); // Adds Button to content pane of frame
		
		//TODO Gabi aranjeaza interfata
		gc.gridx = 3;
		gc.gridy = 5;
		this.add(newPatientButton, gc);
		this.setVisible(true);
	}

	// ** Getters and setters//

	public JTextField getTextFieldDate() {
		return textFieldDate;
	}

	public void setTextFieldDate(JTextField textFieldDate) {
		this.textFieldDate = textFieldDate;
	}

}
