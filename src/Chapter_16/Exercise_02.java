package Chapter_16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * (Select geometric figures)
 * Write a program that draws various figures,
 * as shown in Figure 16.36b. The user selects a figure
 * from a radio button and uses a check box to
 * specify whether it is filled.
 *
 * Created by luizsa on 9/24/14.
 */
public class Exercise_02  extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Text text = new Text(50, 50, "JavaFX");
        text.setFont(Font.font("Arial", 20));

        ShapePane pane = new ShapePane();

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Text Pane");
        primaryStage.show();
    }


    private class ShapePane extends BorderPane {

        private ShapePane() {

            // create 3 shapes
            Shape[] shapes = new Shape[3];
            shapes[0] = new Circle(50);
            shapes[1] = new Rectangle(200, 100);
            shapes[2] = new Ellipse(45, 30);

            // Center pane that displays shapes
            StackPane centerPane = new StackPane();
            setCenter(centerPane);

            // set shapes default settings
            for (Shape s : shapes) {
                s.setFill(Color.TRANSPARENT);
                s.setStroke(Color.BLACK);
            }

            // create radio buttons
            RadioButton[] rbButtons = new RadioButton[3];
            rbButtons[0] = new RadioButton("Circle");
            rbButtons[1] = new RadioButton("MyRec2");
            rbButtons[2] = new RadioButton("Ellipse");

            // Create Fill checkbox and add set its target
            CheckBox cbFill = new CheckBox("Fill");
            cbFill.setOnAction(e-> {
                Shape shape = (Shape)centerPane.getChildren().get(0);
                if (cbFill.isSelected()) {
                    shape.setFill(Color.BLACK);
                } else {
                    shape.setFill(Color.TRANSPARENT);
                }
            });

            // Create Pane to hold Radio buttons and checkbox
            HBox bottomHbox = new HBox(10);
            bottomHbox.getChildren().addAll(rbButtons);
            bottomHbox.getChildren().add(cbFill);
            setBottom(bottomHbox);
            // bottomPane default settings
            bottomHbox.setAlignment(Pos.CENTER);
            bottomHbox.setPadding(new Insets(1, 10, 1, 10));
            // add radio button target event listeners
            // and add them to button group
            ToggleGroup group = new ToggleGroup();
            for (int i = 0; i < rbButtons.length; i++) {
                final int index = i;
                rbButtons[i].setToggleGroup(group);
                rbButtons[i].setOnAction(e-> {

                    if (shapes[index].getFill() != Color.TRANSPARENT) {
                        cbFill.setSelected(true);
                    } else {
                        cbFill.setSelected(false);
                    }
                    centerPane.getChildren().clear();
                    centerPane.getChildren().add(shapes[index]);

                });
            }
            setPrefHeight(200);

        }
    }
}
