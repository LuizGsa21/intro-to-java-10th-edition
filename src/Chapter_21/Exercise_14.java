package Chapter_21;

import java.util.*;

/**
 * (Web crawler)
 * Rewrite Listing 12.18, WebCrawler.java, to improve the performance
 * by using appropriate new data structures for listOfPendingURLs
 * and listofTraversedURLs.
 *
 * Created by Luiz Arantes Sa on 1/30/15.
 */
public class Exercise_14 {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        crawler(url); // Traverse the Web from the a starting url
    }

    public static void crawler(String startingURL) {
        LinkedList<String> listOfPendingURLs = new LinkedList<>();
        HashSet<String> listOfTraversedURLs = new HashSet<>();

        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
            String url = listOfPendingURLs.pop();
            if (!listOfTraversedURLs.contains(url)) {
                listOfTraversedURLs.add(url);
                System.out.println("Craw " + url);
                getSubURLs(url).stream().filter(s -> !listOfTraversedURLs.contains(s)).forEach(listOfPendingURLs::push);

            }

        }
    }
    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>(1000);

        try {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
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
