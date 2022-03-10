package com.fnctnl.prgrm.fp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class FP01Struct {
	
	private static List<String> aList = Arrays.asList("Spring","Spring boot","API","Streams","MicroServices");

	public static void main(String[] args) {
		printListOfNumbers();
		
		customClass();
	}

	public static int sum(int a, int b) {
		System.out.println("A->"+a+" B->"+b);
		return a+b;
	}

	private static void printNumbers(Integer number) {
		System.out.println(number);
	}
	
	public static void printLine(String s) {
		System.out.println("--------------------");
		System.out.println(s);
	}

	private static Integer sum(Integer integer1, Integer integer2) {
		return null;
	}

	private static void printListOfNumbers() {
		List<Integer> numbers=List.of(12,9,13,4,6,2,4,12,15);
		printLine("Print numbers With method");
		numbers.stream().forEach(FP01Struct::printNumbers);
		printLine("Print numbers with method reference");
		numbers.stream().forEach(System.out::println);
		printLine("Print Even numbers");
		numbers.stream().filter(n->n%2==0).forEach(System.out::println);
		printLine("Print Odd numbers");
		numbers.stream().filter(n->n%2==1).forEach(System.out::println);
		printLine("Print Names");
		aList.stream().forEach(System.out::println);
		printLine("Print Contains Spring");
		aList.stream().filter(n->n.contains("Spring")).forEach(System.out::println);
		printLine("Square of the numbers");
		numbers.stream().map(n->n*n).forEach(System.out::println);
		printLine("Cube of the odd numbers");
		numbers.stream().filter(n->n%2==1).map(i->i*i*i).forEach(System.out::println);
		printLine("Length of the Strings");
		aList.stream().map(n->n.length()).forEach(System.out::println);
		
		printLine("Sum of the all numbers");
		Integer sum = numbers.stream()
				  .reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		printLine("Sum of the all numbers Squers");
		Integer sumOfSqures1 = numbers.stream()
				  .map(n->n*n).reduce(0, (a,b)->a+b);
		System.out.println(sumOfSqures1);
		printLine("Sum of the all Odd numbers cubes");
		int oddCube=numbers.stream().filter(n->n%2==1).map(i->i*i*i).reduce(0,(a,b)->a+b);
		System.out.println(oddCube);
		
		printLine("DistinctNumbers");
		numbers.stream().distinct().sorted().forEach(System.out::println);
		printLine("Sorted Strings");
		
		aList.stream().sorted().forEach(System.out::println);
		
		printLine("Sorted Strings");
		aList.stream().sorted(Comparator.comparing(str->str.length())).forEach(System.out::println);
		
		printLine("Double the list");
		List<Integer> doubleList=numbers.stream().map(n->n*2).collect(Collectors.toList());
		doubleList.stream().forEach(System.out::println);
		printLine("Even number only list");
		List<Integer> evenList = numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
		evenList.stream().forEach(System.out::println);
	}
	

	private static void customClass() {
		List<Cource> courses= 
		List.of(new Cource("Spring","FrameWork",398,200),
				new Cource("Spring Boot","FrameWork",392,500),
				new Cource("JPA","FrameWork",938,700),
				new Cource("AWS","Clude",548,800),
				new Cource("JSP","FrameWork",998,800),
				new Cource("CoreJava","Language",298,900),
				new Cource("DS","DSData",298,350));
		
		System.out.println(courses.stream().allMatch(course->course.getScore()>300));
		System.out.println(courses.stream().noneMatch(course->course.getScore()<300));
		System.out.println(courses.stream().anyMatch(course->course.getScore()>300));
		System.out.println(courses.stream().anyMatch(course->course.getScore()<300));
		
		Comparator<Cource> compareStudents = Comparator.comparing(Cource::getNumberStudents);
		
		System.out.println(courses.stream().sorted(compareStudents).collect(Collectors.toList()));
		
		Comparator<Cource> compareScores = Comparator.comparing(Cource::getScore);
		System.out.println(courses.stream().sorted(compareScores).collect(Collectors.toList()));
		
		Comparator<Cource> compareStudentsScores = Comparator.comparing(Cource::getScore).thenComparing(compareStudents);
		System.out.println(courses.stream().sorted(compareStudentsScores).collect(Collectors.toList()));
		
		System.out.println(courses.stream().sorted(compareStudentsScores).limit(5).collect(Collectors.toList()));
		
		System.out.println(courses.stream().sorted(compareStudentsScores).skip(5).collect(Collectors.toList()));
		
	}
	
}
@Setter@Getter@ToString
@AllArgsConstructor
@NoArgsConstructor
class Cource{
	private String name;
	private String category;
	private int score;
	private int numberStudents;
}
