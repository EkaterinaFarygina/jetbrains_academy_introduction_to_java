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

    void displaySupplies() {
        System.out.printf("%d ml of water\n", amountOfWater);
        System.out.printf("%d ml of milk\n", amountOfMilk);
        System.out.printf("%d g of coffee beans\n", amountOfCoffeeBeans);
        System.out.printf("%d disposable cups\n", amountOfDisposableCups);
    }

    boolean canMakeCoffee(Coffee coffee) {
        if (amountOfWater < coffee.getAmountOfWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (amountOfMilk < coffee.getAmountOfMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (amountOfCoffeeBeans < coffee.getAmountOfCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (amountOfDisposableCups < coffee.getAmountOfDisposableCups()) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        } else {
            return true;
        }
    }
}
