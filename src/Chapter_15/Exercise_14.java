package Chapter_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 14:
 *
 *      (Geometry: inside a polygon?)
 *      Write a program that draws a fixed polygon with points at
 *      (40, 20), (70, 40), (60, 80), (45, 45), and (20, 60).
 *      Whenever the mouse is moved, display a message indicating whether
 *      the mouse point is inside the polygon at the mouse point or outside of it,
 *      as shown in Figure 15.27c. To detect whether a point is inside a polygon,
 *      use the contains method defined in the Node class.
 *
 * Created by Luiz Arantes Sa on 9/16/14.
 */
public class Exercise_14 extends Application {

    @Override
    public void start(Stage primaryStage) {

        double width = 400;
        double height = 300;

        Polygon polygon = new Polygon(40, 20, 70, 40, 60, 80, 45, 45, 20, 60);
        polygon.setFill(Color.TRANSPARENT);
        polygon.setStroke(Color.BLACK);

        Pane pane = new Pane(polygon);
        Scene scene = new Scene(pane, width, height);
        Text text = new Text();
        pane.getChildren().add(text);
        pane.setOnMouseMoved(e-> {
            double x = e.getX();
            double y = e.getY();
            text.setX(x);
            text.setY(y);
            if (polygon.contains(x, y)) {
                text.setText("Mouse Point is inside the polygon");
            } else {
                text.setText("Mouse Point is outside the polygon");
            }
            if (text.getLayoutBounds().getWidth() + x > width) {
                text.setX(width - text.getLayoutBounds().getWidth());
            }
            if (y - text.getLayoutBounds().getHeight() < 0) {
                text.setY(text.getLayoutBounds().getHeight());
            }

        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle position");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
