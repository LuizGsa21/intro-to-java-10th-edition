package Chapter_15;

import ToolKit.StopWatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 19:
 *
 *  (Game: eye-hand coordination)
 *  Write a program that displays a circle of radius 10 pixels filled
 *  with a random color at a random location on a pane, as shown in
 *  Figure 15.29b. When you click the circle, it disappears and a new
 *  random- color circle is displayed at another random location. After twenty
 *  circles are clicked, display the time spent in the pane, as shown in Figure 15.29c.
 *
 * Created by Luiz Arantes Sa on 9/17/14.
 */
public class Exercise_19 extends Application {

    static int circleCount = 0;

    @Override
    public void start(Stage primaryStage) {

        double width = 500;
        double height = 500;

        Circle c = new Circle(0, 0, 10);
        updateCircle(c);
        Pane pane = new Pane(c);
        Text count = new Text(50,50,circleCount + "");
        pane.getChildren().add(count);
        StopWatch timer = new StopWatch();
        c.setOnMouseClicked(e-> {

            if (!timer.isOn()) {
                timer.start();
            }
            if (circleCount < 19) {
                circleCount++;
                count.setText(circleCount + "");

                updateCircle(c);
            } else {
                timer.stop();
                pane.getChildren().remove(c);
                pane.getChildren().add(new Text(width / 2, height / 2, "Time spent is " +
                        timer.getElapsedTime() + " milliseconds"));
            }
        });
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.setTitle("Game: eye-hand coordination");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void updateCircle(Circle c) {

        double min = c.getRadius() + 5;
        double max = 500 - c.getRadius() - 5;

        c.setCenterX((Math.random() * (max - min) + min));
        max = 500
                - c.getRadius() - 5;
        c.setCenterY((Math.random() * (max - min) + min));

        c.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
    }


}
