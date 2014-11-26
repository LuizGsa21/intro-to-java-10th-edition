package Chapter_15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 22:
 *
 *  (Connect two circles)
 *  Write a program that draws two circles with radius 15 pixels,
 *  centered at random locations, with a line connecting the two
 *  circles. The line should not cross inside the circles,
 *  as shown in Figure 14.49c.
 *
 * Created by Luiz Arantes Sa on 9/17/14.
 */
public class Exercise_22 extends Application {

    Pane pane = new Pane();


    @Override
    public void start(Stage primaryStage) {
        double width = 400;
        double height = 400;

        Ellipse ellipse = new Ellipse();
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.TRANSPARENT);
        ellipse.centerXProperty().bind(pane.widthProperty().multiply(0.5));
        ellipse.centerYProperty().bind(pane.heightProperty().multiply(0.20));
        ellipse.radiusXProperty().bind(pane.widthProperty().multiply(0.25));
        ellipse.radiusYProperty().bind(pane.heightProperty().multiply(0.1));


        Arc bottomUpperArc = createArc(0, 180);
        bottomUpperArc.getStrokeDashArray().addAll(6.0, 21.0);

        Arc bottomArc = createArc(180, 180);

        Line leftLine = new Line();
        leftLine.startXProperty().bind(ellipse.centerXProperty().subtract(ellipse.radiusXProperty()));
        leftLine.startYProperty().bindBidirectional(ellipse.centerYProperty());
        leftLine.endXProperty().bind(bottomArc.centerXProperty().subtract(bottomArc.radiusXProperty()));
        leftLine.endYProperty().bind(bottomArc.centerYProperty());

        Line rightLine = new Line();
        rightLine.startXProperty().bind(ellipse.centerXProperty().add(ellipse.radiusXProperty()));
        rightLine.startYProperty().bindBidirectional(ellipse.centerYProperty());
        rightLine.endXProperty().bind(bottomArc.centerXProperty().add(bottomArc.radiusXProperty()));
        rightLine.endYProperty().bind(bottomArc.centerYProperty());

        ObservableList<Node> list = pane.getChildren();
        list.addAll(ellipse, bottomArc, bottomUpperArc, leftLine, rightLine);

        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.setTitle("Cylinder");
        primaryStage.show();
    }

    private Arc createArc(double startAngle, double length) {
        Arc arc = new Arc(0, 0, 0, 0, startAngle, length);
        arc.setStroke(Color.BLACK);
        arc.setFill(Color.TRANSPARENT);
        arc.centerXProperty().bind(pane.widthProperty().multiply(0.5));
        arc.centerYProperty().bind(pane.heightProperty().multiply(0.80));
        arc.radiusXProperty().bind(pane.widthProperty().multiply(0.25));
        arc.radiusYProperty().bind(pane.heightProperty().multiply(0.1));
        return arc;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
