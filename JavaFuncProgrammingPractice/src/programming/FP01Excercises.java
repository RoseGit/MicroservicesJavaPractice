package programming;

import java.util.Iterator;
import java.util.List;

public class FP01Excercises {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		printOddNumbersInListFunctional(numbers);
		
		List<String> courses = List.of("Spring","Spring boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernates");
		System.out.println("for each element:");
		courses.stream().forEach(System.out::println);
		System.out.println("");
		
		System.out.println("Only contains spring word");
		courses.stream().filter(course->course.contains("Spring")).forEach(System.out::println);
		System.out.println("");
		
		System.out.println("Only words gratter than 4 characteres");
		courses.stream().filter(course->course.length() > 4 ).forEach(System.out::println);
		System.out.println("");
		
		System.out.println("print cubes for numbers");
		printCubesOfOddNumbersInListFunctional(numbers);
		System.out.println("");
		
		System.out.println("Printing lengh for words ");
		courses.stream()
			.map(course-> course +" "+course.length())
			.forEach(System.out::println);
		System.out.println("");
	}	

	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream().filter(number->number%2==1).forEach(System.out::println);
	}
	
	private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.filter(number->number%2==1)
		.map(number-> number*number*number)
		.forEach(System.out::println);
	}
}
