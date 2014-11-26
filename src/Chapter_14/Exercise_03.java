package Chapter_14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 3:
 *
 *      (Display three cards)
 *      Write a program that displays three cards randomly selected from
 *      a deck of 52, as shown in Figure 14.43c. The card image files are
 *      named 1.png, 2.png, ..., 52.png and stored in the image/card directory.
 *      All three cards are distinct and selected randomly.
 *      Hint: You can select random cards by storing the numbers 1–52 to an array list,
 *      perform a random shuffle introduced in Section 11.12, and use the first three
 *      numbers in the array list as the file names for the image.
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_03 extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        boolean[] usedCards = new boolean[52];
        // choose 3 random distinct cards from the deck
        int count = 0;
        while (count < 3) {
            int card = (int) (Math.random() * 52);
            if (!usedCards[card]) {
                usedCards[card] = true;
                // card png files start from 1, so increment card by one
                // for the correct file name.
                pane.add(new ImageView(new Image("image/card/"+(++card)+".png")), count, 0);
                count++;
            }
        }
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("3 Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }


}
