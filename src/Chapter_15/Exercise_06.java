package Chapter_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise 6:
 *
 *      Alternate two messages)
 *      Write a program to display the text Java is fun and Java is powerful
 *      alternately with a mouse click.
 *
 * Created by Luiz Arantes Sa on 9/15/14.
 */
public class Exercise_06  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        String s1 = "Java is fun";
        String s2 = "Java is Powerful";

        Text text = new Text("Java is fun");
        text.setOnMouseClicked(e -> {
            if (text.getText().contains(s1)) {
                text.setText(s2);
            } else {
                text.setText(s1);
            }
        });
        StackPane pane = new StackPane(text);

        primaryStage.setScene(new Scene(pane, 300, 300));
        primaryStage.setTitle("Click to change text");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
