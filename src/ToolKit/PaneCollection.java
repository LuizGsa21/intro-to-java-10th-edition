package ToolKit;

import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Chapter 14 Exercise 20:
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class PaneCollection {


    public static void drawArrowLine(double x1, double y1, double x2,   double y2, Pane pane) {
        drawArrowLine(x1, y1, x2, y2, pane, 15);
    }

    public static void drawArrowLine(double x1, double y1, double x2,   double y2, Pane pane, int length) {
        drawArrowLine(new Line(x1, y1, x2, y2), pane, length);
    }

    public static void drawArrowLine(Line line, Pane pane) {
        drawArrowLine(line, pane, 15);
    }

    public static void drawArrowLine(Line line, Pane pane, int length) {
        ObservableList<Node> list = pane.getChildren();

        double arctan = Math.atan(slope(line));
        double set45 = (line.getStartX() > line.getEndX()) ? 1.57 / 2 : -1.57 * 1.5;

        list.add(line);
        list.add(new Line(line.getEndX(), line.getEndY(),
                (line.getEndX() + Math.cos(arctan - set45) * length),
                (line.getEndY() + Math.sin(arctan - set45) * length)));
        list.add(new Line(line.getEndX(), line.getEndY(),
                (line.getEndX() + Math.cos(arctan + set45) * length),
                (line.getEndY() + Math.sin(arctan + set45) * length)));
    }

    public static double slope(Line line) {
        return (line.getStartY() - line.getEndY()) / (line.getStartX() - line.getEndX());
    }

    public static double distance(double x1, double y1, double x2, double y2) {

        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static double distance(Line line) {
        return distance(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
    }

    public static MyPoint getCenterPoint(Line line) {

        return new MyPoint(
                (line.getStartX() + line.getEndX()) / 2,
                (line.getStartY() + line.getEndY()) / 2);
    }

    public static void drawPointCounter(Pane pane, Point2D[] points) {
        int counter = 1;

        for (Point2D point : points) {
            Circle temp = new Circle(point.getX(), point.getY(), 5, Color.TRANSPARENT);
            Text text = new Text(point.getX(), point.getY(), "" + counter++);
            pane.getChildren().addAll(temp, text);
        }
    }

    public static boolean containsPoint(ArrayList<Point2D> points, double x, double y) {
        for (Point2D p : points) {
            if (p.getX() == x && p.getY() == y) return true;
        }
        return false;
    }

    public static boolean removePoint(ArrayList<Point2D> points, double x, double y) {

        int index = 0;
        for (Point2D p : points) {
            if (p.getX() == x && p.getY() == y) {
                points.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }

    public static Line copyLine(Line l) {
        return new Line(l.getStartX(), l.getStartY(), l.getEndX(), l.getEndY());
    }


}
