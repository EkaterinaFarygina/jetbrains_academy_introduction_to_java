package machine;

class CoffeeMachine {

    private final Supplies supplies;

    // For our purposes it is sufficient that the price has int type
    private int money;

    private CoffeeMachineState currentState;

    CoffeeMachineState getCurrentState() {
        return currentState;
    }

    CoffeeMachine(Supplies supplies, int money) {
        this.supplies = supplies;
        this.money = money;
        this.currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
    }

    private void displayContent() {
        System.out.println("\nThe coffee machine has:");
        supplies.displaySupplies();
        System.out.printf("$%d of money\n", money);
    }

    private void prepareCoffee(int chosenOption) {
        final var coffee = Coffee.fromOption(chosenOption);
        if (coffee == null || !isEnoughIngredients(coffee)) return;
        supplies.reduceSupplies(coffee);
        money += coffee.getPriceInDollars();
    }

    private void takeMoney() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
        System.out.println();
    }

    private boolean isEnoughIngredients(Coffee coffee) {
        if (!supplies.canMakeCoffee(coffee)) {
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
                if ("back".equals(input)) {
                    currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
                } else {
                    int chosenOption = Integer.parseInt(input);
                    prepareCoffee(chosenOption);
                    System.out.println();
                    this.currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
                }
            }
            case CHOOSING_AN_ACTION -> {
                CoffeeMachineAction coffeeMachineAction = CoffeeMachineAction.valueOf(input.toUpperCase());
                switch (coffeeMachineAction) {
                    case EXIT -> currentState = CoffeeMachineState.OFF;
                    case BUY -> currentState = CoffeeMachineState.CHOOSING_A_TYPE_OF_COFFEE;
                    case FILL -> currentState = CoffeeMachineState.FILLING_SUPPLIES;
                    case TAKE -> takeMoney();
                    case REMAINING -> displayContent();
                    default -> System.out.println("Option not found. Please try again");
                }
            }
        }
    }
}
