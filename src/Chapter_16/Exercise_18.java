package Chapter_16;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
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
 * (Simulation: a running fan)
 * Rewrite Programming Exercise 15.28 to
 * add a slider to control the speed of the fan,
 * as shown in Figure 16.43c.
 *
 * Created by luizsa on 9/27/14.
 */
public class Exercise_18 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        FanPane pane = new FanPane(100);

        BorderPane borderPane = new BorderPane(pane);
        borderPane.setTop(pane.hButtons);
        borderPane.setBottom(pane.scrollPane);
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Fan");
        primaryStage.show();
    }

    private class FanPane extends Pane {

        private Circle c;
        private Arc[] blades = new Arc[4];
        private double increment = 1;

        // Buttons
        Button playPause = new Button("Play/Pause");
        //Button resume = new Button("Resume");
        Button increase = new Button("Increase");
        Button decrease = new Button("Decrease");
        Button reverse = new Button("Reverse");

        //HBox hButtons = new HBox(pause,resume,increase,decrease, reverse);
        HBox hButtons = new HBox(playPause,increase,decrease, reverse);
        Timeline fanTimeline;
        //ScrollBar mScrollBar = new ScrollBar();

        Slider mSlider = new Slider();
        HBox scrollPane = new HBox(mSlider);


        FanPane(double radius) {
            double w = radius * 4;
            double h = radius * 2;

            setMinWidth(w);
            setMinHeight(h + radius);
            c = new Circle(w/2  , h / 2 + (radius /2), radius, Color.TRANSPARENT);
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


            KeyFrame keyFrame = new KeyFrame(Duration.millis(10), e -> spin());

            fanTimeline = new Timeline(keyFrame);
            fanTimeline.setCycleCount(Timeline.INDEFINITE);

            // Buttons pause, resume, increase, decrease, reverse
            playPause.setOnAction(e -> {
                if (fanTimeline.getStatus() == Animation.Status.RUNNING) {
                    fanTimeline.pause();
                } else {
                    fanTimeline.play();
                }
            });

            increase.setOnAction(e -> {
                fanTimeline.setRate(fanTimeline.getCurrentRate() + 1);
                mSlider.setValue(fanTimeline.getCurrentRate());
            });

            decrease.setOnAction(e -> {
                fanTimeline.setRate(
                        (fanTimeline.getCurrentRate() - 1 < 0) ? 0 : fanTimeline.getCurrentRate() - 1);
                mSlider.setValue(fanTimeline.getCurrentRate());

            });
            mSlider.setMin(0);
            mSlider.setMax(35);
            mSlider.valueProperty().addListener(e -> {
                final double direction = (fanTimeline.getCurrentRate() >= 0) ? 1 : -1;
                fanTimeline.setRate(mSlider.getValue() * direction);
            });
            mSlider.setMinWidth(200);
            scrollPane.setAlignment(Pos.CENTER);
            scrollPane.setPadding(new Insets(5));

            reverse.setOnAction(e -> increment *= -1);
            hButtons.setSpacing(10);
            hButtons.setAlignment(Pos.CENTER);
            hButtons.setPadding(new Insets(5, 5, 5, 5));

        }


        private void spin() {
            for (Arc blade : blades) {
                double prevStartAngle = blade.getStartAngle();
                blade.setStartAngle(prevStartAngle - increment);
            }
        }

    }

}
