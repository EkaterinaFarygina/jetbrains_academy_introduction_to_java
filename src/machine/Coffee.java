package machine;

public enum Coffee {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    private int amountOfWater;
    private int amountOfMilk;
    private int amountOfCoffeeBeans;
    private int amountOfDisposableCups;
    private int price;

    Coffee(int amountOfWater, int amountOfMilk, int amountOfCoffeeBeans, int amountOfDisposableCups, int price) {
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfCoffeeBeans = amountOfCoffeeBeans;
        this.amountOfDisposableCups = amountOfDisposableCups;
        this.price = price;
    }

    public int getAmountOfWater() {
        return this.amountOfWater;
    }

    public int getAmountOfMilk() {
        return this.amountOfMilk;
    }

    public int getAmountOfCoffeeBeans() {
        return this.amountOfCoffeeBeans;
    }

    public int getAmountOfDisposableCups() {
        return this.amountOfDisposableCups;
    }

    public int getPrice() {
        return this.price;
    }
}
