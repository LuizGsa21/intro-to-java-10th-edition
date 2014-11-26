package Chapter_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 12:
 *
 * (Geometry: inside a circle?)
 *      Write a program that draws a fixed circle centered at (100, 60) with radius 50.
 *      Whenever the mouse is moved, display a message indicating whether the
 *      mouse point is inside the circle at the mouse point or outside of it,
 *      as shown in Figure 15.27a.
 *
 * Created by Luiz Arantes Sa on 9/16/14.
 */
public class Exercise_12 extends Application {

    @Override
    public void start(Stage primaryStage) {

        double width = 400;
        double height = 300;
        Circle c = new Circle(100, 60, 50, Color.TRANSPARENT);
        c.setStroke(Color.BLACK);

        Pane pane = new Pane(c);
        Scene scene = new Scene(pane, width, height);
        Text text = new Text();
        pane.getChildren().add(text);
        pane.setOnMouseMoved(e-> {
            double x = e.getX();
            double y = e.getY();
            text.setX(x);
            text.setY(y);
            if (c.contains(x, y)) {
                text.setText("Mouse Point is inside the circle");
            } else {
                text.setText("Mouse Point is outside the circle");
            }
            if (text.getLayoutBounds().getWidth() + x > width) {
                text.setX(width - text.getLayoutBounds().getWidth());
            }
            if (y - text.getLayoutBounds().getHeight() < 0) {
                text.setY(text.getLayoutBounds().getHeight());
            }

        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle position");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
