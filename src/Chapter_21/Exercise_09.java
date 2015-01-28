package Chapter_21;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * (Guess the capitals using maps)
 * Rewrite Programming Exercise 8.37 to store pairs of each state
 * and its capital in a map. Your program should prompt the user
 * to enter a state and should display the capital for the state.
 *
 * Created by Luiz Arantes Sa on 1/28/15.
 */
public class Exercise_09 {

    static int correctCount = 0;

    public static void main(String[] args) {

        Map<String, String> mapStateCapitals = new HashMap<>(50);
        for (String[] stateCapital : stateCapitals) {
            mapStateCapitals.put(stateCapital[0], stateCapital[1]);
        }

        Scanner input = new Scanner(System.in);
        mapStateCapitals.forEach((state, city) -> {
            System.out.print("What is the capital of " + state+"? ");
            if (input.nextLine().trim().equalsIgnoreCase(city)) {
                System.out.println("Your answer is correct!");
                correctCount++;
            } else {
                System.out.println("WRONG - The correct answer is " + city);
            }

        });
        System.out.println(" Score = " + correctCount + " out of");
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
