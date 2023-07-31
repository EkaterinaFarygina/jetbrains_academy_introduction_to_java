package cinemaRoomManager;

import java.util.Scanner;

public class Cinema {

    public static String[][] createCinema() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeatsInRow = scanner.nextInt();
        String[][] cinema = new String[numberOfRows][numberOfSeatsInRow];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfSeatsInRow; j++) {
                cinema[i][j] = "S";
            }
        }
        return cinema;
    }

    public static void printCinemaScheme(String[][] cinema) {
        System.out.println();
        System.out.println("cinemaRoomManager.Cinema:");
        System.out.print("  ");
        for (int i = 0; i < cinema[0].length; i++) {
            if (i == cinema[0].length - 1) {
                System.out.println(i + 1);
                break;
            }
            System.out.print((i + 1) + " ");
        }
        for (int i = 0; i < cinema.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < cinema[i].length; j++) {
                if (j == cinema[i].length - 1) {
                    System.out.println(cinema[i][j]);
                } else {
                    System.out.print(cinema[i][j] + " ");
                }
            }
        }
    }

    public static int checkPrice(String[][] cinema, int rowNumber) {
        int totalNumberOfSeats = cinema.length * cinema[0].length;
        if (totalNumberOfSeats < 60) {
            return 10;
        } else {
            int firstHalfSize = cinema.length / 2;
            if (rowNumber <= firstHalfSize) {
                return 10;
            } else {
                return 8;
            }
        }
    }

    public static void buyTicket(String[][] cinema) {
        boolean isIndexOutOfBounds;
        boolean isOccupied = false;
        int rowNumber;
        int seatNumber;
        while (true) {
            // Asking for input
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a row number:");
            rowNumber = scanner.nextInt() - 1;
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt() - 1;
            // Checking if input is correct
            isIndexOutOfBounds = rowNumber < 0 || rowNumber >= cinema.length ||
                    seatNumber < 0 || seatNumber >= cinema[rowNumber].length;
            if (isIndexOutOfBounds) {
                System.out.println("\nWrong input!");
                continue;
            }
            isOccupied = cinema[rowNumber][seatNumber].equals("B");
            if (isOccupied) {
                System.out.println("\nThat ticket has already been purchased!");
                continue;
            }
            break;
        }
        int price = checkPrice(cinema, rowNumber + 1);
        System.out.println("\nTicket price: $" + price);
        cinema[rowNumber][seatNumber] = "B";
    }

    public static void printStatistics(String[][] cinema) {
        double numberOfPurchasedTickets = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                totalIncome += checkPrice(cinema, i + 1);
                if (cinema[i][j].equals("B")) {
                    numberOfPurchasedTickets++;
                    currentIncome += checkPrice(cinema, i + 1);
                }
            }
        }
        double percentageOfPurchasedTickets = (numberOfPurchasedTickets * 100) / (cinema.length * cinema[0].length);
        System.out.printf("\nNumber of purchased tickets: %.0f\n", numberOfPurchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", percentageOfPurchasedTickets);
        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n", totalIncome);
    }

    public static void showMenu() {
        System.out.println();
        String menu = """
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                """;
        System.out.print(menu);
    }
    public static int chooseFromMenu() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        String[][] cinema = createCinema();
        int chosenOption = -1;
        while(chosenOption != 0) {
            showMenu();
            chosenOption = chooseFromMenu();
            switch (chosenOption) {
                case 0 -> System.out.println();
                case 1 -> printCinemaScheme(cinema);
                case 2 -> buyTicket(cinema);
                case 3 -> printStatistics(cinema);
                default -> System.out.println("Option not found. Try one more time");
            }
        }
    }
}