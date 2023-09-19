package bullscows;

import java.util.Scanner;

public class InputScanner {

    private final Scanner scanner;

    InputScanner() {
        this.scanner = new Scanner(System.in);
    }

    String takeInputCode() {
        return scanner.nextLine();
    }
}
