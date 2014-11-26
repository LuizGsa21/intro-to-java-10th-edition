package Chapter_14;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Chapter 14 Exercise 10:
 *
 *      (Display a cylinder)
 *      Write a program that draws a cylinder, as shown in Figure 14.45b.
 *      You can use the following method to set the dashed stroke for an arc:
 *      Display a random matrix
 *
 *      arc.getStrokeDashArray().addAll(6.0, 21.0);
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_10 extends Application {

    // Top ellipse center point
    private static final int CENTER_Y = 75;
    private static final int CENTER_X = 150;

    private static final int RADIUS_X = 100;
    private static final int RADIUS_Y = 50;
    private static final int CYLINDER_HEIGHT = 200;

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        ArrayList<Node> shapes = new ArrayList<>();
        // top ellipse
        Ellipse ellipse = new Ellipse(CENTER_X, CENTER_Y, RADIUS_X, RADIUS_Y);
        ellipse.setFill(Color.rgb(0, 0, 0, 0)); // opaque fill
        ellipse.setStroke(Color.BLACK);
        shapes.add(ellipse);

        // bottom - top-half circle (dashed lines)
        Arc arc1 = createArc(0, 180);
        arc1.getStrokeDashArray().addAll(6.0, 21.0); // making the arc dashed
        shapes.add(arc1);

        // bottom - bottom-half circle (non-dashed lines)
        Arc arc2 = createArc(180, 180);
        shapes.add(arc2);

        // Creating two lines to connect the upper and lower ellipses
        Line line1 = new Line(CENTER_X - RADIUS_X, CENTER_Y, // starting point
                              arc2.getCenterX() - RADIUS_X, arc2.getCenterY()); // ending point
        shapes.add(line1);
        Line line2 = new Line(CENTER_X + RADIUS_X, CENTER_Y,
                arc2.getCenterX() + RADIUS_X, arc2.getCenterY());
        shapes.add(line2);

        pane.getChildren().addAll(shapes);
        Scene scene = new Scene(pane, RADIUS_X * 3, CYLINDER_HEIGHT + 150);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Cylinder");
        primaryStage.show();
    }

    private Arc createArc(double startAngle, double length) {

        Arc arc = new Arc(CENTER_X, CENTER_Y + CYLINDER_HEIGHT, RADIUS_X, RADIUS_Y, startAngle, length);
        arc.setFill(Color.rgb(0, 0, 0, 0)); // opaque fill
        arc.setStroke(Color.BLACK);
        return arc;
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
