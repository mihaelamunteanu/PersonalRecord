package com.codeprehend.medical.test;

import java.io.IOException;

import com.codeprehend.medical.pdf.ExaminationToPdf;
import com.itextpdf.text.DocumentException;

public class TestNumberOfLinesExamination {
	static String examinationText =
			  "text1\n" + "text2\n" + "text3\n" + "text4\n" + "text5\n" + "text6\n" + "text7\n" + "text8\n" + "text9\n" + "text10\n"
			+ "text11\n" + "text12\n" + "text13\n" + "text14\n" + "text15\n" + "text16\n" + "text17\n" + "text18\n" + "text19\n" + "text20  \n"
			+ "text21\n" + "text22\n" + "text23\n" + "text24\n" + "text25\n" + "text26\n" + "text27\n" + "text28\n" + "text29\n" + "text30\n"
			+ "text31\n" + "text32\n" + "text33\n" + "text34\n" + "text35\n" + "text36\n" + "text37\n" + "text38\n" + "text39\n" + "text40  0 0\n"
			+ "text41\n" + "text42\n" + "text43\n" + "text44\n" + "text45\n" + "text46\n" + "text47\n" + "text48\n" + "text49\n" + "text50\n"
			+ "text51\n" + "text52\n" + "text53\n" + "text54\n" + "text55\n" + "text56\n" + "text57\n" + "text58\n" + "text59\n" + "text60\n"
			+ "text61\n" + "text62\n" + "text63\n" + "text64\n" + "text65\n" + "text66\n" + "text67\n" + "text68\n" + "text69\n" + "text70\n"
			+ "text71\n" + "text72\n" + "text73\n" + "text74\n" + "text75\n" + "text76\n" + "text77\n" + "text78\n" + "text79\n" + "text80\n"
			+ "text81\n" + "text82\n" + "text83\n" + "text84\n" + "text85\n" + "text86\n" + "text87\n" + "text88\n" + "text89\n" + "text90\n"
			+ "text91\n" + "text92\n" + "text93\n" + "text94\n" + "text95\n" + "text96\n" + "text97\n" + "text98\n" + "text99\n" + "text100101102\n\n\n"
			+ "text103\n" + "text104\n" + "text105\n" + "text106\n" + "text107\n" + "text108\n" + "text109\n" + "text110\n" + "text111\n" + "text112\n";

	public static void main(String[] args) throws IOException, DocumentException {
		ExaminationToPdf.createAndOpenPdf(1L, "Mirunesti", "Alexandra", "2830508270028", 
				"0740235908", "13.01.2019", examinationText);
		
		ExaminationToPdf.createAndOpenPdf(2L, "Storea", "Ioan", "1830508270018", 
				"0740235908", "16.01.2019", buildExaminationText(30));
		
		ExaminationToPdf.createAndOpenPdf(2L, "Anitei", "Miruna", "2830508270018", 
				"0740235908", "17.02.2019", "Text normal ca marime\n Diagnostic ok \n \n Recomandari \n \n miscae moderata");
	}
	
	static String buildExaminationText(int numberOfLines) {
		StringBuilder examinationTextBuilder = new StringBuilder();
		for (int i = 1; i <= numberOfLines; i++) {
			examinationTextBuilder.append("text" + i + "\n");
		}
		
		return examinationTextBuilder.toString();
	}

}
 