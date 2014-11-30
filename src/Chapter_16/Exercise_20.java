package Chapter_16;

import ToolKit.StopWatch;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Count-up stopwatch) k
 * Write a program that simulates a stopwatch,
 * as shown in Figure 16.45a. When the user
 * clicks the Start button, the button’s lbl
 * is changed to Pause, as shown in Figure 16.45b.
 * When the user clicks the Pause button, the button’s
 * lbl is changed to Resume, as shown in Figure 16.45c. The
 * Clear button resets the count to 0 and resets the button’s lbl to Start.
 * Created by luizsa on 9/29/14.
 */
public class Exercise_20 extends Application {

    StopWatch stopWatch = new StopWatch();
    Label mLabel = new Label("00:00:00");
    @Override
    public void start(Stage primaryStage) {


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e-> {
            mLabel.setText(stopWatch.toString());
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        // bottom pane
        Button btStartPause = new Button("Start");
        btStartPause.setOnAction(event -> {
            btStartPause.setText((btStartPause.getText().equals("Pause") ? "Start" : "Pause"));
            if (!stopWatch.isOn()) {
                stopWatch.start();
                timeline.play();
            } else
            if (stopWatch.isPaused()) {
                timeline.play();
                stopWatch.resume();
            } else {
                stopWatch.pause();
                timeline.pause();
            }
        });

        Button btClear = new Button("Clear");
        btClear.setOnAction(event -> {
            stopWatch.stop();
            timeline.stop();
            btStartPause.setText("Start");
            mLabel.setText("00:00:00");
        });
        HBox bottomPane = new HBox(btStartPause, btClear);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setSpacing(10);
        bottomPane.setPadding(new Insets(10));
        mLabel.setFont(Font.font(50));

        StackPane centerPane = new StackPane(mLabel);
        centerPane.setPadding(new Insets(10));

        BorderPane borderPane = new BorderPane(centerPane);
        borderPane.setBottom(bottomPane);
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Stopwatch");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
