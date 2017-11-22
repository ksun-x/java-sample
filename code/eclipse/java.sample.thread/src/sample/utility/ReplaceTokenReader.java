package sample.utility;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 * String.replace() method returns a new String instance, thus it is not practical for large character sequence and frequent replacement
 * Instead, TokenReplacingReader can read, identify and replace target characters 
 * http://grepcode.com/file/repository.jboss.org/nexus/content/repositories/releases/org.rhq/test-utils/4.3.0/org/rhq/test/TokenReplacingReader.java
 * @author ksun
 *
 */
public class ReplaceTokenReader {

	public static void main(String[] args) {
		Map<String, String> tokenMap = new HashMap<String, String>();
		tokenMap.put("token1", "Renault");
		tokenMap.put("token2", "Peugeot");
		
		/*
		ITokenResolver resolver = new MapTokenResolver(tokenMap);
		// target char sequence
	    Reader source = new StringReader("Vehicles: ${token1} GTI & ${token2} 3008");
	    // source can also be
	     	- new InputStreamReader(inputStream)
	     	- new FileReader(new File("c:\\file.txt")
	     	- new CharArrayReader(charArray)
	    Reader reader = new TokenReplacingReader(source, resolver);
	
	    int data;
	    while((data = reader.read()) != -1){
	        System.out.print((char) data);
	    }
	    // output: Vehicles: Renault GTI & Peugeot 3008
		 */
	}

}
