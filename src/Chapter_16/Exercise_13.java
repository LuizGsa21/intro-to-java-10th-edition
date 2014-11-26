package Chapter_16;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Compare loans with various interest rates)
 *      Rewrite Programming Exercise 5.21 to create a GUI,
 *      as shown in Figure 16.41b. Your program should let
 *      the user enter the loan amount and loan period in
 *      the number of years from text fields, and it should
 *      display the monthly and total payments for each interest
 *      rate starting from 5 percent to 8 percent,
 *      with increments of one-eighth, in a text area.
 *
 * Created by luizsa on 9/26/14.
 */
public class Exercise_13 extends Application {

    TextField tfLoanAmount = new TextField();
    TextField tfNumOfYears = new TextField();
    TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {

        EventHandler<ActionEvent> handler = event -> updateRates();
        tfNumOfYears.setOnAction(handler);
        tfLoanAmount.setOnAction(handler);

        HBox topPane = new HBox();
        topPane.setSpacing(10);
        topPane.setPadding(new Insets(5));
        Label lblLoanAmount = new Label("Loan Amount:", tfLoanAmount);
        lblLoanAmount.setContentDisplay(ContentDisplay.RIGHT);

        Label lblNumOfYears = new Label("Number Of Years:", tfNumOfYears);
        lblNumOfYears.setContentDisplay(ContentDisplay.RIGHT);

        Button btShowTable = new Button("Show Table");
        btShowTable.setOnAction(handler);
        topPane.getChildren().addAll(lblLoanAmount, lblNumOfYears, btShowTable);


        BorderPane borderPane = new BorderPane(textArea);
        borderPane.setTop(topPane);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Display Loan");
        primaryStage.show();
    }

    private void updateRates() {
        double annualInterestRate = 5.00;

        double loanAmount = Double.parseDouble(tfLoanAmount.getText());

        double numberOfYears = Double.parseDouble(tfNumOfYears.getText());

        String s = String.format("%-1s%20s%20s\n", "Interest Rate", "Monthly Payment", "Total Payment");
        // making loop to display different interest rates
        for ( ; annualInterestRate <= 8.00; annualInterestRate += 0.125) {

            // calculating monthly and total payment rates
            double monthlyInterestRate = annualInterestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));

            double totalPayment = monthlyPayment * numberOfYears * 12;

            // making % string for formatting reasons...
            String str = "%";

            // Displaying formatted info
            s += String.format("%-1.3f%s%19.2f%30.2f \n", annualInterestRate, str, ((int) (monthlyPayment * 100) / 100.0), ((int) (totalPayment * 100) / 100.0));
        }

        textArea.setText(s);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


