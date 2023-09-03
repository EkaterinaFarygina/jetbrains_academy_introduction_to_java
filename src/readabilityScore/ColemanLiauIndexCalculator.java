package readabilityScore;

/**
 * Information regarding Coleman–Liau index can be found in the corresponding article:
 * <a href="https://en.wikipedia.org/wiki/Coleman%E2%80%93Liau_index">...</a>
 */
public class ColemanLiauIndexCalculator implements IndexCalculator {

    @Override
    public double calculateIndex(TextStatistics textStatistics) {
        double L = (double) textStatistics.getCharacters() / textStatistics.getWords() * 100;
        double S = (double) textStatistics.getSentences() / textStatistics.getWords() * 100;
        return 0.0588 * L - 0.296 * S - 15.8;
    }
}
