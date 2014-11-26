package Chapter_14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 15:
 *
 *  (Display a STOP sign)
 *  Write a program that displays a STOP sign, as shown
 *  in Figure 14.47b. The octagon is in red and the sign is in white.
 *  (Hint: Place an octagon and a text in a stack pane.)
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_15 extends Application {


    private static double WIDTH = 400;
    private static double HEIGHT = 400;
    private static double CENTER_X = WIDTH / 2;
    private static double CENTER_Y = HEIGHT / 2;
    private static double RADIUS = WIDTH * 0.4;

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane pane = new StackPane();
        Polygon polygon = new Polygon();
        polygon.setFill(Color.RED);
        polygon.setStroke(Color.RED);
        ObservableList<Double> points = polygon.getPoints();
        for (int i = 0; i < 8; i++) {
            points.add(CENTER_X + RADIUS * Math.cos(Math.toRadians(i * 45 + 45 / 2)));
            points.add(CENTER_Y - RADIUS * Math.sin(Math.toRadians(i * 45 + 45 / 2)));
        }
        polygon.setRotate(0);
        Text text = new Text("STOP");
        text.setFont(Font.font(100));
        text.setFill(Color.WHITE);

        pane.getChildren().addAll(polygon, text);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fans");
        primaryStage.show();
    }
    public static void main(String[] args) {

        Application.launch(args);

    }

}
