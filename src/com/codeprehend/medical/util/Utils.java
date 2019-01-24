package com.codeprehend.medical.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codeprehend.medical.resources.CabinetData;

public class Utils {
	
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	
	public static Properties prop = new Properties();
	
	public static LocalDate parseLocalDate(String date) {
		if (date.contains("."))
			return LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
		else 
			return LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.SLASH_DATE_PATTER));
	
	}
	
	public static String fromDateToString(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
	}
	
	public static void loadProperties() {
		InputStream input = null; 
		
		try {
	
			input = new FileInputStream("config.properties");
	
			// load a properties file
			prop.load(input);
	
			// get the property value and print it out
			LOGGER.log(Level.INFO, "Loaded DB Server Name: " + prop.getProperty("dbserver"));	
			LOGGER.log(Level.INFO, "Loaded DB Port       : " + prop.getProperty("dbport"));
			LOGGER.log(Level.INFO, "Loaded DB User       : " + prop.getProperty("dbuser"));
			
			DatabaseConnection.loadDatabaseProperties(prop.getProperty("dbserver"), 
					prop.getProperty("dbport"), prop.getProperty("dbuser"), prop.getProperty("dbpass"));
			
			CabinetData.loadCabinetData(prop.getProperty("numecabinet"), prop.getProperty("adresacabinet"), 
					prop.getProperty("telefoncabinet"), prop.getProperty("pdf_location"));
			
			String loggerLocation = prop.getProperty("log_location");
			String dateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
			String logFileName = "log" + dateTime.substring(0, 
					dateTime.lastIndexOf(".")).replaceAll(":", "_") + "." + "log";
			if (loggerLocation != null && !loggerLocation.isEmpty()) {
				LoggerSettings.setLoggerSetting(loggerLocation + "\\" + logFileName);
			} else {
				LoggerSettings.setLoggerSetting("." + "\\" + logFileName);
			}
		} catch (IOException ex) {
			LOGGER.log(Level.SEVERE, "Error reading config.properties file", ex);
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void loadLoggingProperties( ) {
		
	}

}
