package Chapter_16;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * (Pattern recognition: consecutive four equal numbers)
 *    Write a GUI program for Programming Exercise 8.19,
 *    as shown in Figure 16.49a–b. Let the user enter the
 *    numbers in the text fields in a grid of 6 rows and 7 columns.
 *    The user can click the Solve button to highlight a sequence of
 *    four equal numbers, if it exists. Ini- tially, the values in the text
 *    fields are filled with numbers from 0 to 9 randomly.
 *
 * Created by luizsa on 9/30/14.
 */
public class Exercise_30 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ConsecutiveFourPane pane;
        boolean isConsecutiveFour = false;
        do {
            pane = new ConsecutiveFourPane(7, 6);
            isConsecutiveFour = pane.isConsecutiveFour();
        } while (!isConsecutiveFour);

        primaryStage.setScene(new Scene(pane));
        pane.btSolve.addEventHandler(EventType.ROOT, event -> {
           primaryStage.sizeToScene();
        });
        primaryStage.setTitle("Consecutive Four");
        primaryStage.show();
    }

    private class ConsecutiveFourPane extends BorderPane {

        int m[][];
        StackPane[][] stackPanes;
        ArrayList<Integer> cFIndexes = new ArrayList<>(); // consecutive four indexes
        Label lblTitle = new Label("Click \"Solve\" to find solution");

        Button btSolve = new Button("Solve");

        private ConsecutiveFourPane(int rows, int columns) {

            // Top Pane
            HBox hBox = new HBox(lblTitle);
            hBox.setAlignment(Pos.CENTER);
            hBox.setPadding(new Insets(5));
            setTop(hBox);

            // Center Pane
            m = new int[rows][columns];
            stackPanes = new StackPane[rows][columns];
            GridPane gridPane = new GridPane();
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = (int) (Math.random() * 10);
                    Label label = new Label(" " + m[i][j] + " ");
                    label.setWrapText(false);
                    label.setFont(Font.font(20.0));
                    label.setWrapText(false);
                    stackPanes[i][j] = new StackPane(label);
                    stackPanes[i][j].setStyle("-fx-border-color: black;" +
                            "-fx-border-radius: 3");
                    gridPane.add(stackPanes[i][j], j, i);

                }
            }

            // Bottom Pane
            btSolve.setOnAction(e -> solve());
            HBox bottomPane = new HBox(btSolve);
            bottomPane.setAlignment(Pos.CENTER);
            bottomPane.setPadding(new Insets(5));
            setBottom(bottomPane);

            // grid pane default settings
            gridPane.setHgap(0.5);
            gridPane.setVgap(0.5);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setPadding(new Insets(10));
            gridPane.setStyle("-fx-border-color: black");

            //gridPane.setPadding(new Insets(5));
            setMargin(gridPane, new Insets(20));

            setCenter(gridPane);
        }

        private boolean solve() {
            boolean isSolved = isConsecutiveFour();

            if (isSolved) {
                lblTitle.setText("A Consecutive Four Found!");
                lblTitle.setTextFill(Color.BLUE);

                // change consecutive four lbl background
                for (int k = 0; k < cFIndexes.size(); k += 2) {
                    int i = cFIndexes.get(k);
                    int j = cFIndexes.get(k + 1);
                    Label label = (Label) stackPanes[i][j].getChildren().get(0);
                    label.setStyle(
                            "-fx-border-color: blue;");

                }
            } else {
                lblTitle.setText("NO Consecutive Four Found!");
                lblTitle.setTextFill(Color.RED);
            }

            return isSolved;
        }

        private boolean isConsecutiveFour() {

            // checking rows
            for (int i = 0; i < m.length; i++) {
                int current = m[i][0];

                for (int j = 0; j < m[i].length; j++) {

                    if (m[i][j] == current) {
                        cFIndexes.add(i);
                        cFIndexes.add(j);

                        if (cFIndexes.size() == 8) {
                            return true;
                        }
                    } else {
                        current = m[i][j];
                        cFIndexes.clear();
                        cFIndexes.add(i);
                        cFIndexes.add(j);
                    }
                }
                cFIndexes.clear();
            }

            // check columns
            for (int j = 0; j < m[0].length; j++) {
                int current = m[0][j];
                for (int i = 0; i < m.length; i++) {

                    if (m[i][j] == current) {
                        cFIndexes.add(i);
                        cFIndexes.add(j);

                        if (cFIndexes.size() == 8) {
                            return true;
                        }
                    } else {
                        current = m[i][j];
                        cFIndexes.clear();
                        cFIndexes.add(i);
                        cFIndexes.add(j);
                    }

                }
                cFIndexes.clear();
            }
            // check topLeft side: going upright
            for (int i = m.length - 1; i > 0; i--) {
                int y = i;
                int x = 0;
                int current = m[y][x];

                while (y >= 0 && x < m[y].length) {
                    if (m[y][x] == current) {
                        cFIndexes.add(y);
                        cFIndexes.add(x);
                        if (cFIndexes.size() == 8) {
                            return true;

                        }

                    } else {
                        current = m[y][x];
                        cFIndexes.clear();
                        cFIndexes.add(y);
                        cFIndexes.add(x);
                    }
                    x++;
                    y--;
                }
                cFIndexes.clear();
            }
            // check bottom right side: going upright
            for (int j = 0; j < m[0].length; j++) {
                int y = m.length - 1;
                int x = j;
                int current = m[y][x];

                while (x < m[0].length && y >= 0) {
                    if (m[y][x] == current) {
                        cFIndexes.add(y);
                        cFIndexes.add(x);
                        if (cFIndexes.size() == 8) {
                            return true;
                        }
                    } else {
                        current = m[y][x];
                        cFIndexes.clear();
                        cFIndexes.add(y);
                        cFIndexes.add(x);
                    }
                    x++;
                    y--;
                }

                cFIndexes.clear();
            }
            // check bottom left side going up-left
            for (int j = m[0].length - 1; j > 0; j--) {

                int x = j;
                int y = m.length - 1;
                int current = m[y][x];

                while (x >= 0 && y >= 0) {

                    if (m[y][x] == current) {
                        cFIndexes.add(y);
                        cFIndexes.add(x);
                        if (cFIndexes.size() == 8) {
                            return true;
                        }
                    } else {
                        current = m[y][x];
                        cFIndexes.clear();
                        cFIndexes.add(y);
                        cFIndexes.add(x);
                    }

                    x--;
                    y--;
                }
                cFIndexes.clear();
            }
            // check bottom right side going up-left
            for (int row = 1 ; row < m.length; row++) {
                int x = m[0].length - 1;
                int y = row;
                int current = m[y][x];

                while (y >= 0 && x >= 0) {
                    if (m[y][x] == current) {
                        cFIndexes.add(y);
                        cFIndexes.add(x);
                        if (cFIndexes.size() == 8) {
                            return true;
                        }
                    } else {
                        current = m[y][x];
                        cFIndexes.clear();
                        cFIndexes.add(y);
                        cFIndexes.add(x);
                    }
                    x--;
                    y--;
                }
                cFIndexes.clear();
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}