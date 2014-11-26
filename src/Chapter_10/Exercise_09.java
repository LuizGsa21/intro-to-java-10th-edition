package Chapter_10;

import ToolKit.Course;

/**
 * Chapter 10 Exercise 9:
 * <p>
 * (The Course class) Revise the Course class as follows:
 * ■ The array size is fixed in Listing 10.6. Improve it to automatically increase the array
 * size by creating a new larger array and copying the contents of the current array to it.
 * ■ Implement the dropStudent method.
 * ■ Add a new method named clear() that removes all students from the course.
 * <p>
 * Write a test program that creates a course, adds three students,
 * removes one, and displays the students in the course.
 * <p>
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class Exercise_09 {

    public static void main(String[] args) {

        Course course = new Course("Intro to Java :)");

        // adding 20 students
        for (int i = 0; i < 20; i++) {
            course.addStudent("Student " + (i + 1));
        }

        // Displaying course name and student taking the course.
        String[] students = course.getStudents();
        System.out.println(course.getCourseName());
        for (int i = 0; i < students.length; i++) {
            System.out.printf("%-12s ", students[i]);
            if ((i + 1) % 5 == 0) {
                System.out.printf("\n");
            }

        }
        System.out.println("Number of students: " + course.getNumberOfStudents());

        System.out.println("\nDropping two students from course..");
        System.out.println("Student #1 dropped.");
        course.dropStudent("Student " + (1));
        System.out.println("Student #8 dropped.");
        course.dropStudent("Student " + (8));

        System.out.println("Displaying students...\n");
        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.printf("%-12s ", students[i]);

            if ((i + 1) % 5 == 0) {
                System.out.printf("\n");
            }
        }
        System.out.println("\nNumber of students: " + course.getNumberOfStudents());

    }
}
