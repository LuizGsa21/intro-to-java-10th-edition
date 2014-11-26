package Chapter_15;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Chapter 15 Exercise 25:
 *
 *      (Animation: ball on curve)
 *      Write a program that animates a ball moving along a sine curve,
 *      as shown in Figure 15.32. When the ball gets to the right border,
 *      it starts over from the left. Enable the user to resume/pause the
 *      animation with a click on the left/right mouse button.
 *
 * Created by Luiz Arantes Sa on 9/17/14.
 */
public class Exercise_25  extends Application {


    private static double WIDTH = 500;
    private static double HEIGHT = 200;
    private static double CENTER_X = WIDTH / 2;
    private static double CENTER_Y = HEIGHT / 2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();


        Polyline xAxis = new Polyline();
        drawXAxis(pane, xAxis);
        Polyline yAxis = new Polyline();
        drawYAxis(pane, yAxis);

        String[] pi = new String[] {"-3\u03c0", "-2\u03c0", "-\u03c0", "0" , "\u03c0", "2\u03c0", "3\u03c0"};

        int index = 0;
        Polyline polyline1 = new Polyline();
        ObservableList<Double> list = polyline1.getPoints();
        for (int x = -170; x <= 170; x++) {
            list.add(x + CENTER_X);
            double y = CENTER_Y - 50 * Math.sin((x / 100.0) * 2 * Math.PI);
            list.add(y);

            if (y >= 99.9 && y < 100.01) {
                Text text1 = new Text(x + CENTER_X, CENTER_Y / 0.9, pi[index++]);
                pane.getChildren().add(text1);
            }

        }
        Circle point = new Circle(list.get(0),list.get(1),10);
        PathTransition path = new PathTransition(Duration.millis(4000), polyline1, point);
        path.setCycleCount(PathTransition.INDEFINITE);
        pane.getChildren().addAll(xAxis, yAxis, polyline1, point);
        pane.setOnMouseClicked(e-> {
            if (e.getButton() == MouseButton.PRIMARY) {
                path.play();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                path.pause();
            }
        });
        primaryStage.setScene(new Scene(pane, WIDTH, HEIGHT));
        primaryStage.setTitle("Plot the sine and cosine functions");
        primaryStage.show();

    }

    private static void drawXAxis(Pane pane, Polyline xAxis) {
        ObservableList<Double> xAxisList = xAxis.getPoints();
        double limit = WIDTH * 0.95;

        for (double x = 0; x < limit; x++) {
            xAxisList.add(x);
            xAxisList.add(CENTER_Y);
        }

        Line line1 = new Line(limit, CENTER_Y, limit - WIDTH * 0.05, CENTER_Y * 0.875);
        Line line2 = new Line(limit, CENTER_Y, limit - WIDTH * 0.05, CENTER_Y / 0.875);
        Text text = new Text(limit + (WIDTH * 0.02), CENTER_Y, "X");
        text.setFont(Font.font(22));
        pane.getChildren().addAll(line1, line2, text);
    }

    private static void drawYAxis(Pane pane, Polyline yAxis) {

        ObservableList<Double> yAxisList = yAxis.getPoints();
        double limit = HEIGHT * 0.95;

        for (double y = 0; y < limit; y++) {
            yAxisList.add(CENTER_X);
            yAxisList.add(y + HEIGHT * 0.1);

        }
        Line line1 = new Line(CENTER_X, HEIGHT * 0.1, CENTER_X - WIDTH * 0.05, HEIGHT * 0.2);
        Line line2 = new Line(CENTER_X, HEIGHT * 0.1, CENTER_X + WIDTH * 0.05, HEIGHT * 0.2);
        Text text = new Text(limit + (WIDTH * 0.2), HEIGHT * 0.1, "Y");
        text.setFont(Font.font(22));
        pane.getChildren().addAll(line1, line2,text);
    }


    public static void main(String[] args) {
        Application.launch(args);
    }


}
