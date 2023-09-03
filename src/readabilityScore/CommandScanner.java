package readabilityScore;

import java.util.Scanner;

public class CommandScanner {

    private final Scanner scanner;

    CommandScanner() {
        this.scanner = new Scanner(System.in);
    }

    String askForCommand() {
        StringBuilder stringBuilder = new StringBuilder("Enter the score you want to calculate (");
        for (IndexType indexType : IndexType.values()) {
            stringBuilder.append(indexType.name());
            stringBuilder.append(", ");
        }
        stringBuilder.append("all)");
        System.out.println(stringBuilder);
        return scanner.nextLine();
    }
}
