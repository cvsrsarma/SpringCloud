package com.interveiw.assignments.streams;

import java.util.Arrays;
import java.util.List;

public class StreamTest3 {
	
	 public static void main(String args[]) {
	
	 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
     long count =  myList.stream()
    		 .map(n->n*2)
    		 .filter(n->n%2==0)
    		 .count();
     System.out.println(count); 
	 }

}
