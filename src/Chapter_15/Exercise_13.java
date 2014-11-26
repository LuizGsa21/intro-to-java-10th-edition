package Chapter_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 13:
 *
 *      (Geometry: inside a rectangle?)
 *      Write a program that draws a fixed rectangle centered at (100, 60)
 *      with width 100 and height 40. Whenever the mouse is moved,
 *      display a message indicating whether the mouse point is inside the
 *      rectangle at the mouse point or outside of it, as shown in Figure 15.27b.
 *      To detect whether a point is inside a polygon, use the contains method
 *      defined in the Node class.
 *
 * Created by Luiz Arantes Sa on 9/16/14.
 */
public class Exercise_13 extends Application {

    @Override
    public void start(Stage primaryStage) {

        double width = 400;
        double height = 300;
        Rectangle rec = new Rectangle(100, 60, 100, 40);
        rec.setFill(Color.TRANSPARENT);
        rec.setStroke(Color.BLACK);

        Pane pane = new Pane(rec);
        Scene scene = new Scene(pane, width, height);
        Text text = new Text();
        pane.getChildren().add(text);
        pane.setOnMouseMoved(e-> {
            double x = e.getX();
            double y = e.getY();
            text.setX(x);
            text.setY(y);
            if (rec.contains(x, y)) {
                text.setText("Mouse Point is inside the rectangle");
            } else {
                text.setText("Mouse Point is outside the rectangle");
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
