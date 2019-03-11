package com.codeprehend.medical;

import com.codeprehend.medical.util.Utils;

/** 
 * Main class launcher. 
 * 
 * @author Gabriel Munteanu
 *
 */
public class MedicalRecordLauncher {
	/**
	 * Versiunea se incrementeaza dupa versiunea bazei de date. 
	 * Cand se modifica DB fara sa se mofice aplicatia creste doar versiunea minora la DB 
	 * 	e.g. 1.0 -> 1.1
	 * Cand se modifica aplicatia fara sa se modifice DB creste versiunea minora la app. 
	 * 	e.g. 1.2 -> 1.3
	 * Cand se modifica ambele cresc ambele versiuni la versiune majora.
	 * 	e.g. DB  1.0 -> 2.0
	 *       App 1.3 -> 2.0
	 */
	 
	public static String versiune = "v2.0";

	public static void main(String[] args) {
		Utils.loadProperties();
		MedicalRecordGUI medicalRecordGUI = new MedicalRecordGUI();
		medicalRecordGUI.showSearchPatientPanel();

	}

}
