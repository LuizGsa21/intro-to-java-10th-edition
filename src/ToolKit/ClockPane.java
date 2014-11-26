package ToolKit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 * Chapter 14 Exercise 26:
 *
 * Taken from the book example.
 */
public class ClockPane extends Pane {

    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;
    private Timeline timeline;

    // Clock pane's width and height
    private double w = 250, h = 250;

    /** Construct a default clock with the current time*/
    public ClockPane() {
        setPrefHeight(h);
        setPrefWidth(w);
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        setCurrentTime();
    }

    /** Construct a clock with specified hour, minute, and second */
    public ClockPane(int hour, int minute, int second) {
        this();
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
    }

    public ClockPane(int hour, int minute, int second, double width, double height) {
        this(hour, minute, second);
        this.w = width;
        this.h = height;
        paintClock();
    }

    /** Return hour */
    public int getHour() {
        return hour;
    }

    /** Set a new hour */
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    /** Return minute */
    public int getMinute() {
        return minute;
    }

    /** Set a new minute */
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    /** Return second */
    public int getSecond() {
        return second;
    }

    /** Set a new second */
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    /** Return clock pane's width */
    public double getW() {
        return w;
    }

    /** Set clock pane's width */
    public void setW(double w) {
        this.w = w;
        paintClock();
    }

    /** Return clock pane's height */
    public double getH() {
        return h;
    }

    /** Set clock pane's height */
    public void setH(double h) {
        this.h = h;
        paintClock();
    }

    public boolean isHourHandVisible() {
        return hourHandVisible;
    }

    public void setHourHandVisible(boolean hourHandVisible) {
        this.hourHandVisible = hourHandVisible;
        paintClock();
    }

    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }

    public void setMinuteHandVisible(boolean minuteHandVisible) {
        this.minuteHandVisible = minuteHandVisible;
        paintClock();
    }

    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }

    public void setSecondHandVisible(boolean secondHandVisible) {
        this.secondHandVisible = secondHandVisible;
        paintClock();
    }

    /* Set the current time for the clock */
    public void setCurrentTime() {
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock(); // Repaint the clock
    }

    /** Paint the clock */
    private void paintClock() {
        // Initialize clock parameters
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;
        Point2D center = new Point2D(centerX, centerY);
        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Draw time numbers
        Text[] texts = new Text[12];
        for (int i = 0; i < 12; i++) {
            int time = (i + 3 > 12) ? i + 3 - 12 : i + 3;
            Point2D b = new Point2D(
                    centerX + clockRadius * Math.cos(i * 2 * Math.PI / 12),
                    centerY + clockRadius * Math.sin(i * 2 * Math.PI / 12));
            b = getPointBCloserToA(center, b, 0.82);
            texts[i] = new Text(b.getX() - (clockRadius * 0.03125), b.getY() + (clockRadius * 0.025), "" + time);
        }

        // Draw dashes
        Line[] dashes = new Line[60];
        for (int i = 0; i < dashes.length; i++) {
            Point2D start = new Point2D(
                    centerX + clockRadius * Math.cos(i * 2 * Math.PI / 60),
                    centerY + clockRadius * Math.sin(i * 2 * Math.PI / 60));
            double coefficient = (i % 5 == 0) ? 0.91 : 0.955;
            Point2D end = getPointBCloserToA(center,start, coefficient);
            dashes[i] = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        }

        // Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength *
                Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength *
                Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);
        sLine.setVisible(isSecondHandVisible());

        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *
                Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
                Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);
        mLine.setVisible(isMinuteHandVisible());

        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);
        hLine.setVisible(isHourHandVisible());
        // Draw time HH:MM:SS
        String s = "" + getHour() + ":" + getMinute() + ":" + getSecond();
        Text timeText = new Text(getW() * 0.4, getH() - 10, s);

        // Adding nodes to pane
        getChildren().clear();
        ObservableList<Node> list = getChildren();
        list.add(circle);
        Collections.addAll(list, dashes);
        Collections.addAll(list, texts);
        list.addAll(sLine, mLine, hLine, timeText);
    }

    public void start(){
        timeline.play();
    }

    public void stop(){
        timeline.pause();
    }

    private void update(){
        setCurrentTime();
        paintClock();
    }

    private Point2D getPointBCloserToA(Point2D a, Point2D b, double coefficient) {

        double deltaX = b.getX() - a.getX();
        double deltaY = b.getY() - a.getY();

        return new Point2D(
                a.getX() + coefficient * deltaX,
                a.getY() + coefficient * deltaY);
    }
}
