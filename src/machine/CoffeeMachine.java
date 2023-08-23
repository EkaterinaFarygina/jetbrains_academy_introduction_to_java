package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int amountOfWater;
    private int amountOfMilk;
    private int amountOfCoffeeBeans;
    private int amountOfDisposableCups;
    private int money;

    public CoffeeMachine(int amountOfWater, int amountOfMilk, int amountOfCoffeeBeans,
                         int amountOfDisposableCups, int money) {
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfCoffeeBeans = amountOfCoffeeBeans;
        this.amountOfDisposableCups = amountOfDisposableCups;
        this.money = money;
    }

    public void displayContent() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", this.amountOfWater);
        System.out.printf("%d ml of milk\n", this.amountOfMilk);
        System.out.printf("%d g of coffee beans\n", this.amountOfCoffeeBeans);
        System.out.printf("%d disposable cups\n", this.amountOfDisposableCups);
        System.out.printf("$%d of money\n", this.money);
    }

    public void prepareCoffee(int chosenOption) {
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

    public void fillSupplies() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        this.amountOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.amountOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.amountOfCoffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        this.amountOfDisposableCups += scanner.nextInt();
    }

    public void takeMoney() {
        System.out.printf("I gave you $%d\n", this.money);
        this.money = 0;
    }
    public boolean isEnoughIngredients(Coffee coffee) {
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

    public void coffeeMachine(String input) {
        State state = State.valueOf(input.toUpperCase());
        switch (state) {
            case BUY -> {
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, " +
                        "3 - cappuccino, back - to main menu:");
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                if (option.equals("back")) {
                    break;
                }
                int chosenOption = Integer.parseInt(option);
                prepareCoffee(chosenOption);
                System.out.println();
            }
            case FILL -> {
                fillSupplies();
                System.out.println();
            }
            case TAKE -> {
                takeMoney();
                System.out.println();
            }
            case REMAINING -> displayContent();
            default -> System.out.println("Option not found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            coffeeMachine.coffeeMachine(input);
        }
    }
}
