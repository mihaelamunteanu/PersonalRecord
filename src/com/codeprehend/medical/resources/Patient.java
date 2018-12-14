package com.codeprehend.medical.resources;

import java.sql.Date;

public class Patient {
	
	//TODO establish the form of Date
	private Integer id;
	private String nume;
	private String prenume;
	private String cnp;
	private Date dataNasterii;
	private String adresa;
	private Date primaConsultatie;
	private String numarTelefon;
	private String altele;
	private int nasteriNaturale;
	private int cezariene; 
	private int avorturiLaCerere;
	private int avorturiSpontane;
	
	public Patient(){
		
	}
	
	public Patient(Integer id, String nume, String prenume, String cnp, 
			Date dataNasterii, Date primaConsultatie, String adresa, String numarTelefon){
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.cnp = cnp;
		this.dataNasterii = dataNasterii;
		this.primaConsultatie = primaConsultatie;
		this.adresa = adresa;
	}
	
	public boolean equals(Patient second){
		if(!this.getNume().equals(second.getNume()))
			return false;
		
		if(!this.getCnp().equals(second.getCnp()))
			return false;
		
		if(!this.getPrenume().equals(second.getPrenume()))
			return false;
		
		if(!this.getDataNasterii().equals(second.getDataNasterii()))
			return false;
		
		return true;
	}
	

	public Integer getId() {
		return id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	
	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public Date getDataNasterii() {
		return dataNasterii;
	}

	public void setDataNasterii(Date dataNasterii) {
		this.dataNasterii = dataNasterii;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getPrimaConsultatie() {
		return primaConsultatie;
	}

	public void setPrimaConsultatie(Date primaConsultatie) {
		this.primaConsultatie = primaConsultatie;
	}

	public String getAltele() {
		return altele;
	}

	public void setAltele(String altele) {
		this.altele = altele;
	}

	public String getNumarTelefon() {
		return numarTelefon;
	}

	public void setNumarTelefon(String numarTelefon) {
		this.numarTelefon = numarTelefon;
	}

	public int getNasteriNaturale() {
		return nasteriNaturale;
	}

	public void setNasteriNaturale(int nasteriNaturale) {
		this.nasteriNaturale = nasteriNaturale;
	}

	public int getCezariene() {
		return cezariene;
	}

	public void setCezariene(int cezariene) {
		this.cezariene = cezariene;
	}

	public int getAvorturiLaCerere() {
		return avorturiLaCerere;
	}

	public void setAvorturiLaCerere(int avorturiLaCerere) {
		this.avorturiLaCerere = avorturiLaCerere;
	}

	public int getAvorturiSpontane() {
		return avorturiSpontane;
	}

	public void setAvorturiSpontane(int avorturiSpontane) {
		this.avorturiSpontane = avorturiSpontane;
	}
	
 }
