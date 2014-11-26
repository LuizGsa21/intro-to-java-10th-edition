package Chapter_14;

import ToolKit.ClockPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 27:
 *
 *      (Draw a detailed clock)
 *      Modify the ClockPane class in Section 14.12 to draw the
 *      clock with more details on the hours and minutes,
 *      as shown in Figure 14.52a.
 *
 * Created by Luiz Arantes Sa on 9/14/14.
 */
public class Exercise_27 extends Application {

    @Override
    public void start(Stage primaryStage) {

        double height = 400;
        double width = 400;
        ClockPane clock1 = new ClockPane(4, 20, 45, width, height);
        HBox hBox = new HBox(clock1);


        Scene scene = new Scene(hBox, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Draw a detailed clock");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}
