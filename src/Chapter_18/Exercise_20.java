package Chapter_18;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * (Display circles)
 * Write a Java program that displays ovals. The circles are centered in the pane.
 * The gap between two adjacent circles is 10 pixels, and the gap between the
 * border of the pane and the largest circle is also 10.
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_20  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        CirclePane pane = new CirclePane();

        Scene scene = new Scene(pane);
        scene.widthProperty().addListener(e-> pane.draw());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle pane");
        primaryStage.show();
    }

    class CirclePane extends StackPane {

        CirclePane() {
            setPrefHeight(200);
            setPrefWidth(200);
        }

        public void draw() {
            getChildren().clear();

            double range = Math.min(getWidth(), getHeight());
            createCircle(range / 2 - 10);
        }

        public void createCircle(double radius) {
            if (radius > 10) {
                Circle c = new Circle(radius, Color.TRANSPARENT);
                c.setStroke(Color.BLACK);
                getChildren().add(c);
                createCircle(radius - 10);
            }
        }

    }
}
