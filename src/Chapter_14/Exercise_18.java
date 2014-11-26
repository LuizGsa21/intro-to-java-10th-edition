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
 * Chapter 14 Exercise 18:
 *
 *      (Plot the square function)
 *      Write a program that draws a diagram for the function
 *      f(x) = x2 (see Figure 14.48b).
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_18 extends Application {

    private static double WIDTH = 400;
    private static double HEIGHT = 250;
    private static double CENTER = WIDTH / 2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();


        Polyline xAxis = new Polyline();
        drawXAxis(pane, xAxis);
        Polyline yAxis = new Polyline();
        drawYAxis(pane, yAxis);

        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();

        for (int x = -100; x <= 100; x++) {
            list.add(x + CENTER);
            double scaleFactor = 0.0125;
            list.add(CENTER - scaleFactor * x * x);
        }
        pane.getChildren().addAll(xAxis, yAxis,polyline);
        primaryStage.setScene(new Scene(pane, WIDTH, HEIGHT));
        primaryStage.setTitle("f(x) = x^2");
        primaryStage.show();

    }

    private static void drawXAxis(Pane pane, Polyline xAxis) {
        ObservableList<Double> xAxisList = xAxis.getPoints();
        double limit = WIDTH * 0.9;

        for (double x = 0; x < limit; x++) {
            xAxisList.add(x);
            xAxisList.add(CENTER);

            if (x % 10 == 0) {
                //Line dash = new Line(x, 195.0, x, 205.0);
                //pane.getChildren().add(dash);
            }
        }
        Line line1 = new Line(limit, CENTER, limit - WIDTH * 0.05, CENTER * 0.875);
        Line line2 = new Line(limit, CENTER, limit - WIDTH * 0.05, CENTER / 0.875);
        Text text = new Text(limit + (WIDTH * 0.02), CENTER, "X");
        text.setFont(Font.font(22));
        pane.getChildren().addAll(line1, line2, text);
    }

    private static void drawYAxis(Pane pane, Polyline yAxis) {

        ObservableList<Double> yAxisList = yAxis.getPoints();
        double limit = HEIGHT * 0.9;

        for (double y = 0; y < limit; y++) {
            yAxisList.add(CENTER);
            yAxisList.add(y + HEIGHT * 0.1);

            if (y % 10 == 0 && y > 20) {
                //Line dash = new Line(195.0, y + HEIGHT * 0.1, 205.0, y + HEIGHT * 0.1);
                //pane.getChildren().add(dash);
            }
        }
        Line line1 = new Line(CENTER, HEIGHT * 0.1, CENTER - WIDTH * 0.05, HEIGHT * 0.2);
        Line line2 = new Line(CENTER, HEIGHT * 0.1, CENTER + WIDTH * 0.05, HEIGHT * 0.2);
        Text text = new Text(limit + (WIDTH * 0.02), HEIGHT * 0.1, "Y");
        text.setFont(Font.font(22));
        pane.getChildren().addAll(line1, line2,text);
    }


    public static void main(String[] args) {

        Application.launch(args);

    }

}
