package Chapter_15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 3:
 *
 *      (Move the ball)
 *      Write a program that moves the ball in a pane.
 *      You should define a pane class for displaying the ball and provide
 *      the methods for moving the ball left, right, up, and down, as shown
 *      in Figure 15.24c. Check the bound- ary to prevent the ball
 *      from moving out of sight completely.
 *
 * Created by Luiz Arantes Sa on 9/15/14.
 */
public class Exercise_03 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        double width = 400;
        double height = 400;
        BallPane ballPane = new BallPane(width / 2,height / 2, Math.min(width,height) / 15);

        Button btUp = new Button("Up");
        btUp.setOnAction(e -> ballPane.moveUp());

        Button btDown = new Button("Down");
        btDown.setOnAction(e -> ballPane.moveDown());

        Button btLeft = new Button("Left");
        btLeft.setOnAction(e -> ballPane.moveLeft());

        Button btRight = new Button("Right");
        btRight.setOnAction(e -> ballPane.moveRight());

        HBox buttons = new HBox(btUp, btDown, btLeft, btRight);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setSpacing(10);
        buttons.setPadding(new Insets(10, 10, 10, 10));

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(buttons);

        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click to move ball");
        primaryStage.show();
    }

    private class BallPane extends Pane {

        private Circle mCircle;

        public BallPane() {
            this(0, 0, 10);
        }
        public BallPane(double centerX, double centerY, double radius) {
            mCircle = new Circle(centerX, centerY, radius);
            getChildren().add(mCircle);
        }

        public void moveUp() {
            if (mCircle.getCenterY() - mCircle.getRadius()  - 10 < 0) return;
            mCircle.setCenterY(mCircle.getCenterY() - 10);
        }
        public void moveDown() {
            if (mCircle.getCenterY() + mCircle.getRadius() + 10 > getHeight()) return;

            mCircle.setCenterY(mCircle.getCenterY() + 10);
        }
        public void moveRight() {
            if (mCircle.getCenterX() + mCircle.getRadius() + 10 > getWidth()) return;
            mCircle.setCenterX(mCircle.getCenterX() + 10);
        }
        public void moveLeft() {
            if (mCircle.getCenterX() - mCircle.getRadius()  - 10 < 0) return;
            mCircle.setCenterX(mCircle.getCenterX() - 10);

        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
