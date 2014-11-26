package Chapter_15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Chapter 15 Exercise 28:
 *
 *      (Display a running fan)
 *      Write a program that displays a running fan,
 *      as shown in Figure 15.33c. Use the Pause, Resume, Reverse
 *      buttons to pause, resume, and reverse fan running.
 *
 * Created by Luiz Arantes Sa on 9/17/14.
 */
public class Exercise_28 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create fan pane
        FanPane fanPane = new FanPane(100);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), e-> fanPane.spin());

        Timeline fanTimeline = new Timeline(keyFrame);
        fanTimeline.setCycleCount(Timeline.INDEFINITE);

        // Buttons pause, resume, increase, decrease, reverse
        Button pause = new Button("Pause");
        pause.setOnAction(e-> fanTimeline.pause());

        Button resume = new Button("Resume");
        resume.setOnAction(e-> fanTimeline.play());

        //fanPane.increase()
        Button increase = new Button("Increase");
        increase.setOnAction(e-> {
            fanTimeline.setRate(fanTimeline.getCurrentRate() + 1);
        });

        Button decrease = new Button("Decrease");
        decrease.setOnAction(e-> {
            fanTimeline.setRate(fanTimeline.getCurrentRate() - 1);
        });

        Button reverse = new Button("Reverse");
        reverse.setOnAction(e-> fanPane.increment *= -1);
        HBox hButtons = new HBox(pause,resume,increase,decrease, reverse);
        hButtons.setSpacing(10);
        hButtons.setAlignment(Pos.CENTER);
        hButtons.setPadding(new Insets(10, 10, 10, 10));
        BorderPane borderPane = new BorderPane(fanPane, null, null, hButtons, null);


        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Spinning fan");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private class FanPane extends Pane {

        private Circle c;
        private Arc[] blades = new Arc[4];
        private double increment = 1;

        FanPane(double radius) {
            setMinHeight(400);
            setMinWidth(400);
            c = new Circle(200,200,radius,Color.TRANSPARENT);
            c.setStroke(Color.BLACK);

            double bladeRadius = radius * 0.9;
            for (int i = 0; i < blades.length; i++) {
                blades[i] = new Arc(
                        c.getCenterX(), c.getCenterY(), // center point
                        bladeRadius, bladeRadius, // X and Y radius
                        (i * 90) + 30, 35); // start angle and length
                blades[i].setFill(Color.RED);
                blades[i].setType(ArcType.ROUND);
            }

            getChildren().addAll(c);
            getChildren().addAll(blades);


        }


        private void spin() {
            for (Arc blade : blades) {
                double prevStartAngle = blade.getStartAngle();
                blade.setStartAngle(prevStartAngle + increment);
            }
        }

    }
}






