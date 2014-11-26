package Chapter_15;

import ToolKit.PaneCollection;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * (Simulation: self-avoiding random walk)
 * A self-avoiding walk in a lattice is a path from one point to another
 * that does not visit the same point twice. Self- avoiding walks have applications
 * in physics, chemistry, and mathematics. They can be used to model chain-like
 * entities such as solvents and polymers. Write a program that displays a random
 * path that starts from the center and ends at a point on the boundary, as shown
 * in Figure 15.37a or ends at a dead-end point (i.e., surrounded by four points that
 * have already been visited), as shown in Figure 15.37b. Assume the size of the lattice
 * is 16 by 16.
 * <p>
 * Created by luizsa on 9/23/14.
 */
public class Exercise_34 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        RandomWalkPane pane = new RandomWalkPane();

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Random Walk");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }

    private class RandomWalkPane extends Pane {

        private double size = 20;
        private double squareCount = 16;
        private double w = size * squareCount;
        private double h = w;
        private Point2D centerP = new Point2D(w / 2, h / 2);
        private Point2D currentP = centerP;

        private boolean hasHitBorder;

        // All valid points
        ArrayList<Point2D> points = new ArrayList<>();
        // Line Path
        //ArrayList<Line> lines = new ArrayList<>();

        private RandomWalkPane() {

            setPrefWidth(w);
            setPrefHeight(h);

            drawLayout();

            while (nextPath() && !hasHitBorder);
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
                        getChildren().add(line);

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
    }
}
