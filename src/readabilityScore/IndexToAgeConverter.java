package readabilityScore;

public class IndexToAgeConverter {
    public static int determineAge(double index) {
        int roundedIndex = (int) Math.ceil(index);
        if (roundedIndex > 0 && roundedIndex < 14) {
            return roundedIndex + 5;
        } else {
            return 22;
        }
    }
}
