package com.codeprehend.medical.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.codeprehend.medical.resources.Pacient;

public class PatientsDAO {
	
	//TODO change to Date type instead String
	public static List<Pacient> getPatientsByBirthDate(String date) {
		 List<Pacient> patientWithDate =new ArrayList<Pacient>();
		 
		 //Make mocks with Spring? and remove when added call to DB
		 Pacient pacient = new Pacient("Stravoschi", "Adrian", "2232323443411", 
				 new Date(2352345435L), 
				 new Date((new java.util.Date()).getTime()), "Artelor 12, Galati");
		 patientWithDate.add(pacient);
		 
		 pacient = new Pacient("Adam", "Luca", "2232323443411", 
				 new Date(2352345436L), 
				 new Date((new java.util.Date()).getTime()), "Museului  12, Galati");
		 patientWithDate.add(pacient);
		 
		 return patientWithDate;
	}

}
