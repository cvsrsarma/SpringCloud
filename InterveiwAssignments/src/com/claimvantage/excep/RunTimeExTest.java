package com.claimvantage.excep;

public class RunTimeExTest {
	//Is it mandatory to throws runtime exception. No its not
	public void testRunTimeEx() {
		if(true) {
			throw new RunTimeEx();
		}
		
		if(true) {
			//throw new CustExce();//Is it mandatory to throws runtime exception. Yes its 
		}
	}

}