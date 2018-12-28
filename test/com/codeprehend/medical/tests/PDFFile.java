package com.codeprehend.medical.tests;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFFile {

	public static void main(String[] args) {
		String pdfFile = "pdf\\test" + ".pdf";
		
		Font fontNormalBold = new Font (Font.BOLD, 12, Font.BOLD);
		
		try{

			Document pdfDocument = new Document();
			PdfWriter.getInstance(pdfDocument, new FileOutputStream(pdfFile));
			pdfDocument.open();

			Paragraph preface = new Paragraph();
			
			preface.add(new Paragraph("    "));
			
			FontSelector selector = new FontSelector();
			Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 22);
			f1.setColor(Color.BLACK);
			f1.setStyle("BOLD");
			selector.addFont(f1);
			Phrase ph = selector.process("C.M. Dr. RUGINA");
			
			FontSelector selector2 = new FontSelector();
			Font f2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16);
			f2.setColor(Color.BLACK);
			f2.setStyle("BOLD");
			selector2.addFont(f2);
			
			Phrase ph2 = selector2.process("                          Str. Bd. 9Mai, nr. 1, Bl. A13, Ap.2");
			ph.add(ph2);
			
			preface.add(new Paragraph( ph));
			
			Phrase ph3 = selector2.process("                                                        Telefon: 0233-237969");
			
			preface.add(new Paragraph(ph3));
			
//			preface.add(new Paragraph("   C.M. Dr. RUGINA                                       Str. Bd. 9Mai, nr. 1, Bl. A13, Ap.2"));
//			preface.add(new Paragraph("                                                                        Telefon: 0233-237969"));
			preface.add(new Paragraph("____________________________________________________________________________________________"));
			
			preface.add(new Paragraph(" "));
			preface.add(new Paragraph(" "));
			preface.add(new Paragraph("Pacient: Mihaela Munteanu             	CNP: 2830404240024    Telefon: 0744489899"));
			preface.add(new Paragraph(" "));
			preface.add(new Paragraph(" "));
			preface.add(new Paragraph("Consultatie din data de 12.12.2018 "));
			preface.add(new Paragraph("______________________________________________________________________________"));
			
//			FontSelector selector1 = new FontSelector();
//			Font f2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
//			f2.setColor(Color.BLUE);
//			f2.setStyle("BOLD");
//			selector.addFont(f1);
//			Phrase ph1 = selector.process("TEXT");
//			preface.add(ph);
			
			preface.add(new Paragraph("| Textsjfhjksdfjsd                                                            |"));
			preface.add(new Paragraph("|  asjkdjkasdsajkhd"));
			preface.add(new Paragraph("| Textsjfhjksdfjsd"));
			preface.add(new Paragraph("|  asjkdjkasdsajkhd"));
			preface.add(new Paragraph(" "));
			preface.add(new Paragraph("     Semnatura:                                     Data:"));
			/*
			 * Pacient: Mihaela Munteanu  	CNP: 2830404240024    Telefon: 0744489899
Consultatie din data de 17/08/2018
Text
Semnatura
Data
			 */
			
			pdfDocument.add(preface);

			pdfDocument.close();
			
		} catch(DocumentException exceptioPdfFile){
			
		} catch (FileNotFoundException exceptioPdfFile){
			
		}

	}

}
