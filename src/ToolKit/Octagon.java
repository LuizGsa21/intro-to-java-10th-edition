package ToolKit;

/**
 * Chapter 13 Exercise :
 * <p>
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Octagon extends GeometricObject implements Cloneable {

    // all 8 sides of the octagon have equal length
    double side;


    public Octagon() {
        this(5);
    }

    public Octagon(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2.0 + 4.0 / Math.sqrt(2) * side * side);
    }

    @Override
    public double getPerimeter() {
        return side * 8;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return o;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Octagon && getArea() == ((Octagon)o).getArea();
    }
}
