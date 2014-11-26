package ToolKit;

/**
 * Chapter 10 Exercise 4:
 *
 *      My class for Chapter 10 Exercise 4.
 *
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class MyPoint {

    public double x;
    public double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint() {
        this(0,0);
    }

    public double x() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double y() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(double x, double y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }

    public double distance(MyPoint point) {

        return distance(point.x, point.y);
    }

    public MyPoint getCenterPoint(MyPoint p) {

        return new MyPoint((p.x + this.x) / 2, (p.y + this.y) / 2);
    }

    public static MyPoint getCenterPoint(double x1, double y1, double x2, double y2) {
        return new MyPoint((x1 + x2) / 2, (y1 + y2) / 2);
    }

    /** Return true if this point is on the left side of the
     *  directed line from p0 to p1 */
    public boolean leftOfTheLine(MyPoint p0, MyPoint p1) {

        return leftOfTheLine(p0.x, p0.y, p1.x, p1.y, x, y);
    }

    /** Return true if this point is on the same
     *  line from p0 to p1 */
    public boolean onTheSameLine(MyPoint p0, MyPoint p1) {

        return onTheSameLine(p0.x, p0.y, p1.x, p1.y, x, y);

    }

    /** Return true if this point is on the right side of the
     *  directed line from p0 to p1 */
    public boolean rightOfTheLine(MyPoint p0, MyPoint p1) {

        return rightOfTheLine(p0.x, p0.y, p1.x, p1.y, x, y);

    }

    /** Return true if this point is on the
     *  line segment from p0 to p1 */
    public boolean onTheLineSegment(MyPoint p0, MyPoint p1) {

        return onTheLineSegment(p0.x, p0.y, p1.x, p1.y, x, y);

    }


    /** Return true if point (x2, y2) is on the left side of the
     *  directed line from (x0, y0) to (x1, y1) */
    public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2){

        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) > 0;
    }
    /** Return true if point (x2, y2) is on the same
     *  line from (x0, y0) to (x1, y1) */
    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {

        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) == 0;
    }
    /** Return true if point (x2, y2) is on the
     *  line segment from (x0, y0) to (x1, y1) */
    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {

        double position = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);

        return position <= 0.0000000001 && ((x0 <= x2 && x2 <= x1) || (x0 >= x2 && x2 >= x1));
    }

    /** Return true if point (x2, y2) is on the right side of the
     *  directed line from (x0, y0) to (x1, y1) */
    public static boolean rightOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2){

        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) < 0;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}