package Chapter_16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Use radio buttons)
 * Write a GUI program as shown in Figure 16.36a.
 * You can use buttons to move the message to the left
 * and right and use the radio buttons to change the color for
 * the message displayed.
 * Created by luizsa on 9/23/14.
 */
public class Exercise_01 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Text text = new Text(50, 50, "JavaFX");
        text.setFont(Font.font("Arial", 20));

        TextPane pane = new TextPane(text);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Text Pane");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }

    private class TextPane extends BorderPane {

        Text text;

        private TextPane(Text text) {
            this.text = text;
            Pane textPane = new Pane(this.text);
            setCenter(textPane);
            setPrefWidth(400);
            setPrefHeight(200);

            // Create Color Radio Buttons
            String[] strColors = {"Red", "Yellow", "Black", "Orange", "Green"};
            Color[] colors = {Color.RED, Color.YELLOW, Color.BLACK, Color.ORANGE, Color.GREEN};
            RadioButton[] rbColors = new RadioButton[strColors.length];

            HBox colorRbPane = new HBox(10);
            colorRbPane.setAlignment(Pos.CENTER);
            colorRbPane.setPadding(new Insets(1, 10, 1, 10));
            colorRbPane.setStyle("-fx-border-color: green");
            setTop(colorRbPane);

            // Create ToggleGroup to sync radio buttons together
            ToggleGroup colorGroup = new ToggleGroup();

            for (int i = 0; i < rbColors.length; i++) {

                rbColors[i] = new RadioButton(strColors[i]);

                // Add radio buttons to ButtonGroup
                rbColors[i].setToggleGroup(colorGroup);

                final int index = i; // Index inside inside lambda
                rbColors[i].setOnAction(e -> text.setFill(colors[index]));

                colorRbPane.getChildren().add(rbColors[i]); // add radioButton to buttonsPane
            }

            // Create Left and Right arrow buttons
            Button btLeft = new Button("", new ImageView("/image/left.gif"));
            Button btRight = new Button("", new ImageView("/image/right.gif"));

            // Add buttons to hBox pane
            HBox arrowBtPane = new HBox(btLeft, btRight);

            // Set arrowPane to the bottom of border pane
            setBottom(arrowBtPane);
            // Configure arrowPane to properly display in BorderPane
            arrowBtPane.setAlignment(Pos.CENTER);
            arrowBtPane.setPadding(new Insets(1, 10, 1, 10));
            arrowBtPane.setSpacing(10);
            arrowBtPane.setStyle("-fx-border-color: green");

            btLeft.setOnAction(e -> text.setX(text.getX() - 10));
            btRight.setOnAction(e -> text.setX(text.getX() + 10));
        }


    }
}
