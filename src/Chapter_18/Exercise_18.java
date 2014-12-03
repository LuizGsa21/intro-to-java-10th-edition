package Chapter_18;

import java.util.Scanner;

/**
 * (Tower of Hanoi)
 * Modify Listing 18.8, TowerOfHanoi.java, so that the program finds
 * the number of moves needed to move n disks from tower A to tower B.
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_18 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read number of disks, n
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();

        // Find the solution recursively
        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');

        System.out.println("The total number of moves: " + count);
    }

    static int count = 0;

    public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
        count++;
        if (n == 1)
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}
