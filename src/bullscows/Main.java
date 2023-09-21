package bullscows;

public class Main {
    private static String generateSecretCode() {
        final var generator = new SecretCodeGenerator();
        final var inputScanner = new InputScanner();
        final var length = inputScanner.inputLengthOfCode();
        if (length == -1) {
            return "";
        }
        final var numberOfSymbols = inputScanner.inputNumberOfSymbols();
        if (numberOfSymbols == -1) {
            return "";
        }
        if (numberOfSymbols < length) {
            System.out.printf("Error: it's not possible to generate a code with " +
                    "a length of %d with %d unique symbols.", length, numberOfSymbols);
            return "";
        }
        return generator.generateSecretCode(length, numberOfSymbols);
    }

    private static void playGame() {
        final var secretCode = generateSecretCode();
        if ("".equals(secretCode)) return;
        System.out.println("Okay, let's start a game!");
        final var calculator = new BullsAndCowsCalculator(secretCode);
        var turnCounter = 1;
        var isCorrect = false;
        while (!isCorrect) {
            System.out.printf("Turn %d:\n", turnCounter);
            final var scanner = new InputScanner();
            final var inputCode = scanner.takeInputCode();
            final var bullsAndCows = calculator.calculateBullsAndCows(inputCode);
            if (bullsAndCows.getBulls() == secretCode.length()) {
                isCorrect = true;
            }
            bullsAndCows.displayResult();
            turnCounter++;
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static void main(String[] args) {
        playGame();
    }
}
