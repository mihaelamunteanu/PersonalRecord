package com.codeprehend.medical.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.PatientsDAO;
import com.codeprehend.medical.listeners.NewPatientButtonActionListener;
import com.codeprehend.medical.listeners.SearchPatientButtonActionListener;
import com.codeprehend.medical.resources.Patient;

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

	private JLabel labelDate = new JLabel("Data nastere (aaaa-ll-zz): ");
	private JLabel labelName = new JLabel("Nume: ");
	private JLabel labelFirstName= new JLabel("Prenume: ");
	private JLabel labelRegNumber = new JLabel("CNP: ");
	private JLabel labelPhoneNumber = new JLabel("Tel: ");
	private JTextField textFieldDate = new JTextField();;
	private JTextField textFieldName = new JTextField();;
	private JTextField textFieldFirstname = new JTextField();;
	private JTextField textFieldRegNumber = new JTextField();;
	private JTextField textFieldPhoneNumber = new JTextField();;
		
	private JButton searchPatientButton = new JButton("Cauta Pacienta");
	private JButton newPatientButton = new JButton("Pacienta noua");
	
	public SearchPatientPanel(MedicalRecordGUI parent) {
		super();
		this.parentPanel = parent;
		
		this.setFont(new Font("Times New Roman", Font.BOLD, 11));
		this.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cautare pacienta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Cautare pacienta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		this.setLayout(null);

		// make a separate function
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String stringCurrentDate = format.format(currentDate);

		searchPatientButton.addActionListener(new SearchPatientButtonActionListener(parentPanel));
		newPatientButton.addActionListener(new NewPatientButtonActionListener(parentPanel));

		this.setFont(new Font("Times New Roman", Font.BOLD, 11));
		this.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cautare pacienta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Cautare pacienta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		this.setLayout(null);
		
		//Labels and text fields added on the search panel
		textFieldName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldName.setBounds(148, 27, 200, 26);
		this.add(textFieldName);
		textFieldName.setColumns(10);
		
		labelName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelName.setBounds(10, 33, 46, 14);
		this.add(labelName);
		
		labelFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelFirstName.setBounds(10, 72, 65, 14);
		this.add(labelFirstName);
		
		textFieldFirstname.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldFirstname.setBounds(148, 66, 200, 26);
		this.add(textFieldFirstname);
		textFieldFirstname.setColumns(10);
		
		labelDate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelDate.setBounds(10, 111, 141, 20);
		this.add(labelDate);
		
		textFieldDate.setBounds(148, 105, 200, 26);
		this.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		
		labelRegNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelRegNumber.setBounds(10, 154, 83, 14);
		this.add(labelRegNumber);
		
		textFieldRegNumber = new JTextField();
		textFieldRegNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldRegNumber.setBounds(148, 148, 200, 26);
		this.add(textFieldRegNumber);
		textFieldRegNumber.setColumns(10);
		
		labelPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelPhoneNumber.setBounds(10, 193, 83, 14);
		this.add(labelPhoneNumber);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setBounds(148, 187, 200, 26);
		this.add(textFieldPhoneNumber);
		
		
		
		//searchPatientButton.setBackground(new Color(230, 230, 250));
		
		searchPatientButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchPatientButton.setBounds(85, 236, 181, 23);
		this.add(searchPatientButton);
		
		newPatientButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newPatientButton.setBounds(30, 333, 260, 23);
		this.add(newPatientButton);
		
		
		
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
