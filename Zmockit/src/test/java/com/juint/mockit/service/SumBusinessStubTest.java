package com.juint.mockit.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.juint.mockit.services.SomeDataService;

class SomeDataServiceImpl implements SomeDataService{

	@Override
	public int[] getIntArray() {
	
		return new int[] {1,2,3};
	}
	
}

class SomeDataServiceEmptyImpl implements SomeDataService{

	@Override
	public int[] getIntArray() {
	
		return new int[] {};
	}
	
}

class SumBusinessStubTest {

	@Test
	void calculateSumDataService_basic() {
		SomeBusinessImpl business= new SomeBusinessImpl();
		business.setService(new SomeDataServiceImpl());
		int actualResult=business.calculateSumDataService();
		int expectedResult=6;
		assertEquals(actualResult,expectedResult);
	}
	
	@Test
	void calculateSum_empty() {
		SomeBusinessImpl business= new SomeBusinessImpl();
		business.setService(new SomeDataServiceEmptyImpl());
		int actualResult=business.calculateSumDataService();
		int expectedResult=0;
		assertEquals(actualResult,expectedResult);
	}

}
