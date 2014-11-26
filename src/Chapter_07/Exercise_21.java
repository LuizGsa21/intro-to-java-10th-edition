package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 21:
 *
 *      (Game: bean machine) The bean machine, also known as a quincunx
 *      or the Galton box, is a device for statistics experiments named after
 *      English scientist Sir Francis Galton. It consists of an upright board
 *      with evenly spaced nails (or pegs) in a triangular form.
 *      Each ball takes a random path and falls into a slot.
 *
 *      Balls are dropped from the opening of the board. Every time a ball hits a nail,
 *      it has a 50% chance of falling to the left or to the right. The piles of balls
 *      are accumulated in the slots at the bottom of the board.
 *      Write a program that simulates the bean machine. Your program should prompt the user
 *      to enter the number of the balls and the number of the slots in the machine.
 *      Simulate the falling of each ball by printing its path.
 *
 *      (Hint: Create an array named slots. Each element in slots stores the number of balls
 *      in a slot. Each ball falls into a slot via a path. The number of Rs in a path is the
 *      position of the slot where the ball falls. For example, for the path LRLRLRR, the ball
 *      falls into slots[4], and for the path is RRLLLLL, the ball falls into slots[2].)
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class    Exercise_21 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of balls to drop: ");
        int numberOfBalls = input.nextInt();
        String[] ballPaths = new String[numberOfBalls];

        System.out.print("Enter the number of slots in the bean machine: ");
        int numberOfSlots = input.nextInt();
        int[] slots = new int[numberOfSlots];

        // display ball paths
        for (int i = 0; i < numberOfBalls; i++) {
            ballPaths[i] = dropBall(slots);
            System.out.printf("%10s\n", ballPaths[i]);
        }

        // display game
        System.out.println("");
        printArray(slots, numberOfBalls);
    }

    public static String dropBall(int[] slot) {

        StringBuilder ballPath = new StringBuilder();


        for (int i = 0; i < slot.length - 1; i++) {
            int random = (int)(Math.random() * 10) % 2;
            if (random > 0) ballPath.append("R");
            else ballPath.append("L");
        }
        int position = getBallPosition(ballPath.toString(), 'R');
        slot[position]++;
        return ballPath.toString();

    }

    public static int getBallPosition(String str, char a) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == a) count++;

        }

        return count;
    }


    public static void printArray(int[] slots, int numberOfBalls) {

            while (!isEmpty(slots)) {

                if (isRowEmpty(slots, numberOfBalls)) {
                    numberOfBalls--;
                    continue;
                }
                for (int i = 0; i < slots.length; i++) {

                    if (slots[i] >= numberOfBalls) {
                        System.out.printf("%2c", 'O');
                        slots[i]--;
                    }
                    else System.out.printf("%2c", ' ');

                }
                numberOfBalls--;
                System.out.println("");

            }

    }

    public static boolean isEmpty(int[] slots) {

        for (int slot : slots) {
            if (slot != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isRowEmpty(int[] slots, int rowNum) {

        for (int slot : slots) {
            if (slot == rowNum) {
                return false;
            }
        }

        return true;
    }



}



















