package Chapter_15;

import ToolKit.ClockPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * (Control a clock)
 *  Modify Listing 14.21, ClockPane.java, to add the animation
 *  into this class and add two methods start() and stop() to
 *  start and stop the clock. Write a program that lets the user
 *  control the clock with the Start and Stop buttons, as shown in Figure 15.36a.
 *
 * Created by luizsa on 9/22/14.
 */
public class Exercise_32 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClockPane clockPane = new ClockPane();
        clockPane.start();

        Button btStart = new Button("Start");
        btStart.setOnAction(e -> clockPane.start());
        Button btStop = new Button("Stop");
        btStop.setOnAction(e -> clockPane.stop());

        HBox hBox = new HBox(btStart, btStop);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setAlignment(Pos.CENTER);
        BorderPane borderPane = new BorderPane(clockPane, null, null, hBox, null);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Clock");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
