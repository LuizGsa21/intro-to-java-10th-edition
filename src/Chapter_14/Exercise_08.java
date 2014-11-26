package Chapter_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 8:
 *
 *      (Display 54 cards)
 *      Expand Exercise 14.3 to display all 54 cards (including two jokers),
 *      nine per row. The image files are jokers and are named 53.jpg and 54.jpg.
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_08 extends Application {

    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();

        int card = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                pane.add(new ImageView(new Image("/image/card/"+(card++)+".png")), j, i);
            }
        }
        Scene scene = new Scene(pane, 650, 580);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Card Deck");
        primaryStage.show();
    }
    public static void main(String[] args) {

        Application.launch(args);
    }
}
