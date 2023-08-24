package machine;

import java.util.Scanner;

class CoffeeMachineCommandsScanner {

    private static void askForAction(CoffeeMachine coffeeMachine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String input = scanner.nextLine();
        coffeeMachine.processUserInput(input);
    }

    private static void askForTypeOfCoffee(CoffeeMachine coffeeMachine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, " +
                "3 - cappuccino, back - to main menu:");
        String input = scanner.nextLine();
        coffeeMachine.processUserInput(input);
    }

    public static void main(String[] args) {
        CoffeeMachineState coffeeMachineState = CoffeeMachineState.CHOOSING_AN_ACTION;
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120,
                9, 550, coffeeMachineState);
        while (coffeeMachine.getCurrentState() != CoffeeMachineState.OFF) {
            if (coffeeMachine.getCurrentState() == CoffeeMachineState.CHOOSING_AN_ACTION) {
                askForAction(coffeeMachine);
            }
            if (coffeeMachine.getCurrentState() == CoffeeMachineState.CHOOSING_A_TYPE_OF_COFFEE) {
                askForTypeOfCoffee(coffeeMachine);
            }
        }
    }
}
