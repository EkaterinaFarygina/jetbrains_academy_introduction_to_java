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

    int inputLengthOfCode() {
        System.out.println("Input the length of the secret code:");
        String inputLength = takeInputCode();
        try {
            int length = Integer.parseInt(inputLength);
            if (length == 0) {
                System.out.println("Error: it's not possible to generate a code with a length of 0.");
                length = -1;
            }
            return length;
        } catch (NumberFormatException exception) {
            System.out.printf("Error: \"%s\" isn't a valid number.", inputLength);
            return -1;
        }
    }

    int inputNumberOfSymbols() {
        System.out.println("Input the number of possible symbols in the code:");
        String inputNumbers = takeInputCode();
        try {
            int numberOfSymbols = Integer.parseInt(inputNumbers);
            if (numberOfSymbols == 0) {
                System.out.println("Error: it's not possible to generate a code with a 0 unique symbols.");
                numberOfSymbols = -1;
            } else if (numberOfSymbols > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
                numberOfSymbols = -1;
            }
            return numberOfSymbols;
        } catch (NumberFormatException exception) {
            System.out.printf("Error: %s isn't a valid number.", inputNumbers);
            return -1;
        }
    }
}
