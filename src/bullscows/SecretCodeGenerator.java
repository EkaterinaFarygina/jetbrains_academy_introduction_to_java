package bullscows;

import java.util.Arrays;
import java.util.Random;

public class SecretCodeGenerator {

    int inputLengthOfCode() {
        System.out.println("Input the length of the secret code:");
        InputScanner scanner = new InputScanner();
        String inputLength = scanner.takeInputCode();
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
        InputScanner scanner = new InputScanner();
        String inputNumbers = scanner.takeInputCode();
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

    private char[] initializeArrayOfSymbols(int numberOfSymbols) {
        char[] values = new char[numberOfSymbols];
        if (numberOfSymbols < 10) {
            Arrays.fill(values, (char) (48 + numberOfSymbols));
        } else {
            for (int i = 0; i < 10; i++) {
                values[i] = (char) (48 + i);
            }
            for (int i = 10; i < numberOfSymbols; i++) {
                values[i] = (char) (87 + i);
            }
        }
        return values;
    }

    private void shuffleArrayOfSymbols(char[] values) {
        final var random = new Random();
        char container;
        for (int i = 0; i < 300; i++) {
            int randomIndex1 = random.nextInt(values.length);
            int randomIndex2 = random.nextInt(values.length);
            container = values[randomIndex1];
            values[randomIndex1] = values[randomIndex2];
            values[randomIndex2] = container;
        }
    }

    private void displayRangeOfSymbols(char[] values, int length, int numberOfSymbols) {
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        if (numberOfSymbols < 11) {
            System.out.printf(" (%c-%c).\n", values[0], values[numberOfSymbols - 1]);
        } else {
            System.out.printf(" (0-9, a-%c).\n", values[numberOfSymbols - 1]);
        }
    }

    String generateSecretCode(int length, int numberOfSymbols) {
        if (length > 36) {
            System.out.println("Error: can't generate a secret number with a length of more than 36 " +
                    "because there aren't enough unique symbols.");
        }
        char[] values = initializeArrayOfSymbols(numberOfSymbols);
        displayRangeOfSymbols(values, length, numberOfSymbols);
        shuffleArrayOfSymbols(values);
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(values[i]);
        }
        return stringBuilder.toString();
    }
}
