package Chapter_15;

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
 * Chapter 15 Exercise :
 * <p>
 * Created by Luiz Arantes Sa on 9/17/14.
 */
public class Exercise_21 extends Application {
    Pane pane = new Pane();
    double width = 400;
    double height = 400;

    @Override
    public void start(Stage primaryStage) {


        Circle c = new Circle(width / 2, height / 2, 100);
        pane.getChildren().add(c);

        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        Circle[] p = new Circle[3];
        Line[] lines = new Line[3];
        Text[] texts = new Text[3];
        for (int i = 0; i < p.length; i++) {

            texts[i] = new Text();
            p[i] = new Circle(0, 0, 5);
            setRandomLocation(p[i], c);

            final int index = i; // for use in lambda expression

            p[i].setOnMouseDragged(e -> {

                double radian = Math.atan2(e.getY() - c.getCenterY(), e.getX() - c.getCenterX());
                double x = c.getCenterX() + c.getRadius() * Math.cos(radian);
                double y = c.getCenterY() + c.getRadius() * Math.sin(radian);
                p[index].setCenterX(x);
                p[index].setCenterY(y);
                updateLines(lines, p, texts);
            });

        }

        for (int i = 0; i < lines.length; i++) {
            int cIndex2 = (i + 1 >= p.length) ? 0 : i + 1;
            lines[i] = new Line(
                    p[i].getCenterX(), p[i].getCenterY(),
                    p[cIndex2].getCenterX(), p[cIndex2].getCenterY());

        }
        updateLines(lines, p, texts);
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
    private void setRandomLocation(Circle tPoint, Circle c) {

        double angle = Math.random() * 360;
        double x = c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(angle));
        double y = c.getCenterY() + c.getRadius() * Math.sin(Math.toRadians(angle));
        tPoint.setCenterX(x);
        tPoint.setCenterY(y);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
