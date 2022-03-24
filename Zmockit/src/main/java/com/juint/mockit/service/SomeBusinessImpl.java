package com.juint.mockit.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

import com.juint.mockit.services.SomeDataService;

public class SomeBusinessImpl {
	
	SomeDataService service;
	
	public SomeDataService getService() {
		return service;
	}

	public void setService(SomeDataService service) {
		this.service = service;
	}

	public Integer calculateSum(int []a) {
		Integer[] newArray = ArrayUtils.toObject(a);
	Integer temp=0;
		temp= Arrays.asList(newArray).stream().collect(Collectors.summingInt(Integer::intValue));
		
	return temp;
	}
	
	public Integer calculateSumDataService() {
		int[]a= service.getIntArray();
		Integer[] newArray = ArrayUtils.toObject(a);
	Integer temp=0;
		temp= Arrays.asList(newArray).stream().collect(Collectors.summingInt(Integer::intValue));
		
	return temp;
	}

}
