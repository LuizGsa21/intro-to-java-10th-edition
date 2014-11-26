package Chapter_14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 12:
 *
 *      (Display a bar chart)
 *      Write a program that uses a bar chart to display the percentages
 *      of the overall grade represented by projects, quizzes, midterm exams,
 *      and the final exam, as shown in Figure 14.46b. Suppose that projects
 *      take 20 percent and are displayed in red, quizzes take 10 percent and
 *      are displayed in blue, midterm exams take 30 percent and are displayed
 *      in green, and the final exam takes 40 percent and is displayed in orange.
 *      Use the MyRec2 class to display the bars. Interested readers may explore
 *      the JavaFX BarChart class for further study.
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_12 extends Application {

    // project - 20% - red
    // quizzes - 10% - blue
    // midterm - 30% - green
    // final - 40% - orange
    private static final double WIDTH = 400;
    private static final double HEIGHT = 400;
    private static final double LIMIT_HEIGHT = (HEIGHT / 2);
    private static double[] percent = new double[]{0.20, 0.10, 0.30, 0.40};
    private static String[] titles = new String[] {
            "project - " + String.format("%d%s", (int)(100 * percent[0]), "%"),
            "quizzes - " + String.format("%d%s", (int)(100 * percent[1]), "%"),
            "midterm - " + String.format("%d%s", (int)(100 * percent[2]), "%"),
            "final - "+ String.format("%d%s", (int)(100 * percent[3]), "%")
     };
    private static Color[] colors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 10, 0, 10));
        Rectangle[] bars = new Rectangle[4];

        for (int i = 0; i < bars.length; i++) {

            bars[i] = new Rectangle(
                    5 + (100 * i), // x
                    LIMIT_HEIGHT - (HEIGHT * percent[i]), // y
                    WIDTH / bars.length - 5, // width
                    HEIGHT * percent[i]); // height
            bars[i].setFill(colors[i]);

            Text text = new Text(5 + (100 * i),LIMIT_HEIGHT - (HEIGHT * percent[i]) - 5,titles[i]);
            pane.getChildren().addAll(text, bars[i]);

        }

        primaryStage.setScene(new Scene(pane, WIDTH + 20, LIMIT_HEIGHT));
        primaryStage.setTitle("Bar graph");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }



}
