package Chapter_20;


import ToolKit.PostfixNotation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * (Game: the 24-point card game)
 * This exercise is a variation of the 24-point card game described
 * in Programming Exercise 20.13. Write a program to check whether
 * there is a 24-point solution for the four specified numbers. The program
 * lets the user enter four values, each between 1 and 13, as shown in Figure 20.21.
 * The user can then click the Solve button to display the solution
 * or display “No solution” if none exist.
 *
 * Created by Luiz Arantes Sa on 1/21/15.
 */
public class Exercise_17 extends Application {

    @Override
    public void start(Stage primaryStage) {

        PointCardGamePane pointPane = new PointCardGamePane(4, 24);

        primaryStage.setScene(new Scene(pointPane));
        primaryStage.setTitle(pointPane.gamePoint + " game! Find solution.");
        primaryStage.show();

    }

    private class PointCardGamePane extends GridPane {

        private int gamePoint;

        private TextField tfOutput;
        private TextField[] tfValues;
        private Button btSolve;

        PointCardGamePane(int size, int gamePoint) {

            this.gamePoint = gamePoint;

            // top pane (holds output textfield and solve button
            tfOutput = new TextField();
            tfOutput.setPrefColumnCount(20);
            btSolve = new Button("Solve");
            btSolve.setOnAction(e-> {

                String expression;
                try {
                    ArrayList<Double> numberArray = new ArrayList<>();
                    for (TextField tf : tfValues) {
                        // Truncate decimal places...
                        Integer integer = Integer.parseInt(tf.getText());
                        numberArray.add(Double.parseDouble(integer.toString()));
                    }

                    // Get postfix expression
                    expression = PostfixNotation.postfixGenerator(gamePoint, 10000, numberArray.toArray(new Double[numberArray.size()]));

                    // convert expression to infix if there's still a solution
                    if (!expression.equals("No Solution")) {
                        expression = PostfixNotation.convertToInfix(expression);
                    }
                    tfOutput.setText(expression);

                } catch (NumberFormatException ex) {
                    tfOutput.setText("Invalid input");
                }
            });

            HBox topPane = new HBox(5, tfOutput, btSolve);
            topPane.setPadding(new Insets(10));
            addRow(0, topPane);

            // Bottom pane (holds textfield values)
            HBox bottomPane = new HBox(10);
            bottomPane.setAlignment(Pos.BASELINE_CENTER);
            bottomPane.setPadding(new Insets(10));
            tfValues = new TextField[size];
            for (int i = 0; i < size; i++) {
                tfValues[i] = new TextField();
                tfValues[i].setPrefColumnCount(2);
                tfValues[i].setAlignment(Pos.CENTER);
                tfValues[i].setFont(Font.font(23));
                tfValues[i].setPadding(new Insets(20));
            }
            bottomPane.getChildren().addAll(tfValues);
            addRow(1, bottomPane);
        }
    }

}
