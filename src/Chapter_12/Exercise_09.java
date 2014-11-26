package Chapter_12;

/**
 * Chapter 12 Exercise 9:
 *
 *      (BinaryFormatException)
 *      Exercise 12.7 implements the bin2Dec method to throw a BinaryFormatException
 *      if the string is not a binary string. Define a custom exception called BinaryFormatException.
 *      Implement the bin2Dec method to throw a BinaryFormatException if the string is not a binary string.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_09 {


    public static void main(String[] args) {

        System.out.println(bin2Dec("1100100"));
        // Purposely throwing an exception...
        System.out.println(bin2Dec("lafkja"));
    }

    public static int bin2Dec(String binary) throws BinaryFormatException {

        if (!isBinary(binary)) {
            throw new BinaryFormatException(binary + " is not a binary number.");
        }
        int power = 0;
        int decimal = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {

            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    public static boolean isBinary(String binary) {

        for (char ch : binary.toCharArray()) {
            if (ch != '1' && ch != '0') return false;
        }
        return true;
    }

}

class BinaryFormatException extends IllegalArgumentException {

    BinaryFormatException(String s) {
        super(s);
    }
}
