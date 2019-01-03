package com.codeprehend.medical.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import com.codeprehend.medical.MedicalRecordGUI;
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
	private List<Patient> patients;
	
	private JList listOfPatients = new JList();
	
	private JButton backButton = new JButton("Inapoi");
	private JButton folderAccesButton = new JButton("Acceseaza dosar");
	private JButton filesAccesButton = new JButton("Acceseaza fisire");
	
	private GridBagConstraints gc = new GridBagConstraints();

	public ListOfPatientsPanel(MedicalRecordGUI parent) {
		super();
		this.setLayout(new GridBagLayout());

		this.parentPanel = parent;
		this.setVisible(false);
	}
	
	/**
	 * Loads the list of Patient objects into JPanels
	 * 
	 * @param patients
	 */
	public void setPatientsEntries(List<Patient> patients) {
		this.patients = patients;
		
		backButton.addActionListener(new BackFromListOfPatientsPanelButtonActionListener(parentPanel));

		this.setBorder(new TitledBorder(null, "Lista paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setLayout(null);
		
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
			//str = str.concat(pacient.getNumarTelefon());

			DLM.addElement(str);
								
		}
		
		listOfPatients.setModel(DLM);
		
		listOfPatients.setBounds(10, 23, 434, 300);
		listOfPatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(listOfPatients);
		
		filesAccesButton.setBounds(454, 160, 151, 39);
		this.add(filesAccesButton);
		
		folderAccesButton.setBounds(454, 84, 151, 39);
		this.add(folderAccesButton);
		
		backButton.setBounds(489, 311, 102, 23);
		this.add(backButton);
		
		folderAccesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("merge");
				new AccessExamButtonActionListener(parentPanel, patients.get(listOfPatients.getSelectedIndex()));
			}
		});
		
	}
}
