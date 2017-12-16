package sample.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class UseCase {
	static int globalCounter = 0;
	int localCounter = 0;
	
	List<String> names = Arrays.asList("Peugeot", "Citroen", "Renault");

	void Compare1 () {
		Collections.sort(names, new Comparator<String> () {
			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
	}
	
	void Compare2 () {
		Collections.sort(names, (String a, String b) -> { return a.compareTo(b); });
		Collections.sort(names, (a, b) -> { return a.compareTo(b); });
		Collections.sort(names, (String a, String b) -> a.compareTo(b));
		Collections.sort(names, (a, b) -> a.compareTo(b));
	}
	
	void Compare3 () {
		// at least i must be implicitly final, i.e. its value cannot be modified
		int i = 1;
		Converter<String, Integer> converter = (origin) -> {
			// lambda cannot access default method, but static method
			Converter.printInfo();
			// lambda can read/write static variable and instance field, but only read local variable
			globalCounter++;
			localCounter++;
			return Integer.valueOf(origin) + i;};
		System.out.println(converter.convert("123"));
	}
	
	void Compare4 () {
		// use static method reference
		Converter<String, Integer> converter = Integer::valueOf;
		System.out.println(converter.convert("123"));
	}
	
	void Predicate () {
		Predicate<String> stringPredicate = str -> str.length() > 0;
		// return true
		stringPredicate.test("foo");
		// return false
		stringPredicate.negate().test("foo");
		
		Predicate<Object> notNullPredicate = Objects::nonNull;
		Predicate<Object> isNullPredicate = Objects::isNull;
		
		// isEmpty() is used like extension method in Xtend
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> notEmpty = isEmpty.negate(); 
	}
}
