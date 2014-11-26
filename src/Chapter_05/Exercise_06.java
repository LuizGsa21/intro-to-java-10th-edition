package Chapter_05;

/**
 * Chapter 5 Exercise 6:
 *
 *      (Conversion from miles to kilometers)
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_06 {

    public static void main(String[] args) {

        System.out.printf("%-12s%8s", "Miles", "Kilometers");
        System.out.printf("\t\t|\t\t");
        System.out.printf("%-12s%-8s\n", "Kilometers", "Miles");


        for (int i = 1, j = 20; i <= 10; i++, j += 5) {
            System.out.printf("%-12d%8.3f", i, i * 1.609);
            System.out.printf("\t\t|\t\t");
            System.out.printf("%-12d%-8.3f\n", j, j / 1.609);

        }

    }
}
