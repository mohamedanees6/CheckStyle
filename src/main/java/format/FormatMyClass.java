package format;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

/**
 *  
 * @author mohamedanees
 *
 */

public class FormatMyClass {
	
	private static final String FILE_PATH = "/Users/mohamedanees/Documents/workspace/format/src/main/java/format/SampleFile.java";

	public static void main(String[] args) throws FormatterException, FileNotFoundException {
		Scanner s = new Scanner(new File(FILE_PATH));
		StringBuilder sb= new StringBuilder();
		while(s.hasNextLine()){
			sb.append(s.nextLine());
		}
		System.out.println("File is" + sb.toString());
		String formattedString = new Formatter().formatSource(sb.toString());
		s.close();
		try (PrintWriter out = new PrintWriter(FILE_PATH)) {
		    out.println(formattedString);
		}
		
	}

}
