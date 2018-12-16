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
	private JLabel labelFirstName= new JLabel("Prenume: ");
	private JLabel labelRegNumber = new JLabel("CNP: ");
	private JLabel labelPhoneNumber = new JLabel("Tel: ");
	private JLabel labelEmpty3 = new JLabel(" ");
	private JLabel labelEmpty5 = new JLabel(" ");
	private JLabel labelEmpty7 = new JLabel(" ");
	private JLabel labelEmpty10 = new JLabel(" ");
	private JLabel labelEmpty11 = new JLabel(" ");
	private JTextField textFieldDate;
	private JTextField textFieldName;
	private JTextField textFieldFirstname;
	private JTextField textFieldRegNumber;
	private JTextField textFieldPhoneNumber;
		
	private JButton searchPatientButton = new JButton("Cauta Pacienta");
	private JButton newPatientButton = new JButton("Pacienta noua");
	
	private GridBagConstraints gc = new GridBagConstraints();

	public SearchPatientPanel(MedicalRecordGUI parent) {
		super();
		this.parentPanel = parent;

		// make a separate function
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String stringCurrentDate = format.format(currentDate);

		textFieldDate = new JTextField(15);
		textFieldDate.setText(stringCurrentDate);
		textFieldName = new JTextField(15);
		textFieldFirstname = new JTextField(15);
		textFieldRegNumber = new JTextField(15);
		textFieldPhoneNumber = new JTextField(15);

		searchPatientButton.addActionListener(new SearchPatientButtonActionListener(parentPanel));
		newPatientButton.addActionListener(new NewPatientButtonActionListener(parentPanel));

		Border operBorder = BorderFactory.createTitledBorder(CAUTA_PACIENT);
		this.setBorder(operBorder);
		
		this.setLayout(new GridBagLayout());
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		//gc.gridheight = 10000;
		Font font1 = new Font("TimesNewRoman", Font.BOLD, 15);
		textFieldName.setFont(font1);
		textFieldFirstname.setFont(font1);
		textFieldDate.setFont(font1);
		textFieldRegNumber.setFont(font1);
		textFieldPhoneNumber.setFont(font1);
		
		//Labels and textfields added on the search panel
		gc.gridx = 1;
		gc.gridy = 1;
		this.add(labelName, gc);
		gc.gridy = 2;
		this.add(labelFirstName, gc);
		gc.gridy = 3;
		this.add(labelEmpty3, gc);
		gc.gridy = 4;
		this.add(labelDate, gc);
		gc.gridy = 5;
		this.add(labelEmpty5, gc);
		gc.gridy = 6;
		this.add(labelRegNumber, gc);
		gc.gridy = 7;
		this.add(labelEmpty7, gc);
		gc.gridy = 8;
		this.add(labelPhoneNumber, gc);

		gc.gridx = 2;
		gc.gridy = 1;
		this.add(textFieldName, gc);
		gc.gridy = 2;
		this.add(textFieldFirstname, gc);
		gc.gridy = 3;
		this.add(labelEmpty3, gc);
		gc.gridy = 4;
		this.add(textFieldDate, gc);
		gc.gridy = 5;
		this.add(labelEmpty5, gc);
		gc.gridy = 6;
		this.add(textFieldRegNumber, gc);
		gc.gridy = 7;
		this.add(labelEmpty7, gc);
		gc.gridy = 8;
		this.add(textFieldPhoneNumber, gc);
		
		gc.gridx = 2;
		gc.gridy = 9;
		gc.anchor = GridBagConstraints.CENTER;
		this.add(searchPatientButton, gc); // Adds Button to content pane of frame
		
		//TODO Gabi aranjeaza interfata
		gc.gridy = 10;
		this.add(labelEmpty10, gc);
		gc.gridy = 11;
		this.add(labelEmpty11, gc);
		gc.gridx = 1;
		gc.gridy = 12;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;
		this.add(newPatientButton, gc);
		this.setVisible(true);
	}

	// ** Getters and setters//

	public JTextField getTextFieldDate() {
		return textFieldDate;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public JTextField getTextFieldFirstname() {
		return textFieldFirstname;
	}

	public JTextField getTextFieldRegNumber() {
		return textFieldRegNumber;
	}

	public JTextField getTextFieldPhoneNumber() {
		return textFieldPhoneNumber;
	}
}
