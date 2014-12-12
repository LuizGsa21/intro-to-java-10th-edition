package Chapter_18;

import ToolKit.MyPoint;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * (Game: Knight’s Tour animation)
 * Write a program for the Knight’s Tour problem. Your program should let the
 * user move a knight to any starting knight and click the Solve button to animate
 * a knight moving along the path.
 * <p>
 * Created by Luiz Arantes Sa on 12/11/14.
 */
public class Exercise_33 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ChessBoardPane pane = new ChessBoardPane();

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Knight's Tour");
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
        ChessSquare knight = new ChessSquare(true);

        PathTransition path = new PathTransition();
        Line line = new Line();


        Button btnReset = new Button("Reset");
        Button btnSolve = new Button("Solve Using Brute-Force");

        ChessBoardPane() {

            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10));
            knight.setMinSize(80, 80);
            knight.placeKnight();
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
                            squares[y][x].placeKnight();

                            setPoint(x, y);
                        } else {
                            playerMove(x, y);
                        }

                    });
                    isBlack = !isBlack;
                }
                isBlack = !isBlack;
            }

            btnReset.setOnMouseClicked(e -> completeReset());
            btnSolve.setOnMouseClicked(e -> solve());
            BorderPane borderPane = new BorderPane(gridPane);
            HBox hBox = new HBox(20, btnReset, btnSolve, new Label("Solving using brute force may take a minute..."));
            hBox.setAlignment(Pos.BASELINE_CENTER);
            hBox.setPadding(new Insets(10));
            borderPane.setBottom(hBox);

            toggleKnight();
            getChildren().addAll(borderPane, polyline, line, knight);
            polyline.setStroke(Color.RED);
            line.setStroke(Color.ORANGE);
        }

        private void playerMove(int x, int y) {
            if (isValidMove(x, y)) {
                squares[currentP[1]][currentP[0]].leavePathMark();
                setPoint(x, y);
                currentP[0] = x;
                currentP[1] = y;
            }

        }

        private void toggleKnight() {
            line.setVisible(!line.isVisible());
            knight.setVisible(!knight.isVisible());
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
            polyline.getPoints().addAll(x1, y1);
            isTaken[y][x] = true;
            int last = polyline.getPoints().size() - 1;
            if (last >= 3) {
                line.setStartX(polyline.getPoints().get(last - 3));
                line.setStartY(polyline.getPoints().get(last - 2));
                line.setEndX(polyline.getPoints().get(last - 1));
                line.setEndY(polyline.getPoints().get(last));

                path.setPath(line);
                path.setNode(knight);
                path.setCycleCount(1);
                path.setDuration(Duration.seconds(1));
                toggleKnight();
                path.play();

                path.setOnFinished(e -> {
                    squares[y][x].placeKnight();
                    toggleKnight();
                });
            }
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
                MyPoint p = availablePath.get((int) (Math.random() * availablePath.size()));
                setPoint((int) p.x, (int) p.y);
                return move((int) p.x, (int) p.y);

            }

            return isSuccess();
        }

        private boolean isSuccess() {

            boolean isSuccess = true;
            for (int i = 0; i < isTaken.length; i++) {
                for (int j = 0; j < isTaken[i].length; j++) {
                    if (!isTaken[i][j]) {
                        return false;
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
}
