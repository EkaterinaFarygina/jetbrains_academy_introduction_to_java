package readabilityScore;

public enum Index {
    // Corresponds to Automated readability index
    ARI {
        @Override
        IndexCalculator getCalculator() {
            return new AutomatedReadabilityIndexCalculator();
        }
    },
    // Corresponds to Flesch–Kincaid readability tests
    FK {
        @Override
        IndexCalculator getCalculator() {
            return new FleschKincaidIndexCalculator();
        }
    },
    // Corresponds to Simple Measure of Gobbledygook index
    SMOG {
        @Override
        IndexCalculator getCalculator() {
            return new SMOGIndexCalculator();
        }
    },
    // Corresponds to Coleman–Liau index
    CL {
        @Override
        IndexCalculator getCalculator() {
            return new ColemanLiauIndexCalculator();
        }
    };

    abstract IndexCalculator getCalculator();
}
