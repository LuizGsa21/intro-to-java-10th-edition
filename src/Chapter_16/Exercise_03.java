package Chapter_16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * (Traffic lights)
 *      Write a program that simulates a traffic light.
 *      The program lets the user select one of three
 *      lights: red, yellow, or green. When a radio but- ton
 *      is selected, the light is turned on.
 *      Only one light can be on at a time (see Figure 16.37a).
 *      No light is on when the program starts.
 *
 * Created by luizsa on 9/24/14.
 */
public class Exercise_03 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new TrafficLightPane(300, 300);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Traffic Light");
        primaryStage.show();
    }

    private class TrafficLightPane extends Pane {

        double w;
        double h;
        private TrafficLightPane(double width, double height) {

            w = width;
            h = height;
            setPrefWidth(w);
            setPrefHeight(h);

            Rectangle rec = new Rectangle(w / 3, h / 6, w /3, h / 1.5);
            rec.setFill(Color.TRANSPARENT);
            rec.setStroke(Color.BLACK);
            getChildren().add(rec);


            // Radio buttons names
            String[] colorString = {"Red", "Yellow", "Green"};

            ToggleGroup group = new ToggleGroup();

            Circle[] circles = new Circle[3];
            Color[] colors = new Color[]{Color.RED, Color.YELLOW, Color.GREEN};
            double[] circleY = new double[]{0.3, 0.5, 0.7};
            RadioButton[] rbColors = new RadioButton[circles.length];

            for (int i = 0; i < circles.length; i++) {
                circles[i] = new Circle(w / 2, h * circleY[i], w * 0.09);
                circles[i].setFill(Color.TRANSPARENT);
                circles[i].setStroke(Color.BLACK);
                rbColors[i] = new RadioButton(colorString[i]);


                final int index = i;
                rbColors[i].setOnAction(e-> {
                    resetColors(circles);
                    circles[index].setFill(colors[index]);
                });
                rbColors[i].setToggleGroup(group);
            }

            HBox radioButtonPane = new HBox(10);
            radioButtonPane.getChildren().addAll(rbColors);
            radioButtonPane.setAlignment(Pos.CENTER);
            radioButtonPane.setLayoutX(w * 0.2);
            radioButtonPane.setLayoutY(h - 30);

            getChildren().addAll(circles);
            getChildren().addAll(radioButtonPane);
        }

        private void resetColors(Shape[] shapes) {
            for (Shape s : shapes) {
                s.setFill(Color.TRANSPARENT);
            }
        }
    }
}
