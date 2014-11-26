package Chapter_15;

import ToolKit.MyPoint;
import ToolKit.PaneCollection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 16:
 *
 *      (Two movable vertices and their distances)
 *      Write a program that displays two circles with radius 10 at location
 *      (40, 40) and (120, 150) with a line connect- ing the two circles,
 *      as shown in Figure 15.28b. The distance between the circles is displayed
 *      along the line. The user can drag a circle. When that happens, the circle
 *      and its line are moved and the distance between the circles is updated.
 *
 * Created by Luiz Arantes Sa on 9/16/14.
 */
public class Exercise_16 extends Application {

    Boolean isFocusedOnC1 = false;
    Boolean isFocusedOnC2 = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        double width = 400;
        double height = 400;
        double radius = 15;

        Circle c1 = new Circle(40, 40, radius, Color.TRANSPARENT);
        c1.setStroke(Color.BLACK);
        Text txt1 = new Text(c1.getCenterX(), c1.getCenterY(), "1");
        txt1.xProperty().bind(c1.centerXProperty());
        txt1.yProperty().bind(c1.centerYProperty());

        Circle c2 = new Circle(120, 150, radius, Color.TRANSPARENT);
        c2.setStroke(Color.BLACK);
        Text txt2 = new Text(c2.getCenterX(), c2.getCenterY(), "2");
        txt2.xProperty().bind(c2.centerXProperty());
        txt2.yProperty().bind(c2.centerYProperty());

        Text txtPoint = new Text();
        Line line = new Line();
        updateLine(line, c1, c2, txtPoint);

        c1.setOnMouseDragged(e-> {
            double x = e.getX();
            double y = e.getY();
            c1.setCenterX(x);
            c1.setCenterY(y);
            updateLine(line, c1, c2, txtPoint);

        });

        c2.setOnMouseDragged(e-> {
            double x = e.getX();
            double y = e.getY();
            c2.setCenterX(x);
            c2.setCenterY(y);
            updateLine(line, c1, c2, txtPoint);

        });

        pane.getChildren().addAll(txt1, txt2, c1, c2, line, txtPoint);
        primaryStage.setTitle("Draw Two Circle");
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.show();
    }

    /** Connect two circles centered at (x1, y1) and (x2, y2) */
    private void updateLine(Line line, Circle c1, Circle c2, Text txtPoint) {

        double x1 = c1.getCenterX();
        double y1 = c1.getCenterY();
        double x2 = c2.getCenterX();
        double y2 = c2.getCenterY();
        double radius = c1.getRadius();

        double d = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        int x11 = (int) (x1 - radius * (x1 - x2) / d);
        int y11 = (int) (y1 - radius * (y1 - y2) / d);
        int x21 = (int) (x2 + radius * (x1 - x2) / d);
        int y21 = (int) (y2 + radius * (y1 - y2) / d);

        line.setStartX(x11);
        line.setStartY(y11);
        line.setEndX(x21);
        line.setEndY(y21);
        txtPoint.setText(String.format("%.2f", PaneCollection.distance(line)));
        MyPoint p = PaneCollection.getCenterPoint(line);
        txtPoint.setX(p.x);
        txtPoint.setY(p.y);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
