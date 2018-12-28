package com.codeprehend.medical.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Class to generate a PDF file for the examination.
 * 
 * @author Gabriel Munteanu
 * @since 28 December 2018
 *
 */

public class ExaminationToPdf {
	public static void generatePDF( ) {
		String pdfFile = "pdf\\test" + ".pdf";
		
//		Font fontNormalBold = new Font (Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		
		try{

			Document pdfDocument = new Document();
			PdfWriter.getInstance(pdfDocument, new FileOutputStream(pdfFile));
			pdfDocument.open();

			Paragraph examinationText = new Paragraph();
			examinationText.add(" *   ");
			
			examinationText.add(new Paragraph("______________________________________________________________________________"));
			
			pdfDocument.add(examinationText);

			pdfDocument.close();
			
		} catch(DocumentException exceptioPdfFile){
			
		} catch (FileNotFoundException exceptioPdfFile){
			
		}

	}
}
