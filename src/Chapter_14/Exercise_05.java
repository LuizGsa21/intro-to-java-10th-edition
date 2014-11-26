package Chapter_14;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 5:
 *
 *    (Characters around circle)
 *    Write a program that displays a string Welcome to Java around
 *    the circle, as shown in Figure 14.44b. Hint: You need to display
 *    each character in the right location with appropriate
 *    rotation using a loop.
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_05 extends Application{

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        String[] java = "Welcome to Java".split("");
        Font font = Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 30);

        // http://en.wikipedia.org/wiki/Circle#Equations
        // The equation can be written in parametric form using the
        // trigonometric functions sine and cosine as
        // x = a+r * cos t
        // y = b+r * sin t
        // where t is a parametric variable in the range 0 to 2π,

        Point2D center = new Point2D(200, 200);
        double radius = 100;
        double angle = 0;
        double rotate = 90;
        for (int i = 0; i < java.length; i++, angle += 22, rotate += 22) {
            double x = center.getX() + radius * Math.cos(Math.toRadians(angle));
            double y = center.getY() + radius * Math.sin(Math.toRadians(angle));
            Text text = new Text(x, y,java[i]);
            text.setRotate(rotate);
            text.setFont(font);
            pane.getChildren().add(text);

        }

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Welcome to Java");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
