package Chapter_18;

import ToolKit.MyPoint;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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

    public class ChessBoardPane extends Pane {

        ChessSquare[][] squares = new ChessSquare[8][8];
        boolean[][] isTaken = new boolean[8][8];
        Polyline polyline = new Polyline();
        ArrayList<MyPoint> availablePath = new ArrayList<>(8);
        int[] currentP = new int[2];
        int firstX;
        int firstY;
        boolean isFirstMove = true;

        Button btnReset = new Button("Reset");
        Button btnSolve = new Button("Solve Using Brute-Force");

        ChessBoardPane() {

            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10));

            boolean isBlack = false;
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {

                    gridPane.add(squares[i][j] = new ChessSquare(isBlack), j, i);
                    squares[i][j].setPrefSize(80, 80);
                    int x = j;
                    int y = i;
                    squares[i][j].setOnMouseClicked(e -> {

                        if (isFirstMove) {
                            firstX = x;
                            firstY = y;
                            currentP[0] = x;
                            currentP[1] = y;
                            isFirstMove = false;
                            setPoint(x, y);
                        } else {
                            playerMove(x, y);
                        }

                    });
                    isBlack = !isBlack;
                }
                isBlack = !isBlack;
            }

            btnReset.setOnMouseClicked(e-> completeReset());
            btnSolve.setOnMouseClicked(e-> solve());
            BorderPane borderPane = new BorderPane(gridPane);
            HBox hBox = new HBox(20, btnReset, btnSolve, new Label("Solving using brute force may take a minute..."));
            hBox.setAlignment(Pos.BASELINE_CENTER);
            hBox.setPadding(new Insets(10));
            borderPane.setBottom(hBox);

            getChildren().addAll(borderPane, polyline);

        }

        private void playerMove(int x, int y) {
            if (isValidMove(x, y)) {
                squares[currentP[1]][currentP[0]].leavePathMark();
                setPoint(x, y);
                currentP[0] = x;
                currentP[1] = y;
            }

        }

        private void completeReset() {
            resetChessBoard();
            isFirstMove = true;
        }

        private void resetChessBoard() {
            isTaken = new boolean[8][8];
            for (ChessSquare[] square : squares) {
                for (ChessSquare aSquare : square) {
                    aSquare.reset();
                }
            }
            polyline.getPoints().clear();
        }

        private void solve() {
            resetChessBoard();
            setPoint(firstX, firstY); // draw first point
            boolean isSuccess = false;

            while (!isSuccess) {
                isSuccess = move(firstX, firstY);
                if (!isSuccess) {
                    resetChessBoard();
                }
            }

        }

        private void setPoint(int x, int y) {
            double x1 = x * 80.0 + 50;
            double y1 = y * 80.0 + 50;
            squares[y][x].placeKnight();
            polyline.getPoints().addAll(x1, y1);
            isTaken[y][x] = true;
        }

        private boolean isValidMove(int x, int y) {
            return (!isTaken[y][x] && (currentP[1] == y - 2 && x == currentP[0] - 1 ||  // 2 up 1 left
                currentP[1] == y - 1 && currentP[0] == x - 2 || // 1 up 2 left
                currentP[1] == y - 2 && currentP[0] == x - 1 || // 2 up 1 right
                currentP[1] == y - 1 && currentP[0] == x + 2 || // 1 up 2 right
                currentP[1] == y + 2 && currentP[0] == x - 1 || // 2 down 1 left
                currentP[1] == y + 1 && currentP[0] == x - 2 || // 1 down 2 left
                currentP[1] == y + 1 && currentP[0] == x + 2 || // 1 down 2 right
                currentP[1] == y + 2 && currentP[0] == x + 1));  // 2 down 1 right
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

            boolean isSuccess = true;
            for (int i = 0; i < isTaken.length; i++) {
                for (int j = 0; j < isTaken[i].length; j++) {
                    if (!isTaken[i][j]) {
                        isSuccess = false;
                    }
                }
            }

            return isSuccess;
        }



        private class ChessSquare extends Pane {

            boolean isBlack;
            ChessSquare(boolean isBlack) {
                this.isBlack = isBlack;
                reset();

            }

            private void reset() {
                if (isBlack) {
                    setStyle("-fx-border-color: black; -fx-background-color: black");

                } else {
                    setStyle("-fx-border-color: black; -fx-background-color: gray");
                }
            }

            private void placeKnight() {
                setStyle("-fx-border-color: black;");
                setBackground(
                        new Background(
                                new BackgroundImage(
                                        new Image("image/knight.jpg"), null, null, null,
                                        new BackgroundSize(100, 100, true, true, true, true))));
            }

            private void leavePathMark() {
                setStyle("-fx-border-color: black; -fx-background-color: blue");
            }

        }

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
