package Chapter_13;

import ToolKit.Course;

/**
 * Chapter 13 Exercise 13:
 *
 *      (Enable the Course class cloneable)
 *      Rewrite the Course class in Listing 10.6
 *      to add a clone method to perform a deep copy on the students field.
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_13 {
    public static void main(String[] args) {

        Course course1 = new Course("Course1");
        course1.addStudent("student1");
        course1.addStudent("student2");
        Course course2 = (Course)course1.clone();
        // Checking if any of the members have the same reference
        System.out.println(course1 == course2);
        System.out.println(course1.getCourseName() == course2.getCourseName());
        System.out.println(course1.getStudents() == course2.getStudents());
    }
}
