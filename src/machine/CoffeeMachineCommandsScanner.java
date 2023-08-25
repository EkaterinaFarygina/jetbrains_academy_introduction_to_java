package machine;

import java.util.Scanner;

class CoffeeMachineCommandsScanner {

    private final Scanner scanner;

    CoffeeMachineCommandsScanner() {
        this.scanner = new Scanner(System.in);
    }

    private void askForAction(CoffeeMachine coffeeMachine) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String input = scanner.nextLine();
        coffeeMachine.processCommand(input);
    }

    private void askForTypeOfCoffee(CoffeeMachine coffeeMachine) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, " +
                "3 - cappuccino, back - to main menu:");
        String input = scanner.nextLine();
        coffeeMachine.processCommand(input);
    }

    private void askForQuantityOfSupplies(CoffeeMachine coffeeMachine) {
        System.out.println("Write how many ml of water you want to add:");
        int amountOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int amountOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int amountOfCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int amountOfDisposableCups = scanner.nextInt();
        System.out.println();
        CoffeeMachineSupplies newCoffeeMachineSupplies = new CoffeeMachineSupplies(amountOfWater, amountOfMilk, amountOfCoffeeBeans, amountOfDisposableCups);
        coffeeMachine.fillSupplies(newCoffeeMachineSupplies);
    }

    public static void main(String[] args) {
        final var coffeeMachineSupplies = new CoffeeMachineSupplies(400, 540, 120, 9);
        final var coffeeMachine = new CoffeeMachine(coffeeMachineSupplies, 550);
        final var coffeeMachineCommandsScanner = new CoffeeMachineCommandsScanner();
        while (coffeeMachine.getCurrentState() != CoffeeMachineState.OFF) {
            switch (coffeeMachine.getCurrentState()) {
                case CHOOSING_AN_ACTION -> coffeeMachineCommandsScanner.askForAction(coffeeMachine);
                case CHOOSING_A_TYPE_OF_COFFEE -> coffeeMachineCommandsScanner.askForTypeOfCoffee(coffeeMachine);
                case FILLING_SUPPLIES -> coffeeMachineCommandsScanner.askForQuantityOfSupplies(coffeeMachine);
            }
        }
    }
}
