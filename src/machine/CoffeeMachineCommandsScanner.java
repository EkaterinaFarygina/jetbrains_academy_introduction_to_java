package machine;

import java.util.Scanner;

class CoffeeMachineCommandsScanner {

    private static void askForAction(CoffeeMachine coffeeMachine, Scanner scanner) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String input = scanner.nextLine();
        coffeeMachine.processCommand(input);
    }

    private static void askForTypeOfCoffee(CoffeeMachine coffeeMachine, Scanner scanner) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, " +
                "3 - cappuccino, back - to main menu:");
        String input = scanner.nextLine();
        coffeeMachine.processCommand(input);
    }

    private static void askForQuantityOfSupplies(CoffeeMachine coffeeMachine, Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int amountOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int amountOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int amountOfCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int amountOfDisposableCups = scanner.nextInt();
        System.out.println();
        Supplies newSupplies = new Supplies(amountOfWater, amountOfMilk, amountOfCoffeeBeans, amountOfDisposableCups);
        coffeeMachine.fillSupplies(newSupplies);
    }

    public static void main(String[] args) {
        Supplies supplies = new Supplies(400, 540, 120, 9);
        CoffeeMachine coffeeMachine = new CoffeeMachine(supplies, 550);
        Scanner scanner = new Scanner(System.in);
        while (coffeeMachine.getCurrentState() != CoffeeMachineState.OFF) {
            switch (coffeeMachine.getCurrentState()) {
                case CHOOSING_AN_ACTION -> askForAction(coffeeMachine, scanner);
                case CHOOSING_A_TYPE_OF_COFFEE -> askForTypeOfCoffee(coffeeMachine, scanner);
                case FILLING_SUPPLIES -> askForQuantityOfSupplies(coffeeMachine, scanner);
            }
        }
    }
}
