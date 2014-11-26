package Chapter_12;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 33:
 *
 *      (Search Web)
 *      Modify Listing 12.18 WebCrawler.java to search for the word Computer
 *      Programming starting from the URL http://cs.armstrong.edu/liang.
 *      Your program terminates once the word is found. Display the URL for the
 *      page that contains the word.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_33 {

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter a URL: ");
//        String url = input.nextLine();
        crawler("http://cs.armstrong.edu/liang"); // Traverse the Web from the a starting url
    }

    public static void crawler(String startingURL) {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();

        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100) {
            String urlString = listOfPendingURLs.remove(0);
            if (!listOfTraversedURLs.contains(urlString)) {
                listOfTraversedURLs.add(urlString);
                System.out.println("Craw " + urlString);

                for (String s: getSubURLs(urlString)) {
                    if (!listOfTraversedURLs.contains(s))
                        listOfPendingURLs.add(s);
                }
            }
        }
    }

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();

        try {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                if (line.contains("Computer Programming")) {
                    System.out.println("Found the word \"Computer Programming\".");
                    System.out.println("URL: " + url);
                    System.exit(1);
                }
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { // Ensure that a correct URL is found
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    }
                    else
                        current = -1;
                }
            }
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return list;
    }
}
