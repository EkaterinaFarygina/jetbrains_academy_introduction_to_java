package machine;

class CoffeeMachine {

    private final CoffeeMachineSupplies coffeeMachineSupplies;

    // For our purposes it is sufficient that the price has int type
    private int dollars;

    private CoffeeMachineState currentState;

    CoffeeMachineState getCurrentState() {
        return currentState;
    }

    CoffeeMachine(CoffeeMachineSupplies coffeeMachineSupplies, int dollars) {
        this.coffeeMachineSupplies = coffeeMachineSupplies;
        this.dollars = dollars;
        this.currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
    }

    private void displayContent() {
        System.out.println("\nThe coffee machine has:");
        coffeeMachineSupplies.displaySupplies();
        System.out.printf("$%d of money\n", dollars);
    }

    private void prepareCoffee(int chosenOption) {
        final var coffee = Coffee.fromOption(chosenOption);
        try {
            coffeeMachineSupplies.reduceSupplies(coffee);
            dollars += coffee.getPriceInDollars();
            System.out.println();
        } catch (IllegalStateException exception) {}
    }

    private void takeMoney() {
        System.out.printf("I gave you $%d\n", dollars);
        dollars = 0;
        System.out.println();
    }

    void fillSupplies(CoffeeMachineSupplies newCoffeeMachineSupplies) {
        coffeeMachineSupplies.addSupplies(newCoffeeMachineSupplies);
        currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
    }

    void processCommand(String input) {
        switch (currentState) {
            case CHOOSING_A_TYPE_OF_COFFEE -> {
                if ("back".equals(input)) {
                    currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
                } else {
                    if (!input.matches("[1-3]")) {
                        System.out.println("There is no such option. Please try again");
                        return;
                    }
                    final int chosenOption = Integer.parseInt(input);
                    prepareCoffee(chosenOption);
                    this.currentState = CoffeeMachineState.CHOOSING_AN_ACTION;
                }
            }
            case CHOOSING_AN_ACTION -> {
                try {
                    final var coffeeMachineAction = CoffeeMachineAction.valueOf(input.toUpperCase());
                    switch (coffeeMachineAction) {
                        case EXIT -> currentState = CoffeeMachineState.OFF;
                        case BUY -> currentState = CoffeeMachineState.CHOOSING_A_TYPE_OF_COFFEE;
                        case FILL -> currentState = CoffeeMachineState.FILLING_SUPPLIES;
                        case TAKE -> takeMoney();
                        case REMAINING -> displayContent();
                        default -> System.out.println("Option not found. Please try again");
                    }
                } catch (IllegalArgumentException exception) {
                    System.out.println("Invalid command. Please try again");
                }
            }
        }
    }
}
