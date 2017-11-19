/**
 * 
 */
package sample.test.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;

/**
 * @author ksun
 *
 */
class MyIOUnitTest {

	@Test
	void testRead() throws IOException {
		InputStream input = new ByteArrayInputStream("abc,def,ghi".getBytes());
		MyIOUnit myIOUnit = new MyIOUnit();
		myIOUnit.read(input);
		assertEquals("abc", myIOUnit.tokens.get(0));
		assertEquals("def", myIOUnit.tokens.get(1));
		assertEquals("ghi", myIOUnit.tokens.get(2));
	}
	
	@Test
	void testWrite() throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		MyIOUnit myIOUnit = new MyIOUnit();
		myIOUnit.tokens.add("abc");
		myIOUnit.tokens.add("def");
		myIOUnit.tokens.add("ghi");
		myIOUnit.write(output);
		assertEquals("abc,def,ghi", new String(output.toByteArray()));
	}
}
