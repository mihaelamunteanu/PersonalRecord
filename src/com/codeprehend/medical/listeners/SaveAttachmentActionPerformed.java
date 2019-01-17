package com.codeprehend.medical.listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.AtachementsDAO;
import com.codeprehend.medical.resources.Attachement;
import com.codeprehend.medical.resources.Patient;

public class SaveAttachmentActionPerformed {
	
	public static void saveAttachmentActionPressed(MedicalRecordGUI mainPanel, Patient patient) {
		//TODO externalize this part of code in a new class
		//TODO refresh the list of files
		try {
			String fullName = mainPanel.getFilesPatientPanel().getBrowseFileTextField().getText();
			String fileName = fullName.substring(fullName.lastIndexOf('\\') + 1, fullName.lastIndexOf('.') - 1);
			String fileType = fullName.substring(fullName.lastIndexOf('.') + 1, fullName.length());
	        File file = new File(fullName);
	        file.getParentFile().mkdirs();
	       
			Attachement attachment = new Attachement(patient.getId(), fileName, fileType, 
					file.length(), Files.readAllBytes(file.toPath()), LocalDate.now());
			AtachementsDAO.saveAttachment(attachment);
			List<Attachement> attachements = AtachementsDAO.getAttachmentsByPatientId(patient.getId());
			mainPanel.showFilesPatientPanel(patient, attachements);
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(mainPanel, e1.getLocalizedMessage(), "Erroare", JOptionPane.ERROR_MESSAGE);
		} 
	}

}
