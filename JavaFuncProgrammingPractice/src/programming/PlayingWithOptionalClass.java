package programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Demonstrates the use of the optional class.
 */
public class PlayingWithOptionalClass {

	/**
	 * the main method of the program
	 * @param args Extra program information
	 */
	public static void main (String args[]) {
		List<String> fruits = List.of("banana","apple","mango");
		
		Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
		Optional<String> first = fruits.stream().filter(predicate).findFirst();
		
		System.out.println(first);
		System.out.println(first.isEmpty());
		System.out.println(first.isPresent());
		System.out.println(first.get());
		//Podemos asignar valores a un optional 
		Optional<String> fruit = Optional.of("banana");
		Optional<String> empty = Optional.empty();
	}
}
