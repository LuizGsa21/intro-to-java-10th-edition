package Chapter_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 10:
 * <p>
 * Created by Luiz Arantes Sa on 9/15/14.
 */
public class Exercise_10 extends Application {

    @Override
    public void start(Stage primaryStage) {
        double width = 400;
        double height = 400;


        Label label = new Label();
        StackPane pane = new StackPane(label);

        StringBuilder s = new StringBuilder();
        pane.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                label.setText(s.toString());
                s.delete(0, s.length());
            } else {
                s.append(e.getText());
            }
        });

        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.setTitle("Click to see position..");
        primaryStage.show();
        pane.requestFocus();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }

}
