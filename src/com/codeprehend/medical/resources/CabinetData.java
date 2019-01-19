package com.codeprehend.medical.resources;

/**
 * Information to be displayed in the generated PDF about the Cabinet. 
 * It will be taken from DB. 
 * 
 * @author Mihaela Munteanu
 *
 */
public class CabinetData {
	private String cabinetName = "C.M. Dr. RUGINA";
	private String cabinetAddress = "Str. Bd. 9Mai, nr. 1, Bl. A13, Ap.2";
	private String cabinetTelNumber = "0233-237969";
	
	public CabinetData(String cabinetName, String cabinetAddress, String cabinetTelNumber) {
		this.cabinetName = cabinetName;
		this.cabinetAddress = cabinetAddress;
		this.cabinetTelNumber = cabinetTelNumber;
	}
	
	public String getCabinetName() {
		return cabinetName;
	}
	
	public String getCabinetAddress() {
		return cabinetAddress;
	}
	
	public String getCabinetTelNumber() {
		return cabinetTelNumber;
	}
}