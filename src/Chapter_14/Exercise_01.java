package Chapter_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 1:
 *
 *      (Display images)
 *      Write a program that displays four images in a grid pane,
 *      as shown in Figure 14.43a.
 *
 * Created by Luiz Arantes Sa on 9/12/14.
 */
public class Exercise_01 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        int flagCount = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                gridPane.add(new ImageView(new Image("image/flag"+flagCount+".gif")),i,j);
                flagCount++;
            }
        }
        Scene scene = new Scene(gridPane, 1000, 500);
        primaryStage.setTitle("Flags");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
