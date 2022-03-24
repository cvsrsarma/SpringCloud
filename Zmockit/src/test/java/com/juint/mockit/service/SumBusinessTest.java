package com.juint.mockit.service;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SumBusinessTest {

	@Test
	void calculateSum_basic() {
		SomeBusinessImpl business= new SomeBusinessImpl();
		int actualResult=business.calculateSum(new int[] {1,2,3});
		int expectedResult=6;
		assertEquals(actualResult,expectedResult);
	}
	
	@Test
	void calculateSum_empty() {
		SomeBusinessImpl business= new SomeBusinessImpl();
		int actualResult=business.calculateSum(new int[] {});
		int expectedResult=0;
		assertEquals(actualResult,expectedResult);
	}

}
