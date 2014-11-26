package Chapter_15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 5:
 *
 *      (Create an investment-value calculator)
 *      Write a program that calculates the future value of an investment
 *      at a given interest rate for a specified number of years.
 *      The formula for the calculation is:
 *
 * Created by Luiz Arantes Sa on 9/15/14.
 */
public class Exercise_05 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        LoanInvestCalcPane calcPane = new LoanInvestCalcPane();

        primaryStage.setScene(new Scene(calcPane, calcPane.getPrefWidth(), calcPane.getPrefHeight()));
        primaryStage.setTitle("Simple calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }


    private class LoanInvestCalcPane extends GridPane {

        Label lbInvestAmount = new Label("Invest Amount:");
        TextField tfInvestAmount = new TextField();

        Label lbNumberOfYears = new Label("Number Of Years:");
        TextField tfNumberOfYears = new TextField();

        Label lbAnnualInterestRate = new Label("Annual Interest Rate:");
        TextField tfAnnualInterestRate = new TextField();

        Label lbFutureValue = new Label("Future Value:");
        TextField tfFutureValue = new TextField();

        Button btCalc = new Button("Calculate");

        private LoanInvestCalcPane() {

            // Create layout
            setPadding(new Insets(10, 10, 10, 10));
            setAlignment(Pos.CENTER);
            setHgap(10);
            setVgap(10);

            add(lbInvestAmount, 0, 0);
            add(tfInvestAmount, 1, 0);

            add(lbNumberOfYears, 0, 1);
            add(tfNumberOfYears, 1, 1);

            add(lbAnnualInterestRate, 0, 2);
            add(tfAnnualInterestRate, 1, 2);

            add(lbFutureValue, 0, 3);
            add(tfFutureValue, 1, 3);

            HBox buttons = new HBox();
            buttons.getChildren().add(btCalc);
            buttons.setAlignment(Pos.BOTTOM_RIGHT);
            add(buttons, 1, 4);
            btCalc.setOnAction(e-> calcFutureValue());

            // Editing TextField settings
            TextField[] textFields = (TextField[])getArray(
                    tfInvestAmount, tfNumberOfYears, tfAnnualInterestRate, tfFutureValue);

            for (TextField tf : textFields) {
                tf.setAlignment(Pos.BASELINE_RIGHT);
            }
            tfFutureValue.setDisable(true);

        }

        private Object[] getArray(Object... objects) {
            Object[] temp = new TextField[objects.length];
            for (int i = 0; i < objects.length; i++) {
                temp[i] = objects[i];
            }
            return temp;
        }

        public void calcFutureValue() {
            double investmentAmount = Double.parseDouble(tfInvestAmount.getText());
            double years = Double.parseDouble(tfNumberOfYears.getText());
            double monthInterestRate = Double.parseDouble(tfAnnualInterestRate.getText()) / 12 / 100;

            double futureValue = investmentAmount * Math.pow(1 + monthInterestRate, years * 12);
            tfFutureValue.setText(String.format("$%.2f", futureValue));
        }
    }
}
