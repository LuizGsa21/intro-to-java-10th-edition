package Chapter_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 9:
 *
 *      (Draw lines using the arrow keys)
 *      Write a program that draws line segments using the arrow keys.
 *      The line starts from the center of the pane and draws toward east,
 *      north, west, or south when the right-arrow key, up-arrow key,
 *      left- arrow key, or down-arrow key is pressed,
 *      as shown in Figure 15.26b.
 *
 * Created by Luiz Arantes Sa on 9/15/14.
 */
public class Exercise_09 extends Application {

    Pane pane = new Pane();
    double width = 400;
    double height = 400;
    double cX = width / 2;
    double cY = height / 2;

    @Override
    public void start(Stage primaryStage) {


        pane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP: moveUp(); break;
                case DOWN: moveDown(); break;
                case LEFT: moveLeft(); break;
                case RIGHT: moveRight(); break;
            }
        });

        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.setTitle("Click to see position..");
        primaryStage.show();
        pane.requestFocus();
    }

    private void moveUp() {
        pane.getChildren().add(new Line(cX, cY, cX, cY - 10));
        cY -= 10;

    }

    private void moveDown() {
        pane.getChildren().add(new Line(cX, cY, cX, cY + 10));
        cY += 10;

    }
    private void moveLeft() {
        pane.getChildren().add(new Line(cX, cY, cX - 10, cY));
        cX -= 10;

    }
    private void moveRight() {
        pane.getChildren().add(new Line(cX, cY, cX + 10, cY));
        cX += 10;
    }



    public static void main(String[] args) {
        Application.launch(args);
    }
}
