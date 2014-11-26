package Chapter_06;

/**
 * Chapter 6 Exercise 25:
 *
 *      (Convert milliseconds to hours, minutes, and seconds) Write a method that converts
 *      milliseconds to hours, minutes, and seconds using the following header:
 *
 *              public static String convertMillis(long millis)
 *      The method returns a string as hours:minutes:seconds.
 *      For example,
 *      convertMillis(5500) returns a string 0:0:5,
 *      convertMillis(100000) returns a string 0:1:40,
 *      and convertMillis(555550000) returns a string 154:19:10
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_25 {

    public static void main(String[] args) {

        System.out.println(convertMillis(5500));
        System.out.println(convertMillis(100000));
        System.out.println(convertMillis(555550000));
    }

    /**
     *
     * @param millis time in milliseconds
     * @return returns a string as hours:minutes:seconds
     */
    public static String convertMillis(long millis) {

        long totalSeconds = millis / 1000;
        long totalMinutes = totalSeconds / 60;
        long totalHours = totalMinutes / 60;

        StringBuilder s = new StringBuilder();
        s.append(totalHours + ":");
        s.append(totalMinutes % 60 + ":");
        s.append(totalSeconds % 60);

        return s.toString();
    }
}
