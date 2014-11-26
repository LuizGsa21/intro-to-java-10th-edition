package Chapter_11;

import ToolKit.*;

/**
 * Chapter 11 Exercise 02:
 *
 *      (The Person, Student, Employee, Faculty, and Staff classes) Design a
 *      class named Person and its two subclasses named Student and Employee.
 *      Make Faculty and Staff subclasses of Employee. A person has a name,
 *      address, phone number, and email address. A student has a class status (freshman,
 *      sophomore, junior, or senior). Define the status as a constant. An employee has
 *      an office, salary, and date hired. Use the MyDate class defined in Programming
 *      Exercise 10.14 to create an object for date hired. A faculty member has office
 *      hours and a rank. A staff member has a title. Override the toString method in
 *      each class to display the class name and the person’s name.
 *      Draw the UML diagram for the classes and implement them. Write a test program
 *      that creates a Person, Student, Employee, Faculty, and Staff, and
 *      invokes their toString() methods.
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_02 {

    public static void main(String[] args) {

        Person person = new Person("person");
        Student student = new Student("student");
        Employee employee = new Employee("employee");
        Faculty faculty = new Faculty("faculty");
        Staff staff = new Staff("staff");

        System.out.println(person.toString());
        System.out.println(student.toString());
        System.out.println(employee.toString());
        System.out.println(faculty.toString());
        System.out.println(staff.toString());

    }


}
