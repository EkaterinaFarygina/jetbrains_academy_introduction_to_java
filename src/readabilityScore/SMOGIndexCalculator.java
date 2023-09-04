package readabilityScore;

/**
 * Information regarding Simple Measure of Gobbledygook index can be found in the corresponding article:
 * <a href="https://en.wikipedia.org/wiki/SMOG">...</a>
 */
public class SMOGIndexCalculator implements IndexCalculator {

    @Override
    public double calculateIndex(TextStatistics textStatistics) {
        return 1.043 * Math.sqrt((double) textStatistics.getPolysyllables() * 30 / textStatistics.getSentences()) + 3.1291;
    }
}
