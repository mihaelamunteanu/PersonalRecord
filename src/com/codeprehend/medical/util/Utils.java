package com.codeprehend.medical.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
	
	public static LocalDate parseLocalDate(String date) {
		if (date.contains("."))
			return LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
		else 
			return LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.SLASH_DATE_PATTER));
	
	}
	
	public static String fromDateToString(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
	}

}
