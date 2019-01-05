package com.codeprehend.medical.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.AtachementsDAO;
import com.codeprehend.medical.listeners.AccesFilesExaminationButtonActionListener;
import com.codeprehend.medical.listeners.AccessExamButtonActionListener;
import com.codeprehend.medical.listeners.BackFromExaminationPatientPanelButtonActionListener;
import com.codeprehend.medical.listeners.BackFromListOfPatientsPanelButtonActionListener;
import com.codeprehend.medical.listeners.GoHomeFromExaminationPatientButtonListener;
import com.codeprehend.medical.listeners.ModifyPatientButtonActionListener;
import com.codeprehend.medical.listeners.SaveExaminationButtonActionListener;
import com.codeprehend.medical.resources.Attachement;
import com.codeprehend.medical.resources.Patient;

public class FilesPatientPanel extends JPanel {
	/**
	 * Default serial key. 
	 */
	private static final long serialVersionUID = 1L;
	
	private MedicalRecordGUI parentPanel;
	private Patient currentPatient; 

	private JTextField patientPersonalInfoTextField = new JTextField();
	private JTextField patientMedicalInfoTextField = new JTextField();
	private JTextField browseFileTextField = new JTextField();
	
	private JScrollPane scrollPane = new JScrollPane();
	
	private JButton homeButton = new JButton("Ecran principal");
	private JButton backFromFilesPanel = new JButton("Inapoi la lista");
	private JButton modifyPatientInfoButton = new JButton("Modifica info");
	private JButton saveFilesButton = new JButton("Salveaza fisier");
	private JButton folderAccesButton = new JButton("Acceseaza dosarul");
	private JButton browseFileButton = new JButton("Cauta fisier");
	
	private JFileChooser selectFile = new JFileChooser();
	
	private File file;
	
	private JPanel panel_2 = new JPanel();
	
	private JList listOfFiles = new JList();
	
	public FilesPatientPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(null);

		this.parentPanel = parent;
		this.setVisible(false);
	}
	
	public void setPatientFiles(Patient pacient){
		this.currentPatient = pacient;
		
		loadFilesGUIForPatient(currentPatient);
		
		//examinationDiagnosis = new JTextArea();
		//examinationDiagnosis.setSize(100, 100);
		//saveExaminationButton.addActionListener(new SaveExaminationButtonActionListener(parentPanel, currentPatient));
		
		//this.add(examinationDiagnosis);
		//this.add(saveExaminationButton);
	}
	
	private void loadFilesGUIForPatient(Patient pacient) {
		
		String patientPersonalInfoText = new String("");
		
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getNume());
		patientPersonalInfoText = patientPersonalInfoText.concat(" ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getPrenume());
		patientPersonalInfoText = patientPersonalInfoText.concat("    data nasterii: ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getDataNasterii().toString());
		patientPersonalInfoText = patientPersonalInfoText.concat("     CNP: ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getCnp());
		patientPersonalInfoText = patientPersonalInfoText.concat("     Tel: ");
		patientPersonalInfoText = patientPersonalInfoText.concat(pacient.getNumarTelefon());
		
		String patientMedicalInfoText = new String("");
		patientMedicalInfoText = patientMedicalInfoText.concat("Nasteri naturale: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getNasteriNaturale()));
		patientMedicalInfoText = patientMedicalInfoText.concat("   Cezariene: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getCezariene()));
		patientMedicalInfoText = patientMedicalInfoText.concat("   Avorturi la cerere: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getAvorturiLaCerere()));
		patientMedicalInfoText = patientMedicalInfoText.concat("    Avorturi spontane: ");
		patientMedicalInfoText = patientMedicalInfoText.concat(Integer.toString(pacient.getAvorturiSpontane()));


		//this.setBorder(new TitledBorder(null, "Lista fisiere", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setBounds(10, 11, 882, 532);
		this.setLayout(null);
		
		saveFilesButton.setBounds(400, 450, 156, 52);
		this.add(saveFilesButton);
		
		modifyPatientInfoButton.setBounds(656, 254, 156, 52);
		this.add(modifyPatientInfoButton);
		
		browseFileButton.setBounds(150, 450, 156, 52);
		this.add(browseFileButton);
		
		browseFileTextField.setEditable(false);
		browseFileTextField.setFont(new Font("Times New Roman", Font.BOLD, 13));
		browseFileTextField.setColumns(10);
		browseFileTextField.setBackground(Color.WHITE);
		browseFileTextField.setBounds(27, 410, 573, 28);
		this.add(browseFileTextField);
		
		backFromFilesPanel.setBounds(681, 459, 131, 39);
		this.add(backFromFilesPanel);
		
		homeButton.setBounds(681, 409, 131, 39);
		this.add(homeButton);
		
		folderAccesButton.setBounds(656, 146, 156, 52);
		this.add(folderAccesButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Date pacienta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(28, 23, 573, 77);
		this.add(panel_1);
		panel_1.setLayout(null);
		
		patientPersonalInfoTextField.setText(patientPersonalInfoText);
		patientPersonalInfoTextField.setBackground(Color.WHITE);
		patientPersonalInfoTextField.setBounds(6, 16, 561, 28);
		panel_1.add(patientPersonalInfoTextField);
		patientPersonalInfoTextField.setEditable(false);
		patientPersonalInfoTextField.setFont(new Font("Times New Roman", Font.BOLD, 13));
		patientPersonalInfoTextField.setColumns(10);
		
		patientMedicalInfoTextField.setText(patientMedicalInfoText);
		patientMedicalInfoTextField.setBackground(Color.WHITE);
		patientMedicalInfoTextField.setBounds(6, 42, 561, 28);
		panel_1.add(patientMedicalInfoTextField);
		patientMedicalInfoTextField.setEditable(false);
		patientMedicalInfoTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		patientMedicalInfoTextField.setColumns(10);
		
		List<Attachement> attachements = new ArrayList<Attachement>();
		attachements = AtachementsDAO.getAttachmentsByPatientId(pacient.getId());
		
		DefaultListModel DLM = new DefaultListModel();
		for (Attachement attachement: attachements) {
			
			String str = new String ("");
			str = str.concat(attachement.getFileName());
			str = str.concat(".");
			str = str.concat(attachement.getFileType());

			DLM.addElement(str);
								
		}
		
		listOfFiles.setModel(DLM);
		
		listOfFiles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista fisiere", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(27, 133, 573, 230);
		panel_2.setLayout(null);
		panel_2.add(scrollPane);
		
		scrollPane.setBounds(6, 16, 561, 210);
		
		scrollPane.setViewportView(listOfFiles);
		
		this.add(panel_2);	
		
		
		//Action Listeners
		
		//modifyPatientInfoButton.addActionListener(new ModifyPatientButtonActionListener(this.parentPanel, currentPatient));
		
		backFromFilesPanel.addActionListener(new BackFromExaminationPatientPanelButtonActionListener(this.parentPanel));
		homeButton.addActionListener(new GoHomeFromExaminationPatientButtonListener(this.parentPanel));
		
		folderAccesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AccessExamButtonActionListener(parentPanel, pacient);
			}
		});
		
		backFromFilesPanel.addActionListener(new BackFromExaminationPatientPanelButtonActionListener(this.parentPanel));
		homeButton.addActionListener(new GoHomeFromExaminationPatientButtonListener(this.parentPanel));
		
		browseFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				selectFile.showOpenDialog(parentPanel);
				
				file = selectFile.getSelectedFile();
				browseFileTextField.setText(selectFile.getSelectedFile().toString());
			}
		});
		
		//saveFilesButton.addActionListener(new SaveFilesButton());
		

	}
	
	
}
