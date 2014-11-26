package ToolKit;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Chapter 14 Exercise 29:
 *
 *      Bean Machine Pane
 *
 * Created by Luiz Arantes Sa on 9/14/14.
 */
public class BeanMachinePane  extends Pane {

    private double mWidth;
    private double mHeight;
    private int triangleSize;
    private int slots;

    /* positions */
    private double centerTopX;
    private double centerTopY;

    private double ballRadius;
    private ArrayList<Circle> balls = new ArrayList<>();

    public BeanMachinePane() {
        mWidth = 800;
        mHeight = 800;
        slots = 8;
        triangleSize = circleCount(slots);
        paintBeanMachine();
        dropBall();
    }

    public double getW() {
        return mWidth;
    }

    public void setW(double width) {
        paintBeanMachine();
        mWidth = width;
    }

    public double getH() {
        return mHeight;
    }

    public void setH(double height) {
        paintBeanMachine();
        mHeight = height;
    }

    private void paintBeanMachine() {

        // Draw lower line
        Line lowerLine = new Line(mWidth * 0.2, mHeight * 0.8, mWidth * 0.8, mHeight * 0.8);

        // distance gap per circle
        double distance = (lowerLine.getEndX() - lowerLine.getStartX()) / slots;
        ballRadius = distance / 2;

        // Draw triangle circles
        Circle[] circles = new Circle[triangleSize];
        int index = 0;
        for (int i = 1; i < slots; i++) {

            double x = lowerLine.getStartX() + (i * distance * 0.50) + distance / 2;
            double y = lowerLine.getStartY() - (distance * i) - distance / 2;

            for (int j = 0; j < slots - i; j++) {
                circles[index++] = new Circle(x, y, mWidth * 0.012, Color.BLUE);
                x += distance;
            }
        }

        distance = distance + (distance / 2) - circles[0].getRadius();
        // Connect the base of the triangle with lowerLine
        // NOT including left most and right most line
        Line[] lines = new Line[slots-1];
        for (int i = 0; i < slots - 1; i++) {
            double x1 = circles[i].getCenterX() + circles[i].getRadius() * Math.sin(Math.PI);
            double y1 = circles[i].getCenterY() - circles[i].getRadius() * Math.cos(Math.PI);
            lines[i] = new Line(
                    x1, y1, // start point
                    x1, y1 + distance); // end point

        }
        // Draw right most and left most most line
        Line[] sides = new Line[6];
        sides[0] = new Line(
                lowerLine.getEndX(), lowerLine.getEndY(),
                lowerLine.getEndX(), lowerLine.getEndY() - distance);
        sides[1] = new Line(
                lowerLine.getStartX(), lowerLine.getStartY(),
                lowerLine.getStartX(), lowerLine.getStartY() - distance);

        // Draw left side line
        for (int i = 2; i < 4; i++) {
            double x = circles[circles.length - i].getCenterX();
            double y = circles[circles.length - i].getCenterY() - distance;
            sides[i] = new Line(x, y, sides[i - 2].getEndX(), sides[i - 2].getEndY());
        }

        // Draw the upper 2 lines on top of the triangle
        for (int i = 4; i < sides.length; i++) {
            sides[i] = new Line(
                    sides[i-2].getStartX(), sides[i-2].getStartY(),
                    sides[i-2].getStartX(), sides[i-2].getStartY() - (distance * 0.6)
            );
        }

        getChildren().addAll(lowerLine);
        Collections.addAll(getChildren(), circles);
        Collections.addAll(getChildren(), lines);
        Collections.addAll(getChildren(), sides);
    }

    private int circleCount(int slots) {
        int count = 0;
        while (--slots != 0) {
            count += slots;
        }
        return count;
    }

    private void dropBall() {
        balls.add(new Circle(420, 180, ballRadius / 2 / 2));
        getChildren().addAll(balls);

    }

    private void generatePath() {

        Polyline linePath = new Polyline();
        for (int i = 0; i < slots * 2; i++) {

        }
    }


}
