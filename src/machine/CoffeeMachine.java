package machine;

class CoffeeMachine {

    private Supplies supplies;

    // It's ok, that the type of the price is int for this task
    private int money;

    private CoffeeMachineState currentState;

    CoffeeMachineState getCurrentState() {
        return currentState;
    }

    CoffeeMachine() {
        supplies = new Supplies(400, 540, 120, 9);
        this.money = 550;
        this.currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
    }

    private void displayContent() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", supplies.getAmountOfWater());
        System.out.printf("%d ml of milk\n", supplies.getAmountOfMilk());
        System.out.printf("%d g of coffee beans\n", supplies.getAmountOfCoffeeBeans());
        System.out.printf("%d disposable cups\n", supplies.getAmountOfDisposableCups());
        System.out.printf("$%d of money\n", money);
    }

    private void prepareCoffee(int chosenOption) {
        final var coffee = Coffee.fromOption(chosenOption);
        if (coffee != null) {
            if (!isEnoughIngredients(coffee)) return;
            supplies.reduceSupplies(coffee);
            money += coffee.getPriceInDollars();
        }
    }

    private void takeMoney() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
        System.out.println();
    }

    private boolean isEnoughIngredients(Coffee coffee) {
        if (supplies.getAmountOfWater() < coffee.getAmountOfWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (supplies.getAmountOfMilk() < coffee.getAmountOfMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (supplies.getAmountOfCoffeeBeans() < coffee.getAmountOfCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (supplies.getAmountOfDisposableCups() < coffee.getAmountOfDisposableCups()) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    void fillSupplies(Supplies newSupplies) {
        supplies.addSupplies(newSupplies);
        currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
    }

    void processCommand(String input) {
        switch (currentState) {
            case CHOOSING_A_TYPE_OF_COFFEE -> {
                int chosenOption = Integer.parseInt(input);
                prepareCoffee(chosenOption);
                System.out.println();
                this.currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
            }
            default -> {
                CoffeeMachineAction coffeeMachineAction = CoffeeMachineAction.valueOf(input.toUpperCase());
                switch (coffeeMachineAction) {
                    case EXIT -> currentState = CoffeeMachineState.OFF;
                    case BUY -> currentState = CoffeeMachineState.CHOOSING_A_TYPE_OF_COFFEE;
                    case BACK -> currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
                    case FILL -> currentState = CoffeeMachineState.FILLING_SUPPLIES;
                    case TAKE -> takeMoney();
                    case REMAINING -> displayContent();
                    default -> System.out.println("Option not found. Please try again");
                }
            }
        }
    }
}
