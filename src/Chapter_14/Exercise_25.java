package Chapter_14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 25:
 *
 *  (Random points on a circle)
 *  Modify Programming Exercise 4.6 to create five random points on a circle,
 *  form a polygon by connecting the points clockwise, and display the circle
 *  and the polygon, as shown in Figure 14.51b.
 *
 * Created by Luiz Arantes Sa on 9/14/14.
 */
public class Exercise_25 extends Application {


    public void start(Stage primaryStage) {
        double width = 400;
        double height =400;

        Pane pane = new Pane();
        ObservableList<Node> list = pane.getChildren();

        Circle c = new Circle(width / 2, height / 2, width / 4, Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        list.add(c);

        drawRandomPolygon(pane, c);

        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.setTitle("Random points in a circle");
        primaryStage.show();
    }

    private static void drawRandomPolygon(Pane pane, Circle c) {

        int numberOfPoints = 5;
        ObservableList<Node> list = pane.getChildren();
        Point2D[] points = new Point2D[numberOfPoints];

        for (int i = 0; i < numberOfPoints; i++) {
            double angle = Math.random() * 360;
            points[i] = new Point2D(
                    c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(angle)),
                    c.getCenterY() + c.getRadius() * Math.sin(Math.toRadians(angle)));
        }

        sortPointsClockwise(points, new Point2D(c.getCenterX(), c.getCenterY()));

        Polygon polygon = new Polygon();

        for (Point2D point : points) {
            polygon.getPoints().addAll(point.getX(), point.getY());
        }
        list.add(polygon);
    }

    private static void sortPointsClockwise(Point2D[] points, Point2D center) {

        for (int i = 0; i < points.length - 1; i++) {
            Point2D lowest = points[i];
            int currentIndex = i;

            for (int j = i + 1; j < points.length; j++) {

                if (comparePoint(lowest, points[j], center)) {
                    lowest = points[j];
                    currentIndex = j;
                }
            }
            if (currentIndex != i) {
                points[currentIndex] = points[i];
                points[i] = lowest;
            }
        }

    }

    // http://stackoverflow.com/questions/6989100/sort-points-in-clockwise-order
    private static boolean comparePoint(Point2D a, Point2D b, Point2D center) {

        if (a.getX() - center.getX() >= 0 && b.getX() - center.getX() < 0) {
            return true;
        }
        if (a.getX() - center.getX() < 0 && b.getX() - center.getX() >= 0) {
            return false;
        }
        if (a.getX() - center.getX() == 0 && b.getX() - center.getX() == 0) {
            if (a.getY() - center.getY() >= 0 || b.getY() - center.getY() >= 0) {
                return a.getY() > b.getY();
            }
            return b.getY() > a.getY();
        }

        // compute the cross product of vectors (center -> a) x (center -> b)
        double det = (a.getX() - center.getX()) * (b.getY() - center.getY()) - (b.getX() - center.getX()) * (a.getY() - center.getY());
        if (det < 0) {
            return true;
        }
        if (det > 0) {
            return false;
        }

        // points a and b are on the same line from the center
        // check which point is closer to the center
        double d1 = (a.getX() - center.getX()) * (a.getX() - center.getX()) + (a.getY() - center.getY()) * (a.getY() - center.getY());
        double d2 = (b.getX() - center.getX()) * (b.getX() - center.getX()) + (b.getY() - center.getY()) * (b.getY() - center.getY());
        return d1 > d2;
    }


    public static void main(String[] args) {
        Application.launch(args);
    }

}
