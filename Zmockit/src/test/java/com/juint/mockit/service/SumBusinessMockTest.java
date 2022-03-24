package com.juint.mockit.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.juint.mockit.services.SomeDataService;


@RunWith(MockitoJUnitRunner.class)
class SumBusinessMockTest {
	
	@InjectMocks	
	SomeBusinessImpl business;
	
	@Mock
	SomeDataService service;
	
	@BeforeEach
	public void setup() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void calculateSumDataService_basic() {
		when(service.getIntArray()).thenReturn(new int [] {1,2,3});
		int actualResult=business.calculateSumDataService();
		assertEquals(6,actualResult);
	}
	
	@Test
	void calculateSum_empty() {
		when(service.getIntArray()).thenReturn(new int [] {});
		int actualResult= business.calculateSumDataService();
		assertEquals(0,actualResult);
	}

}
/*
 @ExtendWith(MockitoExtension.class)

instead of @RunWith(MockitoJUnitRunner.class)

*/
