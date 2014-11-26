package ToolKit;

import javafx.scene.shape.Rectangle;

/**
 * Chapter 10 Exercise :
 * <p>
 * Created by Luiz Arantes Sa on 9/5/14.
 */
public class MyRectangle2D extends GeometricObject {

    private static final int X = 0;
    private static final int Y = 1;

    public double centerX;
    public double centerY;

    public double width;
    public double height;

    public MyRectangle2D(double centerX, double centerY, double width, double height) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
    }

    public MyRectangle2D(MyPoint centerPoint, double width, double height) {
        this(centerPoint.x, centerPoint.y, width, height);
    }

    public MyRectangle2D(Rectangle rectangle) {
        this(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public MyPoint getCenterP() {
        return new MyPoint(centerX, centerY);
    }
    public MyPoint getP1() {
        return new MyPoint(centerX - width / 2, centerY + height / 2);
    }

    public MyPoint getP2() {
        return new MyPoint(centerX + width / 2, centerY + height / 2);
    }

    public MyPoint getP3() {
        return new MyPoint(centerX - width / 2, centerY - height / 2);
    }

    public MyPoint getP4() {
        return new MyPoint(centerX + width / 2, centerY - height / 2);
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /** returns the perimeter of the rectangle. **/
    @Override
    public double getPerimeter() {

        return width * 2 + height * 2;
    }

    /** returns the area of the rectangle **/
    @Override
    public double getArea() {
        return width * height;
    }

    public boolean contains(double x, double y) {

        // Get max X & Y
        double maxX = getMax(getP1().x, getP2().x, getP3().x, getP4().x);
        double maxY = getMax(getP1().y, getP2().y, getP3().y, getP4().y);
        // Get min X & Y
        double minX = getMin(getP1().x, getP2().x, getP3().x, getP4().x);
        double minY = getMin(getP1().y, getP2().y, getP3().y, getP4().y);

        if (x < minX || x > maxX || y < minY || y > maxY)  return false;

        return true;

    }

    public boolean contains(MyRectangle2D r2) {
        double xDistance = (r2.centerX > centerX) ? r2.centerX - centerX : centerX - r2.centerX;
        double yDistance = (r2.centerY > centerY) ? r2.centerY - centerY : centerY - r2.centerY;

        // if the r2 is inside this rectangle
        // this is only valid if the rectangles are parallel
        return (xDistance <= (width - r2.width) / 2 && yDistance <= (height - r2.height) / 2);

    }

    public boolean overlaps(MyRectangle2D r2) {
        // subtract from the highest number
        double xDistance = (r2.centerX > centerX) ? r2.centerX - centerX : centerX - r2.centerX;
        double yDistance = (r2.centerY > centerY) ? r2.centerY - centerY : centerY - r2.centerY;

        // if the r2 overlaps this rectangle
        // this is only valid if the rectangles are parallel
        return (xDistance <= (width + r2.width) / 2 && yDistance <= (height + r2.height) / 2);

    }

    public static boolean r1OverLapsR2(Rectangle r1, Rectangle r2) {
        return r1.intersects(r2.getBoundsInLocal()) || r2.intersects(r1.getBoundsInLocal());
    }

    public javafx.scene.shape.Rectangle getRectangle() {
        return new Rectangle(centerX, centerY, width, height);
    }
    public boolean contains(MyPoint[] points) {

        for (MyPoint p : points) {
            if (!contains(p)) return false;
        }
        return true;
    }

    public boolean contains(MyPoint point) {
        return contains(point.x, point.y);
    }

    public static MyRectangle2D getRectangle(double[][] points) {

        // find leftLowestPoint

        // find rightMostPoint

        // find the center from highest and lowest point

        // x distance = width

        // y distance = height
        MyPoint[] myPoints = new MyPoint[points.length];
        for (int i = 0; i < points.length; i++) {
            myPoints[i] = new MyPoint(points[i][0], points[i][1]);
        }

        return getRectangle(myPoints);
    }

    public static MyRectangle2D getRectangle(MyPoint[] points) {

        MyPoint leftMost = getLeftMostPoint(points);
        MyPoint rightMost = getRighMostPoint(points);
        double width = Math.abs(rightMost.x - leftMost.x);

        MyPoint highest = getHighestPoint(points);
        MyPoint lowest = getLowestPoint(points);
        double height = Math.abs(highest.y - lowest.y);

        double centerX = highest.getCenterPoint(lowest).x;
        double centerY = leftMost.getCenterPoint(rightMost).y;

        return new MyRectangle2D(centerX, centerY, width, height);
    }

    private static MyPoint getLeftMostPoint(MyPoint[] points) {

        MyPoint leftMost = points[0];
        for (int i = 0; i < points.length; i++) {
            if (leftMost.x > points[i].x) {
                leftMost = points[i];
            }
        }
        return leftMost;
    }

    private static MyPoint getRighMostPoint(MyPoint[] points) {

        MyPoint rightMost = points[0];
        for (int i = 0; i < points.length; i++) {
            if (rightMost.x < points[i].x) {
                rightMost = points[i];
            }
        }
        return rightMost;
    }

    private static MyPoint getHighestPoint(MyPoint[] points) {

        MyPoint highest = points[0];
        for (int i = 0; i < points.length; i++) {
            if (highest.y < points[i].y) {
                highest = points[i];
            }
        }
        return highest;
    }

    private static MyPoint getLowestPoint(MyPoint[] points) {

        MyPoint lowest = points[0];
        for (int i = 0; i < points.length; i++) {
            if (lowest.y > points[i].y) {
                lowest = points[i];
            }
        }
        return lowest;
    }

    private double getMax(double... n) {
        double max = n[0];
        for (int i = 1; i < n.length; i++) {
            if (max < n[i]) {
                max = n[i];
            }
        }
        return max;
    }
    private double getMin(double... n) {
        double min = n[0];
        for (int i = 1; i < n.length; i++) {
            if (min > n[i]) {
                min = n[i];
            }
        }
        return min;
    }

    @Override
    public String toString() {
        return "MyRectangle2D{" +
                "centerX=" + centerX +
                ", centerY=" + centerY +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
