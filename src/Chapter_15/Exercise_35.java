package Chapter_15;

import ToolKit.PaneCollection;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Created by luizsa on 9/23/14.
 */
public class Exercise_35 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        RandomWalkPane pane = new RandomWalkPane();

        Button btStart = new Button("Start");
        btStart.setOnAction(e -> pane.play());

        HBox hButtons = new HBox(btStart);
        hButtons.setAlignment(Pos.CENTER);
        hButtons.setPadding(new Insets(10, 10, 10, 10));

        BorderPane borderPane = new BorderPane(pane, null, null, hButtons, null);
        borderPane.setMinWidth(400);
        borderPane.setMinHeight(400);
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Random Walk");

        pane.setTranslateY(10);
        pane.setTranslateX(10);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }

    private class RandomWalkPane extends Pane {

        private double size = 20;
        private double squareCount = 11;
        private double w = size * squareCount;
        private double h = w;

        private Point2D centerP;
        private Point2D currentP;

        private boolean hasHitBorder;

        // All valid points
        ArrayList<Point2D> points = new ArrayList<>();
        // Line Path
        ArrayList<Line> lines = new ArrayList<>(); // keeps track of the entire path

        Timeline timeline;

        private RandomWalkPane() {
            setPrefWidth(w);
            setPrefHeight(h);

            if (squareCount % 2 == 0) {
                centerP = new Point2D(w / 2, h / 2);
            } else {
                centerP = new Point2D(w / 2 - (size/2), h / 2 - (size/2));
            }
//                centerP = new Point2D(w / 2, h / 2);

            currentP = centerP;
            // above is fine

            drawLayout();
            getChildren().add(new Circle(centerP.getX(), centerP.getY(), 2));
            // Generate path until it hits a border or a dead end
            while (nextPath());

            // Generate Polyline
            timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e-> nextLine()));

            timeline.setCycleCount(lines.size());
        }



        private void drawLayout() {

            // horizontal lines and adding possible points to array
            for (int i = 0; i <= squareCount; i++) {
                Line line = new Line(0, i * size, w, i * size);
                line.setOpacity(0.1);

                // add all possible points
                for (int j = 0; j <= squareCount; j++) {
                    double x = j * size;
                    double y = i * size;

                    points.add(new Point2D(x, y));

                }
                getChildren().add(line);
            }

            // since we start at the center
            // remove center point from points
            if (PaneCollection.containsPoint(points, centerP.getX(), centerP.getY())) {
                PaneCollection.removePoint(points, centerP.getX(), centerP.getY());
            }

            // vertical line
            for (int i = 0; i <= squareCount; i++) {
                Line line = new Line(i * size, 0, i * size, h);

                line.setOpacity(0.1);
                getChildren().add(line);
            }
        }

        private boolean nextPath() {
            // get possible paths
            Point2D[] possiblePs = new Point2D[4];
            possiblePs[0] = new Point2D(currentP.getX(), currentP.getY() - size); // up
            possiblePs[1] = new Point2D(currentP.getX(), currentP.getY() + size); // down
            possiblePs[2] = new Point2D(currentP.getX() - size, currentP.getY()); // left
            possiblePs[3] = new Point2D(currentP.getX() + size, currentP.getY()); // right

            boolean hasMoved = false;
            boolean[] isUsed = new boolean[possiblePs.length];

            for (int i = 0; i < 4;) {
                int ranIndex = (int) (Math.random() * 4);

                if (!isUsed[ranIndex]) {
                    isUsed[ranIndex] = true;
                    i++;
                    Point2D p = possiblePs[ranIndex];
                    if (PaneCollection.containsPoint(points, p.getX(), p.getY())) {

                        // draw path
                        Line line = new Line(
                                currentP.getX(), currentP.getY(),
                                p.getX(), p.getY());
                        currentP = p; // update current Point
                        lines.add(line);

                        // remove point from point tracker
                        PaneCollection.removePoint(points, p.getX(), p.getY());

                        // make the new point the current point
                        // update hasMoved
                        hasMoved = true;
                        checkBorder(currentP);

                        break; // break out of loop early
                    }

                }
            }

            return hasMoved; // return moved status
        }

        private void checkBorder(Point2D p) {
            double x = p.getX();
            double y = p.getY();

            if (x <= 0 || x >= w) hasHitBorder = true;
            if (y <= 0  || y >= h) hasHitBorder = true;
        }


        private int lineIndex = 0;
        private void nextLine() {
            getChildren().add(lines.get(lineIndex++));
        }

        private void play(){
            timeline.play();
        }
    }
}

