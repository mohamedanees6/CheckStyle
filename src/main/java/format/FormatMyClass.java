package format;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

/**
 * 
 * @author mohamedanees
 *
 */

public class FormatMyClass {


	public static void main(String[] args) throws FormatterException, IOException {
		Set<String> javaFilePaths = new HashSet<>();
		try (Stream<Path> paths = Files.walk(Paths.get("/Users/mohamedanees/Documents/Work/insta-hms/instahms"))) {
			paths.filter(
					filePath -> Files.isRegularFile(filePath) && filePath.getFileName().toString().endsWith(".java"))
					.forEach(javaFile -> javaFilePaths.add(javaFile.toAbsolutePath().toString()));
		}
		for (String javaFilePath : javaFilePaths) {
			String fileContent = new String(Files.readAllBytes(Paths.get(javaFilePath)), StandardCharsets.UTF_8);
			String formattedString = new Formatter().formatSource(fileContent);
			try (PrintWriter out = new PrintWriter(javaFilePath)) {
				out.println(formattedString);
			}
		}
	}

}
