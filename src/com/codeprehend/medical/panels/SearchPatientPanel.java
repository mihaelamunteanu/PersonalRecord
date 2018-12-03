package com.codeprehend.medical.panels;

import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.listeners.SearchPatientButtonActionListener;

/** 
 * Separate class for panel with search patient 
 * @author mihae
 *
 */
public class SearchPatientPanel extends JPanel {
	
	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	
	private MedicalRecordGUI parentPanel; 
	
	private JLabel labelSearchPatient = new JLabel("Cautare Pacient: ");;
	private JTextField textFieldDate;
	private JButton searchPatientButton = new JButton("Cauta Pacienta");
	
	public SearchPatientPanel (MedicalRecordGUI parent) {
		super();
		this.setLayout(new GridBagLayout());
		this.parentPanel = parent;
		
		//make a separate function
		Date currentDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String stringCurrentDate = format.format(currentDate);

		textFieldDate = new JTextField(stringCurrentDate);
		
		searchPatientButton.addActionListener(new SearchPatientButtonActionListener(parentPanel));
		
		this.add(labelSearchPatient);
		this.add(textFieldDate);
		this.add(searchPatientButton); // Adds Button to content pane of frame
		this.setVisible(true);
	}
	
	//** Getters and setters//

	public JTextField getTextFieldDate() {
		return textFieldDate;
	}

	public void setTextFieldDate(JTextField textFieldDate) {
		this.textFieldDate = textFieldDate;
	}
	
}
