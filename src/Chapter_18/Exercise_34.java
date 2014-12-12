package Chapter_18;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * (Game: Eight Queens)
 * The Eight Queens problem is to find a solution to place a queen in
 * each row on a chessboard such that no two queens can attack each other.
 * Write a program to solve the Eight Queens problem using recursion and
 *
 * Created by Luiz Arantes Sa on 12/11/14.
 */
public class Exercise_34 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        ChessBoard pane = new ChessBoard();
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Eight Queens");
        primaryStage.show();

        pane.setQueens();
    }

    public class ChessBoard extends GridPane {

        Square[][] grid = new Square[8][8];
        boolean[][] gridBuffer = new boolean[8][8];

        // limits
        final int leftBounds = -1;
        final int rightBounds = 8;
        final int downBounds = 8;
        final int upBounds = -1;

        ChessBoard() {

            boolean isBlack = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    add(grid[i][j] = new Square(80, isBlack), j, i);
                    isBlack = !isBlack;
                }
                isBlack = !isBlack;
            }

        }

        private void setQueens() {

            while (!setQueens(0, 0,0)) {
                gridBuffer = new boolean[8][8];
            }
            drawQueens();
        }

        private boolean setQueens(int x, int attempts, int count) {
            int y;
            do {
                y = (int) (Math.random() * 8);
            } while (gridBuffer[y][x]);

            if (isValid(x, y)) {
                gridBuffer[y][x] = true;
                count++;
            }

            if (attempts < 7 )
                return setQueens(x + 1, attempts + 1, count);
            else
                return count == 8;
        }

        private void drawQueens() {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (gridBuffer[i][j]){
                        grid[i][j].drawQueen();
                    }
                }
            }
        }

        private boolean isValid(int x, int y) {

            int left = x - 1;
            while (left > leftBounds)
                if (gridBuffer[y][left--]) return false;

            int right = x + 1;
            while (right < rightBounds)
                if (gridBuffer[y][right++]) return false;

            int up = y - 1;
            while (up > upBounds)
                if (gridBuffer[up--][x]) return false;

            int down = y + 1;
            while (down < downBounds)
                if (gridBuffer[down++][x]) return false;

            left = x - 1;
            up = y - 1;
            while (up > upBounds && left > leftBounds)
                if (gridBuffer[up--][left--]) return false;

            right = x + 1;
            up = y - 1;
            while (up > upBounds && right < rightBounds)
                if (gridBuffer[up--][right++]) return false;

            left = x - 1;
            down = y + 1;
            while (left > leftBounds && down < downBounds)
                if (gridBuffer[down++][left--]) return false;

            right = x + 1;
            down = y + 1;
            while (right < rightBounds && down < downBounds)
                if (gridBuffer[down++][right++]) return false;


            return true;
        }


        private class Square extends Pane {

            boolean isBlack;

            Square(int size, boolean isBlack) {
                this.isBlack = isBlack;
                setMinSize(size, size);
                reset();
            }

            private void updateBackground() {
                setStyle("-fx-background-color: black");
            }

            private void drawQueen() {

                ImageView image = new ImageView("image/queen.jpg");
                image.setFitHeight(getHeight());
                image.setFitWidth(getWidth());
                getChildren().add(image);

            }

            private void reset() {
                if (isBlack)
                    updateBackground();
                else
                    setStyle("-fx-border-color: black; -fx-background-color: white");
            }

        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
