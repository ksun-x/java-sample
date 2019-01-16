package sample.utility;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
	    ArrayList<String> strings = new ArrayList<String>();
	    strings.add("Hello, World!");
	    strings.add("Welcome to CoderPad.");
	    strings.add("This pad is running Java " + Runtime.version().feature());
	    System.out.println(strings);
	    
	    int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
	    
	    quickSort (test, 0, test.length - 1);
	    System.out.println(Arrays.toString(test));
	  }
	  
	  public static void quickSort (int[] values, int leftBound, int rightBound) {
	    if (values == null || values.length == 0 || (leftBound >= rightBound) || (leftBound < 0) || (rightBound >= values.length)) { 
	      return;
	    }
	    int l = leftBound;
	    int r = rightBound;
	    int pivotValue = values[(leftBound + rightBound)/2];
	    while (l < r) {
	      while (values[l] < pivotValue) {
	        l++;
	      }
	      while (values[r] > pivotValue) {
	        r--;
	      }
	      if (l <= r) {
	        if (l < r) {
	          int tempValue = values[l];
	          values[l] = values[r];
	          values[r] = tempValue;
	        }
	        l++;
	        r--;
	      }
	    }
	    
	    if (leftBound < r) {
	      quickSort (values, leftBound, r);
	    }
	    if (rightBound > l) {
	      quickSort (values, l, rightBound);
	    }
	  }
}
