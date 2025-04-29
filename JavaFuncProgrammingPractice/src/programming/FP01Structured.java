package programming;

import java.util.Iterator;
import java.util.List;

/**
 * shows traditional use without lambdas
 */
public class FP01Structured {

	/**
	 * the main method of execution
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
		//Excersice 1
		//printAllNumbersInListStructured(numbers);
		
		//Excersise 2
		printEvenNumbersInListStructured(numbers);
		
	}

	/**
	 * print all the numbers in a list
	 * @param numbers The list of numbers
	 */
	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		//how to loop the numbers (traditional)
		for (int number : numbers) {
			System.out.println(number);
		}
	}
	
	/**
	 * print all even numbers in a list
	 * @param numbers
	 */
	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		//how to loop the numbers (traditional)
		for (int number : numbers) {
			if(number%2 == 0) {
				System.out.println(number);	
			}
		}
	}

}
