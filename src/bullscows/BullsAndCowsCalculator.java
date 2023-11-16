package bullscows;

public class BullsAndCowsCalculator {
    private final String secretCode;

    BullsAndCowsCalculator(String secretCode) {
        this.secretCode = secretCode;
    }

    BullsAndCows calculateBullsAndCows(String inputCode) {
        var bulls = 0;
        var cows = 0;
        for (int i = 0; i < inputCode.length(); i++) {
            final var currentDigit = inputCode.substring(i, i + 1);
            final var positionInCode = secretCode.indexOf(currentDigit);
            if (positionInCode == i) {
                bulls++;
            } else if (positionInCode != -1) {
                cows++;
            }
        }
        return new BullsAndCows(bulls, cows);
    }
}
