package com.codeprehend.medical.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

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

	private MedicalRecordGUI parentPanel;

	private JTextField textFieldDate = new JTextField();;
	private JTextField textFieldName = new JTextField();;
	private JTextField textFieldFirstname = new JTextField();;
	private JTextField textFieldRegNumber = new JTextField();;
	private JTextField textFieldPhoneNumber = new JTextField();;
	
	public SearchPatientPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(null);
		
		this.parentPanel = parent;
		this.setVisible(true);
	}

	public void loadSearchPatientGUIPanel() {
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		parentPanel.add(this, BorderLayout.CENTER);
		GridBagLayout gbl_GridBagLayoutPanel = new GridBagLayout();
		gbl_GridBagLayoutPanel.columnWidths = new int[] {0};
		gbl_GridBagLayoutPanel.rowHeights = new int[] {0, 0};
		gbl_GridBagLayoutPanel.columnWeights = new double[]{1.0};
		gbl_GridBagLayoutPanel.rowWeights = new double[]{0.9, 0.05};
		this.setLayout(gbl_GridBagLayoutPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 45, 5, 45);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		this.add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setRowHeaderView(panel_1);
		
		JPanel medicalInfoPanel = new JPanel();
		scrollPane.setViewportView(medicalInfoPanel);
		GridBagLayout gbl_medicalInfoPanel = new GridBagLayout();
		gbl_medicalInfoPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_medicalInfoPanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
		gbl_medicalInfoPanel.columnWeights = new double[]{1.0, 0.2, 0.1, 2.0};
		gbl_medicalInfoPanel.rowWeights = new double[]{1.0, 0.1, 0.1, 0.1, 0.1, 0.1, 1.0};
		medicalInfoPanel.setLayout(gbl_medicalInfoPanel);
		
		JLabel label = new JLabel("     ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 6;
		medicalInfoPanel.add(label, gbc_label);
		
		JLabel lblNume = new JLabel("Nume");
		GridBagConstraints gbc_lblNume = new GridBagConstraints();
		gbc_lblNume.anchor = GridBagConstraints.EAST;
		gbc_lblNume.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume.gridx = 1;
		gbc_lblNume.gridy = 1;
		medicalInfoPanel.add(lblNume, gbc_lblNume);
		
		textFieldName = new JTextField();
		GridBagConstraints gbc_txtMunteanu = new GridBagConstraints();
		gbc_txtMunteanu.insets = new Insets(0, 0, 5, 0);
		gbc_txtMunteanu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMunteanu.gridx = 2;
		gbc_txtMunteanu.gridy = 1;
		medicalInfoPanel.add(textFieldName, gbc_txtMunteanu);
		
		JLabel lblPrenume = new JLabel("Prenume");
		GridBagConstraints gbc_lblPrenume = new GridBagConstraints();
		gbc_lblPrenume.anchor = GridBagConstraints.EAST;
		gbc_lblPrenume.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenume.gridx = 1;
		gbc_lblPrenume.gridy = 2;
		medicalInfoPanel.add(lblPrenume, gbc_lblPrenume);
		
		textFieldFirstname = new JTextField();
		GridBagConstraints gbc_txtMihaela = new GridBagConstraints();
		gbc_txtMihaela.insets = new Insets(0, 0, 5, 0);
		gbc_txtMihaela.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMihaela.gridx = 2;
		gbc_txtMihaela.gridy = 2;
		medicalInfoPanel.add(textFieldFirstname, gbc_txtMihaela);
		textFieldFirstname.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon");
		GridBagConstraints gbc_lblTelefon = new GridBagConstraints();
		gbc_lblTelefon.anchor = GridBagConstraints.EAST;
		gbc_lblTelefon.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefon.gridx = 1;
		gbc_lblTelefon.gridy = 3;
		medicalInfoPanel.add(lblTelefon, gbc_lblTelefon);
		
		textFieldPhoneNumber = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		medicalInfoPanel.add(textFieldPhoneNumber, gbc_textField_1);
		textFieldPhoneNumber.setColumns(10);
		
		JLabel lblDataNastere = new JLabel("Data nastere");
		GridBagConstraints gbc_lblDataNastere = new GridBagConstraints();
		gbc_lblDataNastere.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataNastere.anchor = GridBagConstraints.EAST;
		gbc_lblDataNastere.gridx = 1;
		gbc_lblDataNastere.gridy = 4;
		medicalInfoPanel.add(lblDataNastere, gbc_lblDataNastere);
		
		textFieldDate = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		medicalInfoPanel.add(textFieldDate, gbc_textField);
		textFieldDate.setColumns(10);
		
		JLabel lblCnp = new JLabel("CNP");
		GridBagConstraints gbc_lblCnp = new GridBagConstraints();
		gbc_lblCnp.anchor = GridBagConstraints.EAST;
		gbc_lblCnp.insets = new Insets(0, 0, 5, 5);
		gbc_lblCnp.gridx = 1;
		gbc_lblCnp.gridy = 5;
		medicalInfoPanel.add(lblCnp, gbc_lblCnp);
		
		textFieldRegNumber = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		medicalInfoPanel.add(textFieldRegNumber, gbc_textField_2);
		textFieldRegNumber.setColumns(10);
		
		JLabel label1 = new JLabel("     ");
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.insets = new Insets(0, 0, 0, 5);
		gbc_label1.gridx = 1;
		gbc_label1.gridy = 6;
		medicalInfoPanel.add(label1, gbc_label1);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(8, 25, 35, 15);
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 1;
		this.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0, 0};
		gbl_buttonPanel.rowHeights = new int[]{0, 0};
		gbl_buttonPanel.columnWeights = new double[]{1.0, 1.0};
		gbl_buttonPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton btnNewPatient = new JButton("Pacienta noua");
		btnNewPatient.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnAcceseazaFisiere = new GridBagConstraints();
		gbc_btnAcceseazaFisiere.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcceseazaFisiere.gridx = 0;
		gbc_btnAcceseazaFisiere.gridy = 0;
		buttonPanel.add(btnNewPatient, gbc_btnAcceseazaFisiere);
		
		JButton btnSearchPatient = new JButton("Cautare pacienta");
		btnSearchPatient.setVerticalAlignment(SwingConstants.TOP);
		btnSearchPatient.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnSalveaza = new GridBagConstraints();
		gbc_btnSalveaza.anchor = GridBagConstraints.NORTH;
		gbc_btnSalveaza.gridheight = 2;
		gbc_btnSalveaza.gridx = 1;
		gbc_btnSalveaza.gridy = 0;
		buttonPanel.add(btnSearchPatient, gbc_btnSalveaza);
		
		btnSearchPatient.addActionListener(new SearchPatientButtonActionListener(parentPanel));
		btnNewPatient.addActionListener(new NewPatientButtonActionListener(parentPanel));

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
