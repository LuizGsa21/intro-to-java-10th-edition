package Chapter_14;

import ToolKit.PaneCollection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 20:
 *
 *      (Draw an arrow line) Write a static method that draws an arrow
 *      line from a start- ing point to an ending point in a pane using the
 *      following method header:
 *
 *          public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane)
 *
 *      Programming Exercises 581
 *      Write a test program that randomly draws an arrow line, as shown in Figure 14.49a.
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_20 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        double width = 400;
        double height = 400;
        Line line = new Line(
                Math.random() * width,
                Math.random() * height,
                Math.random() * width,
                Math.random() * height);

        PaneCollection.drawArrowLine(line,pane);
        primaryStage.setTitle("Draw Random arrow");
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}
