package readabilityScore;

/**
 * Information regarding Automated readability index can be found in the corresponding article:
 * <a href="https://en.wikipedia.org/wiki/Automated_readability_index">...</a>
 */
class AutomatedReadabilityIndexCalculator implements IndexCalculator {

    @Override
    public double calculateIndex(TextStatistics textStatistics) {
        return 4.71 * textStatistics.getCharacters() / textStatistics.getWords() +
                0.5 * textStatistics.getWords() / textStatistics.getSentences() - 21.43;
    }
}
