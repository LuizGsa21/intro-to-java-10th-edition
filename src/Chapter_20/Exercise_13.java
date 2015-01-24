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
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

/**
 * (Game: the 24-point card game)
 * The 24-point game is to pick any 4 cards from 52 cards, as shown in Figure 20.19.
 * Note that the Jokers are excluded. Each card represents a number. An Ace, King, Queen,
 * and Jack represent 1, 13, 12, and 11, respectively. You can click the Shuffle button to
 * get four new cards. Enter an expression that uses the four numbers from the four selected
 * cards. Each number must be used once and only once. You can use the opera- tors
 * (addition, subtraction, multiplication, and division) and parentheses in the expression.
 * The expression must evaluate to 24. After entering the expression, click the Verify button
 * to check whether the numbers in the expression are cur- rently selected and whether the result
 * of the expression is correct. Display the verification in a label before the Shuffle button.
 * Assume that images are stored in files named 1.png, 2.png, . . . , 52.png, in the order of spades,
 * hearts, diamonds, and clubs. So, the first 13 images are for spades 1, 2, 3, . . . , and 13.
 * <p>
 * Created by Luiz Arantes Sa on 1/14/15.
 */
public class Exercise_13 extends Application {

    int[] validNumbers = new int[4];

    @Override
    public void start(Stage primaryStage) {

        // Top pane
        Button btRefresh = new Button("Shuffle");
        Label lblStatus = new Label("");
        HBox topPane = new HBox(lblStatus, btRefresh);
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
        Label lblExpression = new Label("Enter an expression:");
        Button btVerify = new Button("Verify");
        HBox bottomPane = new HBox(10, lblExpression, tfExpression, btVerify);

        // Container Pane
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        borderPane.setTop(topPane);
        borderPane.setCenter(centerPane);
        borderPane.setBottom(bottomPane);

        // Listeners
        btRefresh.setOnAction(e -> {
            lblStatus.setText("");
            setRandomCards(centerPane);
        });
        btVerify.setOnAction(e -> {

            String expression = tfExpression.getText();
            if (isValid(expression) && isCorrect(expression)) {
                lblStatus.setText("Good job! " + expression + " = 24");
            } else {
                lblStatus.setText("Invalid Expression");
            }
        });

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("4 Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Debug
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
                int value = card % 13;
                validNumbers[count] = (value == 0) ? 13 : value;
                count++;
            }
        }

    }

    private static boolean isOperator(char ch) {
        return (ch == '(' ||
                ch == ')' ||
                isArithmeticOperator(ch));
    }

    private static boolean isArithmeticOperator(char ch) {
        return (ch == '/' ||
                ch == '+' ||
                ch == '-' ||
                ch == '*');
    }

    private static String[] separateExpression(String s) {
        ArrayList<String> tokens = new ArrayList<>(30);

        char[] chars = s.toCharArray();

        String numBuffer = "";
        for (char ch : chars) {
            if (isOperator(ch)) {
                if (numBuffer.length() > 0) {
                    tokens.add(numBuffer);
                    numBuffer = "";
                }
                tokens.add(ch + "");
            } else {
                if (ch != ' ')
                    numBuffer += ch;
            }
        }

        if (numBuffer.length() > 0) {
            tokens.add(numBuffer);
        }

        return tokens.toArray(new String[tokens.size()]);

    }

    private boolean isCorrect(String infixExpression) {
        return (24 == PostfixNotation.evaluateInfix(infixExpression));
    }

    private boolean isValid(String infixExpression) {

        String[] tokens = separateExpression(infixExpression);
        // Check is tokens contains any letters
        for (String s : tokens) {
            for (char ch : s.toCharArray()) {
                if (Character.isAlphabetic(ch))
                    return false;
            }
        }
        Stack<Integer> operands = new Stack<>();
        for (String token : tokens) {
            if (!isOperator(token.charAt(0))) {
                operands.push(Integer.parseInt(token));
            }
        }

        if (operands.size() != validNumbers.length)
            return false;

        // Put validNumbers into a buffer ArrayList
        ArrayList<Integer> validOperands = new ArrayList<>();
        for (int num : validNumbers) {
            validOperands.add(num);
        }

        for (int i = 0; i < validOperands.size(); i++) {
            int number = operands.pop();
            int index = validOperands.indexOf(number);

            if (index != -1) {
                validOperands.remove(index);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
