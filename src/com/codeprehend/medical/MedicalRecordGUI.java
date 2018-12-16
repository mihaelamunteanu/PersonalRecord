package com.codeprehend.medical;


import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.codeprehend.medical.panels.ExaminationPatientPanel;
import com.codeprehend.medical.panels.ListOfPatientsPanel;
import com.codeprehend.medical.panels.NewPatientPanel;
import com.codeprehend.medical.panels.SearchPatientPanel;
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
	
	public MedicalRecordGUI(){
		//initialize GUI
		
		this.setSize(1100, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(numeFereastraPrincipala);
		
		//Create main panel
		   
		theMainPanel = new JPanel();
		theMainPanel.setLayout(new GridBagLayout());
		
		searchPatientPanel = new SearchPatientPanel(this);
		newPatientPanel = new NewPatientPanel(this);
		listOfPatientsPanel = new ListOfPatientsPanel(this);
		examinationPatientPanel = new ExaminationPatientPanel(this);
		
		theMainPanel.add(searchPatientPanel);
		theMainPanel.add(listOfPatientsPanel);
		theMainPanel.add(newPatientPanel);
		theMainPanel.setVisible(true);
	    
	    this.add(theMainPanel);
	    this.setVisible(true);
	}
	
	//TODO to put this in a controller outside this class?
	public void showPanelListOfPatients(List<Patient> listOfPatients) {
		listOfPatientsPanel.setPatientsEntries(listOfPatients);
		listOfPatientsPanel.setVisible(true);
		
		searchPatientPanel.setVisible(false);
		newPatientPanel.setVisible(false);
	}

	
	//TODO to put this in a controller outside this class?
	public void showSearchPatientPanel() {
		searchPatientPanel.setVisible(true);
		
		newPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
	}
	
	
	public void showNewPatientPanel() {
		newPatientPanel.setVisible(true);
		
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
	}
	
	public void showExaminationPatientPanel(Patient patient) {
		//TODO here or later: load the list of previous examinations
		examinationPatientPanel.setPreviousExaminationEntries(new ArrayList<Examination>());
		examinationPatientPanel.setVisible(true);
		
		newPatientPanel.setVisible(false);
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
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

	public ExaminationPatientPanel getCurrentDiagnosisPanel() {
		return examinationPatientPanel;
	}

	public ListOfPatientsPanel getListOfPatientsPanel() {
		return listOfPatientsPanel;
	}
	
}