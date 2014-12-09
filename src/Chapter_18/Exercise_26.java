package Chapter_18;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * (Create a maze)
 * Write a program that will find a path in a maze,
 * as shown in Figure 18.13a. The maze is represented
 * by an 8 * 8 board. The path must meet the following conditions:
 * <p>
 * The path is between the upper-left corner cell
 * and the lower-right corner cell in the maze.
 * <p>
 * The program enables the user to place or remove a mark on a cell.
 * A path consists of adjacent unmarked cells. Two cells are said to
 * be adjacent if they are horizontal or vertical neighbors,
 * but not if they are diagonal neighbors.
 * <p>
 * The path does not contain cells that form a square.
 * The path in Figure 18.13b, for example, does not meet
 * this condition. (The condition makes a path easy to
 * identify on the board.)
 * <p>
 * Created by Luiz Arantes Sa on 12/8/14.
 */
public class Exercise_26 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        MazePane pane = new MazePane(8, 100);

        HBox hBox = new HBox(20, pane.btnFindPath, pane.btnClearPath, pane.btnClearMarks);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setPadding(new Insets(10));
        BorderPane borderPane = new BorderPane(pane);
        borderPane.setBottom(hBox);


        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Maze");
        primaryStage.show();

    }

    private class MazePane extends GridPane {

        public Button btnFindPath = new Button("Find Path");
        public Button btnClearPath = new Button("Clear Path");
        public Button btnClearMarks = new Button("Clear Marks");
        SquarePane[][] squares;
        // Position
        int x;
        int y;


        MazePane(int size, int width) {

            squares = new SquarePane[size][size];

            for (int i = 0; i < squares.length; i++) {
                for (int k = 0; k < squares[i].length; k++) {
                    squares[i][k] = new SquarePane(width);
                    add(squares[i][k], k, i);
                }
            }

            squares[0][0].setDisable(true);
            squares[size - 1][size - 1].setDisable(true);
            btnClearPath.setOnMouseClicked(e -> clearPath());
            btnFindPath.setOnMouseClicked(e -> findPath());
            btnClearMarks.setOnMouseClicked(e -> clearMarks());
            setPadding(new Insets(10));
        }

        private boolean findPath() {
            return findPath(0, 0);
        }

        private boolean findPath(int x, int y) {

            squares[y][x].isFilled = true;

            if (isSquareRoute(x, y)) {
                squares[y][x].isFilled = false;
                return false;
            }
            // finish line
            if (x == squares[0].length - 1 && y == squares.length - 1) {
                squares[y][x].fillSquare();
                return true;
            }

            // right
            if (x < squares.length - 1 && !squares[y][x + 1].isMarked() && !squares[y][x + 1].isFilled()) {
                if (findPath(x + 1, y)) {

                    squares[y][x].fillSquare();
                    return true;
                }
            }

            // down
            if (y < squares.length - 1 && !squares[y + 1][x].isMarked() && !squares[y + 1][x].isFilled()) {
                if (findPath(x, y + 1)) {
                    squares[y][x].fillSquare();
                    return true;
                }
            }

            // left
            if (x > 0 && !squares[y][x - 1].isMarked() && !squares[y][x - 1].isFilled()) {
                if (findPath(x - 1, y)) {
                    squares[y][x].fillSquare();
                    return true;
                }
            }

            // up
            if (y > 0 && !squares[y - 1][x].isMarked() && !squares[y - 1][x].isFilled()) {
                if (findPath(x, y - 1)) {
                    squares[y][x].fillSquare();
                    return true;
                }
            }

            // clearPath fill
            squares[y][x].isFilled = false;

            return false;

        }

        // checks surrounding squares
        private boolean isSquareRoute(int x, int y) {

            int count = 1; // initial square
            if (y > 0 && x > 0 && squares[y - 1][x - 1].isFilled()) // up left
                count++;
            if (x < squares[0].length - 1 && y > 0 && squares[y - 1][x + 1].isFilled()) // up right
                count++;
            if (y < squares.length - 1 && x < squares[0].length - 1 && squares[y + 1][x + 1].isFilled()) // down right
                count++;
            if (x > 0 && y < squares.length - 1 && squares[y + 1][x - 1].isFilled()) // down left
                count++;
            if (x < squares[0].length - 1 && squares[y][x + 1].isFilled())
                count++;
            if (x > 0 && squares[y][x - 1].isFilled())
                count++;
            if (y < squares.length - 1 && squares[y + 1][x].isFilled())
                count++;
            if (y > 0 && squares[y - 1][x].isFilled())
                count++;

            return (count >= 4);
        }

        private void clearPath() {
            x = 0;
            y = 0;
            for (int i = 0; i < squares.length; i++) {
                for (int k = 0; k < squares[i].length; k++) {
                    squares[i][k].clearPath();
                }
            }
        }

        private void clearMarks() {
            x = 0;
            y = 0;
            for (int i = 0; i < squares.length; i++) {
                for (int k = 0; k < squares[i].length; k++) {
                    if (squares[i][k].isMarked()) {
                        squares[i][k].clearMark();
                    }
                }
            }
        }

        private class SquarePane extends Pane {

            private boolean isFilled;

            SquarePane(int size) {
                setPrefSize(size, size);
                setStyle(
                        "-fx-border-color: black;" +
                                "-fx-background-color: transparent;"
                );
                this.setOnMouseClicked(e -> toggleX());
            }

            private void toggleX() {

                ObservableList<Node> list = this.getChildren();

                if (list.size() > 0) {
                    list.clear();
                } else {
                    list.addAll(
                            new Line(0, 0, getWidth(), getHeight()),
                            new Line(getWidth(), 0, 0, getHeight())
                    );
                }
            }

            private void fillSquare() {
                setStyle("-fx-background-color: blue; -fx-border-color: black;");
                isFilled = true;
            }

            private boolean isMarked() {
                return (getChildren().size() > 0);
            }

            private boolean isFilled() {
                return isFilled;
            }

            private void clearPath() {
                setStyle("-fx-background-color: transparent; -fx-border-color: black");
                isFilled = false;
            }

            private void clearMark() {
                toggleX();
            }
        }
    }
}
