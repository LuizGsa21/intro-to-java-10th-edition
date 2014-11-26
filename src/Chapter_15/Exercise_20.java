package Chapter_15;

import ToolKit.PaneCollection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 20:
 *
 *  (Geometry: display angles)
 *  Write a program that enables the user to drag the
 *  vertices of a triangle and displays the angles dynamically
 *  as the triangle shape changes, as shown in Figure 15.30a.
 *  The formula to compute angles is given in Listing 4.1.
 *
 * Created by Luiz Arantes Sa on 9/17/14.
 */
public class Exercise_20 extends Application {

    Pane pane = new Pane();
    double width = 400;
    double height = 400;

    @Override
    public void start(Stage primaryStage) {


        Circle[] p = new Circle[3];
        Line[] lines = new Line[3];
        Text[] texts = new Text[3];
        for (int i = 0; i < p.length; i++) {
            p[i] = new Circle(0,0,10);
            setRandomLocation(p[i]);
            texts[i] = new Text();
            final int index = i; // for use in lambda expression
            p[i].setOnMouseDragged(e-> {
                p[index].setCenterX(e.getX());
                p[index].setCenterY(e.getY());
                updateLines(lines, p, texts);
            });

        }
        for (int i = 0; i < lines.length; i++) {
            int cIndex2 = (i + 1 >= p.length) ? 0 : i + 1;
            lines[i] = new Line(
                    p[i].getCenterX(), p[i].getCenterY(),
                    p[cIndex2].getCenterX(), p[cIndex2].getCenterY());

        }
        updateLines(lines,p,texts);
        pane.getChildren().addAll(lines);
        pane.getChildren().addAll(texts);
        pane.getChildren().addAll(p);
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.setTitle("Game: eye-hand coordination");
        primaryStage.show();
    }

    private void updateLines(Line[] lines, Circle[] p, Text[] angles) {
        for (int i = 0; i < lines.length; i++) {

            int cIndex2 = (i + 1 >= p.length) ? 0 : i + 1;
            lines[i].setStartX(p[i].getCenterX());
            lines[i].setStartY(p[i].getCenterY());
            lines[i].setEndX(p[cIndex2].getCenterX());
            lines[i].setEndY(p[cIndex2].getCenterY());
            angles[i].setX(p[i].getCenterX() + 5);
            angles[i].setY(p[i].getCenterY() - 5);

        }

        double a = PaneCollection.distance(lines[0]);
        double b = PaneCollection.distance(lines[1]);
        double c = PaneCollection.distance(lines[2]);

        double A = Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
        angles[2].setText(String.format("%.2f 1", A));

        double B = Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2 * a * c)));
        angles[0].setText(String.format("%.2f 2", B));

        double C = Math.toDegrees(Math.acos((c * c - b * b - a * a) / (-2 * a * b)));
        angles[1].setText(String.format("%.2f 3", C));



    }
    private void setRandomLocation(Circle c) {

        double min = c.getRadius() + 5;
        double max = width - c.getRadius() - 5;
        c.setCenterX((Math.random() * (max - min) + min));
        max = height - c.getRadius() - 5;
        c.setCenterY((Math.random() * (max - min) + min));

    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}
