package bullscows;

public class BullsAndCows {
    private final int bulls;
    private final int cows;

    BullsAndCows(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    void displayResult() {
        final String cowFormat = cows == 1 ? "cow" : "cows";
        final String bullFormat = bulls == 1 ? "bull" : "bulls";
        if (bulls == 0 && cows == 0) {
            System.out.print("Grade: None\n");
        } else if (bulls == 0) {
            System.out.printf("Grade: %d %s\n", cows, cowFormat);
        } else if (cows == 0) {
            System.out.printf("Grade: %d %s\n", bulls, bullFormat);
        } else {
            System.out.printf("Grade: %d %s and %d %s\n", bulls, bullFormat, cows, cowFormat);
        }
    }

    int getBulls() {
        return bulls;
    }
}
