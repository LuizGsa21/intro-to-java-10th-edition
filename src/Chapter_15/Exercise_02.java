package Chapter_15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Chapter 15 Exercise :
 *
 *      (Rotate a rectangle)
 *      Write a program that rotates a rectangle 15 degrees
 *      right when the Rotate button is clicked,
 *      as shown in Figure 15.24b.
 *
 * Created by Luiz Arantes Sa on 9/15/14.
 */
public class Exercise_02  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // create pane to hold a rectangle
        StackPane pane = new StackPane();
        pane.setMinWidth(300);
        pane.minHeight(300);
        // create a rectangle and add it to pane
        Rectangle rectangle = new Rectangle();
        rectangle.widthProperty().bind(primaryStage.widthProperty().divide(2));
        rectangle.heightProperty().bind(primaryStage.heightProperty().divide(2));
        pane.getChildren().add(rectangle);

        // create HBox to hold a button
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);

        // create a button and add it to buttons (Hbox)
        Button btRotate = new Button("Rotate");
        buttons.getChildren().add(btRotate);

        // create a button click listener to change the rectangles rotation
        btRotate.setOnAction(e -> rectangle.setRotate(rectangle.getRotate() + 15));

        // add pane and buttons to borderPane to position nodes
        BorderPane borderPane = new BorderPane(pane);
        borderPane.setBottom(buttons);
        BorderPane.setMargin(buttons, new Insets(10, 10, 30, 10));

        Scene scene = new Scene(borderPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotate MyRec2");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
