package readabilityScore;

/**
 * Information regarding Flesch–Kincaid readability tests can be found in the corresponding article:
 * <a href="https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests">...</a>
 */
public class FleschKincaidIndexCalculator implements IndexCalculator {

    @Override
    public double calculateIndex(TextStatistics textStatistics) {
        return 0.39 * textStatistics.getWords() / textStatistics.getSentences() +
                11.8 * textStatistics.getSyllables() / textStatistics.getWords() - 15.59;
    }
}
