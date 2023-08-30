package readabilityScore;

/*
Information regarding Automated readability index can be found in the corresponding article:
https://en.wikipedia.org/wiki/Automated_readability_index
 */

class AutomatedReadabilityIndexCalculator extends AbstractIndexCalculator implements IndexCalculator {

    @Override
    public void calculateIndex() {
        if (index == null) {
            index = 4.71 * text.getCharacters() / text.getWords() + 0.5 * text.getWords() / text.getSentences() - 21.43;
        }
    }

    @Override
    public void displayInformation() {
        System.out.printf("Automated Readability Index: %.2f (about %d-year-olds).\n", index, age);
    }
}
