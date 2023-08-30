package readabilityScore;

public abstract class AbstractIndexCalculator implements IndexCalculator {
    protected Text text;
    protected Double index;
    protected Integer age;

    @Override
    public void setText(Text text) {
        this.text = text;
        index = null;
        age = null;
    }

    @Override
    public Integer determineAge() {
        if (index == null) throw new IllegalStateException();
        switch ((int) Math.ceil(index)) {
            case 1 -> age = 6;
            case 2 -> age = 7;
            case 3 -> age = 8;
            case 4 -> age = 9;
            case 5 -> age = 10;
            case 6 -> age = 11;
            case 7 -> age = 12;
            case 8 -> age = 13;
            case 9 -> age = 14;
            case 10 -> age = 15;
            case 11 -> age = 16;
            case 12 -> age = 17;
            case 13 -> age = 18;
            default -> age = 22;
        }
        return age;
    }
}
