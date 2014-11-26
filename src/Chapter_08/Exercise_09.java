package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 9:
 *
 *      (Game: play a tic-tac-toe game)
 *      In a game of tic-tac-toe, two players take turns marking an available
 *      cell in a 3 * 3 grid with their respective tokens (either X or O).
 *      When one player has placed three tokens in a horizontal, vertical, or
 *      diagonal row on the grid, the game is over and that player has won.
 *      A draw (no winner) occurs when all the cells on the grid have been filled
 *      with tokens and neither player has achieved a win. Create a program for playing tic-tac-toe.
 *      The program prompts two players to enter an X token and O token alternately.
 *      Whenever a token is entered, the program re-displays the board on the console
 *      and determines the status of the game (win, draw, or continue).
 *
 * Created by Luiz Arantes Sa on 8/30/14.
 */
public class Exercise_09 {

    static public boolean isPlayer1Turn = true;
    static int mRow = 0;
    static int mColumn = 0;

    public static void main(String[] args) {
        boolean keepPlaying = true;
        boolean isClear;
        Scanner input = new Scanner(System.in);
        String[][] grid = createGrid(3, 3);

        while (keepPlaying) {

            displayGrid(grid);

            do {
                mRow = askForRow();
                mColumn = askForColumn();

                isClear = isPositionClear(grid);
                if (!isClear) {
                    System.out.println("row: " + mRow + " column: " + mRow + " is already been chosen. Try again.");
                }
            } while (!isClear);

            updateTurn(grid);

            if (hasWon(grid)) {
                displayGrid(grid);
                String player = (isPlayer1Turn) ? "X" : "O";
                System.out.println("Player " + player + " has won.");
                System.out.print("Do you want to play again? y/n: ");
                String option = input.next();
                keepPlaying = (option.equalsIgnoreCase("y"));
                grid = createGrid(3, 3);
            }
            isPlayer1Turn = !isPlayer1Turn;

        }

        System.out.println("Game ended..");
        input.close();

    }

    public static int askForColumn(){
        Scanner input = new Scanner(System.in);
        int column = 0;
        boolean isColumnValid = false;
        while (!isColumnValid) {

            if (isPlayer1Turn) {
                System.out.print("Enter a column (0, 1, or 2) for player X: ");
            } else {
                System.out.print("Enter a column (0, 1, or 2) for player O: ");
            }
            column = input.nextInt();
            isColumnValid = isValidRange(column);
        }
        return column;

    }
    public static int askForRow(){
        int row = 0;
        Scanner input = new Scanner(System.in);

        boolean isRowValid = false;
        while (!isRowValid) {

            if (isPlayer1Turn) {
                System.out.print("Enter a row (0, 1, or 2) for player X: ");
            } else {
                System.out.print("Enter a row (0, 1, or 2) for player O: ");
            }
            row = input.nextInt();
            isRowValid = isValidRange(row);

        }

        return row;
    }

    public static boolean isValidRange(int section) {
        return (0 <= section && section <= 2);
    }

    public static boolean isPositionClear(String[][] grid) {

        String position = grid[mRow][mColumn];

        return position.equals("|     |") || position.equals("      |");


    }
    public static void displayGrid(String[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            System.out.println("---------------------");
            for (int k = 0; k < grid[i].length; k++) {
                System.out.print(grid[i][k]);
            }
            System.out.println("");
        }
        System.out.println("---------------------");

    }

    public static String[][] createGrid(int row, int column) {

        String[][] grid = new String[row][column];

        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[i].length; k++) {
                if (k == 0)
                    grid[i][k] = "|     |"; // every first column
                else
                    grid[i][k] = "      |"; // every column after first
            }
        }
        return grid;
    }

    public static boolean updateTurn(String[][] grid) {

        // if grid isn't empty return false
        if (!grid[mRow][mColumn].equals("|     |") &&
            !grid[mRow][mColumn].equals("      |")) return  false;

        String update;
        if (isPlayer1Turn)
            update = (mColumn == 0) ? "|  X  |" : "  X   |";
        else
            update = (mColumn == 0) ? "|  O  |" : "  O   |";

        grid[mRow][mColumn] = update;

        return true;
    }

    public static boolean hasWon(String[][] grid) {

        int player = (isPlayer1Turn) ? 0 : 1;
        String token = (player == 0) ? "X" : "O";

        return (checkColumn(grid, token) || checkColumn(grid,token) || checkDiagonal(grid, token));
    }

    public static boolean checkColumn(String[][] grid, String s) {

        int occurence = 0;
        for (int k = 0; k < grid[0].length; k++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][k].contains(s)) occurence++;
            }
            if (occurence == 3) return true;
            else occurence = 0;
        }

        return false;
    }

    public static boolean checkRow(String[][] grid, String s) {

        int occurrence = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[i].length; k++) {
                if (grid[i][k].contains(s)) occurrence++;
            }
            if (occurrence == 3) return true;
            else occurrence = 0;
        }

        return false;
    }

    public static boolean checkDiagonal(String[][] grid, String s) {

        // check from top left to bottom right
        int occurrence = 0;
        int x = 0;
        int y = 0;
        while (x < grid[0].length && y < grid.length) {

            if (grid[y][x].contains(s)) occurrence++;
            if (occurrence == 3) return true;
            x++;
            y++;
        }

        // Checking from bottom left to top right
        x = 0;
        y = grid.length - 1;
        while (x < grid[0].length && y >= 0) {

            if (grid[y][x].contains(s)) occurrence++;
            if (occurrence == 3) return true;
            y--;
            x++;
        }


        return false;
    }

}
