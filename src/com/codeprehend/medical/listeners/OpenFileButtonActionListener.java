package com.codeprehend.medical.listeners;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.codeprehend.medical.MedicalRecordGUI;
import com.codeprehend.medical.dao.AtachementsDAO;
import com.codeprehend.medical.dao.CabinetDataDAO;
import com.codeprehend.medical.resources.Attachement;
import com.codeprehend.medical.resources.CabinetData;

public class OpenFileButtonActionListener {
//	private MedicalRecordGUI mainWindow;
	private Attachement attachement;
	
	public OpenFileButtonActionListener(MedicalRecordGUI mainWindow, Attachement attachement){
//		this.mainWindow = mainWindow;
		this.attachement = attachement;
		this.actionPerformed();
	}
	
	public void actionPerformed(){
		Attachement attachment = AtachementsDAO.getAttachmentsById(attachement.getId());
		CabinetData cabinetData = CabinetDataDAO.getCabinetData();
		
    	String fileName = attachment.getFileName() + "_" +  
    			attachment.getRegistrationDate();
    	String fileType = attachment.getFileType() ;
    	String DEST = cabinetData.getFolderLocation() + "\\downloads\\" + fileName + "." + fileType;
		
	    InputStream fileStream = new ByteArrayInputStream (attachment.getFileStream());
	    byte[] buffer;
		try {
			buffer = new byte[fileStream.available()];
			fileStream.read(buffer);
			
		    File targetFile = new File(DEST);
		    targetFile.getParentFile().mkdirs();
		    OutputStream outStream = new FileOutputStream(targetFile);
		    outStream.write(buffer);
		    outStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    	 

    	
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(DEST);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
        
	}
}
