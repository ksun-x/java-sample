package sample.test.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyIOUnit {
	protected List<String> tokens = new ArrayList<String>();
	
	public void read (InputStream input) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		
		int i;
		while ((i = input.read()) != -1) {
			char ch = (char) i;
			if (ch != ',') {
				stringBuilder.append(ch);
			} else {
				tokens.add(stringBuilder.toString().trim());
				stringBuilder.delete(0, stringBuilder.length());
			}
		}
		if (stringBuilder.length() > 0) {
			tokens.add(stringBuilder.toString().trim());
		}
	}
	
	public void write (OutputStream output) throws IOException {
		for (int i = 0; i < tokens.size(); i++) {
			if (i > 0) {
				output.write(',');
			}
			output.write(tokens.get(i).getBytes());
		}
	}
}
