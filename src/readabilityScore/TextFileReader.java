package readabilityScore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileReader {

    private static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    static String getFileContent(String fileName) {
        String fileContent = "";
        try {
            fileContent = readFileAsString(fileName);
        } catch (IOException exception) {
            System.out.println("Can't read file: " + exception.getMessage());
        }
        return fileContent;
    }
}
