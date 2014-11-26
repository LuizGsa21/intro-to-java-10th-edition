package Chapter_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 6:
 *
 *      (Game: display a checkerboard)
 *      Write a program that displays a checkerboard in which each
 *      white and black cell is a MyRec2 with a fill color black or white,
 *      as shown in Figure 14.44c.
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_06 extends Application {

    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        boolean isBlack = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rec = new Rectangle(50, 50, (isBlack) ? Color.BLACK : Color.WHITE);
                pane.add(rec,j,i);
                isBlack = !isBlack;
            }
            isBlack = !isBlack;
        }

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Checkerboard");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}
