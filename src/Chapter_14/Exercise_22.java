package Chapter_14;

import ToolKit.MyPoint;
import ToolKit.PaneCollection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Chapter 14 Exercise 22:
 *
 *      (Connect two circles) Write a program that draws two circles
 *      with radius 15 pixels, centered at random locations, with a
 *      line connecting the two circles. The line should not cross inside the circles,
 *      as shown in Figure 14.49c.
 *
 * Created by Luiz Arantes Sa on 9/14/14.
 */
public class Exercise_22 extends Application {

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
                    Math.random() * height, radius, Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            shapes.add(c);
            shapes.add(new Text(c.getCenterX(), c.getCenterY(), Integer.toString(i + 1)));
        }
        Circle c1 = (Circle)shapes.get(0);
        Circle c2 = (Circle)shapes.get(2);

        Line line = getClosestLine(c1, c2);
        shapes.add(line);


        double distance = PaneCollection.distance(line);
        MyPoint center = PaneCollection.getCenterPoint(line);

        shapes.add(new Text(center.x, center.y, Double.toString(distance)));

        pane.getChildren().addAll(shapes);
        primaryStage.setTitle("Draw Two Circle");
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.show();
    }

    private static Line getClosestLine(Circle c1, Circle c2) {

        Line line = new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
        double distance = PaneCollection.distance(line);
        for (int i = 0; i < 360; i++) {
            double x1 = c1.getCenterX() + c1.getRadius() * Math.cos(Math.toRadians(i));
            double y1 = c1.getCenterY() + c1.getRadius() * Math.sin(Math.toRadians(i));
            for (int j = 0; j < 360; j++) {
                double x2 = c2.getCenterX() + c2.getRadius() * Math.cos(Math.toRadians(j));
                double y2 = c2.getCenterY() + c2.getRadius() * Math.sin(Math.toRadians(j));
                Line line1 = new Line(x1, y1, x2, y2);
                double temp = PaneCollection.distance(line1);
                if (temp < distance) {
                    line = line1;
                    distance = temp;
                }
            }
        }
        return line;
    }

// Option 2:
//    /** Connect two circles centered at (x1, y1) and (x2, y2) */
//    private Line connectTwoCircles(
//            double x1, double y1, double x2, double y2, double radius) {
//        double d = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
//        int x11 = (int)(x1 - radius * (x1 - x2) / d);
//        int y11 = (int)(y1 - radius * (y1 - y2) / d);
//        int x21 = (int)(x2 + radius * (x1 - x2) / d);
//        int y21 = (int)(y2 + radius * (y1 - y2) / d);
//        return new Line(x11, y11, x21, y21);
//    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}
