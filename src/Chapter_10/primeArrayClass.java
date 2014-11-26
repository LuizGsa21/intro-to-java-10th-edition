package Chapter_10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Chapter 10 Exercise 19:
 * <p>
 * Created by Luiz Arantes Sa on 9/5/14.
 */
public class primeArrayClass {

    private static final long MAX = 1000000000L;
    private static final long SQRT_MAX = (long) Math.sqrt(MAX) + 1;
    private static final int MEMORY_SIZE = (int) (MAX >> 4);
    private static byte[] array = new byte[MEMORY_SIZE];
    private static ArrayList<Long> primeNumbers = new ArrayList<>();

    public primeArrayClass() {

    }

    public ArrayList<Long> getPrimeArrayList() {



            double debut = System.currentTimeMillis();

            // Find prime
            int[] sequence = { 2, 4 };
            int index = 0;
            long k1 = 0, k = 0;

            double xUpper = Math.sqrt(MAX / 4) + 1;
            long x = 1;
            long y = 0;

            while (x < xUpper) {
                index = 0;
                k1 = 4 * x * x;
                y = 1;
                if (x % 3 == 0) {
                    while (true) {
                        k = k1 + y * y;
                        if (k >= MAX) {
                            break;
                        }
                        toggleBit(k);
                        y += sequence[(++index & 1)];
                    }
                } else {
                    while (true) {
                        k = k1 + y * y;
                        if (k >= MAX) {
                            break;
                        }
                        toggleBit(k);
                        y += 2;
                    }
                }
                x++;
            }

            double intermediaire1 = System.currentTimeMillis();

            xUpper = Math.sqrt(MAX / 3) + 1;
            x = 1;
            y = 0;

            while (x < xUpper) {
                index = 1;
                k1 = 3 * x * x;
                y = 2;
                while (true) {
                    k = k1 + y * y;
                    if (k >= MAX) {
                        break;
                    }
                    toggleBit(k);
                    y += sequence[(++index & 1)];
                }
                x += 2;
            }

            double intermediaire2 = System.currentTimeMillis();

            xUpper = (int) Math.sqrt(MAX);
            x = 1;
            y = 0;

            while (x < xUpper) {
                k1 = 3 * x * x;
                if ((x & 1) == 0) {
                    y = 1;
                    index = 0;
                } else {
                    y = 2;
                    index = 1;
                }
                while (y < x) {
                    k = k1 - y * y;
                    if (k < MAX) {
                        toggleBit(k);
                    }
                    y += sequence[(++index & 1)];
                }
                x++;
            }

            double intermediaire3 = System.currentTimeMillis();

            setBit(2);
            setBit(3);
            for (int n = 5; n <= SQRT_MAX; n += 2) {
                if (getBit(n)) {
                    int n2 = n * n;
                    for (k = n2; k < MAX; k += (2 * n2)) {
                        unSetBit(k);
                    }
                }
            }

            // Display prime
            long pi = 0;
            for (int i = 3; i < MAX; i += 2) {
                if (getBit(i)) {
                    pi++;
                    // System.out.println(i);
                    primeNumbers.add((long)i);
                }
            }


            double fin = System.currentTimeMillis();

//            System.out.println("Max: " + MAX + " -- Pi:" + pi + " -- T: " + (fin - debut) / 1000d);
//            System.out.println("1: " + (intermediaire1 - debut) / 1000d + " -- 2: "
//                    + (intermediaire2 - intermediaire1) / 1000d + " -- 3: "
//                    + (intermediaire3 - intermediaire2) / 1000d + " -- 4: " + (fin - intermediaire3)
//                    / 1000d);

            //savePrimeFile(primeNumbers);

        return primeNumbers;

    }

    private static boolean getBit(long i) {
        byte block = array[(int) (i >> 4)];
        byte mask = (byte) (1 << ((i >> 1) & 7));

        return ((block & mask) != 0);
    }

    private static void setBit(long i) {
        int index = (int) (i >> 4);
        byte block = array[index];
        byte mask = (byte) (1 << ((i >> 1) & 7));

        array[index] = (byte) (block | mask);
    }

    private static void unSetBit(long i) {
        int index = (int) (i >> 4);
        byte block = array[index];
        byte mask = (byte) (1 << ((i >> 1) & 7));

        array[index] = (byte) (block & ~mask);
    }

    private static void toggleBit(long i) {
        int index = (int) (i >> 4);
        byte block = array[index];
        byte mask = (byte) (1 << ((i >> 1) & 7));

        array[index] = (byte) (block ^ mask);
    }

    private static void savePrimeFile(ArrayList<Long> primeNumbers) {
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("primeNumbers11.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(primeNumbers);
            out.close();
            fileOut.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }

        System.exit(0);
    }
}

// AMD 3200+ 2Ghz
// Max: 1000000 -- Pi:78497 -- T: 0.016 // 1: 0.0 -- 2: 0.0 -- 3: 0.0 -- 4: 0.016
// Max: 10000000 -- Pi:664578 -- T: 0.172 // 1: 0.047 -- 2: 0.015 -- 3: 0.031 -- 4: 0.079
// Max: 100000000 -- Pi:5761454 -- T: 3.172 // 1: 1.422 -- 2: 0.531 -- 3: 0.39 -- 4: 0.829
// Max: 1000000000 -- Pi:50847533 -- T: 37.453 // 1: 16.109 -- 2: 7.157 -- 3: 6.015 -- 4: 8.172