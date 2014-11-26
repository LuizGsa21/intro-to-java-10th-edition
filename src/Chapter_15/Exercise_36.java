package Chapter_15;

import ToolKit.PaneCollection;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 *
 * (Simulation: self-avoiding random walk)
 * Write a simulation program to show that the chance
 * of getting dead-end paths increases as the grid size increases.
 * Your program simulates lattices with size from 10 to 80.
 * For each lattice size, simulate a self-avoiding random walk 10,000
 * times and display the probability of the dead-end paths,
 * as shown in the following sample output:
 *
 * Created by luizsa on 9/23/14.
 */
public class Exercise_36 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        double limit = 10000;
        for (int i = 11; i <= 80; i++) {

            int deadEndCount = 0;

            for (int j = 0; j < limit; j++) {

                RandomWalkPane pane = new RandomWalkPane(i,i);
                if (!pane.hasHitBorder()) {
                    deadEndCount++;
                }
            }

            String probability = String.format("%.1f", deadEndCount / limit * 100.0);

            System.out.println(
                    "For a lattice of size "+i+", the probability of dead-end paths is "+ probability);
        }

    }


    public static void main(String[] args) {
        Application.launch(args);


    }

    private class RandomWalkPane extends Pane {

        private double size;
        private double squareCount;
        private double w;
        private double h;
        private Point2D centerP;
        private Point2D currentP;

        private boolean hasHitBorder;

        // All valid points
        ArrayList<Point2D> points = new ArrayList<>();
        // Line Path
        ArrayList<Line> lines = new ArrayList<>(); // keeps track of the entire path

        Timeline timeline;

        private RandomWalkPane(double size, double squareCount) {

            this.size = size;
            this.squareCount = squareCount;
            w = size * squareCount;
            h = w;
            if (squareCount % 2 == 0) {
                centerP = new Point2D(w / 2, h / 2);
            } else {
                centerP = new Point2D(w / 2 + (size/2), h / 2 - (size/2));
            }
            currentP = centerP;

            setPrefWidth(w);
            setPrefHeight(h);
            drawLayout();

            // Generate path until it hits a border or a dead end
            while (nextPath() && !hasHitBorder) ;


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
            PaneCollection.removePoint(points, centerP.getX(), centerP.getY());

            // vertical line
            for (int i = 0; i < squareCount; i++) {
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

            for (int i = 0; i < 4; ) {
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
                        checkBorder(currentP);
                        // remove point from point tracker
                        PaneCollection.removePoint(points, p.getX(), p.getY());

                        // make the new point the current point
                        // update hasMoved
                        hasMoved = true;

                        break; // break out of loop early
                    }

                }
            }

            return hasMoved; // return moved status
        }

        private void checkBorder(Point2D p) {
            double x = p.getX();
            double y = p.getY();


            if (x <= 1 || x >= w - 1) hasHitBorder = true;
            if (y <= 1 || y >= h - 1) hasHitBorder = true;

        }




        private int lineIndex = 0;

        private void nextLine() {
            getChildren().add(lines.get(lineIndex++));
        }

        private void play() {
            if (timeline == null) {
                timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {

                    nextLine();

                }));
                timeline.setCycleCount(lines.size());
            }
            timeline.play();
        }

        public boolean hasHitBorder() {
            return hasHitBorder;
        }
    }
}
