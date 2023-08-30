package readabilityScore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileReader {

    private String fileContent;

    TextFileReader(String fileName) {
        try {
            fileContent = readFileAsString(fileName);
        } catch (IOException exception) {
            System.out.println("Can't read file: " + exception.getMessage());
        }
    }

    private static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    String getFileContent() {
        return fileContent;
    }
}
