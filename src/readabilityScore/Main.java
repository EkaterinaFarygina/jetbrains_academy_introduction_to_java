package readabilityScore;

public class Main {

    private static void initializeCalculator(IndexCalculator calculator, Text text) {
        calculator.setText(text);
        calculator.calculateIndex();
        calculator.determineAge();
        calculator.displayInformation();
    }
    private static void processCommand(String command, Text text) {
        if ("all".equals(command)) {
            System.out.println();
            double ageSumm = 0;
            for (Index index : Index.values()) {
                final var calculator = index.getCalculator();
                initializeCalculator(calculator, text);
                ageSumm += calculator.determineAge();
            }
            double averageAge = ageSumm / Index.values().length;
            System.out.printf("\nThis text should be understood in average by %.2f-year-olds.\n", averageAge);
        } else {
            final var index = Index.valueOf(command);
            final var calculator = index.getCalculator();
            System.out.println();
            initializeCalculator(calculator, text);
        }
    }

    private static void processInput(String fileName) {
        var textFileReader = new TextFileReader(fileName);
        var text = new Text(textFileReader.getFileContent());
        text.displayTextCharacteristics();
        var commandScanner = new CommandScanner();
        String command = commandScanner.askForCommand();
        processCommand(command, text);
    }

    public static void main(String[] args) {
        processInput(args[0]);
    }
}
