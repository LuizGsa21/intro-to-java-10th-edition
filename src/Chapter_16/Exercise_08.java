package Chapter_16;

import ToolKit.Circle2D;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 *
 *(Geometry: two circles intersect?)
 *      Write a program that enables the user to specify the location
 *      and size of the circles and displays whether the two circles
 *      intersect, as shown in Figure 16.39a. Enable the user to point the
 *      mouse inside a circle and drag it. As the circle is being dragged,
 *      the circle’s center coordinates in the text fields are updated.
 *
 *
 * Created by luizsa on 9/25/14.
 */
public class Exercise_08 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        CirclePane cPane = new CirclePane();

        primaryStage.setScene(new Scene(cPane));
        primaryStage.setTitle("Circle Stage");
        primaryStage.show();

    }

    private class CirclePane extends GridPane {


        Label lblIsIntersect; // Tells whether the circles intersect
        String intersectString = "Two Circles Intersect? ";

        Circle[] circles = new Circle[2]; // convenience array
        CircleInfoPane[] cInfoPane = new CircleInfoPane[2];
        Circle c1;
        Circle c2;



        private CirclePane() {

            // Label and circle's default values
            lblIsIntersect = new Label("Two Circles Intersect? No");
            c1 = new Circle(80, 80, 50);
            c2 = new Circle(200, 80, 50);
            circles[0] = c1;
            circles[1] = c2;
            // Connect the circles with the text fields;
            for (int i = 0; i < circles.length; i++) {
                cInfoPane[i] = new CircleInfoPane(
                        "Circle Info " + (i + 1) + ":", circles[i]);
                circles[i].setFill(Color.TRANSPARENT);
                circles[i].setStroke(Color.BLACK);

            }
            // Create Pane to hold the two circles
            Pane cPane = new Pane(circles);
            cPane.setPadding(new Insets(10));
            cPane.setStyle("-fx-border-color: green");

            // Create Hbox to hold lblIsIntersect and make it center
            HBox topLabelPane = new HBox(lblIsIntersect);
            topLabelPane.setAlignment(Pos.CENTER);

            // add listeners to c1, c2
            for (int i = 0; i < 2; i++) {
                final int index = i;
                circles[i].setOnMouseDragged(e-> {
                    circles[index].setCenterX(e.getX());
                    circles[index].setCenterY(e.getY());
                    updateStats();
                    cInfoPane[index].update();
                });
            }

            // add nodes to this pane
            add(topLabelPane, 0, 0, 2, 1);
            add(cPane, 0, 1, 2, 1);

            HBox hBoxInfo = new HBox(cInfoPane);
            hBoxInfo.setSpacing(10);
            add(hBoxInfo, 0, 2, 2, 2);

            setVgap(5);
            setHgap(10);
            setPadding(new Insets(10));

            GridPane.setHalignment(topLabelPane, HPos.CENTER);
            GridPane.setHalignment(hBoxInfo, HPos.CENTER);
            autosize();

        }
        // Updates textfields when circles are moved
        private void updateStats() {
            lblIsIntersect.setText(
                    (Circle2D.c1OverlapsC2(c1, c2)) ? intersectString + "Yes" : intersectString + "No");
        }

        private class CircleInfoPane extends VBox {

            TextField[] mTextFields = new TextField[3];
            private TextField tfCenterX;
            private Label lblCenterX;

            private TextField tfCenterY;
            private Label lblCenterY;

            private TextField tfRadius;
            private Label lblRadius;

            Circle mCircle;
            private CircleInfoPane(String title, Circle c) {

                mCircle = c;
                Label lblTitle = new Label(title);
                HBox titlePane = new HBox(lblTitle);
                titlePane.setAlignment(Pos.CENTER);

                tfCenterX = new TextField();
                mTextFields[0] = tfCenterX;
                tfCenterX.setPrefColumnCount(4);
                tfCenterX.setText(Double.toString(c.getCenterX()));

                lblCenterX = new Label("Center x:", tfCenterX);
                lblCenterX.setContentDisplay(ContentDisplay.RIGHT);
                HBox centerXPane = new HBox(lblCenterX);

                tfCenterY = new TextField();
                mTextFields[1] = tfCenterY;
                tfCenterY.setPrefColumnCount(4);
                tfCenterY.setText(Double.toString(c.getCenterY()));
                lblCenterY = new Label("Center y:", tfCenterY);
                lblCenterY.setContentDisplay(ContentDisplay.RIGHT);
                HBox centerYPane = new HBox(lblCenterY);

                tfRadius = new TextField();
                mTextFields[2] = tfRadius;
                tfRadius.setPrefColumnCount(4);
                tfRadius.setText(Double.toString(c.getRadius()));
                lblRadius = new Label("Radius:", tfRadius);
                lblRadius.setContentDisplay(ContentDisplay.RIGHT);
                HBox radiusPane = new HBox(lblRadius);

                getChildren().addAll(titlePane, centerXPane, centerYPane, radiusPane);

                setStyle("-fx-border-color: black;");

                // set listeners
                for (TextField tf : mTextFields) {
                    tf.setOnAction(e -> updateCircleStats());
                }
            }

            private void updateCircleStats(){
                mCircle.setCenterX(Double.parseDouble(tfCenterX.getText()));
                mCircle.setCenterY(Double.parseDouble(tfCenterY.getText()));
                mCircle.setRadius(Double.parseDouble(tfRadius.getText()));
            }

            private void update() {
                tfCenterX.setText(mCircle.getCenterX() + "");
                tfCenterY.setText(mCircle.getCenterY() + "");
                tfRadius.setText(mCircle.getRadius() + "");
            }
        }
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
