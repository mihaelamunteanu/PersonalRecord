package com.codeprehend.medical.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

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
	
	private List<Antecedent> antecedents = new ArrayList<Antecedent>();
	private List<Examination> examinations = new ArrayList<Examination>();
	
	private JTextArea examinationDiagnosis = new JTextArea();
	
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
	}
	

		
	public void setAntecedents(List<Antecedent> antecedents) {
		this.antecedents = antecedents;
	}
	
	/**
	 * Loads the list of history Examination objects into JPanel
	 * 
	 * @param patients
	 */
	public void setPreviousExaminationEntries(List<Examination> examinations) {
		this.examinations = examinations;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void  loadExaminationGUIForPatient(Patient pacient) {
//		JPanel GridBagLayoutPanel = new JPanel();
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		parentPanel.add(this, BorderLayout.CENTER);
		GridBagLayout gbl_GridBagLayoutPanel = new GridBagLayout();
		gbl_GridBagLayoutPanel.columnWidths = new int[] {0};
		gbl_GridBagLayoutPanel.rowHeights = new int[] {0, 0, 0};
		gbl_GridBagLayoutPanel.columnWeights = new double[]{1.0};
		gbl_GridBagLayoutPanel.rowWeights = new double[]{0.05, 0.9, 0.05};
		this.setLayout(gbl_GridBagLayoutPanel);
		
		JPanel InformationGridBagLayoutPanel =  new JPanel();
		GridBagConstraints gbc_InformationGridBagLayoutPanel = new GridBagConstraints();
		gbc_InformationGridBagLayoutPanel.insets = new Insets(5, 45, 0, 45);
		gbc_InformationGridBagLayoutPanel.weightx = 1.0;
		gbc_InformationGridBagLayoutPanel.fill = GridBagConstraints.BOTH;
		gbc_InformationGridBagLayoutPanel.gridx = 0;
		gbc_InformationGridBagLayoutPanel.gridy = 0;
		this.add(InformationGridBagLayoutPanel, gbc_InformationGridBagLayoutPanel);
		GridBagLayout gbl_InformationGridBagLayoutPanel = new GridBagLayout();
		gbl_InformationGridBagLayoutPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_InformationGridBagLayoutPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_InformationGridBagLayoutPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_InformationGridBagLayoutPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		InformationGridBagLayoutPanel.setLayout(gbl_InformationGridBagLayoutPanel);
		
		JLabel lblAntet = new JLabel("      ");
		GridBagConstraints gbc_lblAntet = new GridBagConstraints();
		gbc_lblAntet.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntet.gridx = 0;
		gbc_lblAntet.gridy = 0;
		InformationGridBagLayoutPanel.add(lblAntet, gbc_lblAntet);
		
		JLabel NameLabel = new JLabel(pacient.getNume());
		GridBagConstraints gbc_NameLabel = new GridBagConstraints();
		gbc_NameLabel.anchor = GridBagConstraints.WEST;
		gbc_NameLabel.weightx = 1.0;
		gbc_NameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_NameLabel.gridx = 0;
		gbc_NameLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(NameLabel, gbc_NameLabel);
		
		JLabel PrenumeLabel = new JLabel(pacient.getPrenume());
		GridBagConstraints gbc_PrenumeLabel = new GridBagConstraints();
		gbc_PrenumeLabel.anchor = GridBagConstraints.WEST;
		gbc_PrenumeLabel.weightx = 1.0;
		gbc_PrenumeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PrenumeLabel.gridx = 1;
		gbc_PrenumeLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(PrenumeLabel, gbc_PrenumeLabel);
		
		JLabel DataNastereLabel = new JLabel("Data nasterii: " + pacient.getDataNasterii());
		GridBagConstraints gbc_DataNastereLabel = new GridBagConstraints();
		gbc_DataNastereLabel.weightx = 1.0;
		gbc_DataNastereLabel.insets = new Insets(0, 0, 5, 5);
		gbc_DataNastereLabel.anchor = GridBagConstraints.WEST;
		gbc_DataNastereLabel.gridx = 2;
		gbc_DataNastereLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(DataNastereLabel, gbc_DataNastereLabel);
		
		JLabel CNPLabel = new JLabel("CNP: " +  pacient.getCnp());
		GridBagConstraints gbc_CNPLabel = new GridBagConstraints();
		gbc_CNPLabel.anchor = GridBagConstraints.WEST;
		gbc_CNPLabel.weightx = 1.0;
		gbc_CNPLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CNPLabel.gridx = 3;
		gbc_CNPLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(CNPLabel, gbc_CNPLabel);
		
		JLabel TelefonLabel = new JLabel("Telefon: " + pacient.getNumarTelefon());
		GridBagConstraints gbc_TelefonLabel = new GridBagConstraints();
		gbc_TelefonLabel.insets = new Insets(0, 0, 5, 0);
		gbc_TelefonLabel.anchor = GridBagConstraints.WEST;
		gbc_TelefonLabel.weightx = 1.0;
		gbc_TelefonLabel.gridx = 4;
		gbc_TelefonLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(TelefonLabel, gbc_TelefonLabel);
		
		JLabel lblNasteriNaturale = new JLabel("Nasteri naturale: " + pacient.getNasteriNaturale());
		GridBagConstraints gbc_lblNasteriNaturale = new GridBagConstraints();
		gbc_lblNasteriNaturale.anchor = GridBagConstraints.WEST;
		gbc_lblNasteriNaturale.insets = new Insets(0, 0, 0, 5);
		gbc_lblNasteriNaturale.gridx = 0;
		gbc_lblNasteriNaturale.gridy = 2;
		InformationGridBagLayoutPanel.add(lblNasteriNaturale, gbc_lblNasteriNaturale);
		
		JLabel lblCezariene = new JLabel("Cezariene: " + pacient.getCezariene());
		GridBagConstraints gbc_lblCezariene = new GridBagConstraints();
		gbc_lblCezariene.anchor = GridBagConstraints.WEST;
		gbc_lblCezariene.insets = new Insets(0, 0, 0, 5);
		gbc_lblCezariene.gridx = 1;
		gbc_lblCezariene.gridy = 2;
		InformationGridBagLayoutPanel.add(lblCezariene, gbc_lblCezariene);
		
		JLabel lblAvorturiLaCerere = new JLabel("Avorturi la cerere: " + pacient.getAvorturiLaCerere());
		GridBagConstraints gbc_lblAvorturiLaCerere = new GridBagConstraints();
		gbc_lblAvorturiLaCerere.anchor = GridBagConstraints.WEST;
		gbc_lblAvorturiLaCerere.insets = new Insets(0, 0, 0, 5);
		gbc_lblAvorturiLaCerere.gridx = 2;
		gbc_lblAvorturiLaCerere.gridy = 2;
		InformationGridBagLayoutPanel.add(lblAvorturiLaCerere, gbc_lblAvorturiLaCerere);
		
		JLabel lblAvorturiSpontane = new JLabel("Avorturi spontane: " + pacient.getAvorturiSpontane());
		GridBagConstraints gbc_lblAvorturiSpontane = new GridBagConstraints();
		gbc_lblAvorturiSpontane.anchor = GridBagConstraints.WEST;
		gbc_lblAvorturiSpontane.insets = new Insets(0, 0, 0, 5);
		gbc_lblAvorturiSpontane.gridx = 3;
		gbc_lblAvorturiSpontane.gridy = 2;
		InformationGridBagLayoutPanel.add(lblAvorturiSpontane, gbc_lblAvorturiSpontane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 45, 5, 45);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		this.add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setRowHeaderView(panel_1);
		
		JPanel medicalInfoPanel = new JPanel();
		scrollPane.setViewportView(medicalInfoPanel);
		GridBagLayout gbl_medicalInfoPanel = new GridBagLayout();
		gbl_medicalInfoPanel.columnWidths = new int[]{0};
//		gbl_medicalInfoPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_medicalInfoPanel.columnWeights = new double[]{1.0};
//		gbl_medicalInfoPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 
//				100.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		medicalInfoPanel.setLayout(gbl_medicalInfoPanel);
		
		
		JLabel label = new JLabel("     ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		gbc_label.gridwidth = 1;
		medicalInfoPanel.add(label, gbc_label);
		
		int ycoordinate = 1;

//for antecedente
		for (Antecedent antecedent : antecedents) {
			
			JLabel lblAntecedente = new JLabel("Antecedente " +  antecedent.getRegistrationDate());
			lblAntecedente.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblAntecedente.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblAntecedente = new GridBagConstraints();
			gbc_lblAntecedente.anchor = GridBagConstraints.WEST; 
			gbc_lblAntecedente.insets = new Insets(0, 0, 10, 5);
			gbc_lblAntecedente.gridx = 0;
			gbc_lblAntecedente.gridy = ycoordinate;
			gbc_lblAntecedente.weighty = Double.MIN_VALUE;
			medicalInfoPanel.add(lblAntecedente, gbc_lblAntecedente);
			
			String antecedentText = antecedent.getAntecedentText();
//					String antecedentTextProcessed = "<html>" + antecedentText + "</html>";
			
			JTextArea lblAntcedenteNumarulDoi = new JTextArea(antecedentText, 1, 1);
			lblAntcedenteNumarulDoi.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_lblAntcedenteNumarulDoi = new GridBagConstraints();
//					gbc_lblAntcedenteNumarulDoi.gridwidth = 1;
			gbc_lblAntcedenteNumarulDoi.anchor = GridBagConstraints.WEST;
			gbc_lblAntcedenteNumarulDoi.insets = new Insets(0, 0, 6, 5);
			gbc_lblAntcedenteNumarulDoi.gridx = 0;
			gbc_lblAntcedenteNumarulDoi.gridy = ycoordinate+1;
			gbc_lblAntcedenteNumarulDoi.weighty = Double.MIN_VALUE;
			gbc_lblAntcedenteNumarulDoi.weightx = 1.0;
			medicalInfoPanel.add(lblAntcedenteNumarulDoi, gbc_lblAntcedenteNumarulDoi);
			
			lblAntcedenteNumarulDoi.setEditable(false);  
			lblAntcedenteNumarulDoi.setCursor(null);  
			lblAntcedenteNumarulDoi.setOpaque(false);  
			lblAntcedenteNumarulDoi.setFocusable(false);
			
			ycoordinate = ycoordinate + 2;
		}
				
		examinationDiagnosis = new JTextArea(1,6);
		examinationDiagnosis.setFont(new Font("Monospaced", Font.ITALIC, 13));
		examinationDiagnosis.setRows(6);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		examinationDiagnosis.setText("\n\n\n\n\n\n\n\n");
		gbc_textArea.gridwidth = 1;
		gbc_textArea.insets = new Insets(3, 0, 3, 10);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = ycoordinate;
		gbc_textArea.weighty = 1.0;
		
		medicalInfoPanel.add(examinationDiagnosis, gbc_textArea);
		examinationDiagnosis.setText("");
//		examinationDiagnosis.setFocusable(true);
		
		ycoordinate = ycoordinate + 1;
		
//		for examinations
		for (Examination examination : examinations) {
			JLabel lblConsultatie = new JLabel("Consultatie " + examination.getConsultationDate());
			lblConsultatie.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblConsultatie = new GridBagConstraints();
			gbc_lblConsultatie.anchor = GridBagConstraints.WEST;
			gbc_lblConsultatie.insets = new Insets(0, 0, 10, 5);
			gbc_lblConsultatie.gridx = 0;
			gbc_lblConsultatie.gridy = ycoordinate + 1;
			medicalInfoPanel.add(lblConsultatie, gbc_lblConsultatie);
			
			JTextArea textAreaConsultatie = new JTextArea(examination.getText(), 1, 1);
			textAreaConsultatie.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_lblConsultatie_1 = new GridBagConstraints();
			gbc_lblConsultatie_1.anchor = GridBagConstraints.WEST;
			gbc_lblConsultatie_1.insets = new Insets(0, 0, 12, 5);
			gbc_lblConsultatie_1.gridx = 0;
			gbc_lblConsultatie_1.gridy = ycoordinate + 2;
			medicalInfoPanel.add(textAreaConsultatie, gbc_lblConsultatie_1);
			
			textAreaConsultatie.setEditable(false);  
			textAreaConsultatie.setCursor(null);  
			textAreaConsultatie.setOpaque(false);  
			textAreaConsultatie.setFocusable(false);
			
			ycoordinate = ycoordinate + 2;
		}
		
		JLabel lblSpaceFill = new JLabel("      ");
		GridBagConstraints gbc_lblSpaceFill = new GridBagConstraints();
		gbc_lblSpaceFill.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpaceFill.gridx = 0;
		gbc_lblSpaceFill.gridy = ycoordinate - 1;
		medicalInfoPanel.add(lblSpaceFill, gbc_lblSpaceFill);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(8, 25, 35, 15);
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 2;
		this.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0};
		gbl_buttonPanel.rowHeights = new int[]{0, 0};
		gbl_buttonPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_buttonPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton btnNewButton_7 = new JButton("Inapoi");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_7.gridx = 1;
		gbc_btnNewButton_7.gridy = 0;
		buttonPanel.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("Ecran principal");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_6.gridx = 2;
		gbc_btnNewButton_6.gridy = 0;
		buttonPanel.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("Modifica Pacient");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 3;
		gbc_btnNewButton_5.gridy = 0;
		buttonPanel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Atasamente");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 0;
		buttonPanel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnSalveaza = new JButton("SALVEAZA CONSULTATIE");
		btnSalveaza.setHorizontalAlignment(SwingConstants.RIGHT);
		btnSalveaza.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnSalveaza = new GridBagConstraints();
		gbc_btnSalveaza.anchor = GridBagConstraints.EAST;
		gbc_btnSalveaza.gridheight = 2;
		gbc_btnSalveaza.gridx = 5;
		gbc_btnSalveaza.gridy = 0;
		buttonPanel.add(btnSalveaza, gbc_btnSalveaza);
		
		//Action Listeners
		
		btnNewButton_7.addActionListener(new BackFromExaminationPatientPanelButtonActionListener(this.parentPanel));
		btnNewButton_6.addActionListener(new GoHomeFromExaminationPatientButtonListener(this.parentPanel));
		btnNewButton_5.addActionListener(new ModifyPatientButtonActionListener(this.parentPanel, currentPatient));
		btnSalveaza.addActionListener(new SaveExaminationButtonActionListener(parentPanel, currentPatient));
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccesFilesExaminationButtonActionListener.actionPerformed(parentPanel, currentPatient);
			}
		});
	}
	public JTextArea getExaminationDiagnosis() {
		return examinationDiagnosis;
	}
	
}
	

	
	
