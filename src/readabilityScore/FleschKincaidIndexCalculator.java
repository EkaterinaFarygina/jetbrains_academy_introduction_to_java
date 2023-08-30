package readabilityScore;

/*
Information regarding Flesch–Kincaid readability tests can be found in the corresponding article:
https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests
 */
public class FleschKincaidIndexCalculator extends AbstractIndexCalculator implements IndexCalculator {

    @Override
    public void calculateIndex() {
        if (index == null) {
            index = 0.39 * text.getWords() / text.getSentences() + 11.8 * text.getSyllables() / text.getWords() - 15.59;
        }
    }

    @Override
    public void displayInformation() {
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).\n", index, age);
    }
}
