package machine;

enum Coffee {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    private final int amountOfWater;
    private final int amountOfMilk;
    private final int amountOfCoffeeBeans;
    private final int amountOfDisposableCups;
    private final int price;

    Coffee(int amountOfWater, int amountOfMilk, int amountOfCoffeeBeans, int amountOfDisposableCups, int price) {
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfCoffeeBeans = amountOfCoffeeBeans;
        this.amountOfDisposableCups = amountOfDisposableCups;
        this.price = price;
    }

    int getAmountOfWater() {
        return this.amountOfWater;
    }

    int getAmountOfMilk() {
        return this.amountOfMilk;
    }

    int getAmountOfCoffeeBeans() {
        return this.amountOfCoffeeBeans;
    }

    int getAmountOfDisposableCups() {
        return this.amountOfDisposableCups;
    }

    int getPrice() {
        return this.price;
    }
}
