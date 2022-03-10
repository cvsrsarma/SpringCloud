package com.claimvantage.Style;

import java.math.BigDecimal;

public class InhertanceEx {

	public static void main(String[] args) {
		TestA a = new TestB();
		System.out.println(a.a);//Which one will print Parent
		a.print();
		
		BigDecimal b1 = new BigDecimal(125);
		BigDecimal b2 = new BigDecimal(125);
		
		System.out.println(b1==b2);
	}
}

class TestA{
	int a =10;
	void print() {
		System.out.println("Parent");
	}
}
class TestB extends TestA{
	int a=20;
	void print() {
		System.out.println("Child");
	}
}