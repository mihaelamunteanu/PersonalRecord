package com.codeprehend.medical;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.codeprehend.medical.panels.ExaminationPatientPanel;
import com.codeprehend.medical.panels.FilesPatientPanel;
import com.codeprehend.medical.panels.ListOfPatientsPanel;
import com.codeprehend.medical.panels.ModifyPatientPanel;
import com.codeprehend.medical.panels.NewPatientPanel;
import com.codeprehend.medical.panels.SearchPatientPanel;
import com.codeprehend.medical.resources.Antecedent;
import com.codeprehend.medical.resources.Attachement;
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
	
//	private JFrame framePrincipal;
	
	private SearchPatientPanel searchPatientPanel;
	private NewPatientPanel newPatientPanel;
	private ExaminationPatientPanel examinationPatientPanel;
	private ListOfPatientsPanel listOfPatientsPanel;
	private ModifyPatientPanel modifyPatientPanel;
	private FilesPatientPanel filesPatientPanel;
	
	public MedicalRecordGUI(){
		super();
		//initialize GUI
		
		this.setBounds(100, 100, 813, 516);
		this.setExitBehaviour();
		this.setTitle(numeFereastraPrincipala);
		
		//Create main panel
		searchPatientPanel = new SearchPatientPanel(this);
		newPatientPanel = new NewPatientPanel(this);
		listOfPatientsPanel = new ListOfPatientsPanel(this);
		examinationPatientPanel = new ExaminationPatientPanel(this);
		modifyPatientPanel = new ModifyPatientPanel(this);
		filesPatientPanel = new FilesPatientPanel(this);
		
	    this.setVisible(true);
	}
	
	private void setExitBehaviour() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Da","Nu"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Sigur doriti sa parasiti aplicatia?","Confirmare EXIT",
		        		JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ObjButtons,ObjButtons[0]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});

	}
	
	public void showPanelListOfPatients(List<Patient> listOfPatients) {
		
		this.remove(listOfPatientsPanel);
		listOfPatientsPanel = new ListOfPatientsPanel(this);
		listOfPatientsPanel.setBounds(150, 22, 700, 367);
		this.add(listOfPatientsPanel);
		
		listOfPatientsPanel.loadListOfPatientsGUIPanel(listOfPatients);
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

	
	public void showSearchPatientPanel() {
		this.remove(searchPatientPanel);
		searchPatientPanel = new SearchPatientPanel(this);
		this.add(searchPatientPanel);
		searchPatientPanel.loadSearchPatientGUIPanel();
		searchPatientPanel.setVisible(true);

		this.validate();
		
		examinationPatientPanel.setVisible(false);
		newPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
		filesPatientPanel.setVisible(false);
	}
	
	
	public void showNewPatientPanel() {
		this.remove(newPatientPanel);
		newPatientPanel = new NewPatientPanel(this);
		this.add(newPatientPanel);
		
		newPatientPanel.loadNewPatientGUIPanel();
		newPatientPanel.setVisible(true);
		
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
		examinationPatientPanel.setVisible(false);
		filesPatientPanel.setVisible(false);
	}
	
	public void showModifyPatientPanel(Patient patient, List<Antecedent> antecedents, String fromPanel) {
		this.remove(modifyPatientPanel);
		modifyPatientPanel = new ModifyPatientPanel(this);
		this.add(modifyPatientPanel);
		
		modifyPatientPanel.setPacient(patient);
		modifyPatientPanel.setAntecedents(antecedents);
		modifyPatientPanel.loadModifyGUIPanelForPatient(patient, fromPanel);
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
		this.remove(examinationPatientPanel);
		examinationPatientPanel = new ExaminationPatientPanel(this);
		this.add(examinationPatientPanel);

		examinationPatientPanel.loadExaminationGUIForPatient(patient, antecedents, examinations);
		
		examinationPatientPanel.setVisible(true);
		
		newPatientPanel.setVisible(false);
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
		filesPatientPanel.setVisible(false);
	}
	
	public void showFilesPatientPanel(Patient patient, List<Attachement> attachements){
		
		this.remove(filesPatientPanel);
		filesPatientPanel = new FilesPatientPanel(this);
		this.add(filesPatientPanel);
		
		filesPatientPanel.loadFilesForPatientGUIPanel(patient, attachements);
		filesPatientPanel.setVisible(true);
		
		examinationPatientPanel.setVisible(false);
		newPatientPanel.setVisible(false);
		searchPatientPanel.setVisible(false);
		listOfPatientsPanel.setVisible(false);
		modifyPatientPanel.setVisible(false);
	}
	
	//** Getters and setters //

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

	public FilesPatientPanel getFilesPatientPanel() {
		return filesPatientPanel;
	}
	
}