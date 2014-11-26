package ToolKit;

import javafx.animation.PathTransition;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 *
 * Chapter 15 Exercise 15
 * Created by luizsa on 9/22/14.
 */
public class TBeanMachinePane extends Pane {

    // Bean machine measurements
    double w = 800; // Pane default width
    double h = 800; // Pane default height
    double gap; // distance gap between slot lines
    double radius; // peg's radius
    double dropX; // Drop ball starting x point
    double dropY; // Drop ball starting y point  //
    int numOfSlots; // numbers of slots

    // Line's sequence drawn matters
    Line baseLine;
    Line leftSLine; // left side line (bottom left)
    Line rightSLine; //  right side line (bottom right)
    Line[] cSlotLines; // center slot lines
    Line midLeftSLine; // middle left line
    Line midRightSLine; // middle right line
    Line topLeftSLine; // top left line
    Line topRightSLine; // top right line


    // Triangle pegs
    Circle[] pegs; // PEEGGSSSSS

    // Dropped balls
    ArrayList<Circle> balls;
    ArrayList<Circle> fineshedBalls;
    ArrayList<Polyline> ballPaths;

    // Animation
    ArrayList<PathTransition> mPathTransitions = new ArrayList<>();

    private TBeanMachinePane() {
        baseLine = new Line();
        baseLine.translateYProperty().bind(translateXProperty());
        leftSLine = new Line();
        rightSLine = new Line();
        midLeftSLine = new Line();
        midRightSLine = new Line();
        topLeftSLine = new Line();
        topRightSLine = new Line();
        balls = new ArrayList<>();
        fineshedBalls = new ArrayList<>();
        ballPaths = new ArrayList<>();
    }

    public TBeanMachinePane(int slots, double width, double height) {
        this();
        initSlotLinesAndPegs(slots); // All layout nodes are initialized after this point

        numOfSlots = slots;
        setMinWidth(w = width);
        setMinHeight(h = height);
        setMaxSize(width, height);

        drawLayout();
        addLayoutShapes();

    }

    public void dropBall() {
        Circle ball = new Circle(dropX, dropY, radius);
        Polyline polyline = generatePath();
        ObservableList<Double> list = polyline.getPoints();
        double x = list.get(list.size() - 2);
        double y = list.get(list.size() - 1);
        fineshedBalls.add(new Circle(x, y, radius));

        ballPaths.add(polyline);
        balls.add(ball);


        PathTransition path = new PathTransition(Duration.seconds(8), polyline, ball);

        mPathTransitions.add(path);
        path.setDelay(Duration.seconds(mPathTransitions.size()));

        getChildren().addAll(ball);
        //getChildren().addAll(polyline);
        path.play();
    }

    private Polyline generatePath() {
        // dropped ball's beginning x and y point
        final int X = 0;
        final int Y = 1;
        double[] p = new double[]{dropX, dropY };

        // the polyline will track the ball's path
        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();

        // Adding start point to the polyline
        list.addAll(p[X], p[Y]);

        // While the ball hasn't reached the end

        while (!isAtEnd(p[Y]) ) {

            // while the ball hasn't hit a boundary: keep falling...
            if (!hasBouncedOnPeg(p[X], p[Y]) && !hasBouncedOnBall(p[X], p[Y])) {

                p[Y] = moveDown(p[Y]);
                list.addAll(p[X], p[Y]);

            }
            // If the ball didn't bounce on another ball
            else if (hasBouncedOnPeg(p[X], p[Y]) || hasBouncedOnBall(p[X], p[Y])){

                // If both sides are clear than make a random turn
                if (isClearLeft(p[X], p[Y]) && isClearRight(p[X], p[Y])) {
                    p = ((int) (Math.random() * 2) == 1) ? rightArc(list, p[X], p[Y]) : leftArc(list, p[X], p[Y]);
                }
                // else if left side is clear make a left turn
                else if (isClearLeft(p[X], p[Y])) {
                    p = leftArc(list, p[X], p[Y]);
                }
                // else if right side is clear make a right turn
                else if (isClearRight(p[X], p[Y])) {
                    p = rightArc(list, p[X], p[Y]);

                } else {
                    // if statement reaches here its a dead end
                    break;
                }
            }

        }

        return polyline;
    }

    private boolean hasBouncedOnPeg(double x, double y) {

        for (Circle c : pegs) {
            if (c.contains(x, y + radius * 1.59999999)) {
                //getChildren().add(new Circle(x, y + radius * 2, 1));
                return true;
            }
        }
        return false;
    }

    private double[] rightArc(ObservableList<Double> list, double startX, double startY) {
        double angle = 90;
        double x = 0;
        double y = 0;
        double arcRadius = radius * 2;
        for (int i = 0; i < 90; i++) {
            x = startX + arcRadius * Math.cos(Math.toRadians(angle));
            y = (startY + arcRadius) - arcRadius * Math.sin(Math.toRadians(angle));
            list.addAll(x,y);
            angle--;
        }
        return new double[]{x,y};
    }

    private double[] leftArc(ObservableList<Double> list, double startX, double startY) {

        double angle = 90;
        double x = 0;
        double y = 0;
        double arcRadius = radius * 2;

        for (int i = 0; i < 90; i++) {
            x = startX + arcRadius * Math.cos(Math.toRadians(angle));
            y = (startY + arcRadius) - arcRadius * Math.sin(Math.toRadians(angle));
            list.addAll(x,y);
            angle++;
        }

        return new double[]{x,y};
    }

    private boolean isClearLeft(double x, double y) {
        double limitX = x - radius * 2;

        if (limitX < baseLine.getStartX()) return false;
        for (Circle peg : pegs) {

            if (peg.contains(limitX, y) || !isInsideBeanMachine(limitX, y)) {
                return false;
            }
        }
        for (Circle c : balls) {
            if (c.contains(limitX, y) || !isInsideBeanMachine(limitX, y)) {
                return false;
            }
        }


        return true;
    }


    private boolean isClearRight(double x, double y) {
        double limitX = x + radius * 2;
        if (limitX > baseLine.getEndX()) return false;

        for (Circle peg : pegs) {

            if (peg.contains(limitX, y) || !isInsideBeanMachine(limitX, y)) {
                return false;
            }
        }
        for (Circle c : balls) {
            if (c.contains(limitX, y) || !isInsideBeanMachine(limitX, y)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInsideBeanMachine(double x, double y) {

        if (y < pegs[pegs.length - 1].getCenterY()) return true;

        MyPoint p1 = new MyPoint(leftSLine.getEndX(), leftSLine.getEndY());
        MyPoint p2 = new MyPoint(rightSLine.getEndX(), rightSLine.getEndY());
        MyPoint p3 = new MyPoint(
                pegs[pegs.length - 1].getCenterX(),
                pegs[pegs.length - 1].getCenterY());

        return (new Triangle2D(p1, p2, p3).contains(x, y));
    }


    private boolean isAtEnd(double y) {
        return y >= baseLine.getEndY() - radius * 2;
    }

    private boolean hasBouncedOnBall(double x, double y) {
        for (Circle c : fineshedBalls) {

            if (c.contains(x, y + radius * 2)) {
                return true;
            }
        }
        return false;
    }

    private double moveDown(double y){
        return y + radius;
    }

    private void drawLayout() {
        // sequence matters...
        drawBase();
        drawLeftAndRightSide();
        drawSlotLines();
        drawPegs();
        drawMidLeftAndRightSide();
        drawTopLeftAndRightSide();
        dropX = pegs[pegs.length - 1].getCenterX();
        dropY = pegs[pegs.length - 1].getCenterY() - radius * 18;

    }

    private void addLayoutShapes() {
        getChildren().addAll(
                baseLine,
                leftSLine,
                rightSLine,
                midLeftSLine,
                midRightSLine,
                topLeftSLine,
                topRightSLine
                );
        getChildren().addAll(pegs);
        getChildren().addAll(cSlotLines);
    }

    private void drawTopLeftAndRightSide() {
        topLeftSLine.setStartX(midLeftSLine.getEndX());
        topLeftSLine.setStartY(midLeftSLine.getEndY());

        topLeftSLine.setEndX(midLeftSLine.getEndX());
        topLeftSLine.setEndY(midLeftSLine.getEndY() - (radius * 5));

        topRightSLine.setStartX(midRightSLine.getEndX());
        topRightSLine.setStartY(midRightSLine.getEndY());

        topRightSLine.setEndX(midRightSLine.getEndX());
        topRightSLine.setEndY(midRightSLine.getEndY() - (radius * 5));

    }

    private void drawMidLeftAndRightSide() {
        midLeftSLine.setStartX(leftSLine.getEndX());
        midLeftSLine.setStartY(leftSLine.getEndY());
        midLeftSLine.setEndX(pegs[pegs.length - 3].getCenterX() - radius);
        midLeftSLine.setEndY(pegs[pegs.length - 1].getCenterY());

        midRightSLine.setStartX(rightSLine.getEndX());
        midRightSLine.setStartY(rightSLine.getEndY());
        midRightSLine.setEndX(pegs[pegs.length - 2].getCenterX() + radius);
        midRightSLine.setEndY(pegs[pegs.length - 1].getCenterY());

    }

    private void drawPegs() {
        // Draw triangle circles
        int index = 0;
        radius = gap / 4;
        for (int i = 1; i < numOfSlots; i++) {

            double x = leftSLine.getEndX();
            double y = leftSLine.getEndY() - radius * 1.5;
            double distanceX = gap * (i - 1) / 2 + gap;
            double distanceY = gap * (i - 1);

            for (int j = 0; j < numOfSlots - i; j++) {

                pegs[index].setCenterX(x + distanceX);
                pegs[index].setCenterY(y - distanceY);
                pegs[index].setFill(Color.TRANSPARENT);
                pegs[index].setStroke(Color.BLACK);
                pegs[index++].setRadius(radius);
                x += gap;
            }
        }
    }

    private void drawBase() {
        double y = h * 0.9;
        double x = w * 0.2;
        double length = w * 0.6;

        baseLine.setStartX(x);
        baseLine.setStartY(y);
        baseLine.setEndX(x + length);
        baseLine.setEndY(y);
    }

    private void drawLeftAndRightSide() {
        // left side
        double x = baseLine.getStartX();
        double y = baseLine.getStartY();
        double length = h * 0.12;

        leftSLine.setStartX(x);
        leftSLine.setStartY(y);
        leftSLine.setEndX(x);
        leftSLine.setEndY(y - length);

        // Right side
        x = baseLine.getEndX();
        y = baseLine.getEndY();
        rightSLine.setStartX(x);
        rightSLine.setStartY(y);
        rightSLine.setEndX(x);
        rightSLine.setEndY(y - length);
    }

    private void drawSlotLines() {
        // start after the leftSLine and increment
        // and increment until second to last line is reached
        gap = PaneCollection.distance(baseLine) / numOfSlots; // gap between each each slot

        for (int i = 0; i < cSlotLines.length; i++) {
            double distance = gap * (i + 1);
            cSlotLines[i].setStartX(leftSLine.getStartX() + distance);
            cSlotLines[i].setStartY(leftSLine.getStartY());
            cSlotLines[i].setEndX(leftSLine.getEndX() + distance);
            cSlotLines[i].setEndY(leftSLine.getEndY());
        }
    }

    private void initSlotLinesAndPegs(int slots) {
        cSlotLines = new Line[slots - 1];
        for (int i = 0; i < cSlotLines.length; i++) {
            cSlotLines[i] = new Line();
        }
        pegs = new Circle[circleCount(slots)];
        for (int i = 0; i < pegs.length; i++) {
            pegs[i] = new Circle();
        }
    }

    private int circleCount(int slots) {
        int count = 0;
        while (--slots != 0) {
            count += slots;
        }
        return count;
    }

}
