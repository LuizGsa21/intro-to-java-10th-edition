package Chapter_14;

import ToolKit.MyPoint;
import ToolKit.PaneCollection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Chapter 14 Exercise 21:
 *
 *      (Two circles and their distance)
 *      Write a program that draws two filled circles with radius 15 pixels,
 *      centered at random locations, with a line connecting the two circles.
 *      The distance between the two centers is displayed on the line,
 *      as shown in Figure 14.49b.
 *
 * Created by Luiz Arantes Sa on 9/14/14.
 */
public class Exercise_21 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        double width = 400;
        double height = 400;
        double radius = 15;

        ArrayList<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Circle c = new Circle(
                    Math.random() * width,
                    Math.random() * height, radius);
            shapes.add(c);
        }
        Circle c1 = (Circle)shapes.get(0);
        Circle c2 = (Circle)shapes.get(1);

        Line line = new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
        shapes.add(line);

        double distance = PaneCollection.distance(line);
        MyPoint center = PaneCollection.getCenterPoint(line);

        shapes.add(new Text(center.x, center.y, Double.toString(distance)));

        pane.getChildren().addAll(shapes);
        primaryStage.setTitle("Draw two Circles");
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}
