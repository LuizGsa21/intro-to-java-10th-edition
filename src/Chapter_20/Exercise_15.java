package Chapter_20;

import ToolKit.PostfixNotation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * (Game: the 24-point card game) Improve Programming Exercise 20.13 to enable the computer
 * to display the expression if one exists, as shown in Figure 20.20. Otherwise, report that
 * the expression does not exist. Place the label for verification result at the bottom of UI.
 * The expression must use all four cards and evaluates to 24.
 *
 * Created by Luiz Arantes Sa on 1/16/15.
 */
public class Exercise_15 extends Application {

    Double[] validNumbers = new Double[4];

    @Override
    public void start(Stage primaryStage) {

        // Top pane
        Button btRefresh = new Button("Shuffle");
        Button btFindSolution = new Button("Find Solution");
        TextField tfSolution = new TextField();
        //tfSolution.setDisable(true);
        HBox topPane = new HBox(btFindSolution, tfSolution, btRefresh);
        topPane.setAlignment(Pos.BASELINE_RIGHT);
        topPane.setSpacing(10);

        // Center Pane
        HBox centerPane = new HBox();
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setSpacing(10);
        centerPane.setPadding(new Insets(10));
        // set first 4 random cards
        setRandomCards(centerPane);

        // Bottom pane
        TextField tfExpression = new TextField();
        Label lblStatus = new Label("");
        Label lblExpression = new Label("Enter an expression:");
        Button btVerify = new Button("Verify");
        HBox hBox1 = new HBox(10, lblExpression, tfExpression, btVerify);
        HBox hBox2 = new HBox(10, lblStatus);
        VBox bottomPane = new VBox(5, hBox1, hBox2);
        bottomPane.setPadding(new Insets(20));

        // Container Pane
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        borderPane.setTop(topPane);
        borderPane.setCenter(centerPane);
        borderPane.setBottom(bottomPane);

        // Listeners
        btRefresh.setOnAction(e -> {
            lblStatus.setText("");
            tfExpression.setText("");
            tfSolution.setText("");
            setRandomCards(centerPane);
        });
        btVerify.setOnAction(e -> {
            String expression = tfExpression.getText();

            // First make sure the user is only using each valid number once
            Double[] operands = PostfixNotation.getOperands(expression, true);
            Stack<Double> list1 = new Stack<>();
            Stack<Double> list2 = new Stack<>();
            Collections.addAll(list1, operands);
            Collections.addAll(list2, validNumbers);

            // Check is the operators match
            if (list1.size() != list2.size()) {
                lblStatus.setText("Please use all number " + Arrays.toString(validNumbers));
                return;
            }

            Collections.sort(list1);
            Collections.sort(list2);
            while (!list1.empty()) {
                if (!list1.pop().equals(list2.pop())) {
                    lblStatus.setText("Please use all number " + Arrays.toString(validNumbers));
                    return;
                }
            }

            try {
                double result = PostfixNotation.safeInfixEvaluation(expression);
                if (result == 24) {
                    lblStatus.setText("Good job! " + expression + " = 24");
                } else {
                    lblStatus.setText("Sorry, your answer is incorrect.\n" + expression + " = " + String.format("%.2f", result));
                }
            } catch (RuntimeException ex) {
                lblStatus.setText(ex.getMessage());
                System.out.println(ex.getMessage());
            }
        });
        btFindSolution.setOnAction(e-> {
            Double[] numbers = new Double[validNumbers.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (double) validNumbers[i];
            }
            String solution = PostfixNotation.postfixGenerator(24, 10000, numbers);
            if (!solution.equals("No Solution")) {
                solution = PostfixNotation.convertToInfix(solution);
            }
            tfSolution.setText(solution);
        });

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("4 Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setRandomCards(HBox pane) {
        boolean[] usedCards = new boolean[52];

        // choose 4 random distinct cards from the deck
        int count = 0;
        pane.getChildren().clear();
        while (count < 4) {
            int card = (int) (Math.random() * 52);
            if (!usedCards[card]) {
                usedCards[card] = true;
                pane.getChildren().add(new ImageView(new Image("image/card/" + (++card) + ".png")));
                double value = card % 13;
                validNumbers[count] = (value == 0) ? 13.0 : value;
                count++;
            }
        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
