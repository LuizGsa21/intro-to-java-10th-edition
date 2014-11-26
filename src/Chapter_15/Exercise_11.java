package Chapter_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 11:
 *
 *      (Move a circle using keys)
 *      Write a program that moves a circle up, down, left, or right using the arrow keys.
 *
 * Created by Luiz Arantes Sa on 9/16/14.
 */
public class Exercise_11 extends Application {

    double width = 400;
    double height = 400;
    double cX = width / 2;
    double cY = height / 2;
    Circle c = new Circle(cX, cY, Math.min(width, height) / 10);

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane(c);

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
        c.setCenterY(cY -= 10);
    }

    private void moveDown() {
        c.setCenterY(cY += 10);

    }
    private void moveLeft() {
        c.setCenterX(cX -= 10);
    }
    private void moveRight() {
        c.setCenterX(cX += 10);
    }



    public static void main(String[] args) {
        Application.launch(args);
    }
}
