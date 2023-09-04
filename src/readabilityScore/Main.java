package readabilityScore;

public class Main {

    private static void displayInformation(IndexType indexType, double index, int age) {
        System.out.printf("%s: %.2f (about %d-year-olds).\n", indexType.name, index, age);
    }

    private static void processCommand(String command, TextStatistics textStatistics) {
        if ("all".equalsIgnoreCase(command)) {
            invokeAllCalculators(textStatistics);
        } else {
            invokeOneCalculator(command, textStatistics);
        }
    }

    private static void invokeOneCalculator(String command, TextStatistics textStatistics) {
        final var indexType = IndexType.from(command);
        if (indexType == null) {
            System.out.println("Not valid command");
            return;
        }
        final var calculator = indexType.getCalculator();
        final var index = calculator.calculateIndex(textStatistics);
        final var age = IndexToAgeConverter.determineAge(index);
        System.out.println();
        displayInformation(indexType, index, age);
    }

    private static void invokeAllCalculators(TextStatistics textStatistics) {
        System.out.println();
        var ageSum = 0.0;
        for (IndexType indexType : IndexType.values()) {
            final var calculator = indexType.getCalculator();
            final var index = calculator.calculateIndex(textStatistics);
            ageSum += IndexToAgeConverter.determineAge(index);
        }
        final var averageAge = ageSum / IndexType.values().length;
        System.out.printf("\nThis text should be understood in average by %.2f-year-olds.\n", averageAge);
    }

    private static void processInput(String fileName) {
        final var calculator = new TextStatisticsCalculator();
        final var textStatistics = calculator.calculateStatistics((TextFileReader.getFileContent(fileName)));
        textStatistics.displayTextStatistics();
        final var commandScanner = new CommandScanner();
        final var command = commandScanner.askForCommand();
        processCommand(command, textStatistics);
    }

    public static void main(String[] args) {
        processInput(args[0]);
    }
}
