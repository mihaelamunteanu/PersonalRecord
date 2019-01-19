package com.codeprehend.medical;

import com.codeprehend.medical.util.Utils;

/** 
 * Main class launcher. 
 * 
 * @author Gabriel Munteanu
 *
 */
public class MedicalRecordLauncher {

	public static void main(String[] args) {
		Utils.loadProperties();
		MedicalRecordGUI medicalRecordGUI = new MedicalRecordGUI();
		medicalRecordGUI.showSearchPatientPanel();

	}

}
