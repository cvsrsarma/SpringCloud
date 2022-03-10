package com.interveiw.assignments.streams;

import com.interveiw.assignments.interfaces.test1.MultiFunctionalInterface;

public class FunctionalInterfaceImpl {

	public static void main(String[] args) {
		
		MultiFunctionalInterface Total = (int a,int b) -> a * b;
	        System.out.println("Result: "+Total.multiply(30, 60));
	        
	}

}


