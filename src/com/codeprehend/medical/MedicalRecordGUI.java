package com.codeprehend.medical;


import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.codeprehend.medical.panels.ExaminationPatientPanel;
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
	
	public MedicalRecordGUI(){
		//initialize GUI
		this.setSize(1100, 500);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setResizable(false);
		
//		this.setSize(1100, 500);
		this.setLocationRelativeTo(null);
		//TODO Ask "Are you sure you want to leave the application? Check if there is anything unsaved"
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(numeFereastraPrincipala);
		
		//Create main panel
		   
		theMainPanel = new JPanel();
		theMainPanel.setLayout(new GridBagLayout());

		searchPatientPanel = new SearchPatientPanel(this);
		newPatientPanel = new NewPatientPanel(this);
		listOfPatientsPanel = new ListOfPatientsPanel(this);
		examinationPatientPanel = new ExaminationPatientPanel(this);
		modifyPatientPanel = new ModifyPatientPanel(this);
		
		theMainPanel.add(searchPatientPanel);
		theMainPanel.add(listOfPatientsPanel);
		theMainPanel.add(newPatientPanel);
		theMainPanel.add(examinationPatientPanel);
		theMainPanel.add(modifyPatientPanel);
		theMainPanel.setVisible(true);
	    
	    this.add(theMainPanel);
	    this.setVisible(true);
	}
	
	//TODO to put this in a controller outside this class?
	public void showPanelListOfPatients(List<Patient> listOfPatients) {
		//TODO see if there are time when this panel shouldnt be reset
		theMainPanel.remove(listOfPatientsPanel);
		listOfPatientsPanel = new ListOfPatientsPanel(this);
		theMainPanel.add(listOfPatientsPanel);
		
		listOfPatientsPanel.setPatientsEntries(listOfPatients);
		listOfPatientsPanel.setVisible(true);
		
		searchPatientPanel.setVisible(false);
		newPatientPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
	}

	
	//TODO to put this in a controller outside this class?
	public void showSearchPatientPanel() {
		searchPatientPanel.setVisible(true);
		
		newPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
	}
	
	
	public void showNewPatientPanel() {
		theMainPanel.remove(newPatientPanel);
		newPatientPanel = new NewPatientPanel(this);
		theMainPanel.add(newPatientPanel);
		newPatientPanel.setVisible(true);
		
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
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
	}
	
	public void showExaminationPatientPanel(Patient patient, List<Antecedent> antecedents, List<Examination> examinations) {
		theMainPanel.remove(examinationPatientPanel);
		examinationPatientPanel = new ExaminationPatientPanel(this);
		theMainPanel.add(examinationPatientPanel);
		
		examinationPatientPanel.setPatientInformations(patient);
		examinationPatientPanel.setAntecedents(antecedents);
		examinationPatientPanel.setPreviousExaminationEntries(examinations);
		examinationPatientPanel.setButtons();
		
		examinationPatientPanel.setVisible(true);
		
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