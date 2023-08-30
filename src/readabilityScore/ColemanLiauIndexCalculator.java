package readabilityScore;

/*
Information regarding Coleman–Liau index can be found in the corresponding article:
https://en.wikipedia.org/wiki/Coleman%E2%80%93Liau_index
 */

public class ColemanLiauIndexCalculator extends AbstractIndexCalculator implements IndexCalculator {

    @Override
    public void calculateIndex() {
        if (index == null) {
            double L = (double) text.getCharacters() / text.getWords() * 100;
            double S = (double) text.getSentences() / text.getWords() * 100;
            index = 0.0588 * L - 0.296 * S - 15.8;
        }
    }

    @Override
    public void displayInformation() {
        System.out.printf("Coleman–Liau index: %.2f (about %d-year-olds).\n", index, age);
    }
}
