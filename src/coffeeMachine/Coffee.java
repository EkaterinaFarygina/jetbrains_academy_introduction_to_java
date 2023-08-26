package coffeeMachine;

enum Coffee {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    private final int amountOfWater;
    private final int amountOfMilk;
    private final int amountOfCoffeeBeans;
    private final int amountOfDisposableCups;
    // For our purposes it is sufficient that the money has int type
    private final int priceInDollars;

    Coffee(int amountOfWater, int amountOfMilk, int amountOfCoffeeBeans, int amountOfDisposableCups, int priceInDollars) {
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfCoffeeBeans = amountOfCoffeeBeans;
        this.amountOfDisposableCups = amountOfDisposableCups;
        this.priceInDollars = priceInDollars;
    }

    int getAmountOfWater() {
        return amountOfWater;
    }

    int getAmountOfMilk() {
        return amountOfMilk;
    }

    int getAmountOfCoffeeBeans() {
        return amountOfCoffeeBeans;
    }

    int getAmountOfDisposableCups() {
        return amountOfDisposableCups;
    }

    int getPriceInDollars() {
        return priceInDollars;
    }

    static Coffee fromOption(int option) {
        return switch (option) {
            case 1 -> Coffee.ESPRESSO;
            case 2 -> Coffee.LATTE;
            case 3 -> Coffee.CAPPUCCINO;
            default -> null;
        };
    }
}
