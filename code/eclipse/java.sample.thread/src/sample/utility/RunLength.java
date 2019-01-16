package sample.utility;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.junit.*;
import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;

public class RunLength {
	public static void main (String[] args) {
//	    System.out.print("Please enter string:");
	    String data = "AAAAaaaaBBBbBbCCccDdEEeEAABSDFFSSS";//System.console().readLine();
	    String encodedData = encodeRunLength(data);
	    System.out.println(encodedData);
	    System.out.println(decodeRunLength(encodedData));
	}
	
	private static String PATTERN_DUPLICATE_CHAR = "([a-zA-Z])\\1*";
	private static String PATTERN_RUNLENGTH = "(\\d+)([a-zA-Z]+)";
	  
	public static String encodeRunLength (String data) {
	    StringBuilder builder = new StringBuilder();
	    Pattern pattern = Pattern.compile(PATTERN_DUPLICATE_CHAR, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(data);
	    while (matcher.find()) {
	      String duplicateChars = matcher.group();
	      builder.append(duplicateChars.length() + "" + duplicateChars.charAt(0));
	    }
	    return builder.toString();
	}
	
	public static String decodeRunLength (String data) {
		StringBuilder builder = new StringBuilder();
		Pattern pattern = Pattern.compile(PATTERN_RUNLENGTH);
		Matcher matcher = pattern.matcher(data);
		while (matcher.find()) {
			int count = Integer.parseUnsignedInt(matcher.group(1));
			builder.append(matcher.group(2).repeat(count));
		}
		return builder.toString();
	}
}
