package com.codeprehend.medical.tests;

public class CompareString {

	
	public static void main(String[] args){
	
		String prenume = new String("Gabi");
		String nume = new String("Munteanu");
		
		String[] sir = {"mama", "tata", "maria", "andreea", "gigi", "vasile"};
		
		if(prenume.trim().compareTo(nume.trim()) < 0)
			System.out.print(prenume);
		
		else {
			System.out.print(nume);
		}
		
		System.out.println("\nSirul ordonat este:");
		
		int i,j;
		String aux = new String();
		
		for(i = 0; i < 5; i++)
			for(j = i+1; j < 6; j++){
				if(sir[i].trim().compareTo(sir[j].trim()) > 0){
					aux = sir[i];
					sir[i] = sir[j];
					sir[j] = aux;
				}
					
			}
		
		for(i = 0; i < 6; i++){
			System.out.println(sir[i]);
		}
		
	}
	
}
