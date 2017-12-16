package sample.lambda;

@FunctionalInterface
public interface Converter <T, F> {
	static void printInfo () {
		System.out.println("This is a converter");
	}

	abstract F convert (T origin);
	
	default void printDescription () {
		System.out.println("This is a converter");
	}
}
