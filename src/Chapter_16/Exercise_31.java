package Chapter_16;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Game: connect four)
 *    Programming Exercise 8.20 enables two players to play the
 *    connect-four game on the console. Rewrite a GUI version
 *    for the program, as shown in Figure 16.49c. The program
 *    enables two players to place red and yellow discs in turn.
 *    To place a disk, the player needs to click an available cell.
 *    An available cell is unoccupied and its downward neighbor is
 *    occupied. The program flashes the four winning cells
 *    if a player wins and reports no winners if all cells
 *    are occupied with no winners.
 * Created by luizsa on 9/30/14.
 */
public class Exercise_31 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        ConsecutiveFourPane pane = new ConsecutiveFourPane(100);

        BorderPane borderPane = new BorderPane(pane);

        HBox bottomPane = new HBox(pane.lblGameStatus);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setPadding(new Insets(10));

        borderPane.setBottom(bottomPane);
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Consecutive Four");
        primaryStage.show();
    }

    private class ConsecutiveFourPane extends GridPane {

        double w;
        double h;
        int columns = 7;
        int rows = 6;
        Circle[][] circles = new Circle[rows][columns];

        boolean isPlayer1Turn = true;
        boolean hasWon;
        int[] c4Indexes = new int[8];

        Label lblGameStatus = new Label(getPlayerString());

        private ConsecutiveFourPane(int size) {
            w = size * columns;
            h = size * rows;

            drawBackground();
            lblGameStatus.setFont(Font.font(30));
        }

        private void drawBackground() {

            for (int i = 0; i < circles.length; i++) {
                for (int j = 0; j < circles[i].length; j++) {

                    Rectangle rec = new Rectangle(w / columns, w / columns);
                    rec.setFill(Color.BLUE);

                    circles[i][j] = new Circle(rec.getWidth() * 0.45);
                    circles[i][j].setFill(Color.WHITE);

                    final int row = i;
                    final int column = j;
                    circles[i][j].setOnMouseClicked(e-> {
                        if (checkLocation(row, column) && !hasWon) {
                            circles[row][column].setFill((isPlayer1Turn) ? Color.RED : Color.YELLOW);

                            if (isConsecutiveFour()) {
                                hasWon = true;
                                flashConsecutiveFour();
                                lblGameStatus.setText((isPlayer1Turn) ? "Player 1 has WON" : "Player 2 has WON");
                            } else if (isDraw()) {
                                lblGameStatus.setText("It's a DRAW");
                            } else {
                                isPlayer1Turn = !isPlayer1Turn;
                                lblGameStatus.setText((isPlayer1Turn) ? "Player's 1 turn" : "Player's 2 turn");
                            }
                        }
                    });
                    StackPane pane = new StackPane(rec, circles[i][j]);
                    add(pane, j, i);
                }
            }

        }

        private void flashConsecutiveFour() {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), e-> {
                    flashCircles();
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }

        private boolean isDraw() {
            for (Circle[] circle : circles) {
                for (Circle c : circle) {
                    if (c.getFill() == Color.WHITE) return false;
                }
            }
            return true;
        }

        private void flashCircles() {
            for (int i = 0; i < 8; i += 2) {
                Circle c = circles[c4Indexes[i]][c4Indexes[i + 1]];
                Color playerColor = (isPlayer1Turn) ? Color.RED : Color.YELLOW;
                c.setFill((c.getFill() != Color.ORANGE) ? Color.ORANGE : playerColor);
            }
        }

        private String getPlayerString() {
            return (isPlayer1Turn) ? "Player's 1 turn" : "Player's 2 turn";
        }

        // returns true if grid location is clear
        private boolean checkLocation(int row, int column) {
            // if at the bottom row and the circle is white return true else false
            if (row == circles.length - 1) {
                return circles[row][column].getFill() == Color.WHITE;
            }
            // if circle below the clicked circle is not white return true
            return (circles[row + 1][column].getFill() != Color.WHITE);
        }

        public boolean isConsecutiveFour() {

            Color color = (isPlayer1Turn) ? Color.RED : Color.YELLOW;

            int occurrence = 0;
            // (m[0].length - 3) --> reason: only checking occurrences of 4
            for (int j = 0; j < circles[0].length - 3; j++) {
                int y = circles.length - 1; // row always starts on last row
                int x = j;
                while (x < circles[0].length && y >= 0) {

                    if (circles[y][x].getFill() == color) {
                        occurrence++;
                        if (occurrence == 4) {                  // | | | | | |R|R|
                            saveOccurrence(y, x, false, true);  // | | | | |R|R|R|
                            return true;                        // | | | |R|R|R|R|
                        }                                       // | | |R|R|R|R| |
                    } else {                                    // | |R|R|R|R| | |
                        occurrence = 0;
                    }
                    x++;
                    y--;
                }
            }

            // (m.length - 2) --> reason: only checking occurrences of 4
            // and last row has already been checked
            for (int i = circles.length - 2; i > 2; i--) {
                int x = 0; // column always starts on the left side
                int y = i;
                occurrence = 0;                                    // | | | |R|R| | |
                while (x < circles[0].length && y >= 0) {          // | | |R|R| | | |
                                                                   // | |R|R| | | | |
                                                                   // |R|R| | | | | |
                    if (circles[y][x].getFill() == color) {        // |R| | | | | | |
                        occurrence++;                              // | | | | | | | |
                        if (occurrence == 4) {
                            saveOccurrence(y, x, false, true);
                            return true;
                        }
                    } else {
                        occurrence = 0;
                    }

                    x++;
                    y--;
                }
            }

            // j >= 3 --> reason: only checking occurrences of 4
            for (int j = circles[0].length - 1; j >= 3; j--) {
                int y = circles.length -1; // row always starts on last row
                int x = j;
                occurrence = 0;
                                                                    // |L|L| | | | | |
                while (x >= 0 && y >= 0) {                          // |L|L|L| | | | |
                                                                    // |L|L|L|L| | | |
                    if (circles[y][x].getFill() == color) {         // | |L|L|L|L| | |
                        occurrence++;                               // | | |L|L|L|L| |
                        if (occurrence == 4) {                      // | | | |L|L|L|L|
                            saveOccurrence(y,x,false,false);
                            return true;
                        }
                    } else {
                        occurrence = 0;
                    }
                    x--;
                    y--;
                }

            }

            // i > 2 --> reason: only checking occurrences of 4  // | | |L|L| | | |
            for (int i = circles.length - 2; i > 2; i--) {       // | | | |L|L| | |
                int x = circles[0].length - 1;                   // | | | | |L|L| |
                int y = i;                                       // | | | | | |L|L|
                occurrence = 0;                                  // | | | | | | |L|
                while (x >= 0 && y >= 0) {                       // | | | | | | | |

                    if (circles[y][x].getFill() == color) {
                        occurrence++;
                        if (occurrence == 4) {
                            saveOccurrence(y, x, false, false);
                            return true;
                        }
                    } else {
                        occurrence = 0;
                    }
                    x--;
                    y--;
                }

            }

            // Check rows
            for (int y = 0; y < circles.length; y++) {
                for (int x = 0; x < circles[y].length; x++) {

                    if (circles[y][x].getFill() == color) {
                        occurrence++;
                        if (occurrence == 4) {
                            int sequence = 0;
                            for (int i = 0; i < 8; i += 2) {
                                c4Indexes[i] = y;
                                c4Indexes[i + 1] = x - sequence++;
                            }
                            return true;
                        }
                    } else {
                        occurrence = 0;
                    }
                }
                occurrence = 0;
            }

            // Check columns
            for (int x = 0; x < circles[0].length; x++) {
                for (int y = 0; y < circles.length; y++) {

                    if (circles[y][x].getFill() == color) {
                        occurrence++;
                        if (occurrence == 4) {
                            int sequence = 0;
                            for (int i = 0; i < 8; i += 2) {
                                c4Indexes[i] = y - sequence++;
                                c4Indexes[i + 1] = x;
                            }
                            return true;
                        }
                    } else {
                        occurrence = 0;
                    }
                }
                occurrence = 0;
            }
            return false;
        }


        private void saveOccurrence(int y, int x, boolean yIsIncrement, boolean xIsIncrement) {
            int yIncrement = (yIsIncrement) ? -1 : 1;
            int xIncrement = (xIsIncrement) ? -1 : 1;

            for (int i = 0; i < 8; i += 2) {
                c4Indexes[i] = y;
                c4Indexes[i + 1] = x;
                y += yIncrement;
                x += xIncrement;
            }
        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
