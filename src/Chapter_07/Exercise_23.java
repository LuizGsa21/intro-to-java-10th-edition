package Chapter_07;

/**
 * Chapter 7 Exercise 23:
 *
 *      (Game: locker puzzle) A school has 100 lockers and 100 students.
 *      All lockers are closed on the first day of school. As the students enter,
 *      the first student, denoted S1, opens every locker. Then the second student,
 *      S2, begins with the second locker, denoted L2, and closes every other locker.
 *      Student S3 begins with the third locker and changes every third locker
 *      (closes it if it was open, and opens it if it was closed). Student S4 begins
 *      with locker L4 and changes every fourth locker. Student S5 starts with L5 and
 *      changes every fifth locker, and so on, until student S100 changes L100.
 *      After all the students have passed through the building and changed the lockers,
 *      which lockers are open? Write a program to find your answer and display all open
 *      locker numbers separated by exactly one space.
 *
 *      (Hint: Use an array of 100 Boolean elements, each of which indicates whether a locker is open (true) or closed (false). Initially, all lockers are closed.)
 *       Created by Luiz Arantes Sa on 8/28/14.
 */
public class Exercise_23 {


    // S1 opens every locker
    // S2 closes every other locker starting at L2 (subscript 1)
    // S3 closes/opens every 3 locker starting at L3 (subscript 2)  *closes if open/ opens if closed
    // s4 starts at 4 (subscript 3) changes every 4th locker
    // etc.. all the way up to 100

    public static void main(String[] args) {

        boolean[] lockers = new boolean[100];

        for (int student = 1; student <= 100; student++) {
            shuffle(lockers, student);
        }
        display(lockers);
    }

    public static void shuffle(boolean[] lockersOpenState,  int start) {

        int nextLocker = start;
        for (int i = start - 1; i < lockersOpenState.length; i += nextLocker) {
                lockersOpenState[i] = !lockersOpenState[i];

        }
    }


    public static void display(boolean[] lockers) {

        int lockerCount = 0;
        for (int i = 0; i < lockers.length; i++) {

            if (lockers[i]) {
                System.out.printf("L%d ", i+1);
                lockerCount++;
                if (lockerCount % 10 == 0) System.out.println("");
            }


        }

    }


}
