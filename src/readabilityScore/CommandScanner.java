package readabilityScore;

import java.util.Scanner;

public class CommandScanner {

    private final Scanner scanner;

    CommandScanner() {
        this.scanner = new Scanner(System.in);
    }

    String askForCommand() {
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all)");
        return scanner.nextLine();
    }
}
