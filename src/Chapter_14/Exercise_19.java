package Chapter_14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 19:
 *
 *
 *      (Plot the sine and cosine functions)
 *      Write a program that plots the sine function in red and cosine
 *      in blue, as shown in Figure 14.48c.
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_19 extends Application{

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
        Polyline polyline2 = new Polyline();
        ObservableList<Double> list2 = polyline2.getPoints();

        for (int x = -170; x <= 170; x++) {
            list2.add(x + CENTER_X);
            list2.add(CENTER_Y - 50 * Math.cos((x / 100.0) * 2 * Math.PI));

        }
        pane.getChildren().addAll(xAxis, yAxis,polyline1,polyline2);
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
