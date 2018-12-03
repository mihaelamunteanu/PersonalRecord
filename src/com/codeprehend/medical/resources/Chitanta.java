package com.codeprehend.medical.resources;


/**
 * Class to define receipt (chitanta)
 * 
 * @since 30th of September 2015
 * @author munteanu
 *
 */
public class Chitanta {
	
	/**
	 * Receipt number
	 */
	private int nrChitanta;
	
	/**
	 * Client corresponding to the receipt
	 */
	private Pacient clientChitanta = new Pacient();
	
	/**
	 * Value of the receipt	as a number with 2 decimals
	 */
	private String valoareChitanta;
	
	/**
	 * Date of the receipt as a string with the format: dd.mm.yyyy
	 */
	private String dataChitanta=new String();
	
	/**
	 * Number of the corresponding invoice 
	 */
	private int nrFactura;
	
	/**
	 * Empty default constructor 
	 */
	public Chitanta(){
		
	}
	
	/**
	 * Constructor with parameters to set all the variables
	 */
	public Chitanta(int nrChitanta, String nameClientChitanta, String valoareChitanta, String dataChitanta, int nrFactura){
		this.nrChitanta = nrChitanta;
		this.clientChitanta.setNume(nameClientChitanta);
		this.valoareChitanta = valoareChitanta;
		this.nrFactura = nrFactura;
		this.dataChitanta = dataChitanta;
	}
	
	
	/**
	 * Getter of nrChitanta
	 * @return nrChitanta
	 */
	public int getNrChitanta(){
		return nrChitanta;
	}
	
	/**
	 * Setter of nrChitanta
	 * @param nrChitanta
	 */
	public void setNrChitanta(int nrChitanta){
		this.nrChitanta=nrChitanta;
	}
	
	public Pacient getClientChitanta(){
		return clientChitanta;
	}
	
	public void setClientChitanta(Pacient clientChitanta){
		this.clientChitanta=clientChitanta;
	}
	
	public String getValoareChitanta(){
		return valoareChitanta;
	}
	
	public void setValoareChitanta(String valoareChitanta){
		this.valoareChitanta=valoareChitanta;
	}
	
	public int getNrFactura(){
		return nrFactura;
	}
	
	public void setNrFactura(int nrFactura){
		this.nrFactura=nrFactura;
	}
	
	public String getDataChitanta(){
		return dataChitanta;
	}
	
	public void setDataChitanta(String dataChitanta){
		this.dataChitanta=dataChitanta;
	}
	
	public boolean equals(Chitanta second){
		if(this.getNrChitanta() != second.getNrChitanta())
			return false;
		
		if(this.getClientChitanta() != second.getClientChitanta())
			return false;
		
		if(this.getDataChitanta() != second.getDataChitanta())
			return false;
		
		if(this.getNrFactura() != second.getNrFactura())
			return false;
		
		if(this.getValoareChitanta() != second.getValoareChitanta())
			return false;
		
		return true;
	}
	
	
	/**Transform the value of valoareChitanta to letters
	 * 
	 * @return - the String with the value expressed in letters
	 */
	public String getValoareChitantaLitere(){
		
		int i = 0;
		String leiString = "";
		String baniString = "";
		
		while(i < valoareChitanta.length() && valoareChitanta.charAt(i) != '.'){
			leiString = leiString + valoareChitanta.charAt(i);
			i++;
		}
		i++;
		
		while(i < valoareChitanta.length()){
			baniString = baniString + valoareChitanta.charAt(i);	 
			i++;
		}
		int bani = 0;
		
		int lei = Integer.parseInt(leiString);
		if(baniString != ""){
			bani = Integer.parseInt(baniString);
			if(baniString.length() == 1)
				bani = bani * 10;
		}
		
//		System.out.println(lei + " si " + bani);
		
		
		// Transformarea cifrelor zecilor si sutelor
		
		//cifrele, zecilor si sutelor
		int leiSute = lei % 1000;
		
		//prima cifra
		int c1 = leiSute % 10;
		
		//cifra zecilor
		int c2 = (leiSute / 10) % 10;
		
		//cifra sutelor
		int c3 = (leiSute / 100) % 10;
		
		String litereSute3 = new String("");
		String litereSute2 = new String("");
		String litereSute1 = new String("");
		
		if(lei > 0){
			litereSute1 = "LEI";
		}
		
		
		if(c2 < 2){
			c1 = leiSute % 100;
		}
		
		if(lei == 1){
			litereSute1 = "UNLEU";
			c1 = 0;
		}
		
		switch (c1) {
		case 1:
			litereSute1 = "UNULEI";
			break;
			
		case 2:
			litereSute1 = "DOILEI";
			break;

		case 3:
			litereSute1 = "TREILEI";
			break;
			
		case 4:
			litereSute1 = "PATRULEI";
			break;
			
		case 5:
			litereSute1 = "CINCILEI";
			break;
			
		case 6:
			litereSute1 = "SASELEI";
			break;
			
		case 7:
			litereSute1 = "SAPTELEI";
			break;
			
		case 8:
			litereSute1 = "OPTLEI";
			break;
			
		case 9:
			litereSute1 = "NOUALEI";
			break;
			
		case 10:
			litereSute1 = "ZECELEI";
			break;
			
		case 11:
			litereSute1 = "UNSPREZECELEI";
			break;
			
		case 12:
			litereSute1 = "DOISPREZECELEI";
			break;
			
		case 13:
			litereSute1 = "TREISPREZECELEI";
			break;
			
		case 14:
			litereSute1 = "PAISPREZECELEI";
			break;
			
		case 15:
			litereSute1 = "CINCISPREZECELEI";
			break;
			
		case 16:
			litereSute1 = "SAISPREZCELEI";
			break;
			
		case 17:
			litereSute1 = "SAPTESPREZECELEI";
			
		case 18:
			litereSute1 = "OPTSPREZECELEI";
			
		case 19:
			litereSute1 = "NOUASPREZECELEI";
		}
		
		switch (c2) {
		case 2:
			litereSute2 = "DOUAZECI";
			break;
			
		case 3:
			litereSute2 = "TREIZECI";
			break;
			
		case 4:
			litereSute2 = "PATRUZECI";
			break;
			
		case 5:
			litereSute2 = "CINCIZEI";
			break;
			
		case 6:
			litereSute2 = "SASEZECI";
			break;
			
		case 7:
			litereSute2 = "SAPTEZECI";
			break;
			
		case 8:
			litereSute2 = "OPTZECI";
			break;
			
		case 9:
			litereSute2 = "NOUAZECI";
			break;
		}
		
		if(c1 > 0 && c2 > 1){
			litereSute1 = "SI" + litereSute1;
		}
		
		switch(c3){
		
		case 1:
			litereSute3 = "OSUTA";
			break;
			
		case 2:
			litereSute3 = "DOUASUTE";
			break;
			
		case 3:
			litereSute3 = "TREISUTE";
			break;
			
		case 4:
			litereSute3 = "PATRUSUTE";
			break;
			
		case 5:
			litereSute3 = "CINCISUTE";
			break;
			
		case 6:
			litereSute3 = "SASESUTE";
			break;
			
		case 7:
			litereSute3 = "SAPTESUTE";
			break;
			
		case 8:
			litereSute3 = "OPTSUTE";
			break;
			
		case 9:
			litereSute3 = "NOUASUTE";
		
		}
		
		
		//Transformare bani
		
		String litereBani1 = new String("");
		String litereBani2 = new String("");

		if(bani > 0){
			
			litereBani1 = "BANI";
			
			if(bani == 1){
				litereBani1 = "UNBAN";
			}
			
			c1 = bani % 10;
			c2 = (bani /10) % 10;
			
			if(c2 < 2){
				c1 = bani;
			}
			
			switch (c1) {
			case 1:
				litereBani1 = "UNUBANI";
				break;
				
			case 2:
				litereBani1 = "DOIBANI";
				break;
				
			case 3:
				litereBani1 = "TREIBANI";
				break;
				
			case 4:
				litereBani1 = "PATRUBANI";
				
			case 5:
				litereBani1 = "CINCIBANI";
				break;
				
			case 6:
				litereBani1 = "SASEBANI";
				break;
				
			case 7:
				litereBani1 = "SAPTEBANI";
				break;
				
			case 8:
				litereBani1 = "OPTBANI";
				break;
				
			case 9:
				litereBani1 = "NOUABANI";
				break;
				
			case 10:
				litereBani1 = "ZECEBANI";
				break;
				
			case 11:
				litereBani1 = "UNSPREZECEBANI";
				break;
				
			case 12:
				litereBani1 = "DOISPREZECEBANI";
				break;
				
			case 13:
				litereBani1 = "TREISPREZECEBANI";
				break;
				
			case 14:
				litereBani1 = "PAISPREZECEBANI";
				break;
				
			case 15:
				litereBani1 = "CINCISPREZECEBANI";
				break;
				
			case 16:
				litereBani1 = "SAISPREZECEBANI";
				break;
				
			case 17:
				litereBani1 = "SAPTESPREZECEBANI";
				break;
				
			case 18:
				litereBani1 = "OPTSPREZECEBANI";
				break;
				
			case 19:
				litereBani1 = "NOUSPREZECEBANI";
				break;
				
			}
			
			switch (c2) {
			case 2:
				litereBani2 = "DOUAZECI";
				break;
				
			case 3:
				litereBani2 = "TREIZECI";
				break;
				
			case 4:
				litereBani2 = "PATRUZECI";
				break;
				
			case 5:
				litereBani2 = "CINCIZECI";
				break;
				
			case 6:
				litereBani2 = "SASEZECI";
				break;
				
			case 7:
				litereBani2 = "SAPTEZECI";
				break;
				
			case 8:
				litereBani2 = "OPTZECI";
				break;
				
			case 9:
				litereBani2 = "NOUAZECI";
				break;
			}
			
			if(lei > 0){
				litereBani2 = "SI" + litereBani2;
			}
			
			if(c2 > 2 && c1>0){
				litereBani1 = "SI" + litereBani1;
			}
		}
		
		
		//Transformarea cifrelor miilor
		
		String litereMii1 = new String("");
		String litereMii2 = new String("");
		String litereMii3 = new String("");
		
		//cifrele miilor, zecilor de mii si sutelor de mii
		int leiMii = (lei / 1000) % 1000;
		
		//cifra miilor
		c1 = leiMii % 10;
		
		//cifra zecilor de mii
		c2 = (leiMii / 10) % 10;
		
		//cifra sutelor de mii
		c3 = (leiMii / 100) % 10;
		
		
		if(lei == 1000){
			return "UNAMIELEI" + litereBani2 + litereBani1;
		}
		
		if(c2 < 2){
			c1 = leiMii % 100; 
		}
		
		if(leiMii > 0){
			litereMii1 = "MII";
		}
		
		switch (c1) {
		case 1:
			litereMii1 = "UNAMII";
			break;
			
		case 2:
			litereMii1 = "DOUAMII";
			break;
			
		case 3:
			litereMii1 = "TREIMII";
			break;
			
		case 4:
			litereMii1 = "PATRUMII";
			break;
			
		case 5:
			litereMii1 = "CINCIMII";
			break;
			
		case 6:
			litereMii1 = "SASEMII";
			break;
			
		case 7:
			litereMii1 = "SAPTEMII";
			break;
			
		case 8:
			litereMii1 = "OPTMII";
			break;
			
		case 9:
			litereMii1 = "NOUAMII";
			break;
			
		case 10:
			litereMii1 = "ZECEMII";
			
		case 11:
			litereMii1 = "UNSPREZECEMII";
			
		case 12:
			litereMii1 = "DOISPREZECEMII";
			break;
			
		case 13:
			litereMii1 = "TREISPREZECEMII";
			break;
			
		case 14:
			litereMii1 = "PAISPREZECEMII";
			break;
			
		case 15:
			litereMii1 = "CINCISPREZECEMII";
			break;
			
		case 16:
			litereMii1 = "SAIPSREZECEMII";
			
		case 17:
			litereMii1 = "SAPTESPREZCEMII";
			break;
			
		case 18:
			litereMii1 = "OPSTSPREZECEMII";
			break;
			
		case 19:
			litereMii1 = "NOUASPREZECEMII";
			break;

		}
		
		switch (c2) {
		case 2:
			litereMii2 = "DOUAZECI";
			break;
			
		case 3:
			litereMii2 = "TREIZECI";
			break;
			
		case 4:
			litereMii2 = "PATRUZECI";
			break;
			
		case 5:
			litereMii2 = "CINCIZECI";
			break;
			
		case 6:
			litereMii2 = "SASEZECI";
			break;
			
		case 7:
			litereMii2 = "SAPTEZECI";
			break;
			
		case 8:
			litereMii2 = "OPTZECI";
			break;
			
		case 9:
			litereMii2 = "NOUAZECI";

		}
		
		if(c1 > 0 && c2 > 1){
			litereMii1 = "SI" + litereMii1;
		}
		
		switch (c3) {
		case 1:
			litereMii3 = "OSUTA";
			break;
			
		case 2:
			litereMii3 = "DOUASUTE";
			break;
			
		case 3:
			litereMii3 = "TREISUTE";
			break;
			
		case 4:
			litereMii3 = "PATRUSUTE";
			break;
			
		case 5:
			litereMii3 = "CINCISUTE";
			break;
			
		case 6:
			litereMii3 = "SASESUTE";
			break;
			
		case 7:
			litereMii3 = "SAPTESUTE";
			break;
			
		case 8:
			litereMii3 = "OPTSUTE";
			break;
			
		case 9:
			litereMii3 = "NOUASUTE";
			break;
		}
		
		
		//Transformarea milioanelor
		
		int leiMilioane = lei /1000000;
		
		//cifra milioanelor
		c1 = leiMilioane % 10;
		
		//cifra zecilor de miliaone
		c2 = (leiMilioane / 10) % 10;
		
		//cifra sutelor de milioane
		c3 = (leiMilioane / 100 ) % 10;
		
		String litereMilioane1 = new String("");
		String litereMilioane2 = new String("");
		String litereMilioane3 = new String("");
		
		
		if(lei == 1000000){
			return "UNMILIONLEI" + litereBani2 + litereBani1;
		}
		
		if (leiMilioane > 0 ){
			litereMilioane1 = "MILIOANE";
		}
		
		if(c2 < 2){
			c1 = leiMilioane % 100;
		}
		
		switch (c1) {
		case 1:
			litereMilioane1 = "UNAMILIOANE";
			break;
			
		case 2:
			litereMilioane1 = "DOUAMILIOANE";
			break;
			
		case 3:
			litereMilioane1 = "TREIMILIOANE";
			break;
			
		case 4:
			litereMilioane1 = "PATRUMILIOANE";
			break;
			
		case 5:
			litereMilioane1 = "CINCIMILIOANE";
			break;
			
		case 6:
			litereMilioane1 = "SASEMILIOANE";
			break;
			
		case 7:
			litereMilioane1 = "SAPTEMILIOANE";
			break;
			
		case 8:
			litereMilioane1 = "OPTMILIOANE";
			break;
			
		case 9:
			litereMilioane1 = "NOUAMILIOANE";
			break;
			
		case 10:
			litereMilioane1 = "ZECEMILIOANE";
			break;
			
		case 11:
			litereMilioane1 = "UNSPREZECEMILIOANE";
			break;
			
		case 12:
			litereMilioane1 = "DOISPREZECEMILIOANE";
			break;
			
		case 13:
			litereMilioane1 = "TREISPREZECEMILIOANE";
			break;
			
		case 14:
			litereMilioane1 = "PAISPREZECEMILIOANE";
			break;
			
		case 15:
			litereMilioane1 = "CINCISPREZECEMILIOANE";
			break;
			
		case 16:
			litereMilioane1 = "SAISPREZECEMILIOANE";
			break;
			
		case 17:
			litereMilioane1 = "SAPTESPREZECEMILIOANE";
			break;
			
		case 18:
			litereMilioane1 = "OPTSPREZECEMILIOANE";
			break;
			
		case 19:
			litereMilioane1 = "NOUASPREZECEMILIOANE";
			break;
		}
		
		switch (c2) {
		case 2:
			litereMilioane2 = "DOUAZECI";
			break;
			
		case 3:
			litereMilioane2 = "TREIZECI";
			break;
			
		case 4:
			litereMilioane2 = "PATRUZECI";
			break;
			
		case 5:
			litereMilioane2 = "CINCIZECI";
			break;
			
		case 6:
			litereMilioane2 = "SASEZECI";
			break;
			
		case 7:
			litereMilioane2 = "SAPTEZECI";
			break;
			
		case 8:
			litereMilioane2 = "OPTZECI";
			break;
			
		case 9:
			litereMilioane2 = "NOUAZECI";
			break;
		}
		
		if(c1 > 0 && c2 > 1){
			litereMilioane1 = "SI" + litereMilioane1;
		}
		
		switch (c3) {
		case 1:
			litereMilioane3 = "OSUTA";
			break;
			
		case 2:
			litereMilioane3 = "DOUASUTE";
			break;
			
		case 3:
			litereMilioane3 = "TREISUTE";
			break;
			
		case 4:
			litereMilioane3 = "PATRUSUTE";
			break;
			
		case 5:
			litereMilioane3 = "CINCISUTE";
			break;
			
		case 6:
			litereMilioane3 = "SASESUTE";
			break;
			
		case 7:
			litereMilioane3 = "SAPTESUTE";
			break;
			
		case 8:
			litereMilioane3 = "OPTSUTE";
			break;
			
		case 9:
			litereMilioane3 = "NOUASUTE";
			break;
		}
		
		
		return litereMilioane3 + litereMilioane2 + litereMilioane1 + litereMii3 + litereMii2 + litereMii1 + litereSute3 + litereSute2 + litereSute1 + litereBani2 + litereBani1;
	}
	
}