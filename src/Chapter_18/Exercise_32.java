package Chapter_18;

import ToolKit.MyPoint;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * (Game: Knight’s Tour)
 * The Knight’s Tour is an ancient puzzle. The objective is to move a
 * knight, starting from any square on a chessboard, to every other square
 * once, as shown in Figure 18.15a. Note that the knight makes only
 * L-shaped moves (two spaces in one direction and one space in a perpendicular
 * direction). As shown in Figure 18.15b, the knight can move to eight squares.
 * Write VideoNote Search a string in a directory a program that displays the
 * moves for the knight, as shown in Figure 18.15c. When you click a cell, the knight
 * is placed at the cell. This cell will be starting point for the knight. Clicking
 * the Solve button to display the path for a solution.
 *
 * Created by Luiz Arantes Sa on 12/10/14.
 */
public class Exercise_32 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        ChessBoardPane pane = new ChessBoardPane();


        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chess Board");
        primaryStage.show();

    }

    private class ChessBoardPane extends Pane {

        ChessSquare[][] squares = new ChessSquare[8][8];
        boolean[][] isTaken = new boolean[8][8];
        Polyline polyline = new Polyline();
        ArrayList<MyPoint> availablePath = new ArrayList<>(8);

        Button btnReset = new Button("Reset");
        int firstX;
        int firstY;

        ChessBoardPane() {

            GridPane gridPane = new GridPane();
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {

                    gridPane.add(squares[i][j] = new ChessSquare(), j, i);
                    squares[i][j].setPrefSize(80, 80);
                    int x = j;
                    int y = i;
                    squares[i][j].setOnMouseClicked(e -> {
                        firstX = x;
                        firstY = y;
                        firstMove(x, y);
                    });
                }
            }

            getChildren().addAll(gridPane, polyline);
            gridPane.setPadding(new Insets(10));

        }

        private void resetChessBoard() {
            for (ChessSquare[] square : squares) {
                for (ChessSquare aSquare : square) {
                    aSquare.reset();
                }
            }
            polyline.getPoints().clear();
        }

        private void firstMove(int x, int y) {
            setPoint(x, y);
            boolean isSuccess = false;

            int count = 0;
            while (!isSuccess) {
                isSuccess = move(x, y);
                if (!isSuccess) {
                    count++;
                    resetChessBoard();
                    isTaken = new boolean[8][8];
                }
            }

            System.out.println("Total attempts: " + count);

        }

        private void setPoint(int x, int y) {
            isTaken[y][x] = true;
            double x1 = x * 80.0 + 50;
            double y1 = y * 80.0 + 50;
            squares[y][x].change();
            polyline.getPoints().addAll(x1, y1);
        }

        private boolean move(int x, int y) {

            availablePath.clear();
            if (x >= 1 && y >= 2 && !isTaken[y - 2][x - 1]) // 2 up 1 left
                availablePath.add(new MyPoint(x - 1, y - 2));
            if (x >= 2 && y >= 1 && !isTaken[y - 1][x - 2]) // 1 up 2 left
                availablePath.add(new MyPoint(x - 2, y - 1));
            if (x <= 6 && y >= 2 && !isTaken[y - 2][x + 1]) // 2 up 1 right
                availablePath.add(new MyPoint(x + 1, y - 2));
            if (x <= 5 && y >= 1 && !isTaken[y - 1][x + 2]) // 1 up 2 right
                availablePath.add(new MyPoint(x + 2, y - 1));
            if (x >= 1 && y <= 5 && !isTaken[y + 2][x - 1]) // 2 down 1 left
                availablePath.add(new MyPoint(x - 1, y + 2));
            if (x >= 2 && y <= 6 && !isTaken[y + 1][x - 2]) // 1 down 2 left
                availablePath.add(new MyPoint(x - 2, y + 1));
            if (x <= 5 && y <= 6 && !isTaken[y + 1][x + 2]) // 1 down 2 right
                availablePath.add(new MyPoint(x + 2, y + 1));
            if (x <= 6 && y <= 5 && !isTaken[y + 2][x + 1]) // 2 down 1 right
                availablePath.add(new MyPoint(x + 1, y + 2));

            if (availablePath.size() > 0) {
                MyPoint p = availablePath.get((int)(Math.random() * availablePath.size()));
                setPoint((int)p.x, (int)p.y);
                return move((int)p.x, (int)p.y);

            }


            return isSuccess();
        }

        private boolean isSuccess() {

            int count = 0;
            boolean isSuccess = true;
            for (int i = 0; i < isTaken.length; i++) {
                for (int j = 0; j < isTaken[i].length; j++) {
                    if (!isTaken[i][j]) {
                        count++;
                        isSuccess = false;
                    }
                }
            }

            System.out.println("Squares missed = " + count);
            return isSuccess;
        }



        private class ChessSquare extends Pane {

            ChessSquare() {
                reset();
            }

            private void reset() {
                setStyle("-fx-border-color: black; -fx-background-color: transparent");
            }

            private void change() {
                setStyle("-fx-border-color: black; -fx-background-color: blue");
            }


        }

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
