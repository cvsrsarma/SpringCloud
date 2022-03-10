package com.interveiw.assignments.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class StreamsTest {
	 static int count = 0;
	public static List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32,10,15,8,25,32);
	public static List<Integer> list = Arrays.asList(10,15,8,49,25,98,32,10,15,8,25,32);
	
	public static String input = "Java Hungry Blog Alive is Awesome";

	public static void main(String[] args) {
		
		evenNumbers();
		compateTwoObjects();
		stringCompare();
		
		listOfEvenNumbers();
		
		boolean b1=true;
		boolean b2;
			b2 = fix(b1);
		System.out.println(b1+" "+b2);
		
		int[] a= {3,5,8};
		a[1]=7;
		int[] b=a;
		System.out.println(a[0]+" "+a[1]+" "+a[2]);
		System.out.println(b[0]+" "+b[1]+" "+b[2]);
		
			 
			    if(count< 3){
			      count++;
			      main(null);
			    }else{
			      return;
			    }
			    System.out.println("Hello World!");
			}
		
		

	/*	listOfEvenNumbers();
		System.out.println("listOfEvenNumbers");
		listStartingWith("1");
		System.out.println("listStartingWith");
		listOfDuplicates();
		System.out.println("listOfDuplicates");
		findFirstElement();
		System.out.println("findFirstElement");
		findNumbersofElements();
		System.out.println("findNumbersofElements");
		findMaxValue();
		System.out.println("findMaxValue");
		squareFunction();
		System.out.println("squareFunction");
		nonRepateChar();
		System.out.println("nonRepateChar");
		
		compateTwoObjects();
		System.out.println("nonRepateChar");
		
		myList.stream().peek(System.out::println).count();*/
		
		//bubbleSortByStream();
	//	bubbleSortUsingStreams();
	//	tryEmployeeSorting();
		


		

	public static boolean fix(boolean b1) {
		b1=false;
		return b1;
		}
	

	private static void stringCompare() {
		String s1="Rama is tacking tech interviews, Rama needs some help with Restfull services, Rama aldskjfa asdsdk as needs some help";
		String s2="some";
		String[] strAry =s1.split(" ");
		List<String> sList = Arrays.asList(strAry);
		
		Long count = sList.stream().filter(s3->s3.equalsIgnoreCase(s2)).count();
		
		System.out.println(count);
		
	}




	private static void evenNumbers() {
		System.out.print("EvenNumbers:- ");
		List evenList = list.stream().filter(n->n%2==0).collect(Collectors.toList());
		evenList.stream().forEach(System.out::print);
		System.out.print("");
	}




	private static void tryEmployeeSorting() {
		
	}



	private static void bubbleSortUsingStreams() {
		int n=myList.size();
		IntStream.range(0,n).flatMap(i->IntStream.range(1, n-1)).forEach(j->{
			if(myList.get(j)<myList.get(j-1)) {
				int tempVar = myList.get(j-1);
				myList.set(j-1, myList.get(j));
				myList.set(j, tempVar);
			}
		});
		System.out.println(myList);
	}



	private static void bubbleSortByStream() {
		int n = myList.size();
		IntStream.range(0,n-1).flatMap(i->IntStream.range(1, n-i)).forEach(j->{
			if(myList.get(j-1)>myList.get(j)) {
				int temp= myList.get(j);
				myList.set(j, myList.get(j-1));
				myList.set(j-1, temp);
		}
			
		});
		
		System.out.println(myList);
		
	}



	private static void nonRepateChar() {
		String st = input.toLowerCase();
		char[] data = new char[st.length()];
		
	}

	private static void squareFunction() {
		List<Integer> sqList= myList.stream().map(n->n*n).collect(Collectors.toList());
		sqList.stream().forEach(System.out::println);
		 Consumer<Integer> display = a -> System.out.println(a);
		 
		 System.out.println("Implement display using accept()");
		 
	        // 
	        display.accept(10);
	        
	        
	        int size = myList.size();
	}

	private static void findMaxValue() {
		Integer maxValue= myList.stream().max(Integer::compareTo).get();
		System.out.println(maxValue);
	}

	private static void findNumbersofElements() {
		Long count =myList.stream().count();
		System.out.println(count);
	}

	private static void findFirstElement() {
		myList.stream().findFirst().ifPresent(System.out::println);
	}

	private static void listOfDuplicates() {
		Set<Integer> set = new HashSet<Integer>();
		myList.stream().filter(n->!set.add(n)).forEach(System.out::println);
	}

	private static void listStartingWith(String string) {
		myList.stream().map(n->n+"").filter(n->n.startsWith("1")).forEach(System.out::println);
	}

	private static void listOfEvenNumbers() {
		myList.stream().filter(i->i%2==0).forEach(System.out::print);
		List<Integer> aList =myList.stream().filter(n->n%2==0).toList();
		
		aList.stream().forEach(System.out::println);
		
		System.out.println("/\\n /\\n /\\n");
		myList.stream().peek(System.out::println).count();
	}
	
	
	private static void compateTwoObjects() {
        ArrayList<Student> ar = new ArrayList<Student>();
        ArrayList<Studt> ar1 = new ArrayList<Studt>();
        
        // Adding entries in above List
        // using add() method
        ar.add(new Student(111, "Mayank", 26));
        ar.add(new Student(131, "Anshul", 34));
        ar.add(new Student(121, "Solanki", 35));
        ar.add(new Student(101, "Aggarwal", 48));
        
        ar1.add(new Studt(111, "Mayank", 26));
        ar1.add(new Studt(131, "Anshul", 34));
        ar1.add(new Studt(121, "Solanki", 35));
        ar1.add(new Studt(101, "Aggarwal", 48));
        
        
        
        
        ar.stream().forEach(System.out::println);
        System.out.println("------------------");
        
        Collections.sort(ar, new SortById());
        ar.stream().forEach(System.out::println);
        Collections.sort(ar, new SortByName());
        ar.stream().forEach(System.out::println);
        System.out.println("/\n/\n/\n");
        Collections.sort(ar, new CustomCompate());
        ar.stream().forEach(System.out::println);
        
        List<Employee> employeesList = new ArrayList<>();

        
        employeesList.add(new Employee(101, "Glady", "Manager", "Male", 6_00_000));
        employeesList.add(new Employee(102, "Vlad", "Software Engineer", "Female", 15_00_000));
        employeesList.add(new Employee(103, "Shine", "Lead Engineer", "Female", 20_00_000));
        employeesList.add(new Employee(104, "Nike", "Manager", "Female", 25_00_000));
        employeesList.add(new Employee(105, "Slagan", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee(106, "Murekan", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee(107, "Gagy", "Software Engineer", "Male", 15_00_000));
        
        System.out.println("hashCode"+new Employee(101, "Glady", "Manager", "Male", 6_00_000).hashCode());
        System.out.println(new Employee(101, "Glady", "Manager", "Male", 6_00_000).hashCode());
        System.out.println(new Employee(101, "Glady", "Manager", "Male", 6_00_000).hashCode());
        System.out.println(new Employee(101, "Glady", "Manager", "Male", 6_00_000).equals(new Employee(101, "Glady", "Manager", "Male", 6_00_000).hashCode()));
        
        Map<Employee, String> map = new HashMap<Employee, String>();
        map.put(new Employee(101, "Glady", "Manager", "Male", 6_00_000), "Emp1");
        map.put(new Employee(101, "Glady", "Manager", "Male", 6_00_000), "Emp2");
        map.put(new Employee(101, "Glady", "Manager", "Male", 6_00_000), "Emp3");
        map.put(new Employee(101, "Glady", "Manager", "Male", 6_00_000), "Emp4");
        System.out.println(map.size());
        
        Map<String, Map<String, Long>> empmap =employeesList.stream().collect(
        		Collectors.groupingBy(Employee::getDesignation,
        				Collectors.groupingBy(Employee::getGender,Collectors.counting())));
        				
        
        Optional<Employee> emp= employeesList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
       
        
        if(emp.isPresent())
        	System.out.println(emp.get());
        
        
        Student empp= ar.stream().max((emp1, emp2)->(emp1.age>emp2.age)?1:-1).get();
        
        if(null!=empp)
        	System.out.println(empp.toString());
        
        Studt empp2= ar1.stream().max((emp1, emp2)->emp1.age>emp2.age?1:-1).get();
        
        if(null!=empp2)
        	System.out.println(empp2.toString());
        
        
        
        Map<String, Map<String, Long>> empMap = employeesList.stream().collect(
        		Collectors.groupingBy(Employee::getDesignation,
        				Collectors.groupingBy(Employee::getGender,
        						Collectors.counting())));
        
        System.out.println(empMap);
        
        employeesList.stream().peek(System.out::println);
        
        
        Map<String,Map<String,Long>> empMap1=employeesList.stream().collect(
        		Collectors.groupingBy(Employee::getDesignation, 
        				Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        
        System.out.println(empMap1);
        
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
        
        
        List<String> employeeNames = employeesList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        	String employeeNamesStr = String.join(",", employeeNames);
        	System.out.println("Employees are: "+employeeNamesStr);
        
        
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	/*private static void findMaxValue() {
		long maxValue= myList.stream().max(Integer::compare).get();
		System.out.println(maxValue);
	}

	private static void findNumbersofElements() {
		long count=myList.stream().count();
		System.out.println(count);
	}

	private static void findFirstElement() {
		myList.stream().findFirst().ifPresent(System.out::print);
	}

	private static void listOfDuplicates() {
		Set<Integer> set = new HashSet<Integer>();
		myList.stream().filter(n->!set.add(n)).forEach(System.out::print);
	}

	private static void listStartingWith(String i) {
		myList.stream().map(n->n+"").filter(n->n.startsWith(i)).forEach(System.out::print);
	}

	private static void listOfEvenNumbers() {
		myList.stream().filter(n->n%2==0).forEach(System.out::print);
	}

}*/
@AllArgsConstructor
@Getter@Setter@ToString
class Student{
	private int sid;
	private String sName;
	public int age;
	
	 public Integer getAge() { return age; }
}

class SortById implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getSid()-o2.getSid();
	}
}

class SortByName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		System.out.println("Compate to method is called");
		return o1.getSName().compareTo(o2.getSName());
	}
}
 class CustomCompate implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int nameCompare = o1.getSName().compareTo(o2.getSName());
		int ageCompare = o1.getAge().compareTo(o2.getAge());
		return nameCompare==0?ageCompare:nameCompare;
	}
 }
 
 @AllArgsConstructor@Setter@Getter@ToString
 @EqualsAndHashCode
 class Employee {
	 public char[] get() {
		// TODO Auto-generated method stub
		return null;
	}
	private int id;
	 private String name;
	 private String designation;
	 private String gender;
	 public long salary;
 }
 
 @AllArgsConstructor
 @Getter@Setter@ToString
 class Studt{
 	private int sid;
 	private String sName;
 	public int age;
 	
 	 public Integer getAge() { return age; }
 }