package sample.utility;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.lang.System;
import java.lang.reflect.Array;
import java.lang.Math;
import java.lang.*;
import java.math.BigInteger;

class Fibonacci {
  public static void main (String[] args) {
    System.out.print("Please enter Fibonacci length:");
    int length = 100;//Integer.valueOf(System.console().readLine());
    	System.out.println(Arrays.toString(reversedFibonacci(length, long.class)));
  }
  
  public static void reversedFibonacci (int length) {
    BigInteger[] reversedFibonacci = new BigInteger [length < 0 ? 0: length];
    if (length > 0) {
    	  reversedFibonacci[length - 1] = BigInteger.ZERO;
    }
    if (length > 1) {
      reversedFibonacci[length - 2] = BigInteger.ONE;
      for (int i = length - 3; i >= 0; i--) {
        reversedFibonacci[i] = reversedFibonacci[i + 2].add(reversedFibonacci [i + 1]);
      }
    }
    System.out.println(Arrays.toString(reversedFibonacci));
  }
  
  public static <T extends Number> Number[] reversedFibonacci (int length, Class<T> numberClass) {
	  if (BigInteger.class.isAssignableFrom(numberClass)) {
		  BigInteger[] reversedFibonacci = (BigInteger[]) Array.newInstance(numberClass, length);
		  if (length > 0) {
			  reversedFibonacci[length - 1] = BigInteger.ZERO;
		  }
		  if (length > 1) {
			  reversedFibonacci[length - 2] = BigInteger.ONE;
			  for (int i = length - 3; i >= 0; i--) {
				  reversedFibonacci[i] = reversedFibonacci[i + 2].add(reversedFibonacci [i + 1]);
			  }
		  }
		  return reversedFibonacci;
	  } else if (long.class.isAssignableFrom(numberClass)) {
		  Long[] reversedFibonacci = new Long[length];
		  if (length > 0) {
			  reversedFibonacci[length - 1] = Long.valueOf(0);
		  }
		  if (length > 1) {
			  reversedFibonacci[length - 2] = Long.valueOf(1);
			  for (int i = length - 3; i >= 0; i--) {
				  reversedFibonacci[i] = reversedFibonacci[i + 2] + reversedFibonacci [i + 1];
			  }
		  }
		  return reversedFibonacci;
	  }
	  return null;
  }
}

/*
import java.io.*;
import java.util.*;
import org.junit.*;
// import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;

public class Solution {
  public static void main (String[] args) {
    System.out.print("Please enter Fibonacci length:");
    String numStr = System.console().readLine();
    int num = Integer.valueOf(numStr);
    getReversedFibonacci(num);
    JUnitCore.main("Solution");
    
    final String introductionStr = "Please input fibonacci length:";
    int length = 0;
    boolean readSucceed = false;
    while (!readSucceed) {
      try {
        System.out.print(introductionStr);
        length = Integer.valueOf(System.console().readLine());
        readSucceed = true;
      } catch (Exception e) {
        System.out.println("Note that the length should be a number");
      }
    }
    System.out.println("Length is " + length);
  }
  
  @Test
  public void testReversedFibonacci() {
    int[] fibonacci = {34, 21, 13, 8, 5, 3, 2, 1, 1, 0};
    assertArrayEquals(fibonacci, getReversedFibonacci(10));
  }
  
  public static int[] getReversedFibonacci (int length) {
    int[] reversedFibonacci = new int[length < 1 ? 0 : length];
    reversedFibonacci[length - 1] = 0;
    if (length > 1) {
      reversedFibonacci[length - 2] = 1;
      for (int i = length - 3; i >= 0; i--) {
        reversedFibonacci[i] = reversedFibonacci[i + 2] + reversedFibonacci [i + 1];
      }
    }
    System.out.println(Arrays.toString(reversedFibonacci));
    return reversedFibonacci;
  }
}
*/