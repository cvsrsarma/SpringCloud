package com.interveiw.assignments.interfaces;

import com.interveiw.assignments.interfaces.test1.Interfaces1;
import com.interveiw.assignments.interfaces.test1.Interfaces2;

public class Ambiguity implements Interfaces1, Interfaces2{

	public static void main(String[] args) {
	}

	@Override
	public void test() {
		
	}

	@Override
	public void test1() {
		Interfaces1.super.test1();
	}


}
