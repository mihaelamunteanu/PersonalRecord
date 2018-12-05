package com.codeprehend.medical.resources;

import java.sql.Date;

public class Pacient {
	
	//TODO establish the form of Date
	private Integer id;
	private String nume;
	private String prenume;
	private String cnp;
	private Date dataNasterii;
	private String adresa;
	private Date primaConsultatie;
	private String altele;
	
	public Pacient(){
		
	}
	
	public Pacient(Integer id, String nume, String prenume, String cnp, 
			Date dataNasterii, Date primaConsultatie, String adresa, String altele){
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.cnp = cnp;
		this.dataNasterii = dataNasterii;
		this.primaConsultatie =primaConsultatie;
		this.adresa = adresa;
	}
	
	public boolean equals(Pacient second){
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

	public void setId(Integer id) {
		this.id = id;
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
}
