package Chapter_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 7:
 *
 *      (Change color using a mouse)
 *      Write a program that displays the color of a circle as
 *      black when the mouse button is pressed and as white when
 *      the mouse button is released.
 *
 * Created by Luiz Arantes Sa on 9/15/14.
 */
public class Exercise_07  extends Application{

    @Override
    public void start(Stage primaryStage) {
        double width = 400;
        double height = 400;
        Circle c = new Circle(width / 2, height / 2, Math.min(width, height) / 10, Color.WHITE);

        c.setStroke(Color.BLACK);

        StackPane pane = new StackPane(c);

        primaryStage.setScene(new Scene(pane, width, height));
        pane.setOnMousePressed(e -> c.setFill(Color.BLACK));
        pane.setOnMouseReleased(e -> c.setFill(Color.WHITE));
        primaryStage.setTitle("Click circle..");
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);

    }
}
