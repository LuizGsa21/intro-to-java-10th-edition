package Chapter_07;

/**
 * Chapter 7 Exercise 22:
 *
 *      (Game: Eight Queens)
 *      The classic Eight Queens puzzle is to place eight queens on a chessboard
 *      such that no two queens can attack each other (i.e., no two queens are on
 *      the same row, same column, or same diagonal). There are many possible solutions.
 *
 *        |Q| | | | | | | |
 *        | | | | |Q| | | |
 *        | | | | | | | |Q|
 *        | | | | | |Q| | |
 *        | | |Q| | | | | |
 *        | | | | | | |Q| |
 *        | |Q| | | | | | |
 *        | | | |Q| | | | |
 *
 *  Created by Luiz Arantes Sa on 8/28/14.
 */

public class Exercise_22 {

    static final int QUEEN = 100;


    static final int X_LIMIT = 8;
    static final int Y_LIMIT = 8;
    static long TIME_LIMIT = 25; // milliseconds
    static int UP_LEFT = 0; // DEBUGGING
    static int UP_RIGTH = 0;
    static int DOWN_LEFT = 0;
    static int DOWN_RIGHT = 0;

    public static void main(String[] args) {

        displayTimesTable(X_LIMIT , Y_LIMIT);
        //displayPlainTable(8, 8);
        System.out.println("\n\n");


        int[][] grid = new int[X_LIMIT][X_LIMIT];

        int queenCount = 0;
        long startTime = System.currentTimeMillis();
        while (queenCount < 8) {


            int x = getPosition();
            int y = getPosition();

            if (isLocationSafe(grid, x, y)) {
                grid[x][y] = QUEEN;
                queenCount++;
            }
            long timeCheck = System.currentTimeMillis();
            if (timeCheck - startTime > TIME_LIMIT) {
                clearGrid(grid);
                queenCount = 0;
                startTime = System.currentTimeMillis();
            }


        }


        displayGrid(grid);

    }

    public static boolean isLocationSafe(int[][] grid, int x, int y) {



        return (isDiagonalSafe(grid, x, y) &&
                isColumnSafe(grid, x, y) &&
                isRowSafe(grid, x, y));
    }
    public static boolean isDiagonalSafe(int[][] grid, int x, int y) {

        int x1 = x; // reset after every while loop
        int y1 = y;

        // check up left
        while (x1 >= 0 && y1 >= 0) {

            if (grid[x1][y1] == QUEEN) return false;
            UP_LEFT++;
            x1--;
            y1--;

        }

        x1 = x;
        y1 = y;
        // check down left
        while ( x1 >= 0 && y1 <= 7) {

            if (grid[x1][y1] == QUEEN) return false;
            DOWN_LEFT++;
            x1--;
            y1++;


        }

        x1 = x;
        y1 = y;
        // check up right
        while (x1 <= 7 && y1 >= 0) {

            if (grid[x1][y1] == QUEEN) return false;

            UP_RIGTH++;
            x1++;
            y1--;


        }

        x1 = x;
        y1 = y;
        // check down right
        while (x1 <= 7 && y1 <= 7) {

            if (grid[x1][y1] == QUEEN) return false;
            DOWN_RIGHT++;
            x1++;
            y1++;

        }



        return true;
    }

    public static boolean isColumnSafe(int[][] grid, int x, int y) {

        for (int i = 0; i < Y_LIMIT; i++) {
            if (grid[x][i] == QUEEN) return false;
        }

        return true;
    }

    public static boolean isRowSafe(int[][] grid, int x, int y) {

        for (int i = 0; i < X_LIMIT; i++) {
            if (grid[i][y] == QUEEN) return false;
        }


        return true;
    }

    public static void displayGrid(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {

            System.out.printf("%20s|", "");
            for (int k = 0; k < grid[i].length; k++) {
                System.out.printf("%-1c|", (grid[i][k] == 100) ? 'Q' : ' ');
            }
            System.out.println("");
        }

    }

    public static int getPosition() {
        return (int) (Math.random() * 8);
    }

    public static void displayTimesTable(int x, int y) {
        // display 8x8 numbered grid to help solve exercise
        for (int i = 1; i <= y; i++) {

            System.out.printf("%20s", "");
            for (int k = 1; k <= x; k++) {
                System.out.printf("|%-2d|", i * k);
            }
            System.out.println("");
        }
    }

    public static void displayPlainTable(int x, int y) {
        // display 8x8 numbered grid to help solve exercise
        for (int i = 0; i < y; i++) {

            System.out.printf("%20s", "");
            for (int k = 0; k < x; k++) {
                System.out.printf("(%1d,%1d)", k, i);
            }
            System.out.println("");
        }
    }

    public static void clearGrid(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {

            for (int k = 0; k < grid[i].length; k++) {
                grid[k][i] = 0;
            }
        }


    }

}
