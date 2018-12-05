package com.codeprehend.medical.panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.listeners.SearchPatientButtonActionListener;

/**
 * Separate class for panel with search patient
 * 
 * @author Mihaela Munteanu
 *
 */
public class SearchPatientPanel extends JPanel {

	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;

	private MedicalRecordGUI parentPanel;

	private JLabel labelSearchPatient = new JLabel("Cautare Pacient: ");
	private JLabel labelDate = new JLabel("Data nastere: ");
	private JLabel labelName = new JLabel("Nume pacient: ");
	private JLabel labelRegNumber = new JLabel("CNP: ");
	private JLabel labelPhoneNumber = new JLabel("Tel: ");
	private JTextField textFieldDate;
	private JTextField textFieldName;
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

		textFieldDate = new JTextField(10);
		textFieldDate.setText(stringCurrentDate);
		textFieldName = new JTextField(10);
		textFieldRegNumber = new JTextField(10);
		textFieldPhoneNumber = new JTextField(10);

		searchPatientButton.addActionListener(new SearchPatientButtonActionListener(parentPanel));

		Border operBorder = BorderFactory.createTitledBorder("Cauta pacienta:");
		this.setBorder(operBorder);
		
		this.setLayout(new GridBagLayout());
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		//Labels and textfields added on the search panel
		gc.gridx = 1;
		gc.gridy = 1;
		this.add(labelName, gc);
		gc.gridy = 2;
		this.add(labelDate, gc);
		gc.gridy = 3;
		this.add(labelRegNumber, gc);
		gc.gridy = 4;
		this.add(labelPhoneNumber, gc);

		gc.gridx = 2;
		gc.gridy = 1;
		this.add(textFieldName, gc);
		gc.gridy = 2;
		this.add(textFieldDate, gc);
		gc.gridy = 3;
		this.add(textFieldRegNumber, gc);
		gc.gridy = 4;
		this.add(textFieldPhoneNumber, gc);
		
		gc.gridx = 3;
		gc.gridy = 2;
		gc.gridheight = 100;
		this.add(searchPatientButton, gc); // Adds Button to content pane of frame
		//this.add(newPatientButton);
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
