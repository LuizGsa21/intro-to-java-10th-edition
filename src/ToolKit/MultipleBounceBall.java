package ToolKit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MultipleBounceBall extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("-fx-border-color: yellow");

        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btAdd, btSubtract);
        hBox.setAlignment(Pos.CENTER);

        // Add or remove a ball
        btAdd.setOnAction(e -> ballPane.add());
        btSubtract.setOnAction(e -> ballPane.subtract());

        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        // Use a scroll bar to control animation speed
        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setValue(10);
        ballPane.rateProperty().bind(sbSpeed.valueProperty());

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("MultipleBounceBall"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    protected class MultipleBallPane extends Pane {
        protected Timeline animation;

        public MultipleBallPane() {
            // Create an animation for moving the ball
            animation = new Timeline(
                    new KeyFrame(Duration.millis(50), e -> moveBall()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play(); // Start animation
        }

        public void add() {
            Color color = new Color(Math.random(),
                    Math.random(), Math.random(), 0.5);

            // Create ball and add listener
            Ball ball = new Ball(30, 30, 20, color);
            ball.setOnMouseClicked(e-> getChildren().remove(ball));

            // Add ball to pane
            getChildren().add(ball);
        }

        public void add(Ball ball) {
            ball.setOnMouseClicked(e-> getChildren().remove(ball));

            // Add ball to pane
            getChildren().add(ball);
        }

        public void subtract() {
            if (getChildren().size() > 0) {
                getChildren().remove(getChildren().size() - 1);
            }
        }

        public void play() {
            animation.play();
        }

        public void pause() {
            animation.pause();
        }

        public void increaseSpeed() {
            animation.setRate(animation.getRate() + 0.1);
        }

        public void decreaseSpeed() {
            animation.setRate(
                    animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
        }

        public DoubleProperty rateProperty() {
            return animation.rateProperty();
        }

        protected void moveBall() {
            for (int i = 0; i < this.getChildren().size(); i++) {
                Ball ball = (Ball)this.getChildren().get(i);

                // Check boundaries
                if (ball.getCenterX() < ball.getRadius() ||
                        ball.getCenterX() > getWidth() - ball.getRadius()) {
                    ball.dx *= -1; // Change ball move direction
                }
                if (ball.getCenterY() < ball.getRadius() ||
                        ball.getCenterY() > getHeight() - ball.getRadius()) {
                    ball.dy *= -1; // Change ball move direction
                }


                for (int j = i + 1; j < this.getChildren().size(); j++) {
                    Ball b = (Ball)this.getChildren().get(j);
                    if (b.intersects(ball.getBoundsInLocal())) {
                        this.getChildren().removeAll(ball, b);

                        double radius = b.getRadius() + ball.getRadius();

                        double x = (b.getCenterX() - radius < 0 || b.getCenterX() + radius > getWidth()) ? radius + 1 : b.getCenterX();
                        double y = (b.getCenterY() - radius < 0 ||  b.getCenterY() + radius > getHeight()) ? radius + 1 : b.getCenterY();
                        Ball newBall = new Ball(x, y, radius, ball.color);

                        this.add(newBall);
                    }
                }

                // Adjust ball position
                ball.setCenterX(ball.dx + ball.getCenterX());
                ball.setCenterY(ball.dy + ball.getCenterY());
            }
        }

    }

    class Ball extends Circle {
        protected double dx = 1, dy = 1;
        protected Color color;
        Ball(double x, double y, double radius, Color color) {
            super(x, y, radius);
            this.color = color;
            setFill(this.color); // Set ball color
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

