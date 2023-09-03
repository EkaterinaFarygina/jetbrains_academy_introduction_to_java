package readabilityScore;

public enum IndexType {
    ARI("Automated Readability Index"),
    FK("Flesch–Kincaid readability tests"),
    SMOG("Simple Measure of Gobbledygook"),
    CL("Coleman–Liau index");

    public final String name;

    IndexType(String name) {
        this.name = name;
    }

    public static IndexType from(String type) {
        try {
            return IndexType.valueOf(type.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    public IndexCalculator getCalculator() {
        return switch (this) {
            case ARI -> new AutomatedReadabilityIndexCalculator();
            case FK -> new FleschKincaidIndexCalculator();
            case SMOG -> new SMOGIndexCalculator();
            case CL -> new ColemanLiauIndexCalculator();
        };
    }
}
