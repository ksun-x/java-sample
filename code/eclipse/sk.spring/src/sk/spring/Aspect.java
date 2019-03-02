package sk.spring;

public class Aspect {
	public void afterReturnAdvice(String parameter) {
		System.out.println("After return advice:" + parameter);
	}
}
