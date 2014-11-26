package Chapter_14;

import ToolKit.MyPoint;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Chapter 14 Exercise 11:
 *
 *  (Paint a smiley face)
 *  Write a program that paints a smiley face, as shown in
 *  Figure 14.46a.
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_11 extends Application {

    private static final int CENTER_Y = 200;
    private static final int CENTER_X = 200;
    private static final int RADIUS = 100;

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        ArrayList<Shape> shapes = new ArrayList<>();

        // Outer circle of the smiley face
        Circle c = new Circle(CENTER_X, CENTER_Y, RADIUS, Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        shapes.add(c);

        // drawing the nose
        Line[] nose = createFixedNose(c);
        Collections.addAll(shapes, nose);

        // drawing left and right eye
        double y =  CENTER_Y - (RADIUS / 2.8);
        double x = CENTER_X - (RADIUS / 2.8);
        for (int i = 0; i < 2; i++) {
            Ellipse outerC = new Ellipse(x, y, RADIUS / 4, RADIUS / 6);
            outerC.setFill(Color.TRANSPARENT);
            outerC.setStroke(Color.BLACK);
            shapes.add(outerC);

            Circle pupil = new Circle(outerC.getCenterX(), outerC.getCenterY(), outerC.getRadiusY() / 1.2);
            shapes.add(pupil);
            x += (RADIUS / 2.8) * 2;
        }

        // drawing the face's smile
        Arc smile = new Arc(
                c.getCenterX(), // center x
                c.getCenterY() + (c.getRadius() / 3), // center y
                c.getRadius() / 2, // x radius
                c.getRadius() / 2 / 2, // y radius
                180, 180); // start point and length
        smile.setFill(Color.TRANSPARENT);
        smile.setStroke(Color.BLACK);
        shapes.add(smile);


        pane.getChildren().addAll(shapes);
        Scene scene = new Scene(pane, CENTER_X + RADIUS * 2, CENTER_Y + RADIUS * 2);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Smiley Face!");
        primaryStage.show();
    }

    /**
     * returns 3 Lines that shape a fixed triangle based
     * from the circle's center point and radius
     * **/
    private Line[] createFixedNose(Circle c) {
        MyPoint p1 = new MyPoint(c.getCenterX() - (c.getRadius() / 4), c.getCenterY() + (c.getRadius() / 4));
        MyPoint p2 = new MyPoint(c.getCenterX() + (c.getRadius() / 4), c.getCenterY() + (c.getRadius() / 4));
        MyPoint p3 = new MyPoint(c.getCenterX(), c.getCenterY() - (c.getRadius() / 4));

        Line[] lines = new Line[3];
        lines[0] = new Line(p1.x, p1.y, p2.x, p2.y);
        lines[1] = new Line(p2.x, p2.y, p3.x, p3.y);
        lines[2] = new Line(p3.x, p3.y, p1.x, p1.y);

        return lines;
    }



    public static void main(String[] args) {
        Application.launch(args);
    }
}
