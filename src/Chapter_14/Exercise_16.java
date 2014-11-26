package Chapter_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 16:
 *
 *      (Display a 3 * 3 grid)
 *      Write a program that displays a 3 * 3 grid, as shown in Figure 14.47c.
 *      Use red color for vertical lines and blue for horizontals.
 *      The lines are automatically resized when the window is resized.
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_16 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        primaryStage.setTitle("3x3 Grid");
        primaryStage.setScene(new Scene(pane, 400, 400));


        double divider = 3;
        for (int i = 0; i < 2; i++) {
            Line line = new Line();
            line.setStroke(Color.RED);
            line.startXProperty().bind(pane.widthProperty().divide(divider));
            line.startYProperty().bind(pane.layoutYProperty());
            line.endXProperty().bind(line.startXProperty());
            line.endYProperty().bind(pane.heightProperty());
            pane.getChildren().add(line);
            divider /= 2;
        }
        divider = 3;
        for (int i = 0; i < 2; i++) {
            Line line = new Line();
            line.setStroke(Color.BLUE);
            line.startXProperty().bind(pane.layoutXProperty());
            line.startYProperty().bind(pane.heightProperty().divide(divider));
            line.endXProperty().bind(pane.widthProperty());
            line.endYProperty().bind(pane.heightProperty().divide(divider));
            pane.getChildren().add(line);
            divider /= 2;
        }


        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}
