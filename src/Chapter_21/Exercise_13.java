package Chapter_21;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * (Baby name popularity ranking)
 * Revise Programming Exercise 21.11 to prompt the user to enter year,
 * gender, and name and display the ranking for the name. Prompt the
 * user to enter another inquiry or exit the program.
 *
 * Created by Luiz Arantes Sa on 1/30/15.
 */
public class Exercise_13 {


    public static void main(String[] args) {

        HashMap<String, Integer>[][] babyNamesMapArray = new HashMap[2][10];

        for (int j = 0; j < babyNamesMapArray.length; j++)
            for (int i = 0; i < babyNamesMapArray[j].length; i++)
                babyNamesMapArray[j][i] = new HashMap<>();
        File[] files = new File("/Users/Kernel/GitHub/intro-to-java-10th-edition/src/text-files")
                .listFiles((dir, name) -> name.matches("babynamesranking.*"));

        Arrays.sort(files);

        for (int i = 0; i < files.length; i++) {
            try(Scanner in = new Scanner(files[i])) {

                int gender = 0;
                String rank = "";
                while (in.hasNext()) {
                    if (gender == 0)
                        rank = in.next() + "";
                    String name = in.next();
                    String popularity = in.next(); // trash for now
                    babyNamesMapArray[gender][i].put(name, Integer.parseInt(rank));

                    if (gender == 1)
                        gender = 0;
                    else
                        gender++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        String again;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a year (2001-2010): ");
            String yearString = scanner.next();
            int year = Integer.parseInt(yearString) - 2001;

            System.out.print("Enter a gender (male/female): ");
            String genderString = scanner.next();
            int gender = (genderString.equalsIgnoreCase("male")) ? 0 : 1;

            System.out.print("Enter a name: ");
            String name = scanner.next();

            HashMap<String, Integer> hashMap = babyNamesMapArray[gender][year];

            String formattedName = makeFirstCapital(name);
            if (hashMap.containsKey(formattedName)) {
                System.out.println(genderString + " " + name + " is rank #" + hashMap.get(formattedName) + " in year " + yearString);
            } else {
                System.out.println("No match was found.");
            }


            System.out.print("Enter another enquiry? ");
            again = scanner.next();
        } while (!again.equalsIgnoreCase("no"));

    }

    public static String makeFirstCapital(String word) {

        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }

}


