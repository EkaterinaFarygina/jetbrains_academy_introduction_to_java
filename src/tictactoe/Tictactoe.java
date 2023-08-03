package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Tictactoe {

    public static void printGrid(String[][] battleField) {
        System.out.println("---------");
        for (String[] row : battleField) {
            System.out.print("| ");
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean isDiagonalWins(String[][] battleField, String whom) {
        boolean isDiagonal1Wins = true;
        boolean isDiagonal2Wins = true;
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                if (i == j) {
                    if (!battleField[i][j].equals(whom)) {
                        isDiagonal1Wins = false;
                    }
                }
                if (i + j == 2) {
                    if (!battleField[i][j].equals(whom)) {
                        isDiagonal2Wins = false;
                    }
                }
            }
        }
        return isDiagonal1Wins || isDiagonal2Wins;
    }

    public static boolean isRowWins(String[][] battleField, String whom) {
        boolean rowWins = false;
        String[] allInRow;
        if (whom.equals("X")) {
            allInRow = new String[]{"X", "X", "X"};
        } else {
            allInRow = new String[]{"O", "O", "O"};
        }
        for (String[] row : battleField) {
            if (Arrays.equals(row, allInRow)) {
                rowWins = true;
                break;
            }
        }
        return rowWins;
    }

    public static boolean isColumnWins(String[][] battleField, String whom) {
        String[][] reversed = new String[battleField.length][battleField[0].length];
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                reversed[i][j] = battleField[j][i];
            }
        }
        return isRowWins(reversed, whom);
    }

    public static boolean isImpossible(String[][] battleField) {
        int valueXs = 0;
        int valueOs = 0;
        for (String[] rows : battleField) {
            for (String value : rows) {
                if (value.equals("X")) {
                    valueXs++;
                }
                if (value.equals("O")) {
                    valueOs++;
                }
            }
        }
        boolean isOneMoreThanAnother = ((valueXs - valueOs) >= 2) || ((valueOs - valueXs) >= 2);
        return isOneMoreThanAnother || ((isRowWins(battleField, "X") || isColumnWins(battleField, "X"))
                && (isRowWins(battleField, "O") || isColumnWins(battleField, "O")));
    }

    public static boolean isEmptyCells(String[][] battleField) {
        boolean isEmpty = false;
        for (String[] rows : battleField) {
            for (String value : rows) {
                if (value.equals("_") || value.equals(" ")) {
                    isEmpty = true;
                    break;
                }
            }
        }
        return isEmpty;
    }

    public static String analyzeGameState(String[][] battleField) {
        boolean isXWins = isRowWins(battleField, "X") || isColumnWins(battleField, "X")
                || isDiagonalWins(battleField, "X");
        boolean isOWins = isRowWins(battleField, "O") || isColumnWins(battleField, "O")
                || isDiagonalWins(battleField, "O");
        if (!isXWins && !isOWins && !isEmptyCells(battleField)) {
            return "Draw";
        } else if (isImpossible(battleField)) {
            return "Impossible";
        } else if (isXWins) {
            return "X wins";
        } else if (isOWins) {
            return "O wins";
        } else {
            return "Game not finished";
        }
    }

    public static void includeValue(String[][] battleField, String whom) {
        boolean isInputCorrect = false;
        int row = -1;
        int column = -1;
        while(!isInputCorrect) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                row = scanner.nextInt() - 1;
                if (scanner.hasNextInt()) {
                    column = scanner.nextInt() - 1;
                } else {
                    System.out.println("You should enter numbers!");
                    continue;
                }
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (row < 0 || row > 2 || column < 0 || column > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (battleField[row][column].contains("X") || battleField[row][column].contains("O")) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                isInputCorrect = true;
            }
        }
        battleField[row][column] = whom;
    }

    public static void play() {
        String[][] battleField = new String[3][3];
        for (String[] rows : battleField) {
            Arrays.fill(rows, " ");
        }
        printGrid(battleField);
        String result;
        int i = 1;
        while(true) {
            if (i % 2 != 0) {
                includeValue(battleField, "X");
            } else {
                includeValue(battleField, "O");
            }
            printGrid(battleField);
            result = analyzeGameState(battleField);
            if (result.equals("X wins") || result.equals("O wins") || result.equals("Draw")) {
                System.out.println(result);
                break;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        play();
    }


}
