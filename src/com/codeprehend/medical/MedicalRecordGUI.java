package com.codeprehend.medical;


import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.codeprehend.medical.panels.ListOfPatientsPanel;
import com.codeprehend.medical.panels.SearchPatientPanel;
import com.codeprehend.medical.resources.Pacient;


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
	private ListOfPatientsPanel listOfPatientsPanel;
	private JPanel historyOfPatientPanel;
	private JPanel currentDianosisAndRecomandationsPanel;
	
	public MedicalRecordGUI(){
		//initialize GUI
		
		this.setSize(1100, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(numeFereastraPrincipala);
		
		//Create main panel
		   
		theMainPanel = new JPanel();
		theMainPanel.setLayout(new GridBagLayout());
		
		searchPatientPanel = new SearchPatientPanel(this);
		
		listOfPatientsPanel = new ListOfPatientsPanel(this);
		
		theMainPanel.add(searchPatientPanel);
		theMainPanel.add(listOfPatientsPanel);
		theMainPanel.setVisible(true);
	    
	    this.add(theMainPanel);
	    this.setVisible(true);
	}
	
	//TODO to put this in a controller outside this class?
	public void showPanelListOfPatients(List<Pacient> listOfPatients) {
		listOfPatientsPanel.setPatientsEntries(listOfPatients);
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(true);
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

	public void setSearchPatientPanel(SearchPatientPanel searchPatientPanel) {
		this.searchPatientPanel = searchPatientPanel;
	}
}