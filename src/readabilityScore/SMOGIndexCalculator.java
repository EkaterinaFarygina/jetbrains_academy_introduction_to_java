package readabilityScore;

/*
Information regarding Simple Measure of Gobbledygook index can be found in the corresponding article:
https://en.wikipedia.org/wiki/SMOG
 */

public class SMOGIndexCalculator extends AbstractIndexCalculator implements IndexCalculator {

    @Override
    public void calculateIndex() {
        if (index == null) {
            index = 1.043 * Math.sqrt((double) text.getPolysyllables() * 30 / text.getSentences()) + 3.1291;
        }
    }

    @Override
    public void displayInformation() {
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d-year-olds).\n", index, age);
    }
}
