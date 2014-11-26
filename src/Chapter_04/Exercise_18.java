package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 18:
 *
 *      (Student major and status)
 *      Write a program that prompts the user to enter two characters
 *      and displays the major and status represented in the characters.
 *      The first character indicates the major and the second is number
 *      character 1, 2, 3, 4, which indicates whether a student is a freshman,
 *      sophomore, junior, or senior. Suppose the following characters
 *      are used to denote the majors:
 *
 *       M: Mathematics
 *       C: Computer Science
 *       I: Information Technology
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_18 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter two characters: ");
        String s = input.next();
        input.close();

        String major = getMajor(s.charAt(0));
        String status = getSchoolYear(s.charAt(1));

        if (major == null || status == null) {
            System.out.println("Invalid input.");
            System.exit(0);
        }

        System.out.println(major + " " + status);
    }

    public static String getSchoolYear(char schoolYear) {

        switch (schoolYear) {
            case '1': return "Freshman";
            case '2': return "Sophomore";
            case '3': return "Junior";
            case '4': return "Senior";
                default: return null;
        }
    }
    public static String getMajor(char major) {

        major = Character.toUpperCase(major);
        switch (major) {
            case 'M':
                return "Mathematics";
            case 'C':
                return "Computer Science";
            case 'I':
                return "Information Technology";
            default:
                return null;
        }


    }
}
