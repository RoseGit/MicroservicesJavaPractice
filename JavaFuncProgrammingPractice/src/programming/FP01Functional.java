package programming;

import java.util.Iterator;
import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		//excersice 1
		//printAllNumbersInListFunctional(numbers);
		
		//Excersice 2 
		printEvenNumbersInListFunctional(numbers);
		
		//excercise 3 
		printSquaresOfEvenNumbersInListFunctional(numbers);
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		//What to do ? 
		//1.Crear un stream con la coleccion que vamos a trabajar
		//2. Que vamos a hacer con cada elemento ?(forEach)
		//3. Llamar al metodo de impresion de numero sin argumentos porque es lo que recibe, lo proporciona forEach  
		System.out.println("Primer acercamiento");
		numbers.stream().forEach(FP01Functional::printNumber);//::(Method reference)
		
		System.out.println("Mejorando el proceso");
		//Sin embargo una mejor aproximacion del codigo anterior es este 
		numbers.stream().forEach(System.out::println);
	}

	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		//Filter only even numbers
		System.out.println("using filter");
		numbers.stream().filter(FP01Functional::isEven).forEach(System.out::println);
		
		//Using lambda(metodo mas simple de crear y utilizar un metodo ) 
		System.out.println("using lamda");
		//condition if number -> number%2==0 is true
		numbers.stream().filter(number -> number%2==0).forEach(System.out::println);
	}
	
	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("using Map expressions");
		//Map what I do with this element 
		numbers.stream()
		.filter(number -> number%2==0)
		.map(number -> number * number)
		.forEach(System.out::println);
		
	}
	
	private static void printNumber(int number) {
		System.out.println(number);
	}
	
	private static boolean isEven(int number) {
		return number%2 == 0;
	}
}
