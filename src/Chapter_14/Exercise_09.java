package Chapter_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 9:
 *
 *  (Create four fans)
 *  Write a program that places four fans in a GridPane with
 *  two rows and two columns, as shown in Figure 14.45b.
 *
 * Created by Luiz Arantes Sa on 9/13/14.
 */
public class Exercise_09 extends Application {

    private static final int RADIUS = 100;
    private static final int GAP = 10;
    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        int x = RADIUS + GAP;
        int y = RADIUS + GAP;

        for (int i = 0; i < 2; i++) {

            // drawing a 2 Circles in each row
            for (int j = 0; j < 2; j++) {
                // create circle
                Circle c = new Circle(RADIUS);
                c.setCenterX(x);
                c.setCenterY(y);
                c.setStroke(Color.BLACK);
                c.setFill(Color.WHITE);
                pane.getChildren().add(c);

                // create 4 arcs in each circle with 90 degree increment
                for (int k = 30; k < 360; k += 90) {
                    Arc arc = new Arc(x, y, RADIUS - 15,RADIUS- 15,k,30);
                    arc.setFill(Color.BLACK);
                    arc.setType(ArcType.ROUND);
                    pane.getChildren().add(arc);
                }

                x += RADIUS * 2 + GAP;
            }
            // reset center for the next row
            x = RADIUS + GAP;
            y += RADIUS * 2 + GAP;
        }

        Scene scene = new Scene(pane, 425, 425);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fans");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
