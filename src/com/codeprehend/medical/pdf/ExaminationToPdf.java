package com.codeprehend.medical.pdf;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import com.codeprehend.medical.resources.Attachement;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Class to generate a PDF file for the examination.
 * 
 * @author Gabriel Munteanu
 * @since 28 December 2018
 *
 */

public class ExaminationToPdf {
	    public static final String DEST = "pdf\\pdf_table.pdf";
	    
	    public static Attachement createAndOpenPdf(Long id, String nume, String prenume, String cnp, String telefon, 
	    		String examinationDate, String examinationText) throws IOException, DocumentException {
	    	String fileName = nume + "_" + prenume + "_" + examinationDate;
	    	String fileType = "pdf";
	    	String DEST = "pdf\\" + fileName + "." + fileType;
	    	
	        File file = new File(DEST);
	        file.getParentFile().mkdirs();
	        ExaminationToPdf.createPdf(DEST, nume, prenume, cnp, telefon, examinationDate, examinationText);
	        if (Desktop.isDesktopSupported()) {
	            try {
	                File myFile = new File(DEST);
	                Desktop.getDesktop().open(myFile);
	            } catch (IOException ex) {
	                // no application registered for PDFs
	            }
	        }
	        
	        
	        FileInputStream fis = new FileInputStream(file);
	        Attachement attachement = new Attachement(id, fileName, fileType, file.length(), fis, LocalDate.now());
	       
	        return attachement;
	    }
	    
	    private static void createPdf(String dest, String nume, String prenume, String cnp, 
	    		String telefon, String examinationDate, String examinationText) throws IOException, DocumentException {
//	        Rectangle small = new Rectangle(540,220);
	        Rectangle pdfRectangle = new Rectangle(PageSize.A4.getWidth() - 20, PageSize.A4.getHeight() - 20);
	        Font smallfont = new Font(Font.HELVETICA, 10);
	        Document document = new Document(pdfRectangle, 5, 5, 5, 5);
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
	        document.open();
	        PdfPTable table = new PdfPTable(2);
	        table.setTotalWidth(new float[]{ 220, 285 });
	        table.setLockedWidth(true);
	        PdfContentByte cb = writer.getDirectContent();
	        
	        
	        // first row - empty
	        PdfPCell cell = new PdfPCell(new Phrase(" "));
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        cell.setFixedHeight(30);
	        cell.setColspan(2);
	        table.addCell(cell);
	        
	        // first row - empty
	        cell = new PdfPCell(new Phrase(" "));
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.decode("#FFFFEA"));
	        cell.setFixedHeight(30);
	        cell.setColspan(2);
	        table.addCell(cell);
	        
	        
	        // second row - header
			FontSelector selector = new FontSelector();
			Font f1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
			f1.setColor(Color.BLACK);
			f1.setStyle("BOLD");
			selector.addFont(f1);
			Phrase ph = selector.process("  C.M. Dr. RUGINA");
	        cell = new PdfPCell(ph);
	        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.decode("#FFFFEA"));
//	        cell.setFixedHeight(30);
//	        cell.setBorder(Rectangle.NO_BORDER\);
//	        cell.setColspan(2);
	        table.addCell(cell);
	        
			FontSelector selector2 = new FontSelector();
			Font f2 = FontFactory.getFont(FontFactory.HELVETICA, 12);
			f2.setColor(Color.BLACK);
			f2.setStyle("BOLD");
			selector2.addFont(f2);
			Phrase ph2 = selector2.process(" Str. Bd. 9Mai, nr. 1, Bl. A13, Ap.2");
	        cell = new PdfPCell(ph2);
	        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
	        cell.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
	        cell.setBackgroundColor(Color.decode("#FFFFEA"));
	        cell.setBorder(PdfPCell.NO_BORDER);
	        table.addCell(cell);
	        
	        //third row
			FontSelector selector3 = new FontSelector();
			Font f3 = FontFactory.getFont(FontFactory.HELVETICA, 12);
			f3.setColor(Color.BLACK);
			f3.setStyle("BOLD");
			selector3.addFont(f3);
			Phrase ph3 = selector3.process(" Telefon: 0233-237969");
	        cell = new PdfPCell(ph3);
	        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
	        cell.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
	        cell.setBackgroundColor(Color.decode("#FFFFEA"));
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setColspan(2);
	        table.addCell(cell);
	        
	        // third row - empty
	        cell = new PdfPCell(new Phrase(" "));
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.decode("#FFFFEA"));
	        cell.setFixedHeight(30);
	        cell.setColspan(2);
	        table.addCell(cell);
	        
	        // third row - empty
	        cell = new PdfPCell(new Phrase(" "));
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        cell.setFixedHeight(20);
	        cell.setColspan(2);
	        table.addCell(cell);
	        
	        
	        // patient row
			FontSelector selector4 = new FontSelector();
			Font f4 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14);
			f4.setColor(Color.BLACK);
			selector4.addFont(f4);
			Phrase ph4 = selector4.process("  Patient: " + nume + " " + prenume + " ");
	        cell = new PdfPCell(ph4);
	        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        table.addCell(cell);

			FontSelector selector5 = new FontSelector();
			Font f5 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14);
			f5.setColor(Color.BLACK);
			selector5.addFont(f5);
			Phrase ph5 = selector5.process("CNP: "+ cnp + "     " + "Telefon: " + telefon + "   ");
	        cell = new PdfPCell(ph5);
	        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        table.addCell(cell);
	        
	        
	        //empty row
	        cell = new PdfPCell(new Phrase(" "));
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        cell.setFixedHeight(30);
	        cell.setColspan(2);
	        table.addCell(cell);
	        
	        //examination label row
			FontSelector selector6 = new FontSelector();
			Font f6 = FontFactory.getFont(FontFactory.TIMES_BOLD, 14);
			f6.setColor(Color.BLACK);
			selector6.addFont(f6);
			Phrase ph6 = selector6.process("  Consultatie din data de " + examinationDate);
	        cell = new PdfPCell(ph6);
	        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        cell.setColspan(2);
	        table.addCell(cell);
	        
	        // third row - empty
	        cell = new PdfPCell(new Phrase(" "));
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        cell.setFixedHeight(20);
	        cell.setColspan(2);
	        table.addCell(cell);

	        // examination row
			FontSelector selector7 = new FontSelector();
			Font f7 = FontFactory.getFont(FontFactory.TIMES_ITALIC, 12);
			f7.setColor(Color.BLACK);
			selector7.addFont(f7);
			Paragraph examinationParagraph = new Paragraph("\n");
			Phrase ph7 = selector7.process("  " + examinationText);
			examinationParagraph.add(new Paragraph(ph7));
			examinationParagraph.add(new Paragraph("\n"));
			cell = new PdfPCell(examinationParagraph);
	        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        cell.setColspan(2);
	        cell.setFixedHeight(280);
	        table.addCell(cell);
	        
	        // row - empty
	        cell = new PdfPCell(new Phrase(" "));
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        cell.setFixedHeight(40);
	        cell.setColspan(2);
	        table.addCell(cell);
	        
	        // signature row
			FontSelector selector8 = new FontSelector();
			Font f8 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 18);
			f8.setColor(Color.BLACK);
			selector8.addFont(f8);
			Phrase ph8 = selector8.process("  Semnatura");
	        cell = new PdfPCell(ph8);
	        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        table.addCell(cell);

			FontSelector selector9 = new FontSelector();
			Font f9 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 18);
			f9.setColor(Color.BLACK);
			selector9.addFont(f9);
			Phrase ph9 = selector9.process("Data");
	        cell = new PdfPCell(ph9);
	        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        table.addCell(cell);

	        // row - empty
	        cell = new PdfPCell(new Phrase(" "));
	        cell.setBorder(PdfPCell.NO_BORDER);
	        cell.setBackgroundColor(Color.WHITE);
	        cell.setFixedHeight(40);
	        cell.setColspan(2);
	        table.addCell(cell);
	        
	        document.add(table);
	        document.close();
	    }

}
