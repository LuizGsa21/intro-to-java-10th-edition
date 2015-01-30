package Chapter_21;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

/**
 * (Baby name popularity ranking)
 * Use the data files from Programming Exercise 12.31 to write a
 * program that enables the user to select a year, gender, and
 * enter a name to display the ranking of the name for the selected
 * year and gender, as shown in Figure 21.9. To achieve the best efficiency,
 * create two arrays for boy’s names and girl’s names, respectively. Each array
 * has 10 elements for 10 years. Each element is a map that stores a name and
 * its ranking in a pair with the name as the key. Assume the data files are
 * stored at www.cs.armstrong .edu/liang/data/babynamesranking2001.txt, . . . ,
 * and www.cs.armstrong.edu/liang/data/ babynamesranking2010.txt.
 *
 * Created by Luiz Arantes Sa on 1/29/15.
 */
public class Exercise_11 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        BabyNamePopulation pane = new BabyNamePopulation();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Baby Name Popularity Ranking");
        primaryStage.show();

    }

    private class BabyNamePopulation extends GridPane {

        Label lblYear;
        ComboBox<String> cbYear;

        Label lblGender;
        ComboBox<String> cbGender;

        Label lblName;
        TextField tfName;

        Button btnFindRanking;

        Label lblResult;

        HashMap<String, Integer>[][] babyNamesMapArray;
        // babyNamesMapArray outer indices (e.g babyNamesMapArray[MALE][] or babyNamesMapArray[FEMALE][])
        final int MALE = 0;
        final int FEMALE = 1;

        private BabyNamePopulation() {

            // Load files and get the available years
            String[] years = loadFiles();

            // Year
            lblYear = new Label("Select Year:"); // Add years to combo box
            cbYear = new ComboBox<>(FXCollections.observableArrayList(years));
            cbYear.setValue(years[0]);

            // Gender
            lblGender = new Label("Boy or Girl?");
            cbGender = new ComboBox<>(FXCollections.observableArrayList("Boy", "Girl"));
            cbGender.setValue("Boy");

            // Name
            lblName = new Label("Enter Name:");
            tfName = new TextField();

            btnFindRanking = new Button("Find Ranking");

            lblResult = new Label("Search a name...");

            // Add nodes to grid pane
            add(lblYear, 0, 0);
            add(cbYear, 1, 0);

            add(lblGender, 0, 1);
            add(cbGender, 1, 1);

            add(lblName, 0, 2);
            add(tfName, 1, 2);

            add(btnFindRanking, 0, 3, 2, 1);

            add(lblResult, 0, 4, 2, 1);


            // Add padding and alignment to node elements
            setPadding(new Insets(10, 10, 20, 10));
            setVgap(10);
            setHgap(10);
            setHalignment(btnFindRanking, HPos.CENTER);

            // Set listeners
            btnFindRanking.setOnAction(e-> findRanking());
            tfName.setOnKeyPressed(event-> {
                if (event.getCode() == KeyCode.ENTER) findRanking();
            });

        }

        private String[] loadFiles() {

            // Get the baby name file from cs.armstrong website
            String baseURL = "http://www.cs.armstrong.edu/liang/data/babynamesranking";
            String[] urls = new String[10];
            String[] years = new String[urls.length];

            babyNamesMapArray = (HashMap<String, Integer>[][])new HashMap[2][urls.length];

            for (int j = 0; j < babyNamesMapArray.length; j++)
                for (int i = 0; i < babyNamesMapArray[j].length; i++)
                    babyNamesMapArray[j][i] = new HashMap<>();

            for (int i = 0; i < urls.length; i++) {
                years[i] = (2001 + i) + ""; // create the years array
                urls[i] = baseURL + years[i] +".txt";

                try {
                    URL url = new URL(urls[i]);
                    Scanner in = new Scanner(url.openStream());

                    int gender = 0;
                    Integer rank = 0;
                    while (in.hasNext()) {
                        if (gender == 0)
                            rank = in.nextInt();
                        String name = in.next();
                        String popularity = in.next(); // trash for now
                        babyNamesMapArray[gender][i].put(name, rank);

                        if (gender == 1)
                            gender = 0;
                        else
                            gender++;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return years;
        }

        private void findRanking() {
            String name = tfName.getText();
            if (name.length() == 0) {
                lblResult.setText("Please enter a valid name...");
                return;
            }
            String yearString = cbYear.getValue();
            int year = Integer.parseInt(yearString.substring(2)) - 1;
            System.out.println(year);
            String genderString = cbGender.getValue();
            int gender = (genderString.equals("Boy")) ? MALE : FEMALE;

            String formatName = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
            if (babyNamesMapArray[gender][year].containsKey(formatName)) {
                Integer rank = babyNamesMapArray[gender][year].get(formatName);
                lblResult.setText(genderString + " name " + formatName +
                        " is ranked #" + rank + "\n in year " + yearString);
            } else {
                lblResult.setText("Sorry, No name was matched.\nMaybe no one likes that name?");
            }

        }
    }

}
