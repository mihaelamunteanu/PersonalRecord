package com.codeprehend.medical;


import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.codeprehend.medical.panels.ExaminationPatientPanel;
import com.codeprehend.medical.panels.FilesPatientPanel;
import com.codeprehend.medical.panels.ListOfPatientsPanel;
import com.codeprehend.medical.panels.ModifyPatientPanel;
import com.codeprehend.medical.panels.NewPatientPanel;
import com.codeprehend.medical.panels.SearchPatientPanel;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Examination;
import com.codeprehend.medical.resources.Patient;


/**
 * Class containing the main window and the process.
 * 
 * @author Gabriel Munteanu
 * @since 13.11.2015
 *
 */

public class MedicalRecordGUI extends JFrame {
	
	/**
	 * Default serial Version
	 */
	private static final long serialVersionUID = 1L;
	
	public static String numeFereastraPrincipala = "Dosare medicale medic Rugina Cosmin @codeprehend.com";

	public static String searchPacient = "Cautati Pacienta dupa data nasterii";
	
	private MedicalRecordSnapshot snaphotRecord = new MedicalRecordSnapshot();
	
//	private JFrame framePrincipal;
	
	private JPanel theMainPanel;	
	private SearchPatientPanel searchPatientPanel;
	private NewPatientPanel newPatientPanel;
	private ExaminationPatientPanel examinationPatientPanel;
	private ListOfPatientsPanel listOfPatientsPanel;
	private ModifyPatientPanel modifyPatientPanel;
	private FilesPatientPanel filesPatientPanel;
	
	public MedicalRecordGUI(){
		//initialize GUI
		this.setSize(1000, 700);
		this.setResizable(true);
		
//		this.setSize(1100, 500);
		this.setLocationRelativeTo(null);
		//TODO Ask "Are you sure you want to leave the application? Check if there is anything unsaved"
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(numeFereastraPrincipala);
		
		//Create main panel
		   
		theMainPanel = new JPanel();
		theMainPanel.setLayout(null);

		searchPatientPanel = new SearchPatientPanel(this);
		newPatientPanel = new NewPatientPanel(this);
		listOfPatientsPanel = new ListOfPatientsPanel(this);
		examinationPatientPanel = new ExaminationPatientPanel(this);
		modifyPatientPanel = new ModifyPatientPanel(this);
		filesPatientPanel = new FilesPatientPanel(this);
		
		
		searchPatientPanel.setBounds(253, 22, 360, 367);
		theMainPanel.add(searchPatientPanel);
		
		listOfPatientsPanel.setBounds(150, 22, 700, 367);
		theMainPanel.add(listOfPatientsPanel);
		
		newPatientPanel.setBounds(40, 20, 882, 509);
		theMainPanel.add(newPatientPanel);
		
		examinationPatientPanel.setBounds(253, 22, 800, 367);
		theMainPanel.add(examinationPatientPanel);
		
		modifyPatientPanel.setBounds(40, 20, 882, 509);
		theMainPanel.add(modifyPatientPanel);
		
		filesPatientPanel.setBounds(253, 22, 800, 367);
		theMainPanel.add(filesPatientPanel);
		
		theMainPanel.setVisible(true);
	    
	    this.add(theMainPanel);
	    this.setVisible(true);
	}
	
	//TODO to put this in a controller outside this class?
	public void showPanelListOfPatients(List<Patient> listOfPatients) {
		//TODO see if there are time when this panel shouldnt be reset
		theMainPanel.remove(listOfPatientsPanel);
		listOfPatientsPanel = new ListOfPatientsPanel(this);
		listOfPatientsPanel.setBounds(150, 22, 700, 367);
		theMainPanel.add(listOfPatientsPanel);
		
		listOfPatientsPanel.setPatientsEntries(listOfPatients);
		listOfPatientsPanel.setVisible(true);
		
		searchPatientPanel.setVisible(false);
		newPatientPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
		examinationPatientPanel.setVisible(false);
		filesPatientPanel.setVisible(false);
	}
	
	public void showPanelListOfPatients() {
		listOfPatientsPanel.setVisible(true);
		
		searchPatientPanel.setVisible(false);
		newPatientPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
		examinationPatientPanel.setVisible(false);
		filesPatientPanel.setVisible(false);
	}

	
	//TODO to put this in a controller outside this class?
	public void showSearchPatientPanel() {
		searchPatientPanel.setVisible(true);
		
		examinationPatientPanel.setVisible(false);
		newPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
		filesPatientPanel.setVisible(false);
	}
	
	
	public void showNewPatientPanel() {
		theMainPanel.remove(newPatientPanel);
		newPatientPanel = new NewPatientPanel(this);
		theMainPanel.add(newPatientPanel);
		newPatientPanel.setVisible(true);
		
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
		examinationPatientPanel.setVisible(false);
		filesPatientPanel.setVisible(false);
	}
	
	public void showModifyPatientPanel(Patient patient, List<Antecedent> antecedents) {
		theMainPanel.remove(modifyPatientPanel);
		modifyPatientPanel = new ModifyPatientPanel(this);
		theMainPanel.add(modifyPatientPanel);
		
		modifyPatientPanel.setPatientEntry(patient);
		modifyPatientPanel.setAntecedentEntries(antecedents);
		modifyPatientPanel.setVisible(true);
		
		newPatientPanel.setVisible(false);
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		examinationPatientPanel.setVisible(false);
		filesPatientPanel.setVisible(false);
	}
	
	public void showExaminationPatientPanel(Patient patient, List<Antecedent> antecedents, List<Examination> examinations) {
		/*Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setSize(1100, dim.getSize().height);
		this.setLocation(dim.width/2-this.getSize().width/2, 0);
		*/
		theMainPanel.remove(examinationPatientPanel);
		examinationPatientPanel = new ExaminationPatientPanel(this);
		theMainPanel.add(examinationPatientPanel);
		
		examinationPatientPanel.setPatientInformations(patient);
		examinationPatientPanel.setAntecedents(antecedents);
		examinationPatientPanel.setPreviousExaminationEntries(examinations);
	//	examinationPatientPanel.setButtons();
		
		examinationPatientPanel.setVisible(true);
		
		newPatientPanel.setVisible(false);
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
		filesPatientPanel.setVisible(false);
	}
	
	public void showFilesPatientPanel(Patient patient){
		
		theMainPanel.remove(filesPatientPanel);
		filesPatientPanel = new FilesPatientPanel(this);
		theMainPanel.add(filesPatientPanel);
		
	//	examinationPatientPanel.setPatientInformations(patient);
	//	examinationPatientPanel.setAntecedents(antecedents);
	//	examinationPatientPanel.setPreviousExaminationEntries(examinations);
		
		filesPatientPanel.setPatientFiles(patient);
		filesPatientPanel.setVisible(true);
		
		examinationPatientPanel.setVisible(false);
		newPatientPanel.setVisible(false);
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
	}
	
	//** Getters and setters //
	
	public MedicalRecordSnapshot getSnaphotRecord() {
		return snaphotRecord;
	}

	public void setSnaphotRecord(MedicalRecordSnapshot snaphotRecord) {
		this.snaphotRecord = snaphotRecord;
	}

	public SearchPatientPanel getSearchPatientPanel() {
		return searchPatientPanel;
	}

	public NewPatientPanel getNewPatientPanel() {
		return newPatientPanel;
	}

	public ExaminationPatientPanel getExaminationPatientPanel() {
		return examinationPatientPanel;
	}

	public ListOfPatientsPanel getListOfPatientsPanel() {
		return listOfPatientsPanel;
	}

	public ModifyPatientPanel getModifyPatientPanel() {
		return modifyPatientPanel;
	}
	
}