package com.codeprehend.medical.tests;

public class TestString {

	public static void main(String[] args) {
		
		String s = "maxim cel mare";
		
		if(s != "alt"){
			System.out.print(s.charAt(1));
		}
		
		assert 2 > 1 : "assert activ";
		
		System.out.print("\ns-a ajuns la final");

	}

}
