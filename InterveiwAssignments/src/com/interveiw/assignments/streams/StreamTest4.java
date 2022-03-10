package com.interveiw.assignments.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest4 {
	
	public static List<Integer> intList = Arrays.asList(8,49,585,273,159,487,593,378,596, 273, 49, 976);
	
	public static List<List<Integer>> a1 = new ArrayList();
	static {
		a1.add(Arrays.asList(32,432,533,355,254,534));
		a1.add(Arrays.asList(32,432,533,678,534));
		a1.add(Arrays.asList(32,432,434,254,745));
		a1.add(Arrays.asList(45,432,875,254,534));
		a1.add(Arrays.asList(465,432,434,656,745));
	}

	public static void main(String[] args) {
		
		String s1="HELLO";
		String s2="HELLO";
		String s3= new String("HELLO");
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s2));
		
		evenNumbers();
		sortNumbers();
		listStartingWith("1");
		listOfDuplicates();
		findFirstElement();
		countNumbeOFElements();
		findMaxValue();
		findMinValue();
		squareFunction();
		totalNumberOfOccured();
		sortListOfLists();
		findEmpCountBasedOnDescAndSex();
		
		stringStream();
	}

	private static void stringStream() {
        Map<String, Long> finalMap = new LinkedHashMap<>();
        
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        Map<String, Long> result= items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        result.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue()
                .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        
        System.out.println(result);
        
        System.out.println(finalMap);
	}

	private static void sortListOfLists() {
		List<Integer> a2=a1.stream().flatMap(List::stream).sorted().toList();
		a2.stream().map(n->n+"  ").forEach(System.out::print);
		System.out.println();
		
	}

	private static void findEmpCountBasedOnDescAndSex() {
		List<Employee> empList = getEmpList();
		
		Map<String,Map<String,Long>> map= 
				empList.stream().collect(Collectors.groupingBy(Employee::getDesignation,
						Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		System.out.println(map);
		
		Map<String,Map<String,Long>> map1= 
				empList.stream().collect(Collectors.groupingBy(Employee::getGender,
						Collectors.groupingBy(Employee::getDesignation, Collectors.counting())));
		
		System.out.println(map1);
		Map<Long,Map<String,Long>> map2= 
				empList.stream().collect(Collectors.groupingBy(Employee::getSalary,
						Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		System.out.println(map2);
		
		Map<Long,Map<String,Map<String,Long>>> map3= 
				empList.stream().collect(Collectors.groupingBy(Employee::getSalary,
						Collectors.groupingBy(Employee::getGender, 
								Collectors.groupingBy(Employee::getDesignation,Collectors.counting()))));
		System.out.println(map3);
		
		System.out.println();
		System.out.println();System.out.println();
		
		
	}

	private static List<Employee> getEmpList() {
List<Employee> employeesList = new ArrayList<>();
        
        employeesList.add(new Employee(101, "Glady", "Manager", "Male", 6_00_000));
        employeesList.add(new Employee(102, "Vlad", "Software Engineer", "Female", 15_00_000));
        employeesList.add(new Employee(103, "Shine", "Lead Engineer", "Female", 20_00_000));
        employeesList.add(new Employee(104, "Nike", "Manager", "Female", 25_00_000));
        employeesList.add(new Employee(105, "Slagan", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee(106, "Murekan", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee(107, "Gagy", "Software Engineer", "Male", 15_00_000));
        return employeesList;
	}

	private static void squareFunction() {
		System.out.println("squareFunction");
		List<Integer> minValue= intList.stream().map(n->n*n).toList();
		System.out.println(minValue);
		System.out.println("---------------squareFunction End--------------------");
	}

	private static void findMinValue() {
		System.out.println("findMinValue");
		Integer minValue= intList.stream().min(Integer::compareTo).get();
		System.out.println(minValue);
		System.out.println("---------------findMinValue End--------------------");
	}

	private static void findMaxValue() {
		System.out.println("findMaxValue");
		Integer maxValue = intList.stream().max(Integer::compareTo).get();
		System.out.println(maxValue);
		System.out.println("---------------findMaxValue End--------------------");
	}

	private static void countNumbeOFElements() {
		System.out.println("countNumbeOFElements");
		Long count = intList.stream().count();
		System.out.println(count);
		System.out.println("---------------countNumbeOFElements End--------------------");
	}

	private static void findFirstElement() {
		System.out.println("findFirstElement");
		intList.stream().findFirst().ifPresent(System.out::println);
		System.out.println("---------------findFirstElement End--------------------");
	}

	private static void listOfDuplicates() {
		Set<Integer> aSet = new HashSet<Integer>();
		intList.stream().filter(i->!aSet.add(i)).forEach(System.out::print);
	}

	private static void listStartingWith(String string) {
		System.out.println("listStartingWith");
		intList.stream().map(i->i+"").filter(j->j.startsWith(string)).forEach(System.out::println);
		intList.stream().findFirst().ifPresent(System.out::println);
		System.out.println();
		System.out.println("---------------listStartingWith End--------------------");
		
	}

	private static void evenNumbers() {
		System.out.println("EvenNumbers");
		intList.stream().filter(n->n%2==0).forEach(System.out::print);
		System.out.println();
		System.out.println("---------------EvenNumbers End--------------------");
	}

	private static void sortNumbers() {
		System.out.println("Sort Numbers");
		int n= intList.size();
		IntStream.range(0, n-1).flatMap(i->(IntStream.range(1, n-i))).forEach(j->{
			if(intList.get(j-1)>intList.get(j)) {
				int temp = intList.get(j);
				intList.set(j, intList.get(j-1));
				intList.set(j-1, temp);
			}
		});
		System.out.println(intList);
		System.out.println("---------------Sort Numbers End--------------------");
	}
	
	
	
	public static void totalNumberOfOccured() {
		System.out.println("Sort Numbers");
		Map<Integer, Long> map= a1.stream().flatMap(List::stream).sorted().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
		 a1.stream().flatMap(List::stream).sorted().forEach(System.out::println);
		System.out.println("---------------totalNumberOfOccured End--------------------");
			
	}
	
	
	
}
