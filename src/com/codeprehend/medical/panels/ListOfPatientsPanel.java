package com.codeprehend.medical.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.listeners.AccesFilesExaminationButtonActionListener;
import com.codeprehend.medical.listeners.AccessExamButtonActionListener;
import com.codeprehend.medical.listeners.BackFromListOfPatientsPanelButtonActionListener;
import com.codeprehend.medical.resources.Patient;

/** 
 * Separate class for the panel with the detected list of Patients. 
 * 
 * @author Mihaela Munteanu
 * @since 12 Dec 2018
 *
 */
public class ListOfPatientsPanel extends JPanel {
	public static String ACCESS_DOSAR = "Acces Dosar";
	
	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	
	private MedicalRecordGUI parentPanel;
	
	private JList listOfPatients = new JList();

	public ListOfPatientsPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(null);

		this.parentPanel = parent;
		this.setVisible(false);
	}
	
	public void loadListOfPatientsGUIPanel(List<Patient> patients) {
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
		gbl_InformationGridBagLayoutPanel.columnWidths = new int[]{0};
		gbl_InformationGridBagLayoutPanel.rowHeights = new int[]{0};
		gbl_InformationGridBagLayoutPanel.columnWeights = new double[]{1.0};
		gbl_InformationGridBagLayoutPanel.rowWeights = new double[]{0.0};
		InformationGridBagLayoutPanel.setLayout(gbl_InformationGridBagLayoutPanel);
		
		JLabel lblAntet = new JLabel("Lista paciente");
		GridBagConstraints gbc_lblAntet = new GridBagConstraints();
		gbc_lblAntet.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntet.gridx = 0;
		gbc_lblAntet.gridy = 0;
		InformationGridBagLayoutPanel.add(lblAntet, gbc_lblAntet);
		
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
		gbl_medicalInfoPanel.rowHeights = new int[]{0};
		gbl_medicalInfoPanel.columnWeights = new double[]{1.0};
		gbl_medicalInfoPanel.rowWeights = new double[]{1.0};
		medicalInfoPanel.setLayout(gbl_medicalInfoPanel);
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		medicalInfoPanel.add(listOfPatients, gbc_list);
		
		DefaultListModel DLM = new DefaultListModel();
		for (Patient pacient: patients) {
			String str = new String ("");
			str = str.concat(pacient.getNume());
			str = str.concat("  ");
			str = str.concat(pacient.getPrenume());
			str = str.concat("   ");
			str = str.concat(pacient.getDataNasterii().toString());
			str = str.concat("   CNP: ");
			str = str.concat(pacient.getCnp());
			str = str.concat("   tel: ");
			str = str.concat(pacient.getNumarTelefon() != null ? pacient.getNumarTelefon() : "");
			DLM.addElement(str);
								
		}
		
		listOfPatients.setModel(DLM);
		
		listOfPatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		JLabel label = new JLabel("     ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		medicalInfoPanel.add(label, gbc_label);
		
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
		
		JButton backButton = new JButton("Inapoi la cautare");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 1;
		gbc_btnNewButton_7.gridy = 0;
		buttonPanel.add(backButton, gbc_btnNewButton_7);
		
		backButton.addActionListener(new BackFromListOfPatientsPanelButtonActionListener(parentPanel));
		
		JButton filesAccesButton = new JButton("Acceseaza fisiere");
		GridBagConstraints gbc_btnAcceseazaFisiere = new GridBagConstraints();
		gbc_btnAcceseazaFisiere.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcceseazaFisiere.gridx = 3;
		gbc_btnAcceseazaFisiere.gridy = 0;
		buttonPanel.add(filesAccesButton, gbc_btnAcceseazaFisiere);
		
		JButton folderAccessButton = new JButton("Acceseaza dosar");
		folderAccessButton.setVerticalAlignment(SwingConstants.TOP);
		folderAccessButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnAccesDosar = new GridBagConstraints();
		gbc_btnAccesDosar.anchor = GridBagConstraints.NORTH;
		gbc_btnAccesDosar.gridheight = 2;
		gbc_btnAccesDosar.gridx = 5;
		gbc_btnAccesDosar.gridy = 0;
		buttonPanel.add(folderAccessButton, gbc_btnAccesDosar);
		
		filesAccesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccesFilesExaminationButtonActionListener.actionPerformed(parentPanel, patients.get(listOfPatients.getSelectedIndex()));
			}
		});
		
		folderAccessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccessExamButtonActionListener.actionPerformed(parentPanel, patients.get(listOfPatients.getSelectedIndex()));
			}
		});
	}
}
