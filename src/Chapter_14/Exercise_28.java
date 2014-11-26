package Chapter_14;

import ToolKit.ClockPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 28:
 *
 *      (Random time)
 *      Modify the ClockPane class with three new Boolean
 *      properties hourHandVisible, minuteHandVisible, and secondHandVisible
 *      and their associated accessor and mutator methods.
 *      You can use the set methods to make a hand visible or invisible.
 *      Write a test program that displays only the hour and minute hands.
 *      The hour and minute values are randomly generated.
 *      The hour is between 0 and 11, and the minute is either 0 or 30,
 *      as shown in Figure 14.52b.
 *
 * Created by Luiz Arantes Sa on 9/14/14.
 */
public class Exercise_28  extends Application {

    @Override
    public void start(Stage primaryStage) {

        double height = 400;
        double width = 400;
        int hour = (int) (Math.random() * 12);
        int min = (int) (Math.random() * 31);
        ClockPane clock1 = new ClockPane(hour, min, 0, width, height);
        clock1.setSecondHandVisible(true);
        HBox hBox = new HBox(clock1);


        Scene scene = new Scene(hBox, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Random time");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}
