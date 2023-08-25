package machine;

public class Supplies {
    private int amountOfWater;
    private int amountOfMilk;
    private int amountOfCoffeeBeans;
    private int amountOfDisposableCups;

    Supplies(int amountOfWater, int amountOfMilk, int amountOfCoffeeBeans, int amountOfDisposableCups) {
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfCoffeeBeans = amountOfCoffeeBeans;
        this.amountOfDisposableCups = amountOfDisposableCups;
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

    void reduceSupplies(Coffee coffee) {
        amountOfWater -= coffee.getAmountOfWater();
        amountOfMilk -= coffee.getAmountOfMilk();
        amountOfCoffeeBeans -= coffee.getAmountOfCoffeeBeans();
        amountOfDisposableCups -= coffee.getAmountOfDisposableCups();
    }

    void addSupplies(Supplies newSupplies) {
        amountOfWater += newSupplies.getAmountOfWater();
        amountOfMilk += newSupplies.getAmountOfMilk();
        amountOfCoffeeBeans += newSupplies.getAmountOfCoffeeBeans();
        amountOfDisposableCups += newSupplies.getAmountOfDisposableCups();
    }
}
