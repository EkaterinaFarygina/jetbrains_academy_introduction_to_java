package bullscows;

public class BullsAndCowsCalculator {
    private final String secretCode;

    BullsAndCowsCalculator(String secretCode) {
        this.secretCode = secretCode;
    }

    void displaySecretCode() {
        System.out.println("The secret code is " + secretCode + ".");
    }
    BullsAndCows calculateBullsAndCows(String inputCode) {
        var bulls = 0;
        var cows = 0;
        for (int i = 0; i < inputCode.length(); i++) {
            var currentNumber = inputCode.substring(i, i+1);
            if (secretCode.contains(currentNumber)) {
                if (secretCode.indexOf(currentNumber) == i) {
                    bulls++;
                } else {
                    cows++;
                }
            }
        }
        return new BullsAndCows(bulls, cows);
    }
}
