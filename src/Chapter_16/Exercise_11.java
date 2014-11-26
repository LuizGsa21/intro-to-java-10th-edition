package Chapter_16;

import ToolKit.Histogram;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * (Create a histogram for occurrences of letters)
 *      Write a program that reads a file and displays a
 *      histogram to show the occurrences of each letter
 *      in the file, as shown in Figure 16.40b. The file
 *      name is entered from a text field. Pressing the
 *      Enter key on the text field causes the program to
 *      start to read and process the file and displays the
 *      histogram. The histogram is displayed in the center
 *      of the window. Define a class named Histogram that
 *      extends Pane. The class con- tains the property counts
 *      that is an array of 26 elements. counts[0] stores the
 *      number of A, counts[1] the number of B, and so on.
 *      The class also contains a setter method for setting a
 *      new counts and displaying the histogram for the new counts.
 *
 * Created by luizsa on 9/25/14.
 */
public class Exercise_11 extends Application {

    Pane pane = new Pane();
    TextField textField = new TextField();
    VBox box = new VBox();
    @Override
    public void start(Stage primaryStage) throws Exception {

        Label lblFilename = new Label("Filename:", textField);
        lblFilename.setContentDisplay(ContentDisplay.RIGHT);
        textField.setPrefColumnCount(20);
        Button btView = new Button("View");

        HBox hBox = new HBox(lblFilename, btView);

        box.getChildren().addAll(pane, hBox);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        btView.setOnAction(e-> {
            update();
            box.setTranslateY(10);
            primaryStage.sizeToScene();

        });
        primaryStage.show();
    }

    private void update() {
        Histogram graph = new Histogram(textField.getText());
        pane.getChildren().add(graph);
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
