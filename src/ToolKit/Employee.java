package ToolKit;

/**
 * Chapter 11 Exercise :
 * <p>
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Employee extends Person {

    protected double salary;
    protected String office;
    protected MyDate dateHired;

    public Employee(String name) {
        this(name, 0, "none", new MyDate());
    }

    public Employee(String name, double salary, String office, MyDate dateHired) {
        super(name);
        this.salary = salary;
        this.office = office;
        this.dateHired = dateHired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " Class: " + this.getClass().getName();
    }
}
