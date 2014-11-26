package Chapter_04;

/**
 * Chapter 4 Exercise 25:
 *
 *      (Generate vehicle plate numbers)
 *      Assume a vehicle plate number consists of three uppercase
 *      letters followed by four digits. Write a program to
 *      generate a plate number.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_25 {

    public static void main(String[] args) {

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char ch = (char)(Math.random() * 26 + 'A');
            s.append(ch);
        }
        for (int i = 0; i < 4; i++) {
            char digit1 = (char)(Math.random() * 10 + '0');
            s.append(digit1);
        }
        System.out.println("Random vehicle plate number: " + s);
    }
}
