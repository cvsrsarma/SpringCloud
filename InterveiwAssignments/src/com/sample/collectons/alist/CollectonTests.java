package com.sample.collectons.alist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class CollectonTests {

	public static void main(String[] args) {
		
		testArrayList();

	}

	private static void testArrayList() {
		List<Emp> a = new ArrayList<Emp>();
		a.add(new Full(1,"Emp1","Bene1"));
		a.add(new Full(2,"Emp3","Bene4"));
		
		a.stream().forEach(System.out::println);
	}
	
}

@Data

class Emp{
	public Emp(int id2, String name2) {
		this.id=id2;
		this.name=name2;
	}
	int id;
	String name;
	
	public void test() throws Exception{
		if(true)
			throw new Exception("");
	}
}
class Full extends Emp{
	public Full(int id, String name, String bene) {
		super(id, name);
		this.bene=bene;
	}
	String bene; 
	@Override
	public void test() throws IOException {
	}
}

class part extends Emp{
	public part(int id2, String name2, String part) {
		super(id2, name2);
		this.part=part;
		// TODO Auto-generated constructor stub
	}

	String part;
}