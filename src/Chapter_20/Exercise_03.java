package Chapter_20;

import java.util.*;

/**
 * (Guessing the capitals)
 * Rewrite Programming Exercise 8.37 to store the pairs of states and
 * capitals so that the questions are displayed randomly.
 * Created by Luiz Arantes Sa on 12/18/14.
 */
public class Exercise_03 {
    public static void main(String[] args) {

        LinkedList<String[]> list = new LinkedList<>();

        Collections.addAll(list, stateCapitals);

        Scanner input = new Scanner(System.in);
        int correctCount = 0;
        while (list.size() > 0) {
            Collections.shuffle(list);
            String[] s = list.pollFirst();
            System.out.print("What is the capital of " + s[0] +"? ");
            if (input.nextLine().equalsIgnoreCase(s[1])) {
                correctCount++;
                System.out.println("Your answer is correct!");
            } else {
                System.out.println("WRONG - The correct answer is " + s[1]);
            }
        }
        System.out.println("The correct count is " + correctCount);
    }

    private static String[][] stateCapitals = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Maryland", "Annapolis"},
            {"Minnesota", "Saint Paul"},
            {"Iowa", "Des Moines"},
            {"Maine", "Augusta"},
            {"Kentucky", "Frankfort"},
            {"Indiana", "Indianapolis"},
            {"Kansas", "Topeka"},
            {"Louisiana", "Baton Rouge"},
            {"Oregon", "Salem"},
            {"Oklahoma", "Oklahoma City"},
            {"Ohio", "Columbus"},
            {"North Dakota", "Bismark"},
            {"New York", "Albany"},
            {"New Mexico", "Santa Fe"},
            {"New Jersey", "Trenton"},
            {"New Hampshire", "Concord"},
            {"Nevada", "Carson City"},
            {"Nebraska", "Lincoln"},
            {"Montana", "Helena"},
            {"North Carolina", "Raleigh"},
            {"Missouri", "Jefferson City"},
            {"Mississippi", "Jackson"},
            {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"},
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}
    };
}
