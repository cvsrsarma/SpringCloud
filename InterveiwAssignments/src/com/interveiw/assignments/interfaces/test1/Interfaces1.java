package com.interveiw.assignments.interfaces.test1;

public interface Interfaces1 {
	
	public void test();
	
	public default void test1() {
		System.out.println("Test");
	}

}
