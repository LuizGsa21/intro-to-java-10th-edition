package Chapter_14;

import ToolKit.MyRectangle2D;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 14 Exercise 23:
 *
 *      (Geometry: two rectangles)
 *      Write a program that prompts the user to enter the center coordinates,
 *      width, and height of two rectangles from the command line. The program
 *      displays the rectangles and a text indicating whether the two are overlapping,
 *      whether one is contained in the other, or whether they don’t over- lap, as shown
 *      in Figure 14.50. See Programming Exercise 10.13 for checking the relationship
 *      between two rectangles.
 *
 * Created by Luiz Arantes Sa on 9/14/14.
 */
public class Exercise_23 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        double width = 400;
        double height = 400;

        ArrayList<Rectangle> rectangles = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 2; i++) {
            System.out.print("Enter center coordinates / height / width of rectangle " + i + ": ");
            Rectangle temp = new Rectangle(
                    input.nextDouble(),
                    input.nextDouble(),
                    input.nextDouble(),
                    input.nextDouble());
            temp.setFill(Color.TRANSPARENT);
            temp.setStroke(Color.BLACK);

            rectangles.add(temp);
        }
        MyRectangle2D rec1 = new MyRectangle2D(rectangles.get(0));
        MyRectangle2D rec2 = new MyRectangle2D(rectangles.get(1));
        String s = "";
        if (rec1.contains(rec2) || rec2.contains(rec1)) {
            s = "One rectangle is contained in another.";
        } else if (rec1.overlaps(rec2) || rec2.overlaps(rec1)) {
            s = "One rectangle overlaps another";
        } else {
            s = "The rectangles do not overlap.";
        }
        Text text = new Text(width * 0.1, height * 0.9, s);
        pane.getChildren().add(text);
        pane.getChildren().addAll(rectangles);
        primaryStage.setTitle("rectangles..");
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.show();
    }


    public static void main(String[] args) {

        Application.launch(args);

    }
}
