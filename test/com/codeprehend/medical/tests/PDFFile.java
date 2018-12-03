package com.codeprehend.medical.tests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFFile {

	public static void main(String[] args) {
		String pdfFile = "D:\\JAVA\\other_files\\test" + ".pdf";
		
		Font fontNormalBold = new Font (Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		
		try{

			Document pdfDocument = new Document();
			PdfWriter.getInstance(pdfDocument, new FileOutputStream(pdfFile));
			pdfDocument.open();

			Paragraph preface = new Paragraph();
			
			preface.add(new Paragraph("______________________________________________________________________________"));
			
			pdfDocument.add(preface);

			pdfDocument.close();
			
		} catch(DocumentException exceptioPdfFile){
			
		} catch (FileNotFoundException exceptioPdfFile){
			
		}

	}

}
