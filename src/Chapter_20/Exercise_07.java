package Chapter_20;

import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;

/**
 * (Game: hangman)
 * Programming Exercise 7.35 presents a console version of the popular hangman game.
 * Write a GUI program that lets a user play the game. The user guesses a word by entering
 * one letter at a time, as shown in Figure 20.18. If the user misses seven times, a hanging
 * man swings. Once a word is finished,
 * the user can press the Enter key to continue to guess another word.
 *
 * Created by Luiz Arantes Sa on 12/19/14.
 */
public class Exercise_07 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        HangmanPane pane = new HangmanPane();

        Scene scene = new Scene(pane, 400, 400);
        scene.setOnKeyPressed(e-> {
            pane.sendKeyCode(e.getCode());
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hangman");
        primaryStage.show();
    }

    private class HangmanPane extends Pane {

        // List of words
        private String[] words = {"Programming", "Computer", "Mac"};

        private double w = 400;
        private double h = 400;
        private final int THRESHOLD = 7;

        // Hanger
        Line uL;
        Line rL;
        Line dL;

        // Hangman
        Circle head;
        Line leftArm;
        Line rightArm;
        Line body;
        Line leftLeg;
        Line rightLeg;

        String word;
        ArrayList<Character> guessedLetters = new ArrayList<>();
        ArrayList<Character> incorrectGuess = new ArrayList<>();

        Label lblHiddenWord = new Label();
        Label lblMissedLetters = new Label();
        Label lblMessage = new Label();

        boolean isPlaying = true;

        PathTransition path;

        HangmanPane() {
            startGame();
        }

        private void startGame() {

            getChildren().clear();
            guessedLetters.clear();
            incorrectGuess.clear();

            if (path != null) {
                path.stop();
            }

            word = getRandomWord();

            lblHiddenWord.setText(getHiddenWord());
            lblMissedLetters.setText("Missed letters: \n  ");
            lblMessage.setText("New Game: Make a guess!");

            double x = w * 0.4;
            double y = h * 0.8;
            lblHiddenWord.setLayoutX(x);
            lblHiddenWord.setLayoutY(y);

            lblMissedLetters.setLayoutX(x);
            lblMissedLetters.setLayoutY(y * 1.05);

            lblMessage.setLayoutX(x);
            lblMessage.setLayoutY(y * 1.15);

            getChildren().addAll(lblHiddenWord, lblMissedLetters, lblMessage);
            draw();
        }

        private void draw() {
            // Bottom arc
            Arc arc = new Arc(w * 0.2, h * 0.9, w * 0.15, h * 0.15, 0, 180);
            arc.setFill(Color.TRANSPARENT);
            arc.setStroke(Color.BLACK);

            // Upward line
            uL = new Line(arc.getCenterX(), arc.getCenterY() - arc.getRadiusY(), arc.getCenterX(), h * 0.05);
            // Rightward line
            rL = new Line(uL.getEndX(), uL.getEndY(), w * 0.6, uL.getEndY());
            // Downward line
            dL = new Line(rL.getEndX(), rL.getEndY(), rL.getEndX(), rL.getEndY() + h * 0.1);

            getChildren().addAll(arc, uL, rL, dL);

            for (int i = 1; i <= guessedLetters.size(); i++) {
                drawHangman(i);
            }
        }

        private void drawHangman(int guesses) {
            switch (guesses) {
                case 1: drawHead(); break;
                case 2: drawBody(); break;
                case 3: drawLeftArm(); break;
                case 4: drawRightArm(); break;
                case 5: drawLeftLeg(); break;
                case 6: drawRightLeg(); break;
                case 7: animateHang(); break;
            }
        }

        private void animateHang() {

            head.translateXProperty().addListener((observable, oldValue, newValue) -> {
                body.setTranslateX(newValue.doubleValue());
                leftArm.setTranslateX(newValue.doubleValue());
                rightArm.setTranslateX(newValue.doubleValue());
                leftLeg.setTranslateX(newValue.doubleValue());
                rightLeg.setTranslateX(newValue.doubleValue());
            });

            head.translateYProperty().addListener((observable, oldValue, newValue) -> {
                body.setTranslateY(newValue.doubleValue());
                leftArm.setTranslateY(newValue.doubleValue());
                rightArm.setTranslateY(newValue.doubleValue());
                leftLeg.setTranslateY(newValue.doubleValue());
                rightLeg.setTranslateY(newValue.doubleValue());
            });


            Arc arc = new Arc(dL.getEndX(), dL.getEndY() + head.getRadius() - 10, 20, 10, 220, 85);
            arc.setFill(Color.TRANSPARENT);
            arc.setStroke(Color.BLACK);
            path = new PathTransition(Duration.seconds(3), arc, head);
            path.setCycleCount(Transition.INDEFINITE);
            path.setAutoReverse(true);
            path.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            path.play();
        }

        private void drawHead() {
            double radius = w * 0.1;
            head = new Circle(dL.getEndX(), dL.getEndY() + radius, radius, Color.TRANSPARENT);
            head.setStroke(Color.BLACK);
            getChildren().add(head);
        }

        private void drawBody() {
            double startY = head.getCenterY() + head.getRadius();
            double x = head.getCenterX();
            body = new Line(x, startY, x, startY + h * 0.25);
            this.getChildren().add(body);
        }

        private void drawLeftArm() {
            leftArm = createArm(-1, 225);
            this.getChildren().add(leftArm);
        }

        private void drawRightArm() {
            rightArm = createArm(1, 315);
            this.getChildren().add(rightArm);
        }

        private void drawLeftLeg() {
            leftLeg = createLeg(-1);
            this.getChildren().add(leftLeg);
        }

        private void drawRightLeg() {
            rightLeg = createLeg(1);
            this.getChildren().add(rightLeg);
        }

        private Line createLeg(int dX) {
            double x = body.getEndX();
            double y = body.getEndY();
            return new Line(x, y, x + head.getRadius() * dX, y + w * 0.2);
        }

        private Line createArm(int dX, double angle) {
            double radius = head.getRadius();
            double x = head.getCenterX() + radius * Math.cos(Math.toRadians(angle));
            double y = head.getCenterY() - radius * Math.sin(Math.toRadians(angle));
            return new Line(x, y, x + radius * dX, y + radius * 1.5);
        }

        private boolean makeGuess(char ch) {

            if (!isPlaying) return false;

            // Check if guess has been used
            if (isRepeatedGuess(ch)) {
                lblMessage.setText(ch + " has already been used! Try again.");
                return false; // return false on repeated guesses
            }

            // Add letter to guess history
            guessedLetters.add(ch);

            String newWord = getHiddenWord(); // retrieve new word
            // Check if guess is correct
            // if newWord == hidden word then guess was incorrect
            if (newWord.equalsIgnoreCase(lblHiddenWord.getText())) {

                incorrectGuess.add(ch); // keep track of incorrect guesses

                if ((incorrectGuess.size() == THRESHOLD)) { // Player dies IN REAL LIFE jk jk lolol
                    lblMessage.setText("You lost! Press enter to try again.");
                    isPlaying = false; // Player can't make a guess until he presses enter
                } else {
                    lblMessage.setText(ch + " is incorrect guess! \nYou have " + (THRESHOLD - incorrectGuess.size()) + " lives left.");
                }
                lblMissedLetters.setText(lblMissedLetters.getText() + Character.toLowerCase(ch));
                drawHangman(incorrectGuess.size()); // draw hangman
                return false; // return false on incorrect guess
            } else {
                // Code reaches here if guess is correct
                lblHiddenWord.setText(newWord);
                String s = "Correct!";
                // Check if user won the game
                if (newWord.equalsIgnoreCase(word)) {
                    s += " You won the game! \n Press Enter to continue";
                    isPlaying = false;
                }
                lblMessage.setText(s);
            }
            return true;
        }

        public void sendKeyCode(KeyCode key) {
            if (key == KeyCode.ENTER && !isPlaying) {
                isPlaying = true;
                startGame();
            } else if (key.isLetterKey()) {
                makeGuess(key.getName().charAt(0));
            }
        }

        private boolean isRepeatedGuess(char ch) {
            ch = Character.toUpperCase(ch);
            for (char letter : guessedLetters) {
                if (letter == ch) {
                    return true;
                }
            }
            return false;
        }

        private String getHiddenWord() {

            String s = "";
            for (int i = 0; i < word.length(); i++) {
                boolean isMatched = false;
                for (char ch : guessedLetters) {
                    if (Character.toLowerCase(ch) == Character.toLowerCase(word.charAt(i))) {
                        s += word.charAt(i);
                        isMatched = true;
                        break;
                    }
                }
                if (!isMatched) {
                    s += "*";
                }
            }
            return s;
        }

        private String getRandomWord() {
            return words[(int) (Math.random() * words.length)];
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
