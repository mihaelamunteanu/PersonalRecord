package com.codeprehend.medical.database;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

	public static void validateTextField(String text) throws Exception {
		if (text != null && text.length() > 0) {
			Pattern pattern = Pattern.compile("([A-Z]{1}[a-z]*)[-| ]?[A-Z]{1}[a-z]*");
			Matcher matcher = pattern.matcher(text);
			if (!matcher.matches()) {
				throw new Exception("Textul '" + text + "' nu este corect. "
						+ "Se asteapta doar litere latine separate prin spatiu sau - .");
			}
		}
	}
	
	
}
