package bullscows;

import java.util.Arrays;
import java.util.Random;

public class SecretCodeGenerator {

    private char[] initializeArrayOfSymbols(int numberOfSymbols) {
        char[] values = new char[numberOfSymbols];
        if (numberOfSymbols < 10) {
            for (int i = 0; i < numberOfSymbols; i++) {
                values[i] = (char) (48 + i);
            }
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
        for (int i = 0; i < 300; i++) {
            int randomIndex1 = random.nextInt(values.length);
            int randomIndex2 = random.nextInt(values.length);
            char tmp = values[randomIndex1];
            values[randomIndex1] = values[randomIndex2];
            values[randomIndex2] = tmp;
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
            return "";
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
