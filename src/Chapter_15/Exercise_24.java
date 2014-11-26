package Chapter_15;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Chapter 15 Exercise 24:
 * <p>
 * (Animation: palindrome)
 * Write a program that animates a palindrome swing as shown
 * in Figure 15.31. Press/release the mouse to pause/resume the animation.
 * <p>
 * Created by Luiz Arantes Sa on 9/17/14.
 */
public class Exercise_24 extends Application {

    private static double WIDTH = 400;
    private static double HEIGHT = 400;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Arc arc = new Arc(WIDTH / 2, HEIGHT * 0.8, WIDTH * 0.25, HEIGHT * 0.1, 180, 180);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);
        Circle c = new Circle(arc.getCenterX() - arc.getRadiusX(), arc.getCenterY(), 10);

        pane.getChildren().addAll(c, arc);

        PathTransition path = new PathTransition();
        path.setDuration(Duration.millis(4000));
        path.setPath(arc);
        path.setNode(c);
        path.setOrientation(OrientationType.NONE);
        path.setCycleCount(Timeline.INDEFINITE);
        path.setAutoReverse(true);
        path.play();
        c.setOnMouseClicked(e -> {
            path.play();
        });

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Swing");
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
