package machine;

import java.util.Scanner;

class CoffeeMachine {

    private int amountOfWater;
    private int amountOfMilk;
    private int amountOfCoffeeBeans;
    private int amountOfDisposableCups;
    private int money;
    private CoffeeMachineState currentState;

    CoffeeMachineState getCurrentState() {
        return this.currentState;
    }

    CoffeeMachine(int amountOfWater, int amountOfMilk, int amountOfCoffeeBeans,
                         int amountOfDisposableCups, int money, CoffeeMachineState currentState) {
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfCoffeeBeans = amountOfCoffeeBeans;
        this.amountOfDisposableCups = amountOfDisposableCups;
        this.money = money;
        this.currentState = currentState;
    }

    private void displayContent() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", this.amountOfWater);
        System.out.printf("%d ml of milk\n", this.amountOfMilk);
        System.out.printf("%d g of coffee beans\n", this.amountOfCoffeeBeans);
        System.out.printf("%d disposable cups\n", this.amountOfDisposableCups);
        System.out.printf("$%d of money\n", this.money);
    }

    private void prepareCoffee(int chosenOption) {
        Coffee coffee = null;
        switch (chosenOption) {
            case 1 -> coffee = Coffee.ESPRESSO;
            case 2 -> coffee = Coffee.LATTE;
            case 3 -> coffee = Coffee.CAPPUCCINO;
            default -> System.out.println("Option not found");
        }
        if (coffee != null) {
            if (!isEnoughIngredients(coffee)) return;
            this.amountOfWater -= coffee.getAmountOfWater();
            this.amountOfMilk -= coffee.getAmountOfMilk();
            this.amountOfCoffeeBeans -= coffee.getAmountOfCoffeeBeans();
            this.amountOfDisposableCups -= coffee.getAmountOfDisposableCups();
            this.money += coffee.getPrice();
        }
    }

    private void fillSupplies() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        this.amountOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.amountOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.amountOfCoffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        this.amountOfDisposableCups += scanner.nextInt();
        System.out.println();
    }

    private void takeMoney() {
        System.out.printf("I gave you $%d\n", this.money);
        this.money = 0;
        System.out.println();
    }
    private boolean isEnoughIngredients(Coffee coffee) {
        if (this.amountOfWater < coffee.getAmountOfWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (this.amountOfMilk < coffee.getAmountOfMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (this.amountOfCoffeeBeans < coffee.getAmountOfCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (this.amountOfDisposableCups < coffee.getAmountOfDisposableCups()) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    void processUserInput(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3")) {
            int chosenOption = Integer.parseInt(input);
            prepareCoffee(chosenOption);
            System.out.println();
            this.currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
        } else {
            CoffeeMachineAction coffeeMachineAction = CoffeeMachineAction.valueOf(input.toUpperCase());
            switch (coffeeMachineAction) {
                case EXIT -> this.currentState = CoffeeMachineState.OFF;
                case BUY -> this.currentState = CoffeeMachineState.CHOOSING_A_TYPE_OF_COFFEE;
                case BACK -> this.currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
                case FILL -> fillSupplies();
                case TAKE -> takeMoney();
                case REMAINING -> displayContent();
                default -> System.out.println("Option not found. Please try again");
            }
        }
    }
}
