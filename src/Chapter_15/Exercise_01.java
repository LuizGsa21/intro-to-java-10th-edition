package Chapter_15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 1:
 *
 *  (Pick four cards)
 *  Write a program that lets the user click the Refresh button
 *  to display four cards from a deck of 52 cards, as shown in Figure 15.24a.
 *  (See the hint in Programming Exercise 14.3 on how to obtain four random cards.)
 *
 * Created by Luiz Arantes Sa on 9/14/14.
 */
public class Exercise_01 extends Application {

    @Override
    public void start(Stage primaryStage) {

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        setRandomCards(hBox);


        HBox buttons = new HBox();
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setSpacing(10);

        Button btRefresh = new Button("Refresh");
        btRefresh.setOnAction(e -> setRandomCards(hBox));
        buttons.getChildren().add(btRefresh);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(hBox);
        borderPane.setBottom(buttons);
        BorderPane.setMargin(buttons, new Insets(10, 10, 10, 10));
        borderPane.setPadding(new Insets(10, 10, 0, 10));


        borderPane.autosize();

        Scene scene = new Scene(borderPane, borderPane.getPrefWidth(), borderPane.getPrefHeight());
        primaryStage.setTitle("3 Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void setRandomCards(HBox pane){
        boolean[] usedCards = new boolean[52];
        // choose 3 random distinct cards from the deck
        int count = 0;
        pane.getChildren().clear();
        while (count < 4) {
            int card = (int) (Math.random() * 52);
            if (!usedCards[card]) {
                usedCards[card] = true;
                // card png files start from 1, so increment card by one for the correct file name.
                pane.getChildren().add(new ImageView(new Image("image/card/" + (++card) + ".png")));
                count++;
            }
        }
    }


    public static void main(String[] args) {
        Application.launch(args);

    }
}
