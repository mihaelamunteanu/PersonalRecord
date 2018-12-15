package com.codeprehend.medical.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.codeprehend.medical.MedicalRecordGUI;
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
		int i = 1;
		
		this.setLayout(new GridBagLayout());
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		for (Patient pacient: patients) { 
			JPanel patientEntry = new JPanel();
			JLabel nameLabel = new JLabel(pacient.getNume());
			JLabel firstNameLabel = new JLabel(pacient.getPrenume());
			JLabel birthDate = new JLabel(pacient.getDataNasterii().toString());
			JLabel cnpLabel = new JLabel(pacient.getCnp());
			JButton accessButton = new JButton(ACCESS_DOSAR);
			
			patientEntry.add(nameLabel);
			patientEntry.add(firstNameLabel);
			patientEntry.add(birthDate);
			patientEntry.add(cnpLabel);
			patientEntry.add(accessButton);

			patientEntry.setVisible(true);

			gc.gridx = 1;
			gc.gridy = i;
			this.add(patientEntry, gc);
			i++;
		}
	}
}
